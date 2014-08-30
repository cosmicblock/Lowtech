package cosmicblock.lowtech.client.gui;

import cosmicblock.lowtech.Lowtech;
import cosmicblock.lowtech.reference.GuiIds;
import cosmicblock.lowtech.tileentity.TileEntityBarrel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler
{

	public GuiHandler()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(Lowtech.instance, this);
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		switch (ID) 
		{
		case GuiIds.BARREL:
			TileEntity te = world.getTileEntity(x, y, z);
			if(te != null && te instanceof TileEntityBarrel) 
			{
				return new ContainerBarrel(player.inventory, (TileEntityBarrel)te);
			}
			break;
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		switch (ID) 
		{
		case GuiIds.BARREL:
			TileEntity te = world.getTileEntity(x, y, z);
			if(te != null && te instanceof TileEntityBarrel) 
			{
				return new GuiBarrel(player.inventory, (TileEntityBarrel)te);
			}
			break;
		}
		
		return null;
	}
}
