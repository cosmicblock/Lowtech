package cosmicblock.lowtech.reference;

import net.minecraft.util.ResourceLocation;

public final class Textures 
{
	public static final class Models
	{
		public static final ResourceLocation[] BARREL = {
			new ResourceLocation(ModInfo.ID, "textures/models/barrel_oak.png"),
			new ResourceLocation(ModInfo.ID, "textures/models/barrel_spruce.png"),
			new ResourceLocation(ModInfo.ID, "textures/models/barrel_birch.png"),
			new ResourceLocation(ModInfo.ID, "textures/models/barrel_jungle.png"),
			new ResourceLocation(ModInfo.ID, "textures/models/barrel_acacia.png"),
			new ResourceLocation(ModInfo.ID, "textures/models/barrel_dark.png")
		};
	}
	
	public static final class GUIs
	{
		public static final ResourceLocation BARREL = new ResourceLocation(ModInfo.ID, "textures/gui/barrel.png");
	}
}
