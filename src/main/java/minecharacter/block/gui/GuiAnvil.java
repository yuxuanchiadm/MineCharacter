package minecharacter.block.gui;

import minecharacter.block.container.ContainerAnvil;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

public class GuiAnvil extends GuiContainer {

	public GuiAnvil(InventoryPlayer inventoryplayer, World world, int i, int j, int k)
	  {
	    super(new ContainerAnvil(inventoryplayer, world, i, j, k));
	  }



	  protected void drawGuiContainerForegroundLayer()
	  {
	    this.fontRenderer.drawString("Anvil", 12, 6, 4210752);
	    this.fontRenderer.drawString("Hammer", 134, 6, 4210752);
	  }


	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {	    
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(new ResourceLocation("minecharacter","textures/gui/anvil.png"));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		
	}

}
