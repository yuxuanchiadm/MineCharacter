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

		blockOmelette = new BlockOmelette(ModIdConfig.blockOmeletteId).setUnlocalizedName("blockOmelette");
		blockNethercoal = new BlockNetherOrb(ModIdConfig.blockNethercoalId, 0).setUnlocalizedName("blockNethercoal");
		blockDemonite = new BlockNetherOrb(ModIdConfig.blockDemoniteId, 1).setUnlocalizedName("blockDemonite");
		blockLuciferite = new BlockNetherOrb(ModIdConfig.blockLuciferiteId, 2).setUnlocalizedName("blockLuciferite");
		blockWheat = new BlockWheat(ModIdConfig.blockWheatId).setUnlocalizedName("blockWheat");
		blockOrb = new BlockOrb(ModIdConfig.blockOrbId).setUnlocalizedName("blockOrb");
		air = new BlockAir(ModIdConfig.airId, Material.air).setUnlocalizedName("air");
		sponge = new BlockSponge(ModIdConfig.spongeId);
		Block.blocksList[Block.sponge.blockID] = null;
		Block.blocksList[Block.sponge.blockID] = InitBlock.sponge;
		pan = new BlockPan(ModIdConfig.panId).setUnlocalizedName("pan");
		blockAnvil = new BlockAnvil(ModIdConfig.blockAnvilId, Material.rock).setUnlocalizedName("blockAnvil");
		this.registerBlocks();
	}

	private void registerBlock(Block block) {
		GameRegistry.registerBlock(block,ItemBlockMineCharacter.class, block.getUnlocalizedName());


	}

	private void registerBlocks() {
		registerBlock(InitBlock.blockNethercoal);
		registerBlock(InitBlock.blockDemonite);
		registerBlock(InitBlock.blockLuciferite);
		registerBlock(InitBlock.blockWheat);
		registerBlock(InitBlock.blockOrb);
		registerBlock(InitBlock.pan);
		registerBlock(InitBlock.blockAnvil);

	}

}
