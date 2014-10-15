package minecharacter.item.assassin;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minecharacter.MineCharacter;
import minecharacter.misc.Localization;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;

public class ItemDragger extends ItemSword {
	private int demage;
	public ItemDragger(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setMaxDamage(3122);
		this.setCreativeTab(MineCharacter.tabMineCharacter);
		this.demage=(int) (2+par2EnumToolMaterial.getDamageVsEntity());
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon=par1IconRegister.registerIcon("minecharacter:"+this.getUnlocalizedName().replace("item.", ""));
	}

	@Override
	public int getDamage(ItemStack stack) {
		return this.demage;
	}
	@Override
	public String getItemDisplayName(ItemStack itemstack) {
		return Localization.localize(getUnlocalizedName(itemstack));
	}
	@Override
	public boolean hitEntity(ItemStack par1ItemStack,EntityLivingBase par2EntityLivingBase,EntityLivingBase par3EntityLivingBase) {
		
		if(MineCharacter.proxy.isEquid((EntityPlayer) par3EntityLivingBase, "assassin")&&Item.itemRand.nextInt(20)==2){
			par2EntityLivingBase.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) par3EntityLivingBase), 100F);
		}
		
		return super.hitEntity(par1ItemStack, par2EntityLivingBase,
				par3EntityLivingBase);
	}


}
