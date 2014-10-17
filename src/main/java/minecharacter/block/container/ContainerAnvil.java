package minecharacter.block.container;

import minecharacter.block.container.slot.SlotAnvil;
import minecharacter.block.container.slot.SlotAnvilHammer;
import minecharacter.block.tileentity.anvilrecipe.AnvingManager;
import minecharacter.misc.InitBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerAnvil extends Container {

	private InventoryAnvil anvilHammer;
	private InventoryAnvil anvilMatrix;
	private IInventory anvResult;
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;
	private SlotAnvilHammer hammer;

	public ContainerAnvil(InventoryPlayer inventoryplayer, World world, int i,
			int j, int k) {
		this.anvilMatrix = new InventoryAnvil(this, 5, 3);
		this.anvilHammer = new InventoryAnvil(this, 1, 1);
		this.anvResult = new InventoryAnvResult();
		this.worldObj = world;
		this.posX = i;
		this.posY = j;
		this.posZ = k;
		this.hammer = new SlotAnvilHammer(this.anvilHammer, 0, 143, 17);
		this.addSlotToContainer(this.hammer);
		this.addSlotToContainer(new SlotAnvil(inventoryplayer.player,
				this.anvilMatrix, this.anvResult, this.hammer, 0, 143, 49));
		for (int l = 0; l < 3; l++) {
			for (int k1 = 0; k1 < 5; k1++) {
				this.addSlotToContainer(new Slot(this.anvilMatrix, k1 + l * 5,
						12 + k1 * 18, 17 + l * 18));
			}

		}

		for (int l1 = 0; l1 < 3; l1++) {
			for (int k2 = 0; k2 < 9; k2++) {
				this.addSlotToContainer(new Slot(inventoryplayer, k2 + l1 * 9
						+ 9, 8 + k2 * 18, 84 + l1 * 18));
			}
		}

		for (int j1 = 0; j1 < 9; j1++) {
			this.addSlotToContainer(new Slot(inventoryplayer, j1, 8 + j1 * 18,
					142));
		}

		this.onCraftMatrixChanged(this.anvilMatrix);
	}

	@Override
	public void onCraftMatrixChanged(IInventory iinventory) {
		if ((this.hammer.getHasStack())
				&& (this.hammer.getStack().getItemDamage() + 50 <= this.hammer
						.getStack().getMaxDamage())) {
			int number = 0;
			int slot = 0;
			for (int i = 0; i < this.anvilMatrix.getSizeInventory(); i++) {
				ItemStack stack = this.anvilMatrix.getStackInSlot(i);
				if ((stack != null)) {
					number++;
					slot = i;
				}
			}

			if (number == 1) {
				ItemStack newitem = ItemStack.copyItemStack(this.anvilMatrix
						.getStackInSlot(slot));
				if (newitem.getItem().isDamageable()) {
					if (newitem.getItemDamage() - 24 > 0) {
						newitem.setItemDamage(newitem.getItemDamage() - 24);
					} else {
						newitem.setItemDamage(0);
					}

					this.anvResult.setInventorySlotContents(0, newitem);
				}
			} else {
				this.anvResult.setInventorySlotContents(0, AnvingManager
						.getInstance().findMatchingRecipe(this.anvilMatrix));

			}

		} else {
			this.anvResult.setInventorySlotContents(0, null);
		}

	}

	@Override
	public void onContainerClosed(EntityPlayer entityplayer) {
		super.onContainerClosed(entityplayer);
		if (this.worldObj.isRemote) {
			return;
		}
		for (int i = 0; i < 15; i++) {
			ItemStack itemstack = this.anvilMatrix.getStackInSlotOnClosing(i);
			if (itemstack != null) {
				entityplayer.entityDropItem(itemstack, 0F);
			}
		}
		ItemStack itemstack = this.hammer.getStack();
		if (itemstack != null) {
			entityplayer.entityDropItem(itemstack, 0F);
		}

	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		if (!this.worldObj.getBlock(this.posX, this.posY, this.posZ).equals(InitBlock.blockAnvil)) {
			return false;
		}
		return entityplayer.getDistanceSq(this.posX + 0.5D, this.posY + 0.5D,
				this.posZ + 0.5D) <= 64.0D;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (par2 == 0) {
				if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
					return null;
				}
			} else if ((par2 >= 17) && (par2 < 44)) {
				if (!this.mergeItemStack(itemstack1, 44, 53, false)) {
					return null;
				}
			} else if ((par2 >= 44) && (par2 < 53)) {
				if (!this.mergeItemStack(itemstack1, 17, 44, false)) {
					return null;
				}
			} else if (!this.mergeItemStack(itemstack1, 17, 53, false)) {
				return null;
			}
			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}
			if (itemstack1.stackSize == itemstack.stackSize) {
				return null;
			}
			slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
		}
		return itemstack;
	}

}
