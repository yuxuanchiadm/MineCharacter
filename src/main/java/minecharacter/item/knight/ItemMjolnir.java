package minecharacter.item.knight;

import java.util.List;

import minecharacter.MineCharacter;
import minecharacter.entity.EntityLightingMjolnir;
import minecharacter.item.ItemHammer;
import minecharacter.network.PacketSpawnLighting;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMjolnir extends ItemHammer {

	private int weaponDamage;
	public ItemMjolnir(int par1, EnumToolMaterial par3EnumToolMaterial) {
		super(par1,par3EnumToolMaterial);
		this.setMaxDamage(3122);
		this.weaponDamage=(int) (3+par3EnumToolMaterial.getDamageVsEntity());
		this.setCreativeTab(MineCharacter.tabMineCharacter);
	}

	@Override
	public int getDamage(ItemStack stack) {
		return this.weaponDamage;
	}


	@Override
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
		return 1.0F;
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack,EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
		par1ItemStack.damageItem(1, par3EntityLiving);
		par2EntityLiving.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) par3EntityLiving), this.weaponDamage);
		return false;
	}


	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon=par1IconRegister.registerIcon("minecharacter:"+this.getUnlocalizedName().replace("item.", ""));
	}

	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack,
			ItemStack par2ItemStack) {
				return false;
		
	}

	

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		 return 3600*20;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer, int par4) {
		int j = this.getMaxItemUseDuration(par1ItemStack) - par4;
	    float f = j / 20.0F;
	    if(par3EntityPlayer.capabilities.isCreativeMode||MineCharacter.proxy.isEquid(par3EntityPlayer, "knight")){
	    if (f > 1.0F)
	    {
	      aoe(par1ItemStack, par2World, par3EntityPlayer);
	      par3EntityPlayer.swingItem();
	    }
	    }
		
	}

	@SuppressWarnings("unchecked")
	private void aoe(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
	    if (par3EntityPlayer.isDead)
	    {
	      return;
	    }
	    double d6 = 5.0D;
	    double d7 = 5.0D;
	    List<Entity> list = MineCharacter.proxy.findTarget(par2World, AxisAlignedBB.getBoundingBox(par3EntityPlayer.posX - d6, par3EntityPlayer.posY - d7, par3EntityPlayer.posZ - d6, par3EntityPlayer.posX + d6, par3EntityPlayer.posY + d7, par3EntityPlayer.posZ + d6),par3EntityPlayer);
	    for (int k2 = 0; k2 < list.size(); k2++)
	    {
	        EntityLiving entity = (EntityLiving)list.get(k2);
	        double d5 = entity.getDistanceToEntity(par3EntityPlayer);
	        if (d5 <= 8.0D)
	        {
	          par1ItemStack.damageItem(6, par3EntityPlayer);
	          hitEntity(par1ItemStack, entity, par3EntityPlayer);
	          EntityLightingMjolnir lighting=new EntityLightingMjolnir(par2World,par3EntityPlayer, entity.posX, entity.posY, entity.posZ);
	  
	          par2World.weatherEffects.add(lighting);
	          PacketSpawnLighting.spawnlight(lighting.posX, lighting.posY, lighting.posZ, -12);
	          par2World.playSoundEffect(par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ, "random.explode", 4.0F, (1.0F + (par2World.rand.nextFloat() - par2World.rand.nextFloat()) * 0.2F) * 0.7F);
	        }
	      
	    }
	}

	@Override
	protected void back(EntityLiving entity, EntityPlayer player) {
		entity.motionX=0;
		entity.motionY=0;
		entity.motionZ=0;
		entity.motionX+=ran.nextGaussian()*3;
		entity.motionY+=ran.nextGaussian()*3;
		entity.motionZ+=ran.nextGaussian()*3;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		 
	  par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
	        return par1ItemStack;
	}
	@Override
	 public EnumAction getItemUseAction(ItemStack par1ItemStack)
	    {
	        return EnumAction.bow;
	    }


}
