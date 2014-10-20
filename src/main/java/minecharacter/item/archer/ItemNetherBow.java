package minecharacter.item.archer;

import minecharacter.MineCharacter;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNetherBow extends ItemArcherBow {
	public static final String[] netherBowPullIconNameArray = new String[] {
			"netherBow_pull_0", "netherBow_pull_1", "netherBow_pull_2",
			"netherBow_pull_3" };

	public ItemNetherBow() {
		super();
		this.setMaxDamage(2341);
		damage = 6;
		this.iconTime[0] = 0;
		this.iconTime[1] = 19;
		this.iconTime[2] = 40;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer, int par4) {
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
			this.iconsetdefalut();
		int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

		ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer,
				par1ItemStack, j);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled()) {
			return;
		}
		j = event.charge;

		boolean flag = par3EntityPlayer.capabilities.isCreativeMode;

		if (flag
				|| (MineCharacter.proxy.isEquid(par3EntityPlayer, "archer")
						&& par3EntityPlayer.inventory.hasItem(Items.arrow) && (getItemSizeinInventory(
						par3EntityPlayer, Items.arrow) >= 3))) {
			float f = (float) j / 40.0F;
			f = (f * f + f * 2.0F) / 3.0F;

			if ((double) f < 0.1D) {
				return;
			}

			if (f > 1.0F) {
				f = 1.0F;
			}
			EntityArrow[] entityarrows = {
					new EntityArrow(par2World, par3EntityPlayer, f * 2.0F),
					new EntityArrow(par2World, par3EntityPlayer, f * 2.0F),
					new EntityArrow(par2World, par3EntityPlayer, f * 2.0F) };

			entityarrows[1].setPosition(entityarrows[1].posX,
					entityarrows[1].posY + 1, entityarrows[1].posZ);

			entityarrows[2].setPosition(entityarrows[2].posX,
					entityarrows[2].posY + 2, entityarrows[2].posZ);

			for (EntityArrow arrow : entityarrows) {
				if (f == 1.0F) {
					arrow.setIsCritical(true);
				}

				arrow.setFire(100);
				arrow.setDamage(this.damage * f);
				if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
					par2World.playSoundAtEntity(par3EntityPlayer, "random.bow",
							1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F)
									+ f * 0.5F);
				arrow.canBePickedUp = 1;
				par3EntityPlayer.inventory.consumeInventoryItem(Items.arrow);
				if (!par2World.isRemote) {
					par2World.spawnEntityInWorld(arrow);
				}
			}

		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("minecharacter:"
				+ netherBowPullIconNameArray[0]);
		this.iconArray = new IIcon[netherBowPullIconNameArray.length];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister.registerIcon("minecharacter:"
					+ netherBowPullIconNameArray[i]);
		}
	}

	private int getItemSizeinInventory(EntityPlayer player, Item item) {
		ItemStack[] mainInventory = player.inventory.mainInventory;
		for (int i = 0; i < mainInventory.length; ++i) {
			if (mainInventory[i] != null && mainInventory[i].getItem() == item) {
				return i;
			}
		}

		return 0;

	}

}
