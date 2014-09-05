package cosmicblock.lowtech.proxy;

import cosmicblock.lowtech.reference.Names;
import cosmicblock.lowtech.tileentity.TileEntityBarrel;
import cpw.mods.fml.common.registry.GameRegistry;


public abstract class CommonProxy implements IProxy 
{
	public void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityBarrel.class, "tile." + Names.Blocks.BARREL);
	}
}
