package minecharacter.world;

import java.util.Random;



import minecharacter.misc.InitBlock;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId)
		{
		case -1: generateNether(world, random, chunkX*16, chunkZ*16);
		case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
		}

	}

	private void generateSurface(World world, Random random, int i, int j) {
		
	}

	private void generateNether(World world, Random random, int i, int j) {
		for (int x = 0; x < 8; x++)
	    {
	      int Xcoord = i + random.nextInt(16);
	      int Ycoord = random.nextInt(128);
	      int Zcoord = j + random.nextInt(16);
	      new WorldGenMinableNether(InitBlock.blockNethercoal.blockID, 0, 16).generate(world, random, Xcoord, Ycoord, Zcoord);
	    }
	    for (int x = 0; x < 4; x++)
	    {
	      int Xcoord = i + random.nextInt(16);
	      int Ycoord = random.nextInt(128);
	      int Zcoord = j + random.nextInt(16);
	      new WorldGenMinableNether(InitBlock.blockDemonite.blockID, 0, 8).generate(world, random, Xcoord, Ycoord, Zcoord);
	    }
	    for (int x = 0; x < 2; x++)
	    {
	      int Xcoord = i + random.nextInt(16);
	      int Ycoord = random.nextInt(128);
	      int Zcoord = j + random.nextInt(16);
	      new WorldGenMinableNether(InitBlock.blockLuciferite.blockID, 0, 4).generate(world, random, Xcoord, Ycoord, Zcoord);
	    }
	    
		
	}

}
