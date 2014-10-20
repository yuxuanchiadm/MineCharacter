package minecharacter.item.archer;

import minecharacter.MineCharacter;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMechanicBow extends ItemArcherBow {
	public static final String[] mechanicBowPullIconNameArray = new String[] {
			"mechanicBow_pull_0", "mechanicBow_pull_1", "mechanicBow_pull_2",
			"mechanicBow_pull_3" };

	public ItemMechanicBow() {
		super();
		this.setMaxDamage(251);
		damage = 4;
		this.iconTime[0] = 0;
		this.iconTime[1] = 3;
		this.iconTime[2] = 6;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer, int par4) {
		par1ItemStack.damageItem(3, par3EntityPlayer);
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
			iconsetdefalut();
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
				|| (MineCharacter.proxy.isEquid(par3EntityPlayer, "archer") && par3EntityPlayer.inventory
						.hasItem(Items.arrow))) {
			float f = (float) j / 6.0F;
			f = (f * f + f * 2.0F) / 3.0F;

			if ((double) f < 0.1D) {
				return;
			}

			if (f > 1.0F) {
				f = 1.0F;
			}

			EntityArrow entityarrow = new EntityArrow(par2World,
					par3EntityPlayer, f * 2.0F);

			if (f == 1.0F) {
				entityarrow.setIsCritical(true);
			}

			entityarrow.setDamage(this.damage * f);

			par1ItemStack.damageItem(1, par3EntityPlayer);
			if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
			par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F,
					1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

			entityarrow.canBePickedUp = 1;

			par3EntityPlayer.inventory.consumeInventoryItem(Items.arrow);

			if (!par2World.isRemote) {
				par2World.spawnEntityInWorld(entityarrow);
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("minecharacter:"
				+ mechanicBowPullIconNameArray[0]);
		this.iconArray = new IIcon[mechanicBowPullIconNameArray.length];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister.registerIcon("minecharacter:"
					+ mechanicBowPullIconNameArray[i]);
		}
	}

}
