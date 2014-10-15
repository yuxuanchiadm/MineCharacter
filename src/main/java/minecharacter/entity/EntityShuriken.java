package minecharacter.entity;

import minecharacter.misc.InitItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityShuriken extends EntityThrowable {

	public EntityShuriken(World par1World, EntityLivingBase par2EntityLiving) {
		super(par1World, par2EntityLiving);
	this.ignoreFrustumCheck = true;
	}

	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition) {
		if(movingobjectposition.entityHit!=null){
		movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this),4);	

		this.setDead();
		}
		else{
			if(!worldObj.isRemote)
				worldObj.spawnEntityInWorld(new EntityItem(worldObj, movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ, new ItemStack(InitItem.shuriken)));
				this.setDead();
		}
	}

}
