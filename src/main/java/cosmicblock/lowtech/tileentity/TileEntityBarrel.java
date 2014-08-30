package cosmicblock.lowtech.tileentity;

import cosmicblock.lowtech.block.BlockBarrel;
import cosmicblock.lowtech.item.BarrelItemBlock;
import cosmicblock.lowtech.reference.Names;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBarrel extends TileEntity implements IInventory 
{
	private static final int INVENTORY_SIZE = 54;
	public ItemStack[] inventory;
	
	public TileEntityBarrel()
	{
		inventory = new ItemStack[INVENTORY_SIZE];
	}	
	
	@Override
	public int getSizeInventory()
	{
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot)
	{
		return inventory[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int decrement)
	{
		ItemStack itemStack = getStackInSlot(slot);
		if (itemStack != null)
		{
			if (itemStack.stackSize <= decrement)
			{
				setInventorySlotContents(slot, null);
			}
			else
			{
				itemStack = itemStack.splitStack(decrement);
			}
		}
		
		return itemStack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot)
	{
		ItemStack itemStack = getStackInSlot(slot);
		setInventorySlotContents(slot, null);
		
		return itemStack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemStack)
	{
		inventory[slot] = itemStack;
		
		if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
		{
			itemStack.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName()
	{
		return "Barrel";
	}

	@Override
	public boolean hasCustomInventoryName()
	{
		return true;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <= 64;
	}

	@Override
	public void openInventory()
	{
	}

	@Override
	public void closeInventory()
	{
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemStack)
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
	
    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);

        NBTTagList tagList = new NBTTagList();
        for (int i = 0; i < getSizeInventory(); ++i)
        {
        	ItemStack stack = getStackInSlot(i);
        	
            if (stack != null)
            {
                NBTTagCompound item = new NBTTagCompound();
                item.setByte("Slot", (byte) i);
                stack.writeToNBT(item);
                tagList.appendTag(item);
            }
        }
        compound.setTag("Items", tagList);
    }
	
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);

        NBTTagList items = compound.getTagList("Items", 10);
        inventory = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < items.tagCount(); ++i)
        {
            NBTTagCompound item = items.getCompoundTagAt(i);
            byte slot= item.getByte("Slot");
            
            if (slot >= 0 && slot < getSizeInventory())
            {
                setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
            }
        }
    }
}
