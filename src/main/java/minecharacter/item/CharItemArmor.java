package minecharacter.item;

import minecharacter.MineCharacter;
import minecharacter.misc.InitItem;
import minecharacter.misc.Localization;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CharItemArmor extends ItemArmor {
	private int tick = 0;

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

	@Override
	public void onArmorTick(World world, EntityPlayer player,
			ItemStack itemStack) {
		tick++;

		if (tick > 200) {
			if (itemStack.getItem().equals(InitItem.archerHelmet)
					&& MineCharacter.proxy.isEquid(player, "archer")
					&& notEnoughArrow(player)) {

				if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER)
					player.inventory.addItemStackToInventory(new ItemStack(
							Items.arrow, 1));

			}

			tick = 0;
		}

		if (MineCharacter.proxy.isEquid(player, "assassin")) {
			player.addPotionEffect(new PotionEffect(1, 20, 1, false));

		}
	}

	private boolean notEnoughArrow(EntityPlayer player) {
		ItemStack[] stack = player.inventory.mainInventory;
		int count = 0;
		for (int i = 0; i < stack.length; i++) {
			if (stack[i] != null && stack[i].getItem().equals(Items.arrow)) {
				count += stack[i].stackSize;
			}
		}
		if (count < 6) {
			return true;
		}
		return false;
	}

}
