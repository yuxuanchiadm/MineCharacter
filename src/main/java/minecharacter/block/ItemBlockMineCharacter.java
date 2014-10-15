package minecharacter.block;

import minecharacter.misc.Localization;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMineCharacter extends ItemBlock{

	public ItemBlockMineCharacter(int par1, Block par2Block) {
		super(par1);
		
	}
	@Override
	public int getMetadata(int i) {
		return i;
	}

	@Override
	public String getItemDisplayName(ItemStack itemstack) {
		return Localization.localize(getUnlocalizedName(itemstack));
	}
}
