package minecharacter.item.archer;

import javax.swing.Icon;

import minecharacter.MineCharacter;
import minecharacter.misc.Localization;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArcherBow extends ItemBow {
	protected IIcon[] iconArray;
	protected int[] iconTime=new int[3];
	protected double damage; 
	public ItemArcherBow() {
		super();
		this.setCreativeTab(MineCharacter.tabMineCharacter);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getItemIconForUseDuration(int par1) {

		return this.iconArray[par1];
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemStack) {
		return Localization.localize(getUnlocalizedName(itemStack));
	}

	@Override
	public int getItemEnchantability() {

		return 0;
	}

	@Override
	public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
			int j = this.getMaxItemUseDuration(stack) - count;
			this.iconchange(j);
		}

		super.onUsingTick(stack, player, count);
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
