package minecharacter.entity.staff;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityStaffFireball extends EntityStaffBall {

	public EntityStaffFireball(World par1World, EntityLivingBase living, float f) {
		super(par1World, living, f);
		this.setAttribute(1);
	}

	@Override
	protected void withEntity(MovingObjectPosition movingobjectposition) {
	movingobjectposition.entityHit.setFire(20);
	movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, movingobjectposition.entityHit),6);
	int x=MathHelper.floor_double( movingobjectposition.entityHit.posX);
	int y=MathHelper.floor_double( movingobjectposition.entityHit.posY);
	int z=MathHelper.floor_double( movingobjectposition.entityHit.posZ);
	for(int i=x-1;i<=x+1;i++)
		for(int j=y-1;j<=y+1;j++)
			for(int k=z-1;k<=z+1;k++){
				if(this.worldObj.getBlock(i, j, k).equals(Blocks.air) && !this.worldObj.getBlock(i, j-1, k).equals(Blocks.air)){
					this.worldObj.setBlock(i, j, k, Blocks.fire, 0, 2);
					if(this.worldObj.getBlock(i, j, k)==Blocks.ice){
						this.worldObj.setBlock(i,j ,k, Blocks.water, 0, 2);
					}
				}
				
			}
		this.setDead();
	}

	

	@Override
	protected void withBlock(World worldObj, int xTile2, int yTile2, int zTile2) {
		int x=xTile2;
		int y=yTile2;
		int z=zTile2;
		for(int i=x-1;i<=x+1;i++)
			for(int j=y-1;j<=y+1;j++)
				for(int k=z-1;k<=z+1;k++){
					if(this.worldObj.getBlock(i, j, k).equals(Blocks.air) && !this.worldObj.getBlock(i, j-1, k).equals(Blocks.air)){
						this.worldObj.setBlock(i, j, k, Blocks.fire, 0, 2);
						if(this.worldObj.getBlock(i, j, k)==Blocks.ice){
							this.worldObj.setBlock(i,j ,k, Blocks.water,0,2);
						}
					}
				}
	this.setDead();
	}

	@Override
	protected String getTexture() {
		
		return "minecharacter:textures/items/fireOrb.png";
	}

}
