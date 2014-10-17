package minecharacter.block;

import minecharacter.misc.Localization;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMineCharacter extends ItemBlock {

	public ItemBlockMineCharacter(Block par2Block) {
		super(par2Block);

	}

	@Override
	public int getMetadata(int i) {
		return i;
	}

	@Override
	public String getItemStackDisplayName(ItemStack arg0) {
		return Localization.localize(getUnlocalizedName(arg0));
	}

}
