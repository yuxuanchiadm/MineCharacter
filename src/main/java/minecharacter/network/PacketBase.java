package minecharacter.network;

import net.minecraft.entity.player.EntityPlayerMP;
import io.netty.buffer.ByteBuf;

import com.google.common.io.ByteArrayDataInput;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class PacketBase {
	public abstract void writeData(ByteBuf data);

	public abstract void readData(ByteBuf data);

	public void handleServer(EntityPlayerMP playerEntity) {
	}

	@SideOnly(Side.CLIENT)
	public void handleClient() {
	}
}
