package cosmicblock.lowtech.client.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBarrel extends ModelBase
{
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
  
  public ModelBarrel()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 13, 14, 13);
      Shape1.setRotationPoint(0F, 0F, 0F);
      Shape1.setTextureSize(64, 64);
      Shape1.mirror = true;
      Shape2 = new ModelRenderer(this, 0, 27);
      Shape2.addBox(0F, 0F, 0F, 1, 1, 13);
      Shape2.setRotationPoint(0F, 14F, 0F);
      Shape2.setTextureSize(64, 64);
      Shape2.mirror = true;
      Shape3 = new ModelRenderer(this, 0, 27);
      Shape3.addBox(0F, 0F, 0F, 1, 1, 13);
      Shape3.setRotationPoint(12F, 14F, 0F);
      Shape3.setTextureSize(64, 64);
      Shape3.mirror = true;
      Shape4 = new ModelRenderer(this, 0, 27);
      Shape4.addBox(0F, 0F, 0F, 11, 1, 1);
      Shape4.setRotationPoint(1F, 14F, 0F);
      Shape4.setTextureSize(64, 64);
      Shape4.mirror = true;
      Shape5 = new ModelRenderer(this, 0, 27);
      Shape5.addBox(0F, 0F, 0F, 11, 1, 1);
      Shape5.setRotationPoint(1F, 14F, 12F);
      Shape5.setTextureSize(64, 64);
      Shape5.mirror = true;
      Shape6 = new ModelRenderer(this, 0, 27);
      Shape6.addBox(0F, 0F, 0F, 11, 1, 1);
      Shape6.setRotationPoint(1F, -1F, 0F);
      Shape6.setTextureSize(64, 64);
      Shape6.mirror = true;
      Shape7 = new ModelRenderer(this, 0, 27);
      Shape7.addBox(0F, 0F, 0F, 11, 1, 1);
      Shape7.setRotationPoint(1F, -1F, 12F);
      Shape7.setTextureSize(64, 64);
      Shape7.mirror = true;
      Shape8 = new ModelRenderer(this, 0, 27);
      Shape8.addBox(0F, 0F, 0F, 1, 1, 13);
      Shape8.setRotationPoint(0F, -1F, 0F);
      Shape8.setTextureSize(64, 64);
      Shape8.mirror = true;
      Shape9 = new ModelRenderer(this, 0, 27);
      Shape9.addBox(0F, 0F, 0F, 1, 1, 13);
      Shape9.setRotationPoint(12F, -1F, 0F);
      Shape9.setTextureSize(64, 64);
      Shape9.mirror = true;
      Shape1.offsetY = 0.0625F;
      Shape1.offsetX = 0.09375F;
      Shape1.offsetZ = 0.09375F;
      Shape2.offsetY = 0.0625F;
      Shape2.offsetX = 0.09375F;
      Shape2.offsetZ = 0.09375F;
      Shape3.offsetY = 0.0625F;
      Shape3.offsetX = 0.09375F;
      Shape3.offsetZ = 0.09375F;
      Shape4.offsetY = 0.0625F;
      Shape4.offsetX = 0.09375F;
      Shape4.offsetZ = 0.09375F;
      Shape5.offsetY = 0.0625F;
      Shape5.offsetX = 0.09375F;
      Shape5.offsetZ = 0.09375F;
      Shape6.offsetY = 0.0625F;
      Shape6.offsetX = 0.09375F;
      Shape6.offsetZ = 0.09375F;
      Shape7.offsetY = 0.0625F;
      Shape7.offsetX = 0.09375F;
      Shape7.offsetZ = 0.09375F;
      Shape8.offsetY = 0.0625F;
      Shape8.offsetX = 0.09375F;
      Shape8.offsetZ = 0.09375F;
      Shape9.offsetY = 0.0625F;
      Shape9.offsetX = 0.09375F;
      Shape9.offsetZ = 0.09375F;
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
  }
}
