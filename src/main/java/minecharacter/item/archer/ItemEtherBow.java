package minecharacter.item.archer;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minecharacter.MineCharacter;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

public class ItemEtherBow extends ItemArcherBow {
	 public static final String[] etherBowPullIconNameArray = new String[] {"etherBow_pull_0","etherBow_pull_1", "etherBow_pull_2", "etherBow_pull_3"};
	public ItemEtherBow(int par1) {
		super(par1);
		this.setMaxDamage(3122);
		damage=10; 
		this.iconTime[0]=0;
		this.iconTime[1]=3;
		this.iconTime[2]=6;
	}
	@Override
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer, int par4) {
		if(FMLCommonHandler.instance().getEffectiveSide()==Side.CLIENT)
		this.iconsetdefalut();
		int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

	        ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
	        MinecraftForge.EVENT_BUS.post(event);
	        if (event.isCanceled())
	        {
	            return;
	        }
	        j = event.charge;

	        boolean flag = par3EntityPlayer.capabilities.isCreativeMode;

	        if (flag || (MineCharacter.proxy.isEquid(par3EntityPlayer, "archer")&&par3EntityPlayer.inventory.hasItem(Item.arrow.itemID)))
	        {
	            float f = (float)j / 30.0F;
	            f = (f * f + f * 2.0F) / 3.0F;

	            if ((double)f < 0.1D)
	            {
	                return;
	            }

	            if (f > 1.0F)
	            {
	                f = 1.0F;
	            }

	            EntityArrow entityarrow = new EntityArrow(par2World, par3EntityPlayer, f * 2.0F);

	            if (f == 1.0F)
	            {
	                entityarrow.setIsCritical(true);
	            }

	            
	             entityarrow.setDamage(this.damage*f);
	           
	            par1ItemStack.damageItem(2, par3EntityPlayer);
	            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

	            
	                entityarrow.canBePickedUp = 2;
	           
	                par3EntityPlayer.inventory.consumeInventoryItem(Item.arrow.itemID);
	            

	            if (!par2World.isRemote)
	            {
	                par2World.spawnEntityInWorld(entityarrow);
	            }
	        }
	}

	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon=par1IconRegister.registerIcon("minecharacter:"+etherBowPullIconNameArray[0]);
		 this.iconArray = new Icon[etherBowPullIconNameArray.length];

		    for (int i = 0; i < this.iconArray.length; ++i)
		    {
		        this.iconArray[i] = par1IconRegister.registerIcon("minecharacter:"+etherBowPullIconNameArray[i]);
		    }
	}

	

}
