package minecharacter.entity.staff;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityStaffIceball extends EntityStaffBall {

	public EntityStaffIceball(World par1World, EntityLivingBase par2EntityLiving,float par3) {
		super(par1World, par2EntityLiving, par3);
		this.setAttribute(2);
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
		this.toBlock(xTile2, yTile2, zTile2);
	this.setDead();
	}
	
	
	private void toBlock(int x, int y, int z) {
		for(int i=x-2;i<=x+2;i++)
			for(int j=y-2;j<=y+2;j++)
				for(int k=z-2;k<=z+2;k++){
					if(this.worldObj.getBlock(i, j, k)==Blocks.fire){
						this.worldObj.setBlockToAir(i, j, k);
					}
					if(this.worldObj.getBlock(i, j, k)==Blocks.water && this.worldObj.getBlockMetadata(i, j, k)==0){
						this.worldObj.setBlock(i, j, k, Blocks.ice, 0, 2);
					}
					else if(!this.worldObj.getBlock(i, j-1, k).equals(Blocks.air) && this.worldObj.getBlock(i, j, k).equals(Blocks.air)&&this.worldObj.getBlock(i, j-1, k).isNormalCube()){
						this.worldObj.setBlock(i, j, k, Blocks.snow, 0, 2);
					
					
					}
				}
		
		}

		private void toEntity() {
			@SuppressWarnings("rawtypes")
			List list=this.worldObj.getEntitiesWithinAABBExcludingEntity(this, AxisAlignedBB.getBoundingBox(this.posX-5.0D, this.posY-5.0D, this.posZ-5.0D, this.posX+5.0D, this.posY+5.0D, this.posZ+5.0D));
		      for (int k2 = 0; k2 < list.size(); k2++)
		      {
		        if (list.get(k2) instanceof EntityLiving&&!(list.get(k2) instanceof EntityPlayer))
		        {
		          EntityLiving entity = (EntityLiving)list.get(k2);
		          double d5 = entity.getDistance(this.posX, this.posY, this.posZ);
		          if (d5 <= 5.0D)
		          {
		              entity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, this.shootingEntity), 6);
		          }
		        }
		      }
		}

		@Override
		protected String getTexture() {
			return "minecharacter:textures/items/iceOrb.png";
		}


}
