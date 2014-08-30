package cosmicblock.lowtech.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cosmicblock.lowtech.block.ModBlocks;
import cosmicblock.lowtech.client.render.item.RenderBarrelItemBlock;
import cosmicblock.lowtech.client.render.model.ModelBarrel;
import cosmicblock.lowtech.client.render.tileentity.TileEntityBarrelRenderer;
import cosmicblock.lowtech.reference.RenderIds;
import cosmicblock.lowtech.tileentity.TileEntityBarrel;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;


public class ClientProxy extends CommonProxy
{
	@Override
	public void initRenderingAndTextures()
	{
		RenderIds.barrel = RenderingRegistry.getNextAvailableRenderId();
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarrel.class, new TileEntityBarrelRenderer());
		
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.barrel), new RenderBarrelItemBlock(new ModelBarrel()));
	}
}
