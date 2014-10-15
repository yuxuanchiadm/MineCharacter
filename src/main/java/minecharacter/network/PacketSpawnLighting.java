package minecharacter.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import minecharacter.entity.EntityLightingMjolnir;
import minecharacter.entity.EntityLightningOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;



import com.google.common.io.ByteArrayDataInput;

import cpw.mods.fml.common.network.PacketDispatcher;

public class PacketSpawnLighting extends PacketBase {
	public static PacketSpawnLighting instance=new PacketSpawnLighting();

	@Override
	void readClient(int id, ByteArrayDataInput data, Object[] extradata) {
		double x=data.readDouble();
		double y=data.readDouble();
		double z=data.readDouble();
		int type=data.readInt();
		EntityPlayer player=(EntityPlayer) extradata[0];
		if(type==-12){
			EntityLightingMjolnir lightning = new EntityLightingMjolnir(player.worldObj, player, x + 0.5F, y + 1.5F, z + 0.5F);
			player.worldObj.spawnEntityInWorld(lightning);
		}else{
		EntityLightningOrb lightning = new EntityLightningOrb(player.worldObj, x + 0.5F, y + 1.5F, z + 0.5F,type);
		player.worldObj.spawnEntityInWorld(lightning);
		}

	}

	@Override
	void readServer(int id, ByteArrayDataInput data, Object[] extradata) {

	}
	public static void spawnlight(double x,double y,double z, int type){
		ByteArrayOutputStream bos = new ByteArrayOutputStream(110);
		DataOutputStream dos = new DataOutputStream(bos);
		try {
			dos.writeInt(3);
			dos.writeDouble(x);
			dos.writeDouble(y);
			dos.writeDouble(z);
			dos.writeInt(type);
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Packet250CustomPayload pkt = new Packet250CustomPayload();
		pkt.channel = "minecharacter";
		pkt.data = bos.toByteArray();
		pkt.length = bos.size();
		pkt.isChunkDataPacket = false;
		PacketDispatcher.sendPacketToAllPlayers(pkt);
		
	}

}
