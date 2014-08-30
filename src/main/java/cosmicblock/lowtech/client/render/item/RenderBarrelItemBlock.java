package cosmicblock.lowtech.client.render.item;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import cosmicblock.lowtech.client.render.model.ModelBarrel;
import cosmicblock.lowtech.reference.Textures;


public class RenderBarrelItemBlock implements IItemRenderer
{
	private final String[] subTypes = {"oak", "spruce", "birch", "jungle", "acacia", "darkoak"};

	private ModelBarrel model;
	
	public RenderBarrelItemBlock(ModelBarrel model)
	{
		this.model = model;
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		GL11.glPushMatrix();
	
		
		switch(type)
		{
		case INVENTORY:
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef(0.0F, -0.085F, 0.0F);
			break;
		case EQUIPPED:
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef(0.0F, 0.0F, 0.0F);
			break;
		case ENTITY:
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef(0.0F, 0.0F, 0.0F);
			break;
		case EQUIPPED_FIRST_PERSON:
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef(0.0F, 0.0F, 0.0F);
			break;
		default:
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef(0.0F, 0.0F, 0.0F);
			break;
		}
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(Textures.Models.BARREL[item.getItemDamage()]);
		model.render(null, 0, 0, 0, 0, 0, 0.0625F);
		
		GL11.glPopMatrix();
	}
}
