package minecharacter.misc;

import java.util.EnumSet;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import minecharacter.MineCharacter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

public class TickHandler {
	int tick;
	
    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent event)
    {
        if(event.phase == TickEvent.Phase.START)
        {
        	tick++;
    		EntityPlayer player = event.player;
    		if (tick % 200 == 0 && MineCharacter.proxy.isEquid(player, "archer")
    				&& notEnoughArrow(player)) {
    			player.inventory.addItemStackToInventory(new ItemStack(Items.arrow,
    					1));
    		}
    		if (tick == 2000000) {
    			tick = 0;
    		}
    		if (MineCharacter.proxy.isEquid(player, "assassin")) {
    			player.addPotionEffect(new PotionEffect(1, 20, 1, false));

    		}
        }
    }

	private boolean notEnoughArrow(EntityPlayer player) {
		ItemStack[] stack = player.inventory.mainInventory;
		int count = 0;
		for (int i = 0; i < stack.length; i++) {
			if (stack[i] != null
					&& stack[i].getItem().equals(Items.arrow)) {
				count += stack[i].stackSize;
			}
		}
		if (count < 6) {
			return true;
		}
		return false;
	}
}
