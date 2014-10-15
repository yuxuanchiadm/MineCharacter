package minecharacter.item.assassin;

import minecharacter.MineCharacter;
import minecharacter.entity.EntityShuriken;
import minecharacter.item.ItemMineCharacter;
import minecharacter.misc.InitItem;
import minecharacter.misc.Localization;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemShuriken extends ItemMineCharacter {

	public ItemShuriken(int par1) {
		super(par1);
	this.setMaxStackSize(16);
	}
	@Override
	public String getItemDisplayName(ItemStack itemstack) {
		return Localization.localize(getUnlocalizedName(itemstack));
	}
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
//		System.out.println(FMLCommonHandler.instance().getEffectiveSide().name());
	      if (MineCharacter.proxy.isEquid(par3EntityPlayer, "assassin")||par3EntityPlayer.capabilities.isCreativeMode)
	      {	      par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (Item.itemRand.nextFloat() * 0.4F + 0.8F));

//	      if (!par2World.)
	      
	        par2World.spawnEntityInWorld(new EntityShuriken(par2World, par3EntityPlayer));
	        par3EntityPlayer.inventory.consumeInventoryItem(InitItem.shuriken.itemID);
	      
	    }

	    return par1ItemStack;
	}

}
