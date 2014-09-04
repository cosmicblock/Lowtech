package cosmicblock.lowtech.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cosmicblock.lowtech.block.BlockBarrel;
import cosmicblock.lowtech.block.ModBlocks;
import cosmicblock.lowtech.config.Config;
import cosmicblock.lowtech.item.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class Crafting 
{
	public static void init()
	{
		for(int meta = 0; meta < BlockBarrel.subTypes.length; meta++)
		{
			GameRegistry.addRecipe(new ItemStack(ModBlocks.barrel, 1, meta), "ppp",  "ixi", "ppp", 'p', new ItemStack(Blocks.planks, 1, meta), 'i', new ItemStack(Items.iron_ingot));
		}
		
		GameRegistry.addRecipe(new ItemStack(ModItems.mortarandpestle), "ifi", "xix", 'i', new ItemStack(Items.iron_ingot), 'f', new ItemStack(Items.flint));
		
		// mortar and pestle recipes
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, Config.BONEMEAL_YIELD, 15), new ItemStack(ModItems.mortarandpestle, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.bone));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.sugar, Config.SUGAR_YIELD), new ItemStack(ModItems.mortarandpestle, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.reeds));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, Config.PLANT_YIELD, 11), new ItemStack(ModItems.mortarandpestle, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.yellow_flower, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, Config.PLANT_YIELD, 1), new ItemStack(ModItems.mortarandpestle, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.red_flower, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, Config.PLANT_YIELD, 12), new ItemStack(ModItems.mortarandpestle, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.red_flower, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, Config.PLANT_YIELD, 13), new ItemStack(ModItems.mortarandpestle, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.red_flower, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, Config.PLANT_YIELD, 7), new ItemStack(ModItems.mortarandpestle, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.red_flower, 1, 3));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, Config.PLANT_YIELD, 1), new ItemStack(ModItems.mortarandpestle, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.red_flower, 1, 4));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, Config.PLANT_YIELD, 14), new ItemStack(ModItems.mortarandpestle, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.red_flower, 1, 5));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, Config.PLANT_YIELD, 7), new ItemStack(ModItems.mortarandpestle, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.red_flower, 1, 6));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, Config.PLANT_YIELD, 9), new ItemStack(ModItems.mortarandpestle, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.red_flower, 1, 7));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, Config.PLANT_YIELD, 7), new ItemStack(ModItems.mortarandpestle, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.red_flower, 1, 8));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, Config.LARGE_PLANT_YIELD, 11), new ItemStack(ModItems.mortarandpestle, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.double_plant, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, Config.LARGE_PLANT_YIELD, 13), new ItemStack(ModItems.mortarandpestle, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.double_plant, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, Config.LARGE_PLANT_YIELD, 1), new ItemStack(ModItems.mortarandpestle, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.double_plant, 1, 4));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, Config.LARGE_PLANT_YIELD, 9), new ItemStack(ModItems.mortarandpestle, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.double_plant, 1, 5));
	}
}
