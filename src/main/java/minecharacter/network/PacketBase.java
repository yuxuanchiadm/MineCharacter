package minecharacter.network;

import net.minecraft.entity.player.EntityPlayerMP;
import io.netty.buffer.ByteBuf;

import com.google.common.io.ByteArrayDataInput;

public abstract class PacketBase {
	public abstract void writeData(ByteBuf data);

	public abstract void readData(ByteBuf data);

	public void handleServer(EntityPlayerMP playerEntity) {
	}

	public void handleClient() {
	}
}
