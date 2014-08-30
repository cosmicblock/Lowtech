package cosmicblock.lowtech.client.render.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;	

import cosmicblock.lowtech.client.render.model.ModelBarrel;
import cosmicblock.lowtech.reference.ModInfo;
import cosmicblock.lowtech.reference.Textures;

public class TileEntityBarrelRenderer extends TileEntitySpecialRenderer
{
	private final ModelBarrel modelBarrel = new ModelBarrel();
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick)
	{
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x, (float) y, (float) z);
        GL11.glScalef(1F, 1F, 1F);
        setTextureFromMetadata(tileEntity.getBlockMetadata());
        modelBarrel.render(null, 0F, 0F, 0F, 0F, 0F, 0.0625F);
        GL11.glPopMatrix();
	}
	
	public void setTextureFromMetadata(int meta)
	{
		ResourceLocation resourceLocation;
		this.bindTexture(Textures.Models.BARREL[meta]);
	}
}
