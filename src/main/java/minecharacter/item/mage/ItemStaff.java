package minecharacter.item.mage;

import minecharacter.MineCharacter;
import minecharacter.entity.staff.EntityStaffDeathball;
import minecharacter.entity.staff.EntityStaffFireball;
import minecharacter.entity.staff.EntityStaffIceball;
import minecharacter.entity.staff.EntityStaffLifeball;
import minecharacter.item.ItemMineCharacter;
import minecharacter.misc.InitItem;
import minecharacter.misc.Localization;
import net.minecraft.block.Block;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.BlockSapling;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemStaff extends ItemMineCharacter {
	private int attribute =-1;

	public ItemStaff(int par1,int attribute) {
		super(par1);
		this.attribute=attribute;
		this.setMaxDamage(384);
		this.setMaxStackSize(1);
	}
	
	@Override
	public String getItemDisplayName(ItemStack itemstack) {
		return Localization.localize(getUnlocalizedName(itemstack));
	}
	@Override
	public boolean onItemUse(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, World par3World, int par4, int par5,
			int par6, int par7, float par8, float par9, float par10) {
		if(this.attribute==3){
			if((par3World.getBlockId(par4, par5, par6)==Block.crops.blockID||par3World.getBlockId(par4, par5, par6)==Block.melonStem.blockID||par3World.getBlockId(par4, par5, par6)==Block.pumpkinStem.blockID||par3World.getBlockId(par4, par5, par6)==Block.carrot.blockID||par3World.getBlockId(par4, par5, par6)==Block.potato.blockID)&&par3World.getBlockMetadata(par4, par5, par6)<7){
				par1ItemStack.damageItem(2, par2EntityPlayer);
				par3World.setBlockMetadataWithNotify(par4, par5, par6, 7, 2);
				return true;
			}
			else if(par3World.getBlockId(par4, par5, par6)==Block.sapling.blockID){
			(	(BlockSapling)Block.blocksList[Block.sapling.blockID]).growTree(par3World, par4, par5, par6, itemRand);
			par1ItemStack.damageItem(2, par2EntityPlayer);
			return true;
			}
			else if(par3World.getBlockId(par4, par5, par6)==Block.mushroomBrown.blockID||par3World.getBlockId(par4, par5, par6)==Block.mushroomRed.blockID){
				BlockMushroom room=((BlockMushroom)(Block.blocksList[Block.mushroomBrown.blockID]));
			                  room.fertilizeMushroom(par3World, par4, par5, par6, itemRand);
			
			                  par1ItemStack.damageItem(2, par2EntityPlayer);
			                  return true;
			}

			return false;
			
		}
		return false;
	}


	private boolean canDoMage(EntityPlayer player){
		if(player.capabilities.isCreativeMode)
			return true;
		else if(MineCharacter.proxy.isEquid(player, "mage")){
			if(this.attribute==1){
				if(player.inventory.hasItem(InitItem.fireRune.itemID)){
					player.inventory.consumeInventoryItem(InitItem.fireRune.itemID);
					return true;
				}
				else 
					return false;
			}else if(this.attribute==2){
				if(player.inventory.hasItem(InitItem.iceRune.itemID)){
					player.inventory.consumeInventoryItem(InitItem.iceRune.itemID);
					return true;
				}
				else 
					return false;
			}else if(this.attribute==3){
					if(player.inventory.hasItem(InitItem.lifeRune.itemID)){
						player.inventory.consumeInventoryItem(InitItem.lifeRune.itemID);
						return true;
					}
				else 
					return false;
			}else if(this.attribute==4){
					if(player.inventory.hasItem(InitItem.deathRune.itemID)){
						player.inventory.consumeInventoryItem(InitItem.deathRune.itemID);
						return true;
					}
				else 
					return false;
					}
			return true;
			}
	
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
        float f = (float)j / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if ((double)f < 0.1D)
        {
            return;
        }

        if (f > 1.0F)
        {
            f = 1.0F;
        }
	    if (this.canDoMage(par3EntityPlayer))
	    {
	    	magicing(par1ItemStack,par2World,par3EntityPlayer,f*2.0F);
	      par3EntityPlayer.swingItem();
	    }
		
	}


	private void magicing(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer, float f) {
		  par1ItemStack.damageItem(1, par3EntityPlayer);
//		  if (FMLCommonHandler.instance().getEffectiveSide()==Side.CLIENT)
		  {
	        par2World.playSoundAtEntity(par3EntityPlayer, "mob.ghast.fireball", 1.0F, 1.0F / (MineCharacter.ran.nextFloat() * 0.4F + 1.2F));	        
	      
	          if (this.attribute==1)
	          {
	            par2World.spawnEntityInWorld(new EntityStaffFireball(par2World,par3EntityPlayer,f));
	          }
	          if (this.attribute==2)
	          {
	        	  par2World.spawnEntityInWorld(new EntityStaffIceball(par2World,par3EntityPlayer,f));
	          }
	          if (this.attribute==3)
	          {
	        	  par2World.spawnEntityInWorld(new EntityStaffLifeball(par2World,par3EntityPlayer,f));
	          }
	          if (this.attribute==4)
	          {
	        	  par2World.spawnEntityInWorld(new EntityStaffDeathball(par2World,par3EntityPlayer,f));
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
}
