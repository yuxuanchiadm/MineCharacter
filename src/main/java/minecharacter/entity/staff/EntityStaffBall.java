package minecharacter.entity.staff;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class EntityStaffBall extends Entity implements IProjectile{
	protected int xTile;
	protected int yTile;
	protected int zTile;
	protected int attribute=-1;
	protected boolean inGround;
	public Entity shootingEntity;
	protected int ticksInAir;
	ResourceLocation textureResource;


	public EntityStaffBall(World par1World,EntityLivingBase par2EntityLiving,float par3){

        super(par1World);
        this.renderDistanceWeight = 10.0D;
        this.shootingEntity = par2EntityLiving;

        this.setSize(0.5F, 0.5F);
        this.setLocationAndAngles(par2EntityLiving.posX, par2EntityLiving.posY + (double)par2EntityLiving.getEyeHeight(), par2EntityLiving.posZ, par2EntityLiving.rotationYaw, par2EntityLiving.rotationPitch);
        this.posX -= (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
        this.posY -= 0.10000000149011612D;
        this.posZ -= (double)(MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0F;
        this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionY = (double)(-MathHelper.sin(this.rotationPitch / 180.0F * (float)Math.PI));
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, par3 * 1.5F, 1.0F);
        this.textureResource = new ResourceLocation(this.getTexture());
	}
	

	 protected abstract String getTexture();

		public ResourceLocation getTextureResource()
		{
		return textureResource;
		}


	public boolean isInRangeToRenderDist(double par1)
	    {
	        double d1 = this.boundingBox.getAverageEdgeLength() * 4.0D;
	        d1 *= 64.0D;
	        return par1 < d1 * d1;
	    }
	
	public int getAttribute() {
		return attribute;
	}

	public void setAttribute(int attribute) {
		this.attribute = attribute;
	}
	
	
	 public void onUpdate()
	    {
		 super.onUpdate();

	        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
	        {
	            float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
	            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
	            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, (double)f) * 180.0D / Math.PI);
	        }

	        int i = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);

	        if (i > 0)
	        {
	            Block.blocksList[i].setBlockBoundsBasedOnState(this.worldObj, this.xTile, this.yTile, this.zTile);
	            AxisAlignedBB axisalignedbb = Block.blocksList[i].getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);

	            if (axisalignedbb != null && axisalignedbb.isVecInside(this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ)))
	            {
	                this.inGround = true;
	            }
	        }

	       

	        if (this.inGround)
	        {
	            this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);
	            this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);

	           this.withBlock(worldObj, xTile, yTile, zTile);
	        }
	        else
	        {
	            ++this.ticksInAir;
	            Vec3 vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
	            Vec3 vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
	            MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks_do_do(vec3, vec31, false, true);
	            vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
	            vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

	            if (movingobjectposition != null)
	            {
	                vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
	            }

	            Entity entity = null;
	            @SuppressWarnings("rawtypes")
				List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
	            double d0 = 0.0D;
	            int l;
	            float f1;

	            for (l = 0; l < list.size(); ++l)
	            {
	                Entity entity1 = (Entity)list.get(l);

	                if (entity1.canBeCollidedWith() && (entity1 != this.shootingEntity || this.ticksInAir >= 5))
	                {
	                    f1 = 0.3F;
	                    AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand((double)f1, (double)f1, (double)f1);
	                    MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec3, vec31);

	                    if (movingobjectposition1 != null)
	                    {
	                        double d1 = vec3.distanceTo(movingobjectposition1.hitVec);

	                        if (d1 < d0 || d0 == 0.0D)
	                        {
	                            entity = entity1;
	                            d0 = d1;
	                        }
	                    }
	                }
	            }

	            if (entity != null)
	            {
	                movingobjectposition = new MovingObjectPosition(entity);
	            }

	            if (movingobjectposition != null && movingobjectposition.entityHit != null && movingobjectposition.entityHit instanceof EntityPlayer)
	            {
	                EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.entityHit;

	                if (entityplayer.capabilities.disableDamage || this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).canAttackPlayer(entityplayer))
	                {
	                    movingobjectposition = null;
	                }
	            }

	            float f2;
	            if (movingobjectposition != null)
	            {
	                if (movingobjectposition.entityHit != null)
	                {
	                    this.withEntity(movingobjectposition);
	      
	                }
	                else
	                {
	                    this.xTile = movingobjectposition.blockX;
	                    this.yTile = movingobjectposition.blockY;
	                    this.zTile = movingobjectposition.blockZ;
	                    
	                    this.motionX = (double)((float)(movingobjectposition.hitVec.xCoord - this.posX));
	                    this.motionY = (double)((float)(movingobjectposition.hitVec.yCoord - this.posY));
	                    this.motionZ = (double)((float)(movingobjectposition.hitVec.zCoord - this.posZ));
	                    f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
	                    this.posX -= this.motionX / (double)f2 * 0.05000000074505806D;
	                    this.posY -= this.motionY / (double)f2 * 0.05000000074505806D;
	                    this.posZ -= this.motionZ / (double)f2 * 0.05000000074505806D;
	                  
	                    this.inGround = true;
	                    
	                }
	            }

	           

	         
	            this.posX += this.motionX;
	            this.posY += this.motionY;
	            this.posZ += this.motionZ;
	         
	            this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

	          

	            while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
	            {
	                this.prevRotationPitch += 360.0F;
	            }

	            while (this.rotationYaw - this.prevRotationYaw < -180.0F)
	            {
	                this.prevRotationYaw -= 360.0F;
	            }

	            while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
	            {
	                this.prevRotationYaw += 360.0F;
	            }

	            this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
	            this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
	            float f4 = 0.99F;
	            f1 = 0.05F;

	            

	            this.motionX *= (double)f4;
	            this.motionY *= (double)f4;
	            this.motionZ *= (double)f4;
	            this.motionY -= (double)f1;
	            this.setPosition(this.posX, this.posY, this.posZ);
	           
	        }
	    }
	 
	 @Override
	 public void setThrowableHeading(double par1, double par3, double par5, float par7, float par8)
	    {
	        float f2 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
	        par1 /= (double)f2;
	        par3 /= (double)f2;
	        par5 /= (double)f2;
	        par1 += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)par8;
	        par3 += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)par8;
	        par5 += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)par8;
	        par1 *= (double)par7;
	        par3 *= (double)par7;
	        par5 *= (double)par7;
	        this.motionX = par1;
	        this.motionY = par3;
	        this.motionZ = par5;
	        float f3 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
	        this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
	        this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, (double)f3) * 180.0D / Math.PI);
	      
	    }


	protected abstract void withEntity(MovingObjectPosition movingobjectposition);

	protected abstract void withBlock(World worldObj, int xTile2, int yTile2, int zTile2);

	@Override
	protected void entityInit() {
		
	}

	

	
	@Override
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {

        this.xTile = nbttagcompound.getShort("xTile");
        this.yTile = nbttagcompound.getShort("yTile");
        this.zTile = nbttagcompound.getShort("zTile");
        this.inGround = nbttagcompound.getByte("inGround") == 1;
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		 nbttagcompound.setShort("xTile", (short)this.xTile);
	     nbttagcompound.setShort("yTile", (short)this.yTile);
	     nbttagcompound.setShort("zTile", (short)this.zTile);
	     nbttagcompound.setByte("inGround", (byte)(this.inGround ? 1 : 0));
	}

}
