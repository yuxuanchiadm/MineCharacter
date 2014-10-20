package minecharacter.item.grim;

import java.util.List;
import java.util.Set;

import minecharacter.MineCharacter;
import minecharacter.misc.InitItem;
import minecharacter.misc.Localization;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import com.google.common.collect.Sets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemReaper extends ItemTool {
	private static final Set blocksEffectiveAgainst = Sets
			.newHashSet(new Block[] {});

	public ItemReaper(ToolMaterial par2EnumToolMaterial) {
		super(1, par2EnumToolMaterial, blocksEffectiveAgainst);
		this.setCreativeTab(MineCharacter.tabMineCharacter);
		this.setMaxDamage(2341);
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 3600 * 20;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer, int par4) {
		int j = this.getMaxItemUseDuration(par1ItemStack) - par4;
		float f = (float) j / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;

		if (f > 1.0F) {
			f = 1.0F;
		}
		if ((double) f < 1.0D) {
			return;
		}

		if (MineCharacter.proxy.isEquid(par3EntityPlayer, "grim")
				|| par3EntityPlayer.capabilities.isCreativeMode) {
			Useing(par1ItemStack, par2World, par3EntityPlayer, f * 2.0F);
			par3EntityPlayer.swingItem();
		}

	}

	private void Useing(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer, float f) {
		par1ItemStack.damageItem(4, par3EntityPlayer);
		par2World.playSoundAtEntity(par3EntityPlayer, "mob.ghast.scream", 1.0F,
				1.0F / (MineCharacter.ran.nextFloat() * 0.4F + 1.2F));
		List<Entity> list = MineCharacter.proxy.findTarget(par2World,
				AxisAlignedBB.getBoundingBox(par3EntityPlayer.posX - 5,
						par3EntityPlayer.posY - 5, par3EntityPlayer.posZ - 5,
						par3EntityPlayer.posX + 5, par3EntityPlayer.posY + 5,
						par3EntityPlayer.posZ + 5), par3EntityPlayer);
		for (int k2 = 0; k2 < list.size(); k2++) {
			if (list.get(k2) instanceof EntityLivingBase
					&& !(list.get(k2) instanceof EntityEnderman)) {
				EntityLivingBase entity = (EntityLivingBase) list.get(k2);
				double d5 = entity.getDistance(par3EntityPlayer.posX,
						par3EntityPlayer.posY, par3EntityPlayer.posZ);
				if (d5 <= 5.0D) {

					entity.attackEntityFrom(
							DamageSource.causeIndirectMagicDamage(
									par3EntityPlayer, entity), entity
									.getHealth());
					if (!par2World.isRemote) {
						par2World.spawnEntityInWorld(new EntityItem(par2World,
								entity.posX, entity.posY, entity.posZ,
								new ItemStack(InitItem.soul, 1)));

					}
				}
			}
		}

	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {

		par3EntityPlayer.setItemInUse(par1ItemStack,
				this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.bow;
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

}
