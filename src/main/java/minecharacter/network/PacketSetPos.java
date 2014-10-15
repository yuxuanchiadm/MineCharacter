package minecharacter.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;


import com.google.common.io.ByteArrayDataInput;

import cpw.mods.fml.common.network.PacketDispatcher;

public class PacketSetPos extends PacketBase {

	public static PacketSetPos instance=new PacketSetPos();
	@Override
	void readClient(int id, ByteArrayDataInput data, Object[] extradata) {
		

	}

	@Override
	void readServer(int id, ByteArrayDataInput data, Object[] extradata) {
		double posX=data.readDouble();
		double posY=data.readDouble();
		double posZ=data.readDouble();
		EntityPlayer player=(EntityPlayer) extradata[0];
		player.setPosition(posX, posY, posZ);


	}
	

	public static void setPos(double x,double y,double z){

		ByteArrayOutputStream bos = new ByteArrayOutputStream(110);
		DataOutputStream dos = new DataOutputStream(bos);
		try {
			dos.writeInt(0);
			dos.writeDouble(x);
			dos.writeDouble(y);
			dos.writeDouble(z);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Packet250CustomPayload pkt = new Packet250CustomPayload();
		pkt.channel = "minecharacter";
		pkt.data = bos.toByteArray();
		pkt.length = bos.size();
		pkt.isChunkDataPacket = false;
		PacketDispatcher.sendPacketToServer(pkt);
		
	}
	

}
