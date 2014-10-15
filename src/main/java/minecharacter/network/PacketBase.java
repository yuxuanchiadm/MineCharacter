package minecharacter.network;

import com.google.common.io.ByteArrayDataInput;

public abstract class PacketBase {

	abstract void  readClient(int id, ByteArrayDataInput data, Object[] extradata);


	abstract void readServer(int id, ByteArrayDataInput data, Object[] extradata);
	

	
}
