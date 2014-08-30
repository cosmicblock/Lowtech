package cosmicblock.lowtech.block;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import cosmicblock.lowtech.Lowtech;
import cosmicblock.lowtech.creativetab.CreativeTab;
import cosmicblock.lowtech.reference.GuiIds;
import cosmicblock.lowtech.reference.ModInfo;
import cosmicblock.lowtech.reference.Names;
import cosmicblock.lowtech.reference.RenderIds;
import cosmicblock.lowtech.reference.Textures;
import cosmicblock.lowtech.tileentity.TileEntityBarrel;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBarrel extends BlockContainer
{
	private IIcon[] icons;
	public static final String[] subTypes = {"oak", "spruce", "birch", "jungle", "acacia", "dark"};
	private Random random;
	
	protected BlockBarrel()
	{
		super(Material.wood);
		this.setHardness(2F);
		this.setStepSound(soundTypeWood);
		this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.0F, 0.9F);
		this.setCreativeTab(CreativeTab.instance);
		this.setBlockName(Names.Blocks.BARREL);
		random = new Random();
	}
	
	public String getUnlocalizedName(ItemStack stack)
	{
		return getUnlocalizedName() + "." + subTypes[stack.getItemDamage()];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for(int i = 0; i < subTypes.length; i++)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) 
	{
		return new TileEntityBarrel();
	}
	
	
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    @Override
    public int getRenderType()
    {
        return RenderIds.barrel;
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
    	if (!world.isRemote)
    	{
    		FMLNetworkHandler.openGui(player, Lowtech.instance, GuiIds.BARREL, world, x, y, z);
    	}
    	
    	return true;
    }
    
    //These icons are necessarry for block break and sprinting particles
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
    	this.icons = new IIcon[subTypes.length];
    	
        for (int i = 0; i < this.icons.length; i++)
        {
        	icons[i] = iconRegister.registerIcon(ModInfo.ID + ":barrel_" + subTypes[i]);
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon (int side, int metadata)
    {
    	return icons[metadata];
    }
    
    @Override
    public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z, boolean willHarvest)
    { 
    	player.addExhaustion(0.025F);
    	int meta = world.getBlockMetadata(x, y, z);
    	ItemStack barrel = new ItemStack(this, 1, meta);
    	TileEntityBarrel tile = (TileEntityBarrel) world.getTileEntity(x, y, z);
    	
        NBTTagList tagList = new NBTTagList();
        for (int i = 0; i < tile.getSizeInventory(); ++i)
        {
        	ItemStack stack = tile.getStackInSlot(i);
        	
            if (stack != null)
            {
                NBTTagCompound item = new NBTTagCompound();
                item.setByte("Slot", (byte) i);
                stack.writeToNBT(item);
                tagList.appendTag(item);
            }
        }
        
        barrel.stackTagCompound = new NBTTagCompound();
        barrel.stackTagCompound.setTag("Items", tagList);
        
        if (!player.capabilities.isCreativeMode)
        	dropBarrelBlock(world, x, y, z, barrel);
        
        return world.setBlockToAir(x, y, z);
    }
    
    protected void dropBarrelBlock (World world, int x, int y, int z, ItemStack stack)
    {
    	if (!world.isRemote && world.getGameRules().getGameRuleBooleanValue("doTileDrops"))
    	{
    		float f = 0.7F;
    		double d0 = (double) (world.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
    		double d1 = (double) (world.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
    		double d2 = (double) (world.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
    		EntityItem entityitem = new EntityItem(world, (double) x + d0, (double) y + d1, (double) z + d2, stack);
    		entityitem.delayBeforeCanPickup = 10;
    		if(!world.isRemote)
    		{
        		world.spawnEntityInWorld(entityitem);
    		}
    	}
    }
    
    @Override
    public void harvestBlock (World world, EntityPlayer player, int x, int y, int z, int meta)
    {
    }
    
    @Override
    public void onBlockExploded(World world, int x, int y, int z, Explosion explosion)
    {
    	TileEntityBarrel tile = (TileEntityBarrel) world.getTileEntity(x, y, z);
    
    	for (int l = 0; l < tile.getSizeInventory(); l++)
        {
            ItemStack itemstack = tile.getStackInSlot(l);
            if (itemstack == null)
            {
                continue;
            }
            float f = random.nextFloat() * 0.8F + 0.1F;
            float f1 = random.nextFloat() * 0.8F + 0.1F;
            float f2 = random.nextFloat() * 0.8F + 0.1F;
           	EntityItem entityitem = new EntityItem(world, (float) x + f, (float) y + f1, (float) z + f2,
         	new ItemStack(itemstack.getItem(), itemstack.stackSize, itemstack.getItemDamage()));
            float f3 = 0.05F;
            entityitem.motionX = (float) random.nextGaussian() * f3;
            entityitem.motionY = (float) random.nextGaussian() * f3 + 0.2F;
            entityitem.motionZ = (float) random.nextGaussian() * f3;
            if (itemstack.hasTagCompound())
            {
          		entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
        	}
            if(!world.isRemote)
            {
            	world.spawnEntityInWorld(entityitem);
            }
        }
        super.onBlockExploded(world, x, y, z, explosion);
    }
    
    @Override
    public void onBlockPlacedBy (World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
    {
    	if (stack.hasTagCompound())
    	{
    		TileEntityBarrel tile = (TileEntityBarrel) world.getTileEntity(x, y, z);
    		
			NBTTagList items = stack.getTagCompound().getTagList("Items", 10);
			tile.inventory = new ItemStack[tile.getSizeInventory()];
		    for (int i = 0; i < items.tagCount(); ++i)
	        {
	            NBTTagCompound item = items.getCompoundTagAt(i);
	            byte slot= item.getByte("Slot");
		            
	            if (slot >= 0 && slot < tile.getSizeInventory())
		        {
	            	tile.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
		        }
	        }
    	}
    }
}
