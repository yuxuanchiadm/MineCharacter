package minecharacter.block;

import java.util.Random;

import minecharacter.MineCharacter;
import minecharacter.misc.InitBlock;
import minecharacter.misc.InitItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNetherOrb extends Block {
	IIcon rock1;
	IIcon rock2;
	private int meta;

	public BlockNetherOrb(int meta) {
		super(Material.rock);
		this.meta = meta;
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(MineCharacter.tabMineCharacter);
	}

	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3) {

		return this.equals(InitBlock.blockNethercoal) ? InitItem.nethercoal
				: Item.getItemFromBlock(Blocks.netherrack);

	}

	@Override
	public boolean canHarvestBlock(EntityPlayer player, int meta) {

		if (this.equals(InitBlock.blockNethercoal))
			return super.canHarvestBlock(player, meta);
		return true;
	}

	@Override
	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer,
			int par3, int par4, int par5, int par6) {
		if (par2EntityPlayer.inventory.getCurrentItem() != null
				&& par2EntityPlayer.inventory.getCurrentItem().getItem()
						.equals(Items.golden_pickaxe)) {
			switch (this.meta) {
			case 1:
				if (!par1World.isRemote)
					par1World.spawnEntityInWorld(new EntityItem(par1World,
							par3, par4, par5, new ItemStack(InitItem.demonite,
									1, 0)));
				par1World.setBlockToAir(par3, par4, par5);
				return;
			case 2:
				if (!par1World.isRemote)
					par1World.spawnEntityInWorld(new EntityItem(par1World,
							par3, par4, par5, new ItemStack(
									InitItem.luciferite, 1, 0)));
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
	public IIcon getIcon(int par1, int par2) {
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
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister
				.registerIcon("minecharacter:nethercoal");
		this.rock1 = par1IconRegister
				.registerIcon("minecharacter:blockDemonite");
		this.rock2 = par1IconRegister.registerIcon("minecharacter:luciferite");
	}

}
