package minecharacter.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import minecharacter.block.tileentity.TileEntityOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;



import com.google.common.io.ByteArrayDataInput;

import cpw.mods.fml.common.network.PacketDispatcher;

public class PacketOrbChange extends PacketBase {
	public static PacketOrbChange instance=new PacketOrbChange();
	@Override
	void readClient(int id, ByteArrayDataInput data, Object[] extradata) {
		
		EntityPlayer player=(EntityPlayer) extradata[0];
		int x=data.readInt();
		int y=data.readInt();
		int z=data.readInt();
		int orb=data.readInt();
		TileEntity tile=player.worldObj.getBlockTileEntity(x, y, z);
		if(tile instanceof TileEntityOrb){
		player.worldObj.setBlockMetadataWithNotify(x, y, z, orb, 2);
		}
	}

	@Override
	void readServer(int id, ByteArrayDataInput data, Object[] extradata) {

	}
	

	public static void orbChange(int x,int y,int z,int orb){

		ByteArrayOutputStream bos = new ByteArrayOutputStream(110);
		DataOutputStream dos = new DataOutputStream(bos);
		try {
			dos.writeInt(2);
			dos.writeInt(x);
			dos.writeInt(y);
			dos.writeInt(z);
			dos.writeInt(orb);
			
			
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
