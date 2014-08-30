package cosmicblock.lowtech.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cosmicblock.lowtech.reference.Textures;
import cosmicblock.lowtech.tileentity.TileEntityBarrel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiBarrel extends GuiContainer
{
	private static final ResourceLocation texture = Textures.GUIs.BARREL;
	private IInventory invBarrel;
	private IInventory invPlayer;
	
	public GuiBarrel(InventoryPlayer invPlayer, TileEntityBarrel invBarrel)
	{
		super(new ContainerBarrel(invPlayer, invBarrel));
		this.invBarrel = invBarrel;
		this.invPlayer = invPlayer;
				
		xSize = 176;
		ySize = 222;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		//drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, 125);
        this.drawTexturedModalRect(x, y + 125, 0, 126, this.xSize, 96);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y)
	{ 
		fontRendererObj.drawString("Barrel", 8, 6, 0x404040);
      	fontRendererObj.drawString("Inventory", 8, ySize - 96 + 2, 4210752);
	}
}