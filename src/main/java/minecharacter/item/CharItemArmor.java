package minecharacter.item;

import minecharacter.MineCharacter;
import minecharacter.misc.InitItem;
import minecharacter.misc.Localization;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CharItemArmor extends ItemArmor {

	public CharItemArmor(ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(MineCharacter.tabMineCharacter);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("minecharacter:"
				+ this.getUnlocalizedName().replace("item.", ""));
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemStack) {
		return Localization.localize(getUnlocalizedName(itemStack));
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {
		if ((stack.getItem().equals(InitItem.knightHelmet))
				|| (stack.getItem().equals(InitItem.knightChest))
				|| (stack.getItem().equals(InitItem.knightBoots))) {
			return "minecharacter:textures/models/armor/knight_1.png";
		}
		if (stack.getItem().equals(InitItem.knightLegs)) {
			return "minecharacter:textures/models/armor/knight_2.png";
		}
		if ((stack.getItem().equals(InitItem.grimHelmet))
				|| (stack.getItem().equals(InitItem.grimChest))
				|| (stack.getItem().equals(InitItem.grimBoots))) {
			return "minecharacter:textures/models/armor/grim_1.png";
		}
		if (stack.getItem().equals(InitItem.grimLegs)) {
			return "minecharacter:textures/models/armor/grim_2.png";
		}
		if ((stack.getItem().equals(InitItem.mageHelmet))
				|| (stack.getItem().equals(InitItem.mageChest))
				|| (stack.getItem().equals(InitItem.mageBoots))) {
			return "minecharacter:textures/models/armor/mage_1.png";
		}
		if (stack.getItem().equals(InitItem.mageLegs)) {
			return "minecharacter:textures/models/armor/mage_2.png";
		}
		if ((stack.getItem().equals(InitItem.archerHelmet))
				|| (stack.getItem().equals(InitItem.archerChest))
				|| (stack.getItem().equals(InitItem.archerBoots))) {
			return "minecharacter:textures/models/armor/archer_1.png";
		}
		if (stack.getItem().equals(InitItem.archerLegs)) {
			return "minecharacter:textures/models/armor/archer_2.png";
		}
		if ((stack.getItem().equals(InitItem.assassinHelmet))
				|| (stack.getItem().equals(InitItem.assassinChest))
				|| (stack.getItem().equals(InitItem.assassinBoots))) {
			return "minecharacter:textures/models/armor/assassin_1.png";
		}
		if (stack.getItem().equals(InitItem.assassinLegs)) {
			return "minecharacter:textures/models/armor/assassin_2.png";
		}
		return "";
	}



}
