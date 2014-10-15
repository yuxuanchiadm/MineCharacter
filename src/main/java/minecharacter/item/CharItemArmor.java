package minecharacter.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minecharacter.MineCharacter;
import minecharacter.misc.InitItem;
import minecharacter.misc.Localization;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class CharItemArmor extends ItemArmor {

	public CharItemArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial,int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(MineCharacter.tabMineCharacter);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon=par1IconRegister.registerIcon("minecharacter:"+this.getUnlocalizedName().replace("item.", ""));
	}
	@Override
	public String getItemDisplayName(ItemStack itemstack) {
		return Localization.localize(getUnlocalizedName(itemstack));
	}
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	  {
	    if ((stack.itemID == InitItem.knightHelmet.itemID) ||(stack.itemID == InitItem.knightChest.itemID) || (stack.itemID == InitItem.knightBoots.itemID))
	    {
	      return "minecharacter:textures/models/armor/knight_1.png";
	    }
	    if (stack.itemID == InitItem.knightLegs.itemID)
	    {
	      return "minecharacter:textures/models/armor/knight_2.png";
	    }
	    if  ((stack.itemID == InitItem.grimHelmet.itemID) ||(stack.itemID == InitItem.grimChest.itemID) || (stack.itemID == InitItem.grimBoots.itemID))
	    {
	      return "minecharacter:textures/models/armor/grim_1.png";
	    }
	    if  (stack.itemID == InitItem.grimLegs.itemID)
	    {
	      return "minecharacter:textures/models/armor/grim_2.png";
	    }
	    if ((stack.itemID == InitItem.mageHelmet.itemID) ||(stack.itemID == InitItem.mageChest.itemID) || (stack.itemID == InitItem.mageBoots.itemID))
	    {
	      return "minecharacter:textures/models/armor/mage_1.png";
	    }
	    if  (stack.itemID == InitItem.mageLegs.itemID)
	    {
	      return "minecharacter:textures/models/armor/mage_2.png";
	    }
	    if ((stack.itemID == InitItem.archerHelmet.itemID) ||(stack.itemID == InitItem.archerChest.itemID) || (stack.itemID == InitItem.archerBoots.itemID))
	    {
	      return "minecharacter:textures/models/armor/archer_1.png";
	    }
	    if  (stack.itemID == InitItem.archerLegs.itemID)
	    {
	      return "minecharacter:textures/models/armor/archer_2.png";
	    }
	    if((stack.itemID == InitItem.assassinHelmet.itemID) ||(stack.itemID == InitItem.assassinChest.itemID) || (stack.itemID == InitItem.assassinBoots.itemID))
	    {
	      return "minecharacter:textures/models/armor/assassin_1.png";
	    }
	    if (stack.itemID == InitItem.assassinLegs.itemID)
	    {
	      return "minecharacter:textures/models/armor/assassin_2.png";
	    }
	    return "";
	  }

}
