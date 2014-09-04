package cosmicblock.lowtech.item;

import cosmicblock.lowtech.block.BlockBarrel;
import cosmicblock.lowtech.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class ModItems
{
	public static Item mortarandpestle = new ItemMortarAndPestle();
	
	public static void init()
	{
		GameRegistry.registerItem(mortarandpestle, Names.Items.MORTAR_AND_PESTLE);
	}
}
