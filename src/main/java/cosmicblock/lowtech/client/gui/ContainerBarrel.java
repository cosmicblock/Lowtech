package cosmicblock.lowtech.client.gui;

import invtweaks.api.container.ChestContainer;
import cosmicblock.lowtech.tileentity.TileEntityBarrel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

@ChestContainer(isLargeChest = true)
public class ContainerBarrel extends Container
{
	TileEntityBarrel barrel;

	public ContainerBarrel(InventoryPlayer invPlayer, TileEntityBarrel barrel)
	{
		this.barrel = barrel;
		
		for(int y = 0; y < 6; y++)
		{
			for(int x = 0; x < 9; x++)
			{
				addSlotToContainer(new SlotBarrel(barrel, x + y * 9, 8 + 18 * x, 18 + y * 18));
			}
		}		
		
		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 9; x++)
			{
				addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 8 + 18 * x, (140 - 1) + y * 18));
			}
		}
		
		for(int x = 0; x < 9; x++)
		{
			addSlotToContainer(new Slot(invPlayer, x, 8 + 18 * x, (198 - 1)));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return barrel.isUseableByPlayer(player);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i)
	{
		ItemStack result = null;
		Slot slot = getSlot(i);
		
		if(slot != null && slot.getHasStack())
		{
			ItemStack stack = slot.getStack();
			result = stack.copy();
			
			if(i < barrel.getSizeInventory())
			{
				if(!mergeItemStack(stack, barrel.getSizeInventory(), inventorySlots.size(), true)) 
				{
					return null;
				} 
			} 
			else if (!barrel.isItemValidForSlot(slot.getSlotIndex(), stack))
			{
				return null;
			}
			else if(!mergeItemStack(stack, 0, barrel.getSizeInventory(), false))
			{
				return null; 
			}
				
			if(stack.stackSize == 0)
			{
				slot.putStack(null);
			} 
			else 
			{
				slot.onSlotChanged();
			}	
		}
		return result;
	}
	
	@ChestContainer.RowSizeCallback
	public int getNumColumns()
	{
		return 9;
	 }
}
