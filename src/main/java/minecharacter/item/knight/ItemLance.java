package minecharacter.item.knight;

import minecharacter.MineCharacter;
import minecharacter.misc.Localization;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLance extends ItemSword {
	private int demage;
	public ItemLance(ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.setMaxDamage(3122);
		this.setCreativeTab(MineCharacter.tabMineCharacter);
		this.demage=(int) par2EnumToolMaterial.getDamageVsEntity();
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
	public boolean hitEntity(ItemStack par1ItemStack,
			EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
		
		  par1ItemStack.damageItem(2, par3EntityLiving);
		    if ((par2EntityLiving.ridingEntity != null))
		    {
		      par2EntityLiving.mountEntity(null);
		    }
		    return true;
	}
	@Override
	public String getItemStackDisplayName(ItemStack itemStack) {
		return Localization.localize(getUnlocalizedName(itemStack));
	}
}
