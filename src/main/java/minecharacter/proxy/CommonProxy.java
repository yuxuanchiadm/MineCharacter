package minecharacter.proxy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cpw.mods.fml.common.network.IGuiHandler;
import minecharacter.block.container.ContainerAnvil;
import minecharacter.block.gui.GuiAnvil;
import minecharacter.misc.InitItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class CommonProxy implements IGuiHandler{
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  List<Entity> findTarget(World world,AxisAlignedBB aabb,EntityPlayer player){
		List<Entity> entity=new ArrayList();
		List<Entity> willRemove=new ArrayList();
		entity=world.getEntitiesWithinAABBExcludingEntity(player, aabb);
		Iterator<Entity> iterator = entity.iterator();
		while(iterator.hasNext()){
			Entity temp=iterator.next();
			if(!(temp instanceof EntityLiving))
				willRemove.add(temp);
		}
		entity.removeAll(willRemove);
		return entity;
		
	}
	public  int addArmor(String armor){
		return 0;
		
		
	}
	public boolean isEquid(EntityPlayer player,String string){
		if(string.equals("mage")){
		if((player.inventory.armorInventory[3]!=null&&player.inventory.armorInventory[3].itemID==InitItem.mageHelmet.itemID)&&
				(player.inventory.armorInventory[2]!=null&&player.inventory.armorInventory[2].itemID==InitItem.mageChest.itemID)&&
				(player.inventory.armorInventory[1]!=null&&player.inventory.armorInventory[1].itemID==InitItem.mageLegs.itemID)&&
				(player.inventory.armorInventory[0]!=null&&player.inventory.armorInventory[0].itemID==InitItem.mageBoots.itemID))
			return true;
		}
		else if(string.equals("grim")){
			if((player.inventory.armorInventory[3]!=null&&player.inventory.armorInventory[3].itemID==InitItem.grimHelmet.itemID)&&
					(player.inventory.armorInventory[2]!=null&&player.inventory.armorInventory[2].itemID==InitItem.grimChest.itemID)&&
					(player.inventory.armorInventory[1]!=null&&player.inventory.armorInventory[1].itemID==InitItem.grimLegs.itemID)&&
					(player.inventory.armorInventory[0]!=null&&player.inventory.armorInventory[0].itemID==InitItem.grimBoots.itemID))
				return true;
		}
		else if(string.equals("archer")){
			if((player.inventory.armorInventory[3]!=null&&player.inventory.armorInventory[3].itemID==InitItem.archerHelmet.itemID)&&
					(player.inventory.armorInventory[2]!=null&&player.inventory.armorInventory[2].itemID==InitItem.archerChest.itemID)&&
					(player.inventory.armorInventory[1]!=null&&player.inventory.armorInventory[1].itemID==InitItem.archerLegs.itemID)&&
					(player.inventory.armorInventory[0]!=null&&player.inventory.armorInventory[0].itemID==InitItem.archerBoots.itemID))
				return true;
		}
		else if(string.equals("knight")){
			if((player.inventory.armorInventory[3]!=null&&player.inventory.armorInventory[3].itemID==InitItem.knightHelmet.itemID)&&
					(player.inventory.armorInventory[2]!=null&&player.inventory.armorInventory[2].itemID==InitItem.knightChest.itemID)&&
					(player.inventory.armorInventory[1]!=null&&player.inventory.armorInventory[1].itemID==InitItem.knightLegs.itemID)&&
					(player.inventory.armorInventory[0]!=null&&player.inventory.armorInventory[0].itemID==InitItem.knightBoots.itemID))
				return true;
		}
		else if(string.equals("assassin")){
			if((player.inventory.armorInventory[3]!=null&&player.inventory.armorInventory[3].itemID==InitItem.assassinHelmet.itemID)&&
					(player.inventory.armorInventory[2]!=null&&player.inventory.armorInventory[2].itemID==InitItem.assassinChest.itemID)&&
					(player.inventory.armorInventory[1]!=null&&player.inventory.armorInventory[1].itemID==InitItem.assassinLegs.itemID)&&
					(player.inventory.armorInventory[0]!=null&&player.inventory.armorInventory[0].itemID==InitItem.assassinBoots.itemID))
				return true;
		}
		return false;
		
	}
	public void registerRenderInformation(){
		
	}
//	
//	  public void knockBack(Entity par1Entity, int par2, double par3, double par5)
//	    {
//	        this.isAirBorne = true;
//	        float f = MathHelper.sqrt_double(par3 * par3 + par5 * par5);
//	        float f1 = 0.4F;
//	        this.motionX /= 2.0D;
//	        this.motionY /= 2.0D;
//	        this.motionZ /= 2.0D;
//	        this.motionX -= par3 / (double)f * (double)f1;
//	        this.motionY += (double)f1;
//	        this.motionZ -= par5 / (double)f * (double)f1;
//
//	        if (this.motionY > 0.4000000059604645D)
//	        {
//	            this.motionY = 0.4000000059604645D;
//	        }
//	    }
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		
		switch (ID){ 
		case 0:
			
				return new ContainerAnvil(player.inventory,world,x,y,z);
		}
		return null;
	}
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
	
		switch (ID){ 
		case 0:
		
				return new GuiAnvil(player.inventory,world,x,y,z);
		}
		return null;
	
		}
	public String getCurrentLanguage() {

		return null;
	}
	
}
