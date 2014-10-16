package minecharacter.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import minecharacter.MineCharacter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
import cpw.mods.fml.common.network.NetworkRegistry;

public class PacketHandler extends FMLIndexedMessageToMessageCodec<PacketBase> {

	public PacketHandler() {
		addDiscriminator(0, PacketSetPos.class);
		addDiscriminator(1, PacketSpawnItem.class);
		addDiscriminator(2, PacketOrbChange.class);
		addDiscriminator(3, PacketSpawnLighting.class);
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, PacketBase packet,
			ByteBuf data) throws Exception {
		packet.writeData(data);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf data,
			PacketBase packet) {
		packet.readData(data);
		INetHandler netHandler = ctx.channel()
				.attr(NetworkRegistry.NET_HANDLER).get();
		if (netHandler instanceof NetHandlerPlayServer) {
			packet.handleServer(((NetHandlerPlayServer) netHandler).playerEntity);
		} else {
			packet.handleClient();
		}
	}

}
