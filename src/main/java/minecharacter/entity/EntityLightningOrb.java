package minecharacter.entity;

import java.util.List;

import cpw.mods.fml.common.FMLCommonHandler;
import minecharacter.misc.InitItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityLightningOrb extends EntityLightningBolt {

    private int lightningState;
    public long orbBoltVertex = 0L;
    private int boltLivingTime;
    private int type;
	public EntityLightningOrb(World par1World, double par2, double par4,
			double par6) {
		super(par1World, par2, par4, par6);
        this.setLocationAndAngles(par2, par4, par6, 0.0F, 0.0F);
        this.lightningState = 2;
        this.orbBoltVertex = this.rand.nextLong();
        this.boltLivingTime = this.rand.nextInt(3) + 1;

	}
	public EntityLightningOrb(World par1World, double par2, double par4,
			double par6,int type) {
		this(par1World,par2,par4,par6);
		this.type=type;

	}
	@Override
	public void onUpdate() {
		 if (this.lightningState == 2)
	        {
	            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "ambient.weather.thunder", 10000.0F, 0.8F + this.rand.nextFloat() * 0.2F);
	            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 2.0F, 0.5F + this.rand.nextFloat() * 0.2F);
	        }

	        --this.lightningState;

	        if (this.lightningState < 0)
	        {
	            if (this.boltLivingTime == 0)
	            {
	                this.setDead();
	            }
	            else if (this.lightningState < -this.rand.nextInt(10))
	            {
	                --this.boltLivingTime;
	                this.lightningState = 1;
	                this.orbBoltVertex = this.rand.nextLong();

	        
	            }
	        }

	        if (this.lightningState >= 0)
	        {
	            if (this.worldObj.isRemote)
	            {
	                this.worldObj.lastLightningBolt = 2;
	            }
	            else
	            {
	                double d0 = 1.0D;
	                @SuppressWarnings("rawtypes")
					List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, AxisAlignedBB.getAABBPool().getAABB(this.posX - d0, this.posY - d0, this.posZ - d0, this.posX + d0, this.posY + 6.0D + d0, this.posZ + d0));

	                for (int l = 0; l < list.size(); ++l)
	                {
	                    Entity entity = (Entity)list.get(l);
	                    if(entity instanceof EntityItem){
	                    	System.out.println(FMLCommonHandler.instance().getEffectiveSide().name());
	                    	if (((EntityItem)entity).getEntityItem().itemID == InitItem.magicPowder.itemID){
	                    			this.worldObj.spawnEntityInWorld(new EntityItem(worldObj,this.posX, this.posY, this.posZ, new ItemStack(InitItem.etherealPowder.itemID, ((EntityItem)entity).getEntityItem().stackSize,0)));
	                    			entity.setDead();
	                    		this.setDead();
	                    	}
	                    	else if(((EntityItem)entity).getEntityItem().itemID == Item.ingotIron.itemID){

	                    		this.worldObj.spawnEntityInWorld(new EntityItem(worldObj,this.posX, this.posY, this.posZ, new ItemStack(InitItem.assassinSteel.itemID, ((EntityItem)entity).getEntityItem().stackSize,0)));
	                    		entity.setDead();
	                    		this.setDead();
	                    		
	                    	}
	                    		
	           
	                    	else if(((EntityItem)entity).getEntityItem().itemID == InitItem.rune.itemID){
	                    		if(this.type==1){
	                    			this.worldObj.spawnEntityInWorld(new EntityItem(worldObj,this.posX, this.posY, this.posZ, new ItemStack(InitItem.fireRune.itemID, ((EntityItem)entity).getEntityItem().stackSize,0)));
		                    		entity.setDead();
		                    		this.setDead();
	                    			
	                    		}
	                    		if(this.type==2){
	                    			this.worldObj.spawnEntityInWorld(new EntityItem(worldObj,this.posX, this.posY, this.posZ, new ItemStack(InitItem.iceRune.itemID, ((EntityItem)entity).getEntityItem().stackSize,0)));
		                    		entity.setDead();
		                    		this.setDead();
	                    		}
	                    		if(this.type==3){
	                    			this.worldObj.spawnEntityInWorld(new EntityItem(worldObj,this.posX, this.posY, this.posZ, new ItemStack(InitItem.lifeRune.itemID, ((EntityItem)entity).getEntityItem().stackSize,0)));
		                    		entity.setDead();
		                    		this.setDead();
	                    		}
	                    		if(this.type==4){
	                    			this.worldObj.spawnEntityInWorld(new EntityItem(worldObj,this.posX, this.posY, this.posZ, new ItemStack(InitItem.deathRune.itemID, ((EntityItem)entity).getEntityItem().stackSize,0)));
		                    		entity.setDead();
		                    		this.setDead();
	                    		}
	                    }
	                    	 break;
	                }
	                    }
	                }
	            }
	        }
	

}
