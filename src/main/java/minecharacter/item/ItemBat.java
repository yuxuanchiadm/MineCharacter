package minecharacter.item;

import java.util.List;

import minecharacter.MineCharacter;
import minecharacter.misc.Localization;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBat extends Item {
private int weaponDamage;
	public ItemBat() {
		super();
		this.weaponDamage=1;
		this.setCreativeTab(MineCharacter.tabMineCharacter);
		this.setMaxStackSize(1);
	}
	@Override
	public String getItemStackDisplayName(ItemStack itemStack) {
		return Localization.localize(getUnlocalizedName(itemStack));
	}
	
	

	@Override
	public boolean hitEntity(ItemStack par1ItemStack,EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
		par1ItemStack.damageItem(1, par3EntityLiving);
		par2EntityLiving.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) par3EntityLiving), this.weaponDamage);
		return false;
	}


	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon=par1IconRegister.registerIcon("minecharacter:"+this.getUnlocalizedName().replace("item.", ""));
	}

	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack,
			ItemStack par2ItemStack) {
				return false;
		
	}

	

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		 return 3600*20;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer, int par4) {
		int j = this.getMaxItemUseDuration(par1ItemStack) - par4;
	    float f = j / 20.0F;
	    if (f > 1.0F)
	    {
	      aoe(par1ItemStack, par2World, par3EntityPlayer);
	      par3EntityPlayer.swingItem();
	    }
	    par1ItemStack.stackSize--;
		
	}

	private void aoe(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
	    if (par3EntityPlayer.isDead)
	    {
	      return;
	    }
	    double d6 = 5.0D;
	    double d7 = 5.0D;
	    List<Entity> list = MineCharacter.proxy.findTarget(par2World, AxisAlignedBB.getBoundingBox(par3EntityPlayer.posX - d6, par3EntityPlayer.posY - d7, par3EntityPlayer.posZ - d6, par3EntityPlayer.posX + d6, par3EntityPlayer.posY + d7, par3EntityPlayer.posZ + d6),par3EntityPlayer);
	    for (int k2 = 0; k2 < list.size(); k2++)
	    {
	        EntityLiving entity = (EntityLiving)list.get(k2);
	        double d5 = entity.getDistanceToEntity(par3EntityPlayer);
	        if (d5 <= 5.0D)
	        {
	          back(entity,par3EntityPlayer);
	          par2World.playSoundEffect(par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ, "random.explode", 4.0F, (1.0F + (par2World.rand.nextFloat() - par2World.rand.nextFloat()) * 0.2F) * 0.7F);
	        }
	      
	    }
	}


	protected void back(EntityLiving entity, EntityPlayer player) {
		entity.motionX=0;
		entity.motionY=0;
		entity.motionZ=0;
		entity.motionX+=Item.itemRand.nextGaussian()*2;
		entity.motionY+=Item.itemRand.nextGaussian()*4;
		entity.motionZ+=Item.itemRand.nextGaussian()*2;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		 
	  par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
	        return par1ItemStack;
	}
	@Override
	 public EnumAction getItemUseAction(ItemStack par1ItemStack)
	    {
	        return EnumAction.bow;
	    }
}
