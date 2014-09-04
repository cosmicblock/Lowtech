package cosmicblock.lowtech.config;

import java.io.File;

import cosmicblock.lowtech.reference.ModInfo;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import net.minecraftforge.common.config.Configuration;

public class Config
{
	public static int BONEMEAL_YIELD;
	public static int SUGAR_YIELD;
	public static int PLANT_YIELD;
	public static int LARGE_PLANT_YIELD;
	
	public static Configuration configuration;
	
	public static void init(File config)
	{
		if(configuration == null)
		{
			configuration = new Configuration(config);
			loadConfiguration();
		}
	}

	private static void loadConfiguration() 
	{
		BONEMEAL_YIELD = configuration.getInt("bonemeal yield", "Mortar and Pestle", 6, 1, 64, "");
		SUGAR_YIELD = configuration.getInt("sugar yield", "Mortar and Pestle", 2, 1, 64, "");
		PLANT_YIELD = configuration.getInt("plant yield", "Mortar and Pestle", 2, 1, 64, "");
		LARGE_PLANT_YIELD = configuration.getInt("large plant yield", "Mortar and Pestle", 4, 1, 64, "");
		
		if (configuration.hasChanged())
		{
			configuration.save();
		}
	}
	
	 @SubscribeEvent
	 public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	 {
		 if (event.modID.equalsIgnoreCase(ModInfo.ID))
		 {
			 loadConfiguration();
		 }
	 }
}
