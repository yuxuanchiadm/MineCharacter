package minecharacter.misc;

import java.util.EnumSet;

import minecharacter.MineCharacter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class TickHandler implements ITickHandler {
	int tick;

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {

	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		tick++;
		EntityPlayer player = (EntityPlayer) tickData[0];
		if (tick % 200 == 0 && MineCharacter.proxy.isEquid(player, "archer")
				&& notEnoughArrow(player)) {
			player.inventory.addItemStackToInventory(new ItemStack(Item.arrow,
					1));
		}
		if (tick == 2000000) {
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
			if (stack[i] != null
					&& stack[i].getItem().itemID == Item.arrow.itemID) {
				count += stack[i].stackSize;
			}
		}
		if (count < 6) {
			return true;
		}
		return false;
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.PLAYER);
	}

	@Override
	public String getLabel() {
		return "MCtick";
	}

}
