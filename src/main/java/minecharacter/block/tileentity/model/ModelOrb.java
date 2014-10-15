package minecharacter.block.tileentity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelOrb extends ModelBase
{
    ModelRenderer body;
    ModelRenderer fireball;
    ModelRenderer iceball;
    ModelRenderer lifeball;
    ModelRenderer deathball;
    ModelRenderer orb;
  
  public ModelOrb()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      body = new ModelRenderer(this, 0, 0);
      body.addBox(-8F, -6F, -8F, 16, 13, 16);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(128, 64);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      fireball = new ModelRenderer(this, 64, 0);
      fireball.addBox(-4F, -2F, -4F, 8, 4, 8);
      fireball.setRotationPoint(0F, -8F, 0F);
      fireball.setTextureSize(128, 64);
      fireball.mirror = true;
      setRotation(fireball, 0F, 0F, 0F);
      iceball = new ModelRenderer(this, 64, 12);
      iceball.addBox(-4F, -2F, -4F, 8, 4, 8);
      iceball.setRotationPoint(0F, -8F, 0F);
      iceball.setTextureSize(128, 64);
      iceball.mirror = true;
      setRotation(iceball, 0F, 0F, 0F);
      lifeball = new ModelRenderer(this, 64, 24);
      lifeball.addBox(-4F, -2F, -4F, 8, 4, 8);
      lifeball.setRotationPoint(0F, -8F, 0F);
      lifeball.setTextureSize(128, 64);
      lifeball.mirror = true;
      setRotation(lifeball, 0F, 0F, 0F);
      deathball = new ModelRenderer(this, 64, 37);
      deathball.addBox(-4F, -2F, -4F, 8, 4, 8);
      deathball.setRotationPoint(0F, -8F, 0F);
      deathball.setTextureSize(128, 64);
      deathball.mirror = true;
      setRotation(deathball, 0F, 0F, 0F);
      orb = new ModelRenderer(this, 64, 49);
      orb.addBox(-4F, -2F, -4F, 8, 4, 8);
      orb.setRotationPoint(0F, -8F, 0F);
      orb.setTextureSize(128, 64);
      orb.mirror = true;
      setRotation(orb, 0F, 0F, 0F);
  }
  
//  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
//  {
//    super.render(entity, f, f1, f2, f3, f4, f5);
//    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
//    body.render(f5);
//    fireball.render(f5);
//    iceball.render(f5);
//    lifeball.render(f5);
//    deathball.render(f5);
//    orb.render(f5);
//  }
//  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  @Override
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5,entity);
  }
  
  
  public void renderBody(){
	  this.body.render(0.065F);
	  
  }
  public void renderfireball(){
	  this.fireball.render(0.065F);
  }

  public void rendericeball(){
	  this.iceball.render(0.065F);
  }
  public void renderlifeball(){
	  this.lifeball.render(0.065F);
  }
  public void renderdeathball(){
	  this.deathball.render(0.065F);
  }
  public void renderball(){
	  this.orb.render(0.065F);
  }
}
