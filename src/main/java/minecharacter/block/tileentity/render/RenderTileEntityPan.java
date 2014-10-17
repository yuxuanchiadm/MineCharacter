package minecharacter.block.tileentity.render;

import minecharacter.block.tileentity.TileEntityPan;
import minecharacter.block.tileentity.model.ModelPan;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;


public class RenderTileEntityPan extends TileEntitySpecialRenderer {
	ModelPan model=new ModelPan();
	IIcon item=null;

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1,
			double d2, float f) {
	renderPan((TileEntityPan)tileentity,d0,d1,d2,f);
	renderItemInPan((TileEntityPan)tileentity,d0,d1,d2,f);
	}

	private void renderItemInPan(TileEntityPan tileentity, double d0,double d1, double d2, float f) {
		GL11.glPushMatrix();
	  GL11.glTranslatef((float)d0 + 0.5F, (float)d1-0.5F+2, (float)d2 + 0.5F);
		if (tileentity.inPan != null) {
			try {
				ItemStack stack=tileentity.inPan;
				EntityItem item=new EntityItem(tileentity.getWorldObj(), d0, d1, d2, stack);
				RenderManager.instance.renderEntityWithPosYaw(item, 0.0D, -1.5D, 0.0D, 45F,0.0F);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}

		GL11.glPopMatrix();
		
		
	}

	private void renderPan(TileEntityPan tileentity, double d0, double d1,double d2, float f) {

		
		GL11.glPushMatrix();
		  GL11.glTranslatef((float)d0 + 0.5F, (float)d1-0.5F, (float)d2 + 0.5F);

		  this.bindTexture(new ResourceLocation("minecharacter","textures/tileentity/pan.png"));
		  float r=180;
		  if(tileentity.getBlockMetadata()==2){r=0F;}
		if(tileentity.getBlockMetadata()==1){r=90F;}
		if(tileentity.getBlockMetadata()==3){r=270F;}
		  GL11.glRotatef(r, 0.0F, 1.0F, 0.0F);
			model.render(0.065F);
			GL11.glPopMatrix();
		
	}

}
