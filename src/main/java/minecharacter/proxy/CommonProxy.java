package minecharacter.proxy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.relauncher.Side;
import minecharacter.MineCharacter;
import minecharacter.block.container.ContainerAnvil;
import minecharacter.block.gui.GuiAnvil;
import minecharacter.misc.InitItem;
import minecharacter.network.PacketBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class CommonProxy implements IGuiHandler {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Entity> findTarget(World world, AxisAlignedBB aabb,
			EntityPlayer player) {
		List<Entity> entity = new ArrayList();
		List<Entity> willRemove = new ArrayList();
		entity = world.getEntitiesWithinAABBExcludingEntity(player, aabb);
		Iterator<Entity> iterator = entity.iterator();
		while (iterator.hasNext()) {
			Entity temp = iterator.next();
			if (!(temp instanceof EntityLiving))
				willRemove.add(temp);
		}
		entity.removeAll(willRemove);
		return entity;

	}

	public int addArmor(String armor) {
		return 0;

	}

	public boolean isEquid(EntityPlayer player, String string) {
		if (string.equals("mage")) {
			if ((player.inventory.armorInventory[3] != null && player.inventory.armorInventory[3].getItem().equals(InitItem.mageHelmet))
					&& (player.inventory.armorInventory[2] != null && player.inventory.armorInventory[2].getItem().equals(InitItem.mageChest))
					&& (player.inventory.armorInventory[1] != null && player.inventory.armorInventory[1].getItem().equals(InitItem.mageLegs))
					&& (player.inventory.armorInventory[0] != null && player.inventory.armorInventory[0].getItem().equals(InitItem.mageBoots)))
				return true;
		} else if (string.equals("grim")) {
			if ((player.inventory.armorInventory[3] != null && player.inventory.armorInventory[3].getItem().equals(InitItem.grimHelmet))
					&& (player.inventory.armorInventory[2] != null && player.inventory.armorInventory[2].getItem().equals(InitItem.grimChest))
					&& (player.inventory.armorInventory[1] != null && player.inventory.armorInventory[1].getItem().equals(InitItem.grimLegs))
					&& (player.inventory.armorInventory[0] != null && player.inventory.armorInventory[0].getItem().equals(InitItem.grimBoots)))
				return true;
		} else if (string.equals("archer")) {
			if ((player.inventory.armorInventory[3] != null && player.inventory.armorInventory[3].getItem().equals(InitItem.archerHelmet))
					&& (player.inventory.armorInventory[2] != null && player.inventory.armorInventory[2].getItem().equals(InitItem.archerChest))
					&& (player.inventory.armorInventory[1] != null && player.inventory.armorInventory[1].getItem().equals(InitItem.archerLegs))
					&& (player.inventory.armorInventory[0] != null && player.inventory.armorInventory[0].getItem().equals(InitItem.archerBoots)))
				return true;
		} else if (string.equals("knight")) {
			if ((player.inventory.armorInventory[3] != null && player.inventory.armorInventory[3].getItem().equals(InitItem.knightHelmet))
					&& (player.inventory.armorInventory[2] != null && player.inventory.armorInventory[2].getItem().equals(InitItem.knightChest))
					&& (player.inventory.armorInventory[1] != null && player.inventory.armorInventory[1].getItem().equals(InitItem.knightLegs))
					&& (player.inventory.armorInventory[0] != null && player.inventory.armorInventory[0].getItem().equals(InitItem.knightBoots)))
				return true;
		} else if (string.equals("assassin")) {
			if ((player.inventory.armorInventory[3] != null && player.inventory.armorInventory[3].getItem().equals(InitItem.assassinHelmet))
					&& (player.inventory.armorInventory[2] != null && player.inventory.armorInventory[2].getItem().equals(InitItem.assassinChest))
					&& (player.inventory.armorInventory[1] != null && player.inventory.armorInventory[1].getItem().equals(InitItem.assassinLegs))
					&& (player.inventory.armorInventory[0] != null && player.inventory.armorInventory[0].getItem().equals(InitItem.assassinBoots)))
				return true;
		}
		return false;

	}

	public void registerRenderInformation() {

	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {

		switch (ID) {
		case 0:

			return new ContainerAnvil(player.inventory, world, x, y, z);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {

		switch (ID) {
		case 0:

			return new GuiAnvil(player.inventory, world, x, y, z);
		}
		return null;

	}

	public String getCurrentLanguage() {

		return null;
	}

	public void sendToServer(PacketBase packet) {

	}

	public void sendToAllPlayers(PacketBase packet) {
		FMLEmbeddedChannel channel = MineCharacter.instance.channels
				.get(Side.SERVER);
		synchronized (channel) {
			channel.attr(FMLOutboundHandler.FML_MESSAGETARGET).set(
					FMLOutboundHandler.OutboundTarget.ALL);
			channel.writeOutbound(packet);
		}
	}

	public void sendToPlayer(EntityPlayer player, PacketBase packet) {
		FMLEmbeddedChannel channel = MineCharacter.instance.channels
				.get(Side.SERVER);
		synchronized (channel) {
			channel.attr(FMLOutboundHandler.FML_MESSAGETARGET).set(
					FMLOutboundHandler.OutboundTarget.PLAYER);
			channel.attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
			channel.writeOutbound(packet);
		}
	}

}
