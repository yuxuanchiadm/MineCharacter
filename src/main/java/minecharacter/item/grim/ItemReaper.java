package minecharacter.item.grim;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minecharacter.MineCharacter;
import minecharacter.misc.InitItem;
import minecharacter.misc.Localization;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ItemReaper extends ItemTool {
	static Block[] block={};

	public ItemReaper(int par1,EnumToolMaterial par2EnumToolMaterial) {
		super(par1, 1, par2EnumToolMaterial, block);
		this.setCreativeTab(MineCharacter.tabMineCharacter);
		this.setMaxDamage(2341);
	}
	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		 return 3600*20;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer, int par4) {
		int j = this.getMaxItemUseDuration(par1ItemStack) - par4;
        float f = (float)j / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;

        if (f > 1.0F)
        {
            f = 1.0F;
        }
        if ((double)f < 1.0D)
        {
            return;
        }

	    if (MineCharacter.proxy.isEquid(par3EntityPlayer,"grim")||par3EntityPlayer.capabilities.isCreativeMode)
	    {
	    	Useing(par1ItemStack,par2World,par3EntityPlayer,f*2.0F);
	      par3EntityPlayer.swingItem();
	    }
		
	}
	

	private void Useing(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer, float f) {
		par1ItemStack.damageItem(4, par3EntityPlayer);
        par2World.playSoundAtEntity(par3EntityPlayer, "mob.ghast.scream", 1.0F, 1.0F / (MineCharacter.ran.nextFloat() * 0.4F + 1.2F));	        
		List<?> list=par2World.getEntitiesWithinAABBExcludingEntity(par3EntityPlayer, AxisAlignedBB.getBoundingBox(par3EntityPlayer.posX-5.0D, par3EntityPlayer.posY-5.0D, par3EntityPlayer.posZ-5.0D, par3EntityPlayer.posX+5.0D, par3EntityPlayer.posY+5.0D, par3EntityPlayer.posZ+5.0D));
	      for (int k2 = 0; k2 < list.size(); k2++)
	      {
	        if (list.get(k2) instanceof EntityLiving&&!(list.get(k2) instanceof EntityEnderman))
	        {
	          EntityLiving entity = (EntityLiving)list.get(k2);
	          double d5 = entity.getDistance(par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ);
	          if (d5 <= 5.0D)
	          {

	              entity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(par3EntityPlayer,entity), 20);
	          if(!par2World.isRemote){
	        	  par2World.spawnEntityInWorld(new EntityItem(par2World, entity.posX, entity.posY, entity.posZ,	 new ItemStack(InitItem.soul,1)));
	        	  
	          }
	          }
	        }
	      }
		
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
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon=par1IconRegister.registerIcon("minecharacter:"+this.getUnlocalizedName().replace("item.", ""));
	}
	@Override
	public String getItemDisplayName(ItemStack itemstack) {
		return Localization.localize(getUnlocalizedName(itemstack));
	}
}
