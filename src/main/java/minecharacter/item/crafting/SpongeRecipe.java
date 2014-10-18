package minecharacter.item.crafting;

import minecharacter.misc.InitBlock;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class SpongeRecipe implements IRecipe {

	@Override
	public boolean matches(InventoryCrafting var1, World var2) {
		if (var1.getSizeInventory() != 9) {
			return false;
		}
		for (int slot = 0; slot < 9; slot++) {
			ItemStack itemStack = var1.getStackInSlot(slot);
			if (itemStack == null) {
				return false;
			}
			if (slot == 4) {
				if (!(itemStack.getItem().equals(Items.dye) && Items.dye.getDamage(itemStack) == 11)) {
					return false;
				}
			} else {
				if (!itemStack.getItem().equals(
						Item.getItemFromBlock(Blocks.leaves))
						&& !itemStack.getItem().equals(
								Item.getItemFromBlock(Blocks.leaves2))) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting var1) {
		return new ItemStack(InitBlock.sponge, 1, 11).copy();
	}

	@Override
	public int getRecipeSize() {
		return 9;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return new ItemStack(InitBlock.sponge, 1, 11);
	}

}
