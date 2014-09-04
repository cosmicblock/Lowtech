package cosmicblock.lowtech.item;

import cosmicblock.lowtech.creativetab.CreativeTab;
import cosmicblock.lowtech.reference.ModInfo;
import cosmicblock.lowtech.reference.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemMortarAndPestle extends Item
{
	private IIcon[] icons;

	public ItemMortarAndPestle()
	{
		this.setMaxStackSize(1);
		this.setNoRepair();
		this.setMaxDamage(251);
		this.setUnlocalizedName(Names.Items.MORTAR_AND_PESTLE);
		this.setCreativeTab(CreativeTab.instance);
		this.setTextureName(ModInfo.ID + ":" + Names.Items.MORTAR_AND_PESTLE);
	}
	
    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack)
    {
    	return false;
    } 	

    @Override
    public ItemStack getContainerItem(ItemStack itemStack)
    {
       itemStack.setItemDamage(itemStack.getItemDamage() + 1);
       return itemStack;
    }
    
    @Override
    public boolean getShareTag()
    {
        return true;
    }
    
    @Override
    public boolean hasContainerItem(ItemStack stack)
    {
        return true;
    }
}
