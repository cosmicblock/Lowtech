package cosmicblock.lowtech.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import cosmicblock.lowtech.block.ModBlocks;
import cosmicblock.lowtech.item.ModItems;
import cosmicblock.lowtech.reference.ModInfo;

public class CreativeTab 
{
	public static final CreativeTabs instance = new CreativeTabs(ModInfo.ID)
	{
		@Override
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(ModBlocks.barrel);
		}
	};
}
