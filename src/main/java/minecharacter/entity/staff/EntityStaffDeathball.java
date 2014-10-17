package minecharacter.entity.staff;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityStaffDeathball extends EntityStaffBall {

	public EntityStaffDeathball(World par1World, EntityLivingBase par2EntityLiving,
			float par3) {
		super(par1World, par2EntityLiving, par3);
		this.setAttribute(4);
	}

	@Override
	protected void withEntity(MovingObjectPosition movingobjectposition) {
		
		this.toBlock(MathHelper.floor_double(movingobjectposition.entityHit.posX), MathHelper.floor_double(movingobjectposition.entityHit.posY),MathHelper.floor_double(movingobjectposition.entityHit.posZ));
		this.toEntity();
		this.setDead();
	}


	@Override
	protected void withBlock(World worldObj, int xTile2, int yTile2, int zTile2) {
		this.toBlock(xTile2,yTile2,zTile2);
		this.toEntity();
		this.setDead();
	}
	
private void toBlock(int x, int y, int z) {
		
		for(int i=x-1;i<=x+1;i++)
			for(int j=y-1;j<=y+1;j++)
				for(int k=z-1;k<=z+1;k++){
					if((this.worldObj.getBlock(i, j, k).equals(Blocks.grass))){
						this.worldObj.setBlock(i, j, k, Blocks.dirt);
						
						}
					if((this.worldObj.getBlock(i, j, k).equals(Blocks.sapling))){
						this.worldObj.setBlock(i, j, k,Blocks.deadbush);
						
						}
					if((this.worldObj.getBlock(i, j, k).equals(Blocks.tallgrass))){
						this.worldObj.setBlockToAir(i, j, k);
						
						}
					if((this.worldObj.getBlock(i, j, k).equals(Blocks.waterlily))){
						this.worldObj.setBlockToAir(i, j, k);	
						}
					if((this.worldObj.getBlock(i, j, k).equals(Blocks.leaves)||this.worldObj.getBlock(i, j, k).equals(Blocks.log))){
						this.worldObj.setBlockToAir(i, j, k);	
						}
					}
	}

	private void toEntity() {
		
		@SuppressWarnings("rawtypes")
		List list=this.worldObj.getEntitiesWithinAABBExcludingEntity(this, AxisAlignedBB.getBoundingBox(this.posX-5.0D, this.posY-5.0D, this.posZ-5.0D, this.posX+5.0D, this.posY+5.0D, this.posZ+5.0D));
	      for (int k2 = 0; k2 < list.size(); k2++)
	      {
	        if (list.get(k2) instanceof EntityLivingBase)
	        {
	        	EntityLivingBase entity = (EntityLivingBase)list.get(k2);
	          double d5 = entity.getDistance(this.posX, this.posY, this.posZ);
	          if (d5 <= 5.0D)
	          {
	            if (entity.isEntityUndead())
	              entity.heal(20);
	       
	            else if(entity instanceof EntityPlayer){
	            	if(entity==this.shootingEntity);
	            	else
	            	entity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, this.shootingEntity), 10);
	            }
	            else
	              entity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, this.shootingEntity), 20);
	          }
	        }
	      }
	}

	@Override
	protected String getTexture() {
		
		return "minecharacter:textures/items/deathOrb.png";
	}

}
