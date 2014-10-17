package minecharacter.item.knight;

import java.util.Set;

import minecharacter.MineCharacter;
import minecharacter.misc.Localization;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

import com.google.common.collect.Sets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMattock extends ItemTool {
	private static final Set blocksEffectiveAgainst = Sets
			.newHashSet(new Block[] { Blocks.cobblestone,
					Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone,
					Blocks.sandstone, Blocks.mossy_cobblestone,
					Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore,
					Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore,
					Blocks.diamond_block, Blocks.ice, Blocks.netherrack,
					Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore,
					Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail,
					Blocks.golden_rail, Blocks.activator_rail });

	public ItemMattock(ToolMaterial par3EnumToolMaterial) {
		super(4, par3EnumToolMaterial, blocksEffectiveAgainst);
		this.setMaxDamage(3122);
		this.setCreativeTab(MineCharacter.tabMineCharacter);

	}

	@Override
	public float func_150893_a(ItemStack par1ItemStack, Block par2Block) {
		return par2Block != null
				&& (par2Block.getMaterial() == Material.iron
						|| par2Block.getMaterial() == Material.anvil || par2Block.getMaterial() == Material.rock) ? this.efficiencyOnProperMaterial
				: super.func_150893_a(par1ItemStack, par2Block);
	}

	@Override
	public boolean canHarvestBlock(Block par1Block, ItemStack itemStack) {
		return par1Block == Blocks.obsidian ? this.toolMaterial
				.getHarvestLevel() == 3
				: (par1Block != Blocks.diamond_block
						&& par1Block != Blocks.diamond_ore ? (par1Block != Blocks.emerald_ore
						&& par1Block != Blocks.emerald_block ? (par1Block != Blocks.gold_block
						&& par1Block != Blocks.gold_ore ? (par1Block != Blocks.iron_block
						&& par1Block != Blocks.iron_ore ? (par1Block != Blocks.lapis_block
						&& par1Block != Blocks.lapis_ore ? (par1Block != Blocks.redstone_ore
						&& par1Block != Blocks.redstone_lamp ? (par1Block
						.getMaterial().equals(Material.rock) ? true
						: (par1Block.getMaterial().equals(Material.iron) ? true
								: par1Block.getMaterial()
										.equals(Material.anvil)))
						: this.toolMaterial.getHarvestLevel() >= 2)
						: this.toolMaterial.getHarvestLevel() >= 1)
						: this.toolMaterial.getHarvestLevel() >= 1)
						: this.toolMaterial.getHarvestLevel() >= 2)
						: this.toolMaterial.getHarvestLevel() >= 2)
						: this.toolMaterial.getHarvestLevel() >= 2);
	}


	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("minecharacter:"
				+ this.getUnlocalizedName().replace("item.", ""));
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemStack) {
		return Localization.localize(getUnlocalizedName(itemStack));
	}

}
