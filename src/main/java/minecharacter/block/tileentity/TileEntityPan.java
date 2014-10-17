package minecharacter.block.tileentity;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPan extends TileEntity {
	public ItemStack inPan = null;
	private int cooked;

	@Override
	public void updateEntity() {
		if (Block.isEqualTo(this.worldObj.getBlock(xCoord, yCoord - 1, zCoord),
				Blocks.fire) && inPan != null) {
			this.cooked++;

		} else {
			this.cooked = 0;
		}
		if (cooked == 200 && this.inPan != null) {
			cookItem();
		}
		super.updateEntity();

	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {

		super.readFromNBT(par1nbtTagCompound);
		this.cooked = par1nbtTagCompound.getShort("cooked");

		this.inPan = ItemStack.loadItemStackFromNBT(par1nbtTagCompound);

	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {

		super.writeToNBT(par1nbtTagCompound);
		par1nbtTagCompound.setShort("cooked", (short) this.cooked);
		this.inPan.writeToNBT(par1nbtTagCompound);

	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
	}

	private void cookItem() {
		ItemStack stack = FurnaceRecipes.smelting().getSmeltingResult(inPan);
		if (stack != null)
			this.inPan = stack;
		this.cooked = 0;

	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);

		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord,
				this.zCoord, 1, tag);
	}

}
