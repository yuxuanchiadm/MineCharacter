package minecharacter.item.food;

import minecharacter.MineCharacter;
import minecharacter.misc.Localization;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CharItemFood extends ItemFood {
	public CharItemFood( int par2, float par3, boolean par4) {
		super(par2, par3,par4);
		this.setCreativeTab(MineCharacter.tabMineCharacter);
		
	}
    
  
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon=par1IconRegister.registerIcon("minecharacter:"+this.getUnlocalizedName().replace("item.", ""));
	}
	@Override
	public String getItemStackDisplayName(ItemStack itemStack) {
		return Localization.localize(getUnlocalizedName(itemStack));
	}
}
