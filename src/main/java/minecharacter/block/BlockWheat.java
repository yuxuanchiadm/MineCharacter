package minecharacter.block;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import minecharacter.MineCharacter;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWheat extends Block {
	Icon[] iconArray=new Icon[6];
Random ran=new Random();
	private int time=2;
	public BlockWheat(int par1) {
		super(par1, Material.grass);
		this.setTickRandomly(true);
		this.setCreativeTab(MineCharacter.tabMineCharacter);
	}

	@Override
	public void updateTick(World par1World, int par2, int par3, int par4,
			Random par5Random) {
		if(this.time<=0){
			par1World.setBlockToAir(par2, par3, par4);
		}
		int cow=0;
		int sheep=0;
		int chicken=0;
		int pig=0;
		EntityAnimal fCow = null;
		EntityAnimal fSheep=null;
		EntityAnimal fChicken=null;
		EntityAnimal fPig=null;
		
		@SuppressWarnings("rawtypes")
		List list=MineCharacter.proxy.findTarget(par1World,AxisAlignedBB.getBoundingBox(par2-5.0D,par3-5.0,par4-5.0D,par2+5.0D,par3+5.0,par4+5.0), null);
		
		@SuppressWarnings("unchecked")
		Iterator<Entity> iterator=list.iterator();
		while(iterator.hasNext()){
			Entity entity=iterator.next();
			if(entity instanceof EntityCow){
				cow++;
				if(cow==1)
				fCow=(EntityAnimal) entity;
				else if(cow==2){
					pp(fCow,entity,entity.worldObj);
				}
			}
			if(entity instanceof EntityPig){
				pig++;
				if(pig==1)
				fPig=(EntityAnimal) entity;
				else if(pig==2){
					pp(fPig,entity,entity.worldObj);
				}
			}
			if(entity instanceof EntitySheep){
				sheep++;
				if(sheep==1)
				fSheep=(EntityAnimal) entity;
				else if(sheep==2){
					pp(fSheep,entity,entity.worldObj);
				}
			}
			if(entity instanceof EntityChicken){
				chicken++;
				if(chicken==1)
				fChicken=(EntityAnimal) entity;
				else if(chicken==2){
					pp(fChicken,entity,entity.worldObj);
				}
			}
			
			
			
		}
		
		super.updateTick(par1World, par2, par3, par4, par5Random);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		for(int i=0;i<6;i++)
			this.iconArray[i]=par1IconRegister.registerIcon("minecharacter:wheat_"+i);
	}

	private void pp(EntityAnimal fAnimal, Entity entity,World world) {
		EntityAnimal sAnimal=(EntityAnimal) entity;
		fAnimal.inLove=600;
		sAnimal.inLove=600;
		fAnimal.setAttackTarget(sAnimal);
		sAnimal.setAttackTarget(fAnimal);
		 for (int i = 0; i < 7; ++i)
         {
             double d0 = this.ran.nextGaussian() * 0.02D;
             double d1 = this.ran.nextGaussian() * 0.02D;
             double d2 = this.ran.nextGaussian() * 0.02D;
            world.spawnParticle("heart", fAnimal.posX + (double)(this.ran.nextFloat() * fAnimal.width * 2.0F) - (double)fAnimal.width, fAnimal.posY + 0.5D + (double)(this.ran.nextFloat() * fAnimal.height), fAnimal.posZ + (double)(this.ran.nextFloat() * fAnimal.width * 2.0F) - (double)fAnimal.width, d0, d1, d2);
            world.spawnParticle("heart", sAnimal.posX + (double)(this.ran.nextFloat() * sAnimal.width * 2.0F) - (double)sAnimal.width, sAnimal.posY + 0.5D + (double)(this.ran.nextFloat() * sAnimal.height), sAnimal.posZ + (double)(this.ran.nextFloat() * sAnimal.width * 2.0F) - (double)sAnimal.width, d0, d1, d2);
         }
		this.time--;
		
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		return iconArray[par1];
	}

}
