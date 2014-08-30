package cosmicblock.lowtech;

import cosmicblock.lowtech.block.ModBlocks;
import cosmicblock.lowtech.client.gui.GuiHandler;
import cosmicblock.lowtech.crafting.Crafting;
import cosmicblock.lowtech.item.ModItems;
import cosmicblock.lowtech.proxy.IProxy;
import cosmicblock.lowtech.reference.ModInfo;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModInfo.ID, version = ModInfo.VERSION)
public class Lowtech
{   
    @Instance(ModInfo.ID)
    public static Lowtech instance;

    @SidedProxy(clientSide = ModInfo.PROXY_CLIENT, serverSide = ModInfo.PROXY_SERVER)
    public static IProxy proxy;
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	ModItems.init();
    	ModBlocks.init();
    	Crafting.init();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.registerTileEntities();
    	proxy.initRenderingAndTextures();
    	new GuiHandler();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	
    }
}
