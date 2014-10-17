package minecharacter.item.assassin;

import minecharacter.MineCharacter;
import minecharacter.item.ItemMineCharacter;
import minecharacter.misc.Localization;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSmokeGrenade extends ItemMineCharacter {

	public ItemSmokeGrenade(int par1) {
		super();
		this.setMaxStackSize(1);
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemStack) {
		return Localization.localize(getUnlocalizedName(itemStack));
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		if (MineCharacter.proxy.isEquid(par3EntityPlayer, "assassin")
				|| par3EntityPlayer.capabilities.isCreativeMode) {
			par3EntityPlayer.swingItem();
			par3EntityPlayer.addPotionEffect(new PotionEffect(
					Potion.invisibility.id, 20 * 60, 0, false));

			for (int i = 0; i < 20; i++)
				par2World.spawnParticle("hugeexplosion", par3EntityPlayer.posX
						+ Item.itemRand.nextGaussian(), par3EntityPlayer.posY
						+ Item.itemRand.nextGaussian(), par3EntityPlayer.posZ
						+ Item.itemRand.nextGaussian(), 1.0D, 0.0D, 0.0D);
		}
		par2World.playSoundEffect(par3EntityPlayer.posX, par3EntityPlayer.posY,
				par3EntityPlayer.posZ, "random.explode", 4.0F,
				(1.0F + (par2World.rand.nextFloat() - par2World.rand
						.nextFloat()) * 0.2F) * 0.7F);

		par1ItemStack.stackSize--;

		return super.onItemRightClick(par1ItemStack, par2World,
				par3EntityPlayer);
	}

}
