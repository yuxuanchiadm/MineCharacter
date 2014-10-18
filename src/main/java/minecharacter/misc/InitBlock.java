package minecharacter.misc;

import cpw.mods.fml.common.registry.GameRegistry;
import minecharacter.block.BlockAir;
import minecharacter.block.BlockAnvil;
import minecharacter.block.BlockNetherOrb;
import minecharacter.block.BlockOmelette;
import minecharacter.block.BlockOrb;
import minecharacter.block.BlockPan;
import minecharacter.block.BlockSponge;
import minecharacter.block.BlockWheat;
import minecharacter.block.ItemBlockMineCharacter;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class InitBlock {
	public static Block blockOmelette;
	public static Block blockNethercoal;
	public static Block blockDemonite;
	public static Block blockLuciferite;
	public static Block blockWheat;
	public static Block blockOrb;
	public static Block sponge;
	public static Block air;
	public static Block pan;
	public static Block blockAnvil;

	public void initBlock() {

		blockOmelette = new BlockOmelette().setBlockName("blockOmelette");
		blockNethercoal = new BlockNetherOrb(0).setBlockName("blockNethercoal");
		blockDemonite = new BlockNetherOrb(1).setBlockName("blockDemonite");
		blockLuciferite = new BlockNetherOrb(2).setBlockName("blockLuciferite");
		blockWheat = new BlockWheat().setBlockName("blockWheat");
		blockOrb = new BlockOrb().setBlockName("blockOrb");
		air = new BlockAir(Material.air).setBlockName("air");
		sponge = new BlockSponge().setBlockName("sponge");
		pan = new BlockPan().setBlockName("pan");
		blockAnvil = new BlockAnvil(Material.rock).setBlockName("blockAnvil");
		this.registerBlocks();
	}

	private void registerBlock(Block block) {
		GameRegistry.registerBlock(block,ItemBlockMineCharacter.class, block.getUnlocalizedName());


	}
	

	private void registerBlocks() {
		registerBlock(InitBlock.blockOmelette);
		registerBlock(InitBlock.blockNethercoal);
		registerBlock(InitBlock.blockDemonite);
		registerBlock(InitBlock.blockLuciferite);
		registerBlock(InitBlock.blockWheat);
		registerBlock(InitBlock.blockOrb);
		registerBlock(InitBlock.air);
		registerBlock(InitBlock.sponge);
		registerBlock(InitBlock.pan);
		registerBlock(InitBlock.blockAnvil);

	}

}
