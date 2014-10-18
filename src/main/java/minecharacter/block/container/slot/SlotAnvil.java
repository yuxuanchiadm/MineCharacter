package minecharacter.block.container.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotAnvil extends Slot {
	private final IInventory anvilMatrix;
	  private SlotAnvilHammer hammer;
	  public SlotAnvil(EntityPlayer entityplayer, IInventory iinventory, IInventory iinventory1, SlotAnvilHammer iinventory2, int i, int j, int k)
	  {
	    super(iinventory1, i, j, k);
	    this.anvilMatrix = iinventory;
	    this.hammer = iinventory2;
	  }


	  @Override
	public boolean isItemValid(ItemStack par1ItemStack) {
		    return false;
	}

	  @Override
	public void onPickupFromSlot(EntityPlayer thePlayer,ItemStack itemstack)
	  {
	    this.hammer.getStack().damageItem(50, thePlayer);
	    for (int i = 0; i < this.anvilMatrix.getSizeInventory(); i++)
	    {
	    	ItemStack itemstack1 = this.anvilMatrix.getStackInSlot(i);
	      if (itemstack1 != null)
	      {
	        this.anvilMatrix.decrStackSize(i, 1);
	      }
	    }
	  }
}
