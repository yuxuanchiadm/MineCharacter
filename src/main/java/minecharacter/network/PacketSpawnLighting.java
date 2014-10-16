package minecharacter.network;

import io.netty.buffer.ByteBuf;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import cpw.mods.fml.client.FMLClientHandler;
import minecharacter.MineCharacter;
import minecharacter.entity.EntityLightingMjolnir;
import minecharacter.entity.EntityLightningOrb;
import net.minecraft.entity.player.EntityPlayer;

public class PacketSpawnLighting extends PacketBase {
	public double x;
	public double y;
	public double z;
	public int type;

	public PacketSpawnLighting() {
	}

	public PacketSpawnLighting(double x, double y, double z, int type) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.type = type;
	}

	@Override
	public void readData(ByteBuf data) {
		x = data.readDouble();
		y = data.readDouble();
		z = data.readDouble();
		type = data.readInt();
	}

	@Override
	public void writeData(ByteBuf data) {
		data.writeDouble(x);
		data.writeDouble(y);
		data.writeDouble(z);
		data.writeInt(type);
	}

	@Override
	public void handleClient() {
		EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
		if (type == -12) {
			EntityLightingMjolnir lightning = new EntityLightingMjolnir(
					player.worldObj, player, x + 0.5F, y + 1.5F, z + 0.5F);
			player.worldObj.spawnEntityInWorld(lightning);
		} else {
			EntityLightningOrb lightning = new EntityLightningOrb(
					player.worldObj, x + 0.5F, y + 1.5F, z + 0.5F, type);
			player.worldObj.spawnEntityInWorld(lightning);
		}
	}

	public static void spawnlight(double x, double y, double z, int type) {
		MineCharacter.instance.proxy.sendToAllPlayers(new PacketSpawnLighting(
				x, y, z, type));
	}
}
