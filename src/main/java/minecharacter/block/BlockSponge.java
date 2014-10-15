package minecharacter.block;

import java.util.Random;

import minecharacter.misc.InitBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockSponge extends Block {

	public BlockSponge(int par1) {
		super(par1, Material.sponge);
		setHardness(0.6F);
		setStepSound(soundGrassFootstep);
		setUnlocalizedName("sponge");
		setTextureName("sponge");
		  this.setCreativeTab(CreativeTabs.tabBlock);
		  this.setTickRandomly(true);
	}

	@Override
	public void updateTick(World par1World, int par2, int par3, int par4,
			Random par5Random) {
		byte byte0 = 2;
	    for (int l = par2 - byte0; l <= par2 + byte0; l++)
	    {
	      for (int i1 = par3 - byte0; i1 <= par3 + byte0; i1++)
	      {
	        for (int j1 = par4 - byte0; j1 <= par4 + byte0; j1++)
	        {
	          if (par1World.getBlockId(l, i1, j1) ==Block.waterStill.blockID )
	          {
	            if (par1World.getBlockMetadata(l, i1, j1) == 0)
	            {
	              par1World.setBlock(l, i1, j1, InitBlock.air.blockID,0, 2);
	            }
	            else
	            {
	            	par1World.setBlock(l, i1, j1, InitBlock.air.blockID,1, 2);
	            }
	          }
	        }
	      }
	}	
	}

	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		byte byte0 = 2;
	    for (int l = par2 - byte0; l <= par2 + byte0; l++)
	    {
	      for (int i1 = par3 - byte0; i1 <= par3 + byte0; i1++)
	      {
	        for (int j1 = par4 - byte0; j1 <= par4 + byte0; j1++)
	        {
	          if (par1World.getBlockId(l, i1, j1) ==Block.waterStill.blockID )
	          {
	            if (par1World.getBlockMetadata(l, i1, j1) == 0)
	            {
	              par1World.setBlock(l, i1, j1, InitBlock.air.blockID,0, 2);
	            }
	            else
	            {
	            	par1World.setBlock(l, i1, j1, InitBlock.air.blockID,1, 2);
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
	    for (int l = par2 - byte0; l <= par2 + byte0; l++)
	    {
	      for (int i1 = par3 - byte0; i1 <= par3 + byte0; i1++)
	      {
	        for (int j1 = par4 - byte0; j1 <= par4 + byte0; j1++)
	        {
//	          par1World.(l, i1, j1, par1World.a(l, i1, j1));
	          if (par1World.getBlockId(l, i1, j1) == InitBlock.air.blockID)
	          {
	            if (par1World.getBlockMetadata(l, i1, j1) == 0)
	            {
	              par1World.setBlock(l, i1, j1, Block.waterStill.blockID);
	            }
	            else
	            {
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
	    for (int l = par2 - byte0; l <= par2 + byte0; l++)
	    {
	      for (int i1 = par3 - byte0; i1 <= par3 + byte0; i1++)
	      {
	        for (int j1 = par4 - byte0; j1 <= par4 + byte0; j1++)
	        {
//	          par1World.(l, i1, j1, par1World.a(l, i1, j1));
	          if (par1World.getBlockId(l, i1, j1) == InitBlock.air.blockID)
	          {
	            if (par1World.getBlockMetadata(l, i1, j1) == 0)
	            {
	              par1World.setBlock(l, i1, j1, Block.waterStill.blockID);
	            }
	            else
	            {
	              par1World.setBlockToAir(l, i1, j1);
	            }
	          }
	        }
	      }
	}
	}

}
