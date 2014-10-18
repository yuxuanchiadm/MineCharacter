package minecharacter.network;

import io.netty.buffer.ByteBuf;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import minecharacter.MineCharacter;
import minecharacter.block.tileentity.TileEntityOrb;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PacketOrbChange extends PacketBase {
	public int x;
	public int y;
	public int z;
	public int orb;

	public PacketOrbChange() {
	}

	public PacketOrbChange(int x, int y, int z, int orb) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.orb = orb;
	}

	@Override
	public void readData(ByteBuf data) {
		x = data.readInt();
		y = data.readInt();
		z = data.readInt();
		orb = data.readInt();
	}

	@Override
	public void writeData(ByteBuf data) {
		data.writeInt(x);
		data.writeInt(y);
		data.writeInt(z);
		data.writeInt(orb);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void handleClient() {
		WorldClient worldClient = FMLClientHandler.instance().getClient().theWorld;
		TileEntity tile = worldClient.getTileEntity(x, y, z);
		if (tile instanceof TileEntityOrb) {
			worldClient.setBlockMetadataWithNotify(x, y, z, orb, 2);
		}
	}

	public static void orbChange(int x, int y, int z, int orb) {
		MineCharacter.proxy.sendToAllPlayers(new PacketOrbChange(x, y, z, orb));
	}
}
