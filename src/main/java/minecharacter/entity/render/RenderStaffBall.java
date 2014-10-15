package minecharacter.entity.render;

import java.util.Random;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.client.FMLClientHandler;


import minecharacter.entity.staff.EntityStaffBall;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderStaffBall extends Render {

	Random ran=new Random();

	@Override
	public void doRender(Entity entity, double d0, double d1, double d2,
			float f, float f1) {
		renderball(entity,d0,d1,d2,f,f1);
	}


	private void renderball(Entity entity, double d0, double d1, double d2,
			float f, float f1) {

		GL11.glPushMatrix();
	    GL11.glTranslatef((float)d0, (float)d1, (float)d2);
	    GL11.glEnable(GL12.GL_RESCALE_NORMAL);
	    GL11.glScalef(0.5F, 0.5F, 0.5F);
	    Tessellator tessellator = Tessellator.instance;
	   int i=((EntityStaffBall)entity).getAttribute();
	   
	   GL11.glPushMatrix();
	   renderpotion(entity, d0, d1, d2, f, f1,i);
	   GL11.glPopMatrix();
	   GL11.glTranslatef((float)d0, (float)d1, (float)d2);
	   GL11.glColor3f(1.0F, 1.0F, 1.0F);
	   this.bindTexture(this.getEntityTexture(entity));
	 rendering(tessellator);
      	
	    GL11.glDisable(GL12.GL_RESCALE_NORMAL);
	    GL11.glPopMatrix();
	   
	    }

private void renderpotion(Entity entity, double d0, double d1, double d2,
		float f, float f1,int i) {
	 for (int k1 = 0; k1 < 15; ++k1)
     {
        double d7 = ran.nextDouble() * 4.0D;
        double d3 = ran.nextDouble() * Math.PI * 2.0D;
        double  d4 = Math.cos(d3) * d7;
        double  d5 = 0.01D + ran.nextDouble() * 0.5D;
        double d6 = Math.sin(d3) * d7;
         EntityFX entityfx = FMLClientHandler.instance().getClient().renderGlobal.doSpawnParticle("spell", entity.posX + d4 * 0.1D, entity.posY + 0.3D, entity.posZ + d6 * 0.1D, d4, d5, d6);

         if (entityfx != null)
         {
            
        	 if(i==1)
             entityfx.setRBGColorF(0.96F, 0.0F, 0.23F);
        	 else if(i==2)
        		 entityfx.setRBGColorF(0.0F, 0.72F, 0.96F);
        	 else if(i==3)
        		 entityfx.setRBGColorF(0.23F, 0.96F, 0.0F);
        	 else if(i==4)
        		 entityfx.setRBGColorF(0.1F, 0.1F, 0.1F);
        	 else
        		 entityfx.setRBGColorF(0.0F, 0.0F, 0.0F);
             entityfx.multiplyVelocity((float)d7);
         }
     }
	}



private void rendering(Tessellator tessellator)
{
	

	float f3 = 0.0F;
    float f4 = 1.0F;
    float f5 = 0.0F;
    float f6 = 1.0F;
    float f7 = 1.0F;
    float f8 = 0.5F;
    float f9 = 0.25F;
    GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
    GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
    tessellator.startDrawingQuads();
    tessellator.setNormal(0.0F, 1.0F, 0.0F);
    tessellator.addVertexWithUV((double)(0.0F - f8), (double)(0.0F - f9), 0.0D, (double)f3, (double)f6);
    tessellator.addVertexWithUV((double)(f7 - f8), (double)(0.0F - f9), 0.0D, (double)f4, (double)f6);
    tessellator.addVertexWithUV((double)(f7 - f8), (double)(1.0F - f9), 0.0D, (double)f4, (double)f5);
    tessellator.addVertexWithUV((double)(0.0F - f8), (double)(1.0F - f9), 0.0D, (double)f3, (double)f5);
    tessellator.draw();
    GL11.glDisable(GL12.GL_RESCALE_NORMAL);
}



@Override
protected ResourceLocation getEntityTexture(Entity entity) {
	return ((EntityStaffBall)entity).getTextureResource();
}


}
