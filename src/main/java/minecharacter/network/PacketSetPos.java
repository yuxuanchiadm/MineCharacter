package minecharacter.network;

import io.netty.buffer.ByteBuf;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import minecharacter.MineCharacter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketSetPos extends PacketBase {
	public double x;
	public double y;
	public double z;

	public PacketSetPos() {
	}

	public PacketSetPos(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public void readData(ByteBuf data) {
		x = data.readDouble();
		y = data.readDouble();
		z = data.readDouble();
	}

	@Override
	public void writeData(ByteBuf data) {
		data.writeDouble(x);
		data.writeDouble(y);
		data.writeDouble(z);
	}

	@Override
	public void handleServer(EntityPlayerMP playerEntity) {
		playerEntity.setPosition(x, y, z);

	}

	public static void setPos(double x, double y, double z) {
		MineCharacter.proxy.sendToServer(new PacketSetPos(x, y, z));
	}
}
