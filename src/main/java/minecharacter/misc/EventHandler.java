package minecharacter.misc;

import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import minecharacter.MineCharacter;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;

public class EventHandler {
	public static Random rand = new Random();

	@SubscribeEvent
	public void setTorchOrHarestBlock(PlayerInteractEvent event) {
		EntityPlayer player = event.entityPlayer;
		PlayerInteractEvent.Action action = event.action;
		if (player.dimension == -1) {
			if (action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK) {
				if (player.inventory.getCurrentItem() != null
						&& player.inventory.getCurrentItem().getItem() instanceof ItemTool
						&& rand.nextInt(500) == 1) {
					player.worldObj.newExplosion(null, event.x, event.y,
							event.z, 4.0F, true, true);
				}
			} else if (action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
				if (player.inventory.getCurrentItem() != null
						&& player.inventory.getCurrentItem().getItem().equals(Blocks.torch)
						&& rand.nextInt(500) == 1)
					player.worldObj.newExplosion(null, event.x, event.y,
							event.z, 4.0F, true, true);

			}

		}
	}

	@SubscribeEvent
	public void knightHit(AttackEntityEvent event) {
		EntityPlayer player = event.entityPlayer;
		if (MineCharacter.proxy.isEquid(player, "knight")) {
			if (player.ridingEntity != null
					&& player.ridingEntity instanceof EntityHorse) {
				event.target.attackEntityFrom(
						DamageSource.causePlayerDamage(player), 2);
			}
		}
	}

	@SubscribeEvent
	public void canntFouseonAssassin(LivingSetAttackTargetEvent event) {
		if (event.target instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.target;
			if (MineCharacter.proxy.isEquid(player, "assassin")
					&& player.isPotionActive(Potion.invisibility)) {
				((EntityLiving) event.entityLiving).setAttackTarget(null);

			}
		}

	}

	@SubscribeEvent
	public void harvestDrops(BlockEvent.HarvestDropsEvent event) {
		if ((event.harvester != null)
				&& (event.harvester.inventory.getCurrentItem() != null)
				&& (event.harvester.inventory.getCurrentItem().getItem().canHarvestBlock(event.block, event.harvester.inventory.getCurrentItem()))
				&& (event.harvester.inventory.getCurrentItem().equals(InitItem.netherPickaxe))) {
			ArrayList removeThese = new ArrayList(1);
			ArrayList addThese = new ArrayList(1);

			for (ItemStack input : event.drops) {
				ItemStack result = FurnaceRecipes.smelting().getSmeltingResult(
						input);
				if (result != null) {
					addThese.add(new ItemStack(result.getItem(),
							input.stackSize));
					removeThese.add(input);

					spawnSpeltXP(result, event.world, event.x, event.y, event.z);
				}

			}

			event.drops.removeAll(removeThese);

			event.drops.addAll(addThese);
		}
	}

	private void spawnSpeltXP(ItemStack smelted, World world, int x, int y,
			int z) {
		float floatXP = FurnaceRecipes.smelting().func_151398_b(smelted);
		int smeltXP = (int) floatXP;

		if ((floatXP > smeltXP) && (world.rand.nextFloat() < floatXP - smeltXP)) {
			smeltXP++;
		}

		while (smeltXP > 0) {
			int splitXP = EntityXPOrb.getXPSplit(smeltXP);
			smeltXP -= splitXP;
			world.spawnEntityInWorld(new EntityXPOrb(world, x + 0.5D, y + 0.5D,
					z + 0.5D, splitXP));
		}
	}
}
