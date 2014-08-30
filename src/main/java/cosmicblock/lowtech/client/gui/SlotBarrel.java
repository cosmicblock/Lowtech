package cosmicblock.lowtech.client.gui;

import cosmicblock.lowtech.item.BarrelItemBlock;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;

public class SlotBarrel extends Slot {

	public SlotBarrel(IInventory inventory, int slot, int x, int y) 
	{
		super(inventory, slot, x, y);
	}

	@Override
    public boolean isItemValid(ItemStack itemStack)
    {
		if(itemStack.getItem() instanceof BarrelItemBlock)
		{
			if(itemStack.getTagCompound() != null)
			{
				NBTTagList items = itemStack.getTagCompound().getTagList("Items", 10);
				if(items.tagCount() > 0)
				{
					return false;
				}
			}
		}
		return true;
    }
}
