package minecharacter.entity.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import minecharacter.entity.EntityTomahawk;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderTomahawk extends Render {

	@Override
	public void doRender(Entity entity, double d0, double d1, double d2,
			float f, float f1) {
		  renderTomahawk((EntityTomahawk)entity, d0, d1, d2, f, f1);

	}

	private void renderTomahawk(EntityTomahawk entity, double d0, double d1,
			double d2, float f, float f1) {
	   this.bindTexture(new ResourceLocation("minecharacter","textures/entity/tomahawks.png"));
	    GL11.glPushMatrix();
	    GL11.glTranslatef((float)d0, (float)d1, (float)d2);
	    GL11.glRotatef(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * f1 - 90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * f1, 0.0F, 0.0F, 1.0F);
	    Tessellator tessellator = Tessellator.instance;
	    float f2 = 0.25F;
	    float f3 = 0.0F;
	    float f4 = 0.46875F;
	    float f5 = 0.0F;

	    float f6 = 0.0F;
	    float f7 = 0.125F;
	    float f8 = 0.5F;
	    float f9 = 0.96875F;

	    float f10 = 0.05625F;
	    GL11.glEnable(GL12.GL_RESCALE_NORMAL);
	    GL11.glScalef(f10, f10, f10);
	    GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
	    GL11.glNormal3f(f10, 0.0F, 0.0F);
	    tessellator.startDrawingQuads();
	    tessellator.addVertexWithUV(0.0D, -12.0D, -1.5D, f6, f9);
	    tessellator.addVertexWithUV(0.0D, -12.0D, 1.5D, f7, f9);
	    tessellator.addVertexWithUV(0.0D, 2.0D, 1.5D, f7, f8);
	    tessellator.addVertexWithUV(0.0D, 2.0D, -1.5D, f6, f8);
	    tessellator.draw();
	    GL11.glNormal3f(-f10, 0.0F, 0.0F);
	    tessellator.startDrawingQuads();
	    tessellator.addVertexWithUV(0.0D, 2.0D, -1.5D, f6, f8);
	    tessellator.addVertexWithUV(0.0D, 2.0D, 1.5D, f7, f8);
	    tessellator.addVertexWithUV(0.0D, -12.0D, 1.5D, f7, f9);
	    tessellator.addVertexWithUV(0.0D, -12.0D, -1.5D, f6, f9);
	    tessellator.draw();
	    GL11.glNormal3f(0.0F, 0.0F, f10);
	    tessellator.startDrawingQuads();
	    tessellator.addVertexWithUV(-1.5D, -12.0D, 0.0D, f3, f4);
	    tessellator.addVertexWithUV(5.5D, -12.0D, 0.0D, f2, f4);
	    tessellator.addVertexWithUV(5.5D, 2.0D, 0.0D, f2, f5);
	    tessellator.addVertexWithUV(-1.5D, 2.0D, 0.0D, f3, f5);
	    tessellator.draw();
	    GL11.glNormal3f(0.0F, 0.0F, f10);
	    tessellator.startDrawingQuads();
	    tessellator.addVertexWithUV(5.5D, -12.0D, 0.0D, f2, f4);
	    tessellator.addVertexWithUV(-1.5D, -12.0D, 0.0D, f3, f4);
	    tessellator.addVertexWithUV(-1.5D, 2.0D, 0.0D, f3, f5);
	    tessellator.addVertexWithUV(5.5D, 2.0D, 0.0D, f2, f5);
	    tessellator.draw();

	    GL11.glDisable(GL12.GL_RESCALE_NORMAL);
	    GL11.glPopMatrix();
		
	}



	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		// PLAN Auto-generated method stub
		return null;
	}

}
