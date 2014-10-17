package minecharacter.item.assassin;

import minecharacter.MineCharacter;
import minecharacter.misc.Localization;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDragger extends ItemSword {
	private int demage;
	public ItemDragger(ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.setMaxDamage(3122);
		this.setCreativeTab(MineCharacter.tabMineCharacter);
		this.demage=(int) (2+par2EnumToolMaterial.getDamageVsEntity());
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon=par1IconRegister.registerIcon("minecharacter:"+this.getUnlocalizedName().replace("item.", ""));
	}

	@Override
	public int getDamage(ItemStack stack) {
		return this.demage;
	}
	@Override
	public String getItemStackDisplayName(ItemStack itemStack) {
		return Localization.localize(getUnlocalizedName(itemStack));
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
