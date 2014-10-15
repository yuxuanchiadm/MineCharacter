package minecharacter.item.archer;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minecharacter.MineCharacter;
import minecharacter.misc.Localization;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemArcherBow extends ItemBow {
	protected Icon[] iconArray;
	protected int[] iconTime=new int[3];
	protected double damage; 
	public ItemArcherBow(int par1) {
		super(par1);
		this.setCreativeTab(MineCharacter.tabMineCharacter);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getItemIconForUseDuration(int par1) {

		return this.iconArray[par1];
	}

	@Override
	public String getItemDisplayName(ItemStack itemstack) {
		return Localization.localize(getUnlocalizedName(itemstack));
	}

	@Override
	public int getItemEnchantability() {

		return 0;
	}

	@Override
	public void onUsingItemTick(ItemStack stack, EntityPlayer player, int count) {
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
			int j = this.getMaxItemUseDuration(stack) - count;
			this.iconchange(j);
		}

		super.onUsingItemTick(stack, player, count);
	}

	@SideOnly(Side.CLIENT)
	protected void iconsetdefalut() {

		this.itemIcon = this.iconArray[0];

	}

	@SideOnly(Side.CLIENT)
	private void iconchange(int count) {
		if (count > this.iconTime[0]) {
			this.itemIcon = this.iconArray[1];
		}
		if (count > this.iconTime[1]) {
			this.itemIcon = this.iconArray[2];
		}
		if (count > this.iconTime[2]) {
			this.itemIcon = this.iconArray[3];
		}

	}

}
