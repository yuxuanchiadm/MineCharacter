package minecharacter.proxy;

import minecharacter.MineCharacter;
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
import minecharacter.network.PacketBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.resources.Language;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.FMLOutboundHandler.OutboundTarget;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderInformation() {
		RenderingRegistry.registerEntityRenderingHandler(EntityTomahawk.class,
				new RenderTomahawk());
		RenderingRegistry.registerEntityRenderingHandler(
				EntityStaffFireball.class, new RenderStaffBall());
		RenderingRegistry.registerEntityRenderingHandler(
				EntityStaffIceball.class, new RenderStaffBall());
		RenderingRegistry.registerEntityRenderingHandler(
				EntityStaffLifeball.class, new RenderStaffBall());
		RenderingRegistry.registerEntityRenderingHandler(
				EntityStaffDeathball.class, new RenderStaffBall());
		RenderingRegistry.registerEntityRenderingHandler(EntityShuriken.class,
				new RenderSnowball(InitItem.shuriken));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOrb.class,
				new RenderTileEntityOrb());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPan.class,
				new RenderTileEntityPan());
	}

	@Override
	public int addArmor(String armor) {
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}

	@Override
	public String getCurrentLanguage() {
		Language language = Minecraft.getMinecraft().getLanguageManager()
				.getCurrentLanguage();
		if (language != null) {
			return language.getLanguageCode();
		} else {
			return "en_US";
		}
	}

	@Override
	public void sendToServer(PacketBase packet) {
		FMLEmbeddedChannel channel = MineCharacter.instance.channels
				.get(Side.CLIENT);
		synchronized (channel) {
			channel.attr(FMLOutboundHandler.FML_MESSAGETARGET).set(
					OutboundTarget.TOSERVER);
			channel.writeOutbound(packet);
		}
	}
}
