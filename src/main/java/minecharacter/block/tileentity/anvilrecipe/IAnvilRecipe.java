package minecharacter.block.tileentity.anvilrecipe;

import minecharacter.block.container.InventoryAnvil;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IAnvilRecipe {
	boolean matches(InventoryAnvil paramInventoryAnvil, World par2World);

	ItemStack getCraftingResult(InventoryAnvil paramInventoryAnvil);

	int getRecipeSize();

	ItemStack getRecipeOutput();

}
