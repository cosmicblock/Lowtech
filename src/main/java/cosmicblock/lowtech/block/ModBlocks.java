package cosmicblock.lowtech.block;

import net.minecraft.block.Block;
import cosmicblock.lowtech.item.BarrelItemBlock;
import cosmicblock.lowtech.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks 
{
	public static Block barrel = new BlockBarrel();

	public static void init()
	{
		GameRegistry.registerBlock(barrel, BarrelItemBlock.class, Names.Blocks.BARREL);
	}
}
