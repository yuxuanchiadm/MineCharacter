package minecharacter.block;

import java.util.Random;

import minecharacter.misc.InitBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockSponge extends Block {

	public BlockSponge() {
		super(Material.sponge);
		setHardness(0.6F);
		setStepSound(soundTypeGrass);
		// setUnlocalizedName("sponge");
		// setTextureName("sponge");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setTickRandomly(true);
	}

	@Override
	public void updateTick(World par1World, int par2, int par3, int par4,
			Random par5Random) {
		byte byte0 = 2;
		for (int l = par2 - byte0; l <= par2 + byte0; l++) {
			for (int i1 = par3 - byte0; i1 <= par3 + byte0; i1++) {
				for (int j1 = par4 - byte0; j1 <= par4 + byte0; j1++) {
					if (par1World.getBlock(l, i1, j1).equals(Blocks.water)) {
						if (par1World.getBlockMetadata(l, i1, j1) == 0) {
							par1World.setBlock(l, i1, j1, InitBlock.air, 0, 2);
						} else {
							par1World.setBlock(l, i1, j1, InitBlock.air, 1, 2);
						}
					}
				}
			}
		}
	}

	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		byte byte0 = 2;
		for (int l = par2 - byte0; l <= par2 + byte0; l++) {
			for (int i1 = par3 - byte0; i1 <= par3 + byte0; i1++) {
				for (int j1 = par4 - byte0; j1 <= par4 + byte0; j1++) {
					if (par1World.getBlock(l, i1, j1) .equals(Blocks.water)) {
						if (par1World.getBlockMetadata(l, i1, j1) == 0) {
							par1World.setBlock(l, i1, j1,
									InitBlock.air, 0, 2);
						} else {
							par1World.setBlock(l, i1, j1,
									InitBlock.air, 1, 2);
						}
					}
				}
			}
		}
	}

	@Override
	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3,
			int par4, int par5) {
		byte byte0 = 2;
		for (int l = par2 - byte0; l <= par2 + byte0; l++) {
			for (int i1 = par3 - byte0; i1 <= par3 + byte0; i1++) {
				for (int j1 = par4 - byte0; j1 <= par4 + byte0; j1++) {
					// par1World.(l, i1, j1, par1World.a(l, i1, j1));
					if (par1World.getBlock(l, i1, j1) == InitBlock.air) {
						if (par1World.getBlockMetadata(l, i1, j1) == 0) {
							par1World.setBlock(l, i1, j1, Blocks.water);
						} else {
							par1World.setBlockToAir(l, i1, j1);
						}
					}
				}
			}
		}
	}

	@Override
	public void onBlockDestroyedByExplosion(World par1World, int par2,
			int par3, int par4, Explosion par5Explosion) {
		byte byte0 = 2;
		for (int l = par2 - byte0; l <= par2 + byte0; l++) {
			for (int i1 = par3 - byte0; i1 <= par3 + byte0; i1++) {
				for (int j1 = par4 - byte0; j1 <= par4 + byte0; j1++) {
					// par1World.(l, i1, j1, par1World.a(l, i1, j1));
					if (par1World.getBlock(l, i1, j1) == InitBlock.air) {
						if (par1World.getBlockMetadata(l, i1, j1) == 0) {
							par1World.setBlock(l, i1, j1, Blocks.water);
						} else {
							par1World.setBlockToAir(l, i1, j1);
						}
					}
				}
			}
		}
	}

}
