package minecharacter.proxy;

import minecharacter.block.tileentity.TileEntityOrb;
import minecharacter.block.tileentity.TileEntityPan;
import minecharacter.block.tileentity.render.RenderTileEntityOrb;
import minecharacter.block.tileentity.render.RenderTileEntityPan;
import minecharacter.entity.EntityShuriken;
import minecharacter.entity.EntityTomahawk;
import minecharacter.entity.render.RenderStaffBall;
import minecharacter.entity.render.RenderTomahawk;
import minecharacter.entity.staff.EntityStaffDeathball;
import minecharacter.entity.staff.EntityStaffFireball;
import minecharacter.entity.staff.EntityStaffIceball;
import minecharacter.entity.staff.EntityStaffLifeball;
import minecharacter.misc.InitItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderInformation() {
		RenderingRegistry.registerEntityRenderingHandler(EntityTomahawk.class, new RenderTomahawk());
		RenderingRegistry.registerEntityRenderingHandler(EntityStaffFireball.class, new RenderStaffBall());
		RenderingRegistry.registerEntityRenderingHandler(EntityStaffIceball.class, new RenderStaffBall());
		RenderingRegistry.registerEntityRenderingHandler(EntityStaffLifeball.class, new RenderStaffBall());
		RenderingRegistry.registerEntityRenderingHandler(EntityStaffDeathball.class, new RenderStaffBall());
		RenderingRegistry.registerEntityRenderingHandler(EntityShuriken.class, new RenderSnowball(InitItem.shuriken));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOrb.class, new RenderTileEntityOrb());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPan.class, new RenderTileEntityPan());
	}

	@Override
	public int addArmor(String armor) {
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
	@Override
	public String getCurrentLanguage() {
		return Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode();
	}
}
