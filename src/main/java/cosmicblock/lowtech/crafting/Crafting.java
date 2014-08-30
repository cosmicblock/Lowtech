package cosmicblock.lowtech.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cosmicblock.lowtech.block.BlockBarrel;
import cosmicblock.lowtech.block.ModBlocks;
import cpw.mods.fml.common.registry.GameRegistry;

public class Crafting 
{
	public static void init()
	{
		for(int meta = 0; meta < BlockBarrel.subTypes.length; meta++)
		{
			GameRegistry.addRecipe(new ItemStack(ModBlocks.barrel, 1, meta), "ppp",  "ixi", "ppp", 'p', new ItemStack(Blocks.planks, 1, meta), 'i', new ItemStack(Items.iron_ingot));
		}
		
	}
}
