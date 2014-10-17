package minecharacter.entity;

import java.util.List;

import minecharacter.misc.InitItem;
import minecharacter.network.PacketSpawnItem;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.network.play.server.S40PacketDisconnect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.IThrowableEntity;
import cpw.mods.fml.relauncher.Side;

public class EntityTomahawk extends Entity implements IThrowableEntity,
		IProjectile {

	private int xTile = -1;
	private int yTile = -1;
	private int zTile = -1;
	private Block inTile = null;
	private int inData = 0;
	private boolean inGround = false;
	private int ticksInGround;
	private int ticksInAir = 0;
	private double damage = 2.0D;
	private EntityPlayer thrower;
	private int itemDamage;

	public EntityTomahawk(World par1World, ItemStack itemstack,
			EntityLivingBase par2EntityLiving, float par3) {
		super(par1World);
		this.thrower = (EntityPlayer) par2EntityLiving;
		this.itemDamage = itemstack.getItemDamage();

		this.renderDistanceWeight = 10.0D;
		this.setSize(0.5F, 0.5F);
		this.setLocationAndAngles(par2EntityLiving.posX, par2EntityLiving.posY
				+ (double) par2EntityLiving.getEyeHeight(),
				par2EntityLiving.posZ, par2EntityLiving.rotationYaw,
				par2EntityLiving.rotationPitch);
		this.posX -= (double) (MathHelper.cos(this.rotationYaw / 180.0F
				* (float) Math.PI) * 0.16F);
		this.posY -= 0.10000000149011612D;
		this.posZ -= (double) (MathHelper.sin(this.rotationYaw / 180.0F
				* (float) Math.PI) * 0.16F);
		this.setPosition(this.posX, this.posY, this.posZ);
		this.yOffset = 0.0F;
		this.motionX = (double) (-MathHelper.sin(this.rotationYaw / 180.0F
				* (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F
				* (float) Math.PI));
		this.motionZ = (double) (MathHelper.cos(this.rotationYaw / 180.0F
				* (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F
				* (float) Math.PI));
		this.motionY = (double) (-MathHelper.sin(this.rotationPitch / 180.0F
				* (float) Math.PI));
		this.setThrowableHeading(this.motionX, this.motionY, this.motionZ,
				par3 * 1.5F, 1.0F);
	}

	@Override
	public Entity getThrower() {
		return this.thrower;
	}

	@Override
	public void setThrower(Entity entity) {
		this.thrower = (EntityPlayer) entity;

	}

	@Override
	protected void entityInit() {
		this.dataWatcher.addObject(16, Byte.valueOf((byte) 0));

	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
			float f = MathHelper.sqrt_double(this.motionX * this.motionX
					+ this.motionZ * this.motionZ);
			this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(
					this.motionX, this.motionZ) * 180.0D / Math.PI);
			this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(
					this.motionY, (double) f) * 180.0D / Math.PI);
		}

		Block block = this.worldObj
				.getBlock(this.xTile, this.yTile, this.zTile);

		if (!block.isAir(worldObj, xTile, yTile, zTile)) {
			block.setBlockBoundsBasedOnState(this.worldObj, this.xTile,
					this.yTile, this.zTile);
			AxisAlignedBB axisalignedbb = block
					.getCollisionBoundingBoxFromPool(this.worldObj, this.xTile,
							this.yTile, this.zTile);

			if (axisalignedbb != null
					&& axisalignedbb.isVecInside(this.worldObj
							.getWorldVec3Pool().getVecFromPool(this.posX,
									this.posY, this.posZ))) {
				this.inGround = true;
			}
		}

		if (this.inGround) {
			Block blockJ = this.worldObj.getBlock(this.xTile, this.yTile,
					this.zTile);
			int k = this.worldObj.getBlockMetadata(this.xTile, this.yTile,
					this.zTile);

			if (blockJ == this.inTile && k == this.inData) {
				++this.ticksInGround;

				if (this.ticksInGround == 1200) {
					this.setDead();
				}
			} else {
				this.inGround = false;
				this.motionX *= (double) (this.rand.nextFloat() * 0.2F);
				this.motionY *= (double) (this.rand.nextFloat() * 0.2F);
				this.motionZ *= (double) (this.rand.nextFloat() * 0.2F);
				this.ticksInGround = 0;
				this.ticksInAir = 0;
			}
		} else {
			++this.ticksInAir;
			Vec3 vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(
					this.posX, this.posY, this.posZ);
			Vec3 vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(
					this.posX + this.motionX, this.posY + this.motionY,
					this.posZ + this.motionZ);
			MovingObjectPosition movingobjectposition = this.worldObj
					.func_147447_a(vec3, vec31, false, true, false);
			vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX,
					this.posY, this.posZ);
			vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(
					this.posX + this.motionX, this.posY + this.motionY,
					this.posZ + this.motionZ);

			if (movingobjectposition != null) {
				vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(
						movingobjectposition.hitVec.xCoord,
						movingobjectposition.hitVec.yCoord,
						movingobjectposition.hitVec.zCoord);
			}

			Entity entity = null;
			List<?> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(
					this,
					this.boundingBox.addCoord(this.motionX, this.motionY,
							this.motionZ).expand(1.0D, 1.0D, 1.0D));
			double d0 = 0.0D;
			int l;
			float f1;

			for (l = 0; l < list.size(); ++l) {
				Entity entity1 = (Entity) list.get(l);

				if (entity1.canBeCollidedWith()
						&& (entity1 != this.thrower || this.ticksInAir >= 5)) {
					f1 = 0.3F;
					AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand(
							(double) f1, (double) f1, (double) f1);
					MovingObjectPosition movingobjectposition1 = axisalignedbb1
							.calculateIntercept(vec3, vec31);

					if (movingobjectposition1 != null) {
						double d1 = vec3
								.distanceTo(movingobjectposition1.hitVec);

						if (d1 < d0 || d0 == 0.0D) {
							entity = entity1;
							d0 = d1;
						}
					}
				}
			}

			if (entity != null) {
				movingobjectposition = new MovingObjectPosition(entity);
			}

			if (movingobjectposition != null
					&& movingobjectposition.entityHit != null
					&& movingobjectposition.entityHit instanceof EntityPlayer) {
				EntityPlayer entityplayer = (EntityPlayer) movingobjectposition.entityHit;

				if (entityplayer.capabilities.disableDamage
						|| this.thrower instanceof EntityPlayer
						&& !((EntityPlayer) this.thrower)
								.canAttackPlayer(entityplayer)) {
					movingobjectposition = null;
				}
			}

			float f2;
			float f3;

			if (movingobjectposition != null) {
				if (movingobjectposition.entityHit != null) {
					f2 = MathHelper.sqrt_double(this.motionX * this.motionX
							+ this.motionY * this.motionY + this.motionZ
							* this.motionZ);
					int i1 = MathHelper.ceiling_double_int((double) f2
							* this.damage);

					// if (this.getIsCritical())
					// {
					// i1 += this.rand.nextInt(i1 / 2 + 2);
					// }

					DamageSource damagesource = null;

					if (this.thrower == null) {
						damagesource = DamageSource.causeThrownDamage(this,
								this);
					} else {
						damagesource = DamageSource.causeThrownDamage(this,
								this.thrower);
					}

					if (this.isBurning()
							&& !(movingobjectposition.entityHit instanceof EntityEnderman)) {
						movingobjectposition.entityHit.setFire(5);
					}

					if (movingobjectposition.entityHit.attackEntityFrom(
							damagesource, i1)) {
						if (movingobjectposition.entityHit instanceof EntityLiving) {
							EntityLiving entityliving = (EntityLiving) movingobjectposition.entityHit;

							if (!this.worldObj.isRemote) {
								entityliving.setArrowCountInEntity(entityliving
										.getArrowCountInEntity() + 1);
							}

							if (this.thrower != null) {
//								EnchantmentThorns.func_151367_b(entityliving,
//										this.thrower, 1);
								//TODO ´ò¸öÀ×
							}

							if (this.thrower != null
									&& movingobjectposition.entityHit != this.thrower
									&& movingobjectposition.entityHit instanceof EntityPlayer
									&& this.thrower instanceof EntityPlayerMP) {

								((EntityPlayerMP) this.thrower).playerNetServerHandler
										.sendPacket(new S2BPacketChangeGameState(
												6, 0));

							}
						}

						this.playSound("random.bowhit", 1.0F,
								1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));

						if (!(movingobjectposition.entityHit instanceof EntityEnderman)) {
							this.setDead();
						}
					} else {
						this.motionX *= -0.10000000149011612D;
						this.motionY *= -0.10000000149011612D;
						this.motionZ *= -0.10000000149011612D;
						this.rotationYaw += 180.0F;
						this.prevRotationYaw += 180.0F;
						this.ticksInAir = 0;
					}
				} else {
					this.xTile = movingobjectposition.blockX;
					this.yTile = movingobjectposition.blockY;
					this.zTile = movingobjectposition.blockZ;
					this.inTile = this.worldObj.getBlock(this.xTile,
							this.yTile, this.zTile);
					this.inData = this.worldObj.getBlockMetadata(this.xTile,
							this.yTile, this.zTile);
					this.motionX = (double) ((float) (movingobjectposition.hitVec.xCoord - this.posX));
					this.motionY = (double) ((float) (movingobjectposition.hitVec.yCoord - this.posY));
					this.motionZ = (double) ((float) (movingobjectposition.hitVec.zCoord - this.posZ));
					f2 = MathHelper.sqrt_double(this.motionX * this.motionX
							+ this.motionY * this.motionY + this.motionZ
							* this.motionZ);
					this.posX -= this.motionX / (double) f2
							* 0.05000000074505806D;
					this.posY -= this.motionY / (double) f2
							* 0.05000000074505806D;
					this.posZ -= this.motionZ / (double) f2
							* 0.05000000074505806D;
					this.playSound("random.bowhit", 1.0F,
							1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
					this.inGround = true;
					// this.setIsCritical(false);

					if (this.inTile != null) {
						this.inTile.onEntityCollidedWithBlock(this.worldObj,
								this.xTile, this.yTile, this.zTile, this);
					}
				}
			}

			this.posX += this.motionX;
			this.posY += this.motionY;
			this.posZ += this.motionZ;
			f2 = MathHelper.sqrt_double(this.motionX * this.motionX
					+ this.motionZ * this.motionZ);
			this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

			for (this.rotationPitch = (float) (Math.atan2(this.motionY,
					(double) f2) * 180.0D / Math.PI); this.rotationPitch
					- this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F) {
				;
			}

			while (this.rotationPitch - this.prevRotationPitch >= 180.0F) {
				this.prevRotationPitch += 360.0F;
			}

			while (this.rotationYaw - this.prevRotationYaw < -180.0F) {
				this.prevRotationYaw -= 360.0F;
			}

			while (this.rotationYaw - this.prevRotationYaw >= 180.0F) {
				this.prevRotationYaw += 360.0F;
			}

			this.rotationPitch = this.prevRotationPitch
					+ (this.rotationPitch - this.prevRotationPitch) * 0.2F;
			this.rotationYaw = this.prevRotationYaw
					+ (this.rotationYaw - this.prevRotationYaw) * 0.2F;
			float f4 = 0.99F;
			f1 = 0.05F;

			if (this.isInWater()) {
				for (int j1 = 0; j1 < 4; ++j1) {
					f3 = 0.25F;
					this.worldObj.spawnParticle("bubble", this.posX
							- this.motionX * (double) f3, this.posY
							- this.motionY * (double) f3, this.posZ
							- this.motionZ * (double) f3, this.motionX,
							this.motionY, this.motionZ);
				}

				f4 = 0.8F;
			}

			this.motionX *= (double) f4;
			this.motionY *= (double) f4;
			this.motionZ *= (double) f4;
			this.motionY -= (double) f1;
			this.setPosition(this.posX, this.posY, this.posZ);
			this.func_145775_I();
		}
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer) {
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {

			if (this.ticksInAir > 0 && this.inGround) {
				this.worldObj.spawnEntityInWorld(new EntityItem(worldObj,
						xTile, yTile, zTile, new ItemStack(InitItem.tomahawk,
								this.itemDamage, 1)));

				this.setDead();
			}
		}

	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
		this.posX = nbttagcompound.getDouble("posx");
		this.posY = nbttagcompound.getDouble("posy");
		this.posZ = nbttagcompound.getDouble("posz");
		this.itemDamage = nbttagcompound.getShort("itemDamage");
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		nbttagcompound.setDouble("posx", this.posX);
		nbttagcompound.setDouble("posy", this.posY);
		nbttagcompound.setDouble("posz", this.posZ);
		nbttagcompound.setShort("itemDamage", (short) this.itemDamage);

	}

	public void setShouldDead(boolean par1) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);

		if (par1) {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 | 1)));
		} else {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 & -2)));
		}
	}

	/**
	 * Whether the arrow has a stream of critical hit particles flying behind
	 * it.
	 */
	public boolean getShouldDead() {
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);
		return (b0 & 1) != 0;
	}

	@Override
	public void setThrowableHeading(double par1, double par3, double par5,
			float par7, float par8) {
		float f2 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5
				* par5);
		par1 /= (double) f2;
		par3 /= (double) f2;
		par5 /= (double) f2;
		par1 += this.rand.nextGaussian()
				* (double) (this.rand.nextBoolean() ? -1 : 1)
				* 0.007499999832361937D * (double) par8;
		par3 += this.rand.nextGaussian()
				* (double) (this.rand.nextBoolean() ? -1 : 1)
				* 0.007499999832361937D * (double) par8;
		par5 += this.rand.nextGaussian()
				* (double) (this.rand.nextBoolean() ? -1 : 1)
				* 0.007499999832361937D * (double) par8;
		par1 *= (double) par7;
		par3 *= (double) par7;
		par5 *= (double) par7;
		this.motionX = par1;
		this.motionY = par3;
		this.motionZ = par5;
		float f3 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
		this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(par1,
				par5) * 180.0D / Math.PI);
		this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(par3,
				(double) f3) * 180.0D / Math.PI);
		this.ticksInGround = 0;

	}

}
