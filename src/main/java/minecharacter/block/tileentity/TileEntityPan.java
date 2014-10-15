package minecharacter.block.tileentity;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPan extends TileEntity {
	public int inPan = -1;
	private int cooked;
	@Override
	public void updateEntity() {
		if(this.worldObj.getBlockId(xCoord, yCoord-1, zCoord)==Block.fire.blockID&&inPan!=-1){
			this.cooked++;
			
		}
		else{
			this.cooked=0;
		}
		if (cooked == 200 && this.inPan != -1) {
			cookItem();
		}
		super.updateEntity();
		
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {

	
		super.readFromNBT(par1nbtTagCompound);
		this.cooked = par1nbtTagCompound.getShort("cooked");
		this.inPan = par1nbtTagCompound.getInteger("inPan");
	
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
	
		super.writeToNBT(par1nbtTagCompound);

		par1nbtTagCompound.setShort("cooked", (short) this.cooked);
		par1nbtTagCompound.setInteger("inPan", this.inPan);
		

	}

	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt) {

		readFromNBT(pkt.data);
	}

	private void cookItem() {
		ItemStack stack = FurnaceRecipes.smelting().getSmeltingResult(
				new ItemStack(inPan, 1, 0));
		if (stack != null)
			this.inPan = stack.itemID;
		this.cooked = 0;

	}
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);
		return new Packet132TileEntityData(this.xCoord, this.yCoord,this.zCoord, 1, tag);
	}
}
