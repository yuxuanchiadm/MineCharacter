package minecharacter.block;

import java.util.Random;

import minecharacter.MineCharacter;
import minecharacter.misc.InitBlock;
import minecharacter.misc.InitItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNetherOrb extends Block {
	Icon rock1;
	Icon rock2;
	private int meta;

	public BlockNetherOrb(int par1,int meta) {
		super(par1, Material.rock);
		this.meta=meta;
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundStoneFootstep);
		this.setCreativeTab(MineCharacter.tabMineCharacter);
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return this.blockID==InitBlock.blockNethercoal.blockID?InitItem.nethercoal.itemID:Block.netherrack.blockID;
	}

	@Override
	public boolean canHarvestBlock(EntityPlayer player, int meta) {
		if(this.blockID!=InitBlock.blockNethercoal.blockID)
		return super.canHarvestBlock(player, meta);
		else{
		if(player.inventory.getCurrentItem().getItem() instanceof ItemTool){
		return EnumToolMaterial.valueOf(((ItemTool)player.inventory.getCurrentItem().getItem()).getToolMaterialName()).getHarvestLevel()>0;
		}
		}
		return super.canHarvestBlock(player, meta);
	}

	@Override
	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer,
			int par3, int par4, int par5, int par6) {
		if(par2EntityPlayer.inventory.getCurrentItem()!=null&&par2EntityPlayer.inventory.getCurrentItem().itemID==Item.pickaxeGold.itemID){
			switch (this.meta) {
				case 1:
					if(!par1World.isRemote)
						par1World.spawnEntityInWorld(new EntityItem(par1World, par3, par4, par5, new ItemStack(InitBlock.blockDemonite,1,0)));	
					par1World.setBlockToAir(par3, par4, par5);
						return;
				case 2:
					if(!par1World.isRemote)
						par1World.spawnEntityInWorld(new EntityItem(par1World, par3, par4, par5, new ItemStack(InitBlock.blockLuciferite,1,0)));	
					par1World.setBlockToAir(par3, par4, par5);
						return;
				default:
					break;
			}
		}
		super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		switch (this.meta) {
			case 0:
				return this.blockIcon;
			case 1:
				return this.rock1;
			case 2:
				return this.rock2;
			default:
				break;
		}
		return blockIcon;
		
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
	     this.blockIcon = par1IconRegister.registerIcon("minecharacter:nethercoal");
	     this.rock1 = par1IconRegister.registerIcon("minecharacter:blockDemonite");
	     this.rock2 = par1IconRegister.registerIcon("minecharacter:luciferite");
	}



}
