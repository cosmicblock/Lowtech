package cosmicblock.lowtech.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cosmicblock.lowtech.reference.Names;

public class BarrelItemBlock extends ItemBlock
{
	private final String[] subTypes = {"oak", "spruce", "birch", "jungle", "acacia", "dark"};
	
	public BarrelItemBlock(Block block)
	{
		super(block);
		this.setMaxDamage(0);
		this.setMaxStackSize(1);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(Names.Blocks.BARREL);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return getUnlocalizedName() + "." + subTypes[stack.getItemDamage()];
	}
	
	 @Override
	 public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
	 {
		 int itemCount = 0;
		 
		 if (stack.hasTagCompound())
		 {
			 NBTTagList items = stack.getTagCompound().getTagList("Items", 10);
			 if(items != null)
			 {
				 for (int i = 0; i < items.tagCount(); ++i)
				 {
					 NBTTagCompound item = items.getCompoundTagAt(i);
					 int size = ItemStack.loadItemStackFromNBT(item).stackSize;
					 itemCount += size;
				 }
			 }
		 }
		 
		 if(itemCount == 0)
		 {
			 list.add("Empty");
		 } else {
			 list.add(Integer.toString(itemCount) + " " + (itemCount == 1 ? "Item" : "Items"));
		 }
	 }
}
