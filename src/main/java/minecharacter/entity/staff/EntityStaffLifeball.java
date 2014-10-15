package minecharacter.entity.staff;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityStaffLifeball extends EntityStaffBall {

	public EntityStaffLifeball(World par1World, EntityLivingBase par2EntityLiving,float par3) {
		super(par1World, par2EntityLiving, par3);
		this.setAttribute(3);
	}

	@Override
	protected void withEntity(MovingObjectPosition movingobjectposition) {
		this.toEntity();
	this.toBlock(MathHelper.floor_double(movingobjectposition.entityHit.posX), MathHelper.floor_double(movingobjectposition.entityHit.posY),MathHelper.floor_double(movingobjectposition.entityHit.posZ));
		this.setDead();
	}

	
	@Override
	protected void withBlock(World worldObj, int xTile2, int yTile2, int zTile2) {
		
		this.toEntity();
	    this.toBlock(xTile2,yTile2,zTile2);
		
		
	this.setDead();
	}
	private void toEntity(){
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
	          	entity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, this.shootingEntity), 10);
	          else
	          	entity.heal(10);
	            
	        }
	      }
	    }

	}
	
	private void toBlock(int x,int y,int z) {
		for(int i=x-3;i<=x+3;i++)
			for(int j=y-3;j<=y+3;j++)
				for(int k=z-3;k<=z+3;k++){
					if((this.worldObj.getBlockId(i, j, k)==0)&&this.worldObj.getBlockId(i, j-1, k)!=0){
						if(this.worldObj.getBlockId(i, j-1, k) == Block.waterStill.blockID&&this.worldObj.getBlockMetadata(i, j-1, k)==0){
							this.worldObj.setBlock(i, j, k,Block.waterlily.blockID,0,2);
						}
						if(this.worldObj.getBlockId(i, j-1, k) == Block.grass.blockID )
						this.worldObj.setBlock(i, j, k, Block.tallGrass.blockID, 1, 2);
						else if(this.worldObj.getBlockId(i, j-1, k) == Block.dirt.blockID || this.worldObj.getBlockId(i, j-1, k) == Block.tilledField.blockID){
							this.worldObj.setBlock(i, j, k, Block.tallGrass.blockID, 1, 2);
							this.worldObj.setBlock(i, j-1, k, Block.grass.blockID, 0, 2);
						}
					}
				}
	}

	@Override
	protected String getTexture() {
		
		return "minecharacter:textures/items/lifeOrb.png";
	}


}
