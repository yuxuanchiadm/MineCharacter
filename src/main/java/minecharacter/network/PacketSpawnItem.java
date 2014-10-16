package minecharacter.network;

import io.netty.buffer.ByteBuf;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import minecharacter.MineCharacter;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PacketSpawnItem extends PacketBase {
	public int itemId;
	public int meate;
	public int count;
	public double x;
	public double y;
	public double z;

	public PacketSpawnItem() {
	}

	public PacketSpawnItem(int itemId, int meate, int count, double x,
			double y, double z) {
		this.itemId = itemId;
		this.meate = meate;
		this.count = count;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public void readData(ByteBuf data) {
		itemId = data.readInt();
		meate = data.readInt();
		count = data.readInt();
		x = data.readDouble();
		y = data.readDouble();
		z = data.readDouble();
	}

	@Override
	public void writeData(ByteBuf data) {
		data.writeInt(itemId);
		data.writeInt(meate);
		data.writeInt(count);
		data.writeDouble(x);
		data.writeDouble(y);
		data.writeDouble(z);
	}

	@Override
	public void handleServer(EntityPlayerMP playerEntity) {
		World world = playerEntity.worldObj;
		playerEntity.worldObj.spawnEntityInWorld(new EntityItem(world, x, y, z,
				new ItemStack(Item.getItemById(itemId), count, meate)));

	}

	public static void spawnItem(int itemId, int meate, int count, double x,
			double y, double z) {
		MineCharacter.proxy.sendToServer(new PacketSpawnItem(itemId, meate,
				count, x, y, z));
	}
}