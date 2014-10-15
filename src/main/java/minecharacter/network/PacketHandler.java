package minecharacter.network;


import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

	@Override
	public void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player) {
		ByteArrayDataInput dat = ByteStreams.newDataInput(packet.data);
		int id = dat.readInt();
		Object[] extradata = { (EntityPlayer) player };
		switch (FMLCommonHandler.instance().getEffectiveSide()) {
		case SERVER: {
			switch (id) {
				case 0:
					PacketSetPos.instance.readServer(id, dat,
							extradata);
					break;
				case 1:
					PacketSpawnItem.instance.readServer(id, dat,
							extradata);
				
					break;
			
				
	
			}
			break;
		}
		case CLIENT: {
			switch (id) {
				case 2:
					PacketOrbChange.instance.readClient(id, dat,
							extradata);
					break;
				case 3:
					PacketSpawnLighting.instance.readClient(id, dat,
							extradata);
					break;
			
				
			
			
			}
			break;
		
			
		}
		default:
			break;
		}
	}

}
