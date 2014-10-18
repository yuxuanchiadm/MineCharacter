package minecharacter.item.knight;

import com.google.common.collect.Multimap;

import minecharacter.MineCharacter;
import minecharacter.misc.Localization;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLance extends ItemSword {
	private int damage;

	public ItemLance(ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.setMaxDamage(3122);
		this.setCreativeTab(MineCharacter.tabMineCharacter);
		this.damage = (int) par2EnumToolMaterial.getDamageVsEntity();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("minecharacter:"
				+ this.getUnlocalizedName().replace("item.", ""));
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack,
			EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {

		par1ItemStack.damageItem(2, par3EntityLiving);
		if ((par2EntityLiving.ridingEntity != null)) {
			par2EntityLiving.mountEntity(null);
		}
		if (par3EntityLiving.ridingEntity != null) {
			par2EntityLiving.attackEntityFrom(DamageSource
					.causeIndirectMagicDamage(par3EntityLiving,
							par2EntityLiving), 6);
		}

		return true;
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemStack) {
		return Localization.localize(getUnlocalizedName(itemStack));
	}

	@Override
	public Multimap getItemAttributeModifiers() {
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.attackDamage
				.getAttributeUnlocalizedName(), new AttributeModifier(
				field_111210_e, "Weapon modifier", (double) this.damage, 0));
		return multimap;
	}
}
