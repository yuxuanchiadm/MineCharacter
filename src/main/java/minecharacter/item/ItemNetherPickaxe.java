package minecharacter.item;

import java.util.ArrayList;

import minecharacter.MineCharacter;
import minecharacter.misc.Localization;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNetherPickaxe extends ItemPickaxe {

	public static final Block[] blocksEffectiveAgainst = new Block[] {
			Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab,
			Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone,
			Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore,
			Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore,
			Blocks.diamond_block, Blocks.ice, Blocks.netherrack,
			Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore,
			Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail,
			Blocks.golden_rail, Blocks.activator_rail };

	public ItemNetherPickaxe(ToolMaterial par3EnumToolMaterial) {
		super(par3EnumToolMaterial);
		this.setCreativeTab(MineCharacter.tabMineCharacter);
		this.setMaxDamage(3321);

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
	public String getItemStackDisplayName(ItemStack itemStack) {
		return Localization.localize(getUnlocalizedName(itemStack));
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack,
			EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
		par1ItemStack.damageItem(1, par3EntityLiving);
		return super.hitEntity(par1ItemStack, par2EntityLiving,
				par3EntityLiving);
	}

	

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {

		this.itemIcon = par1IconRegister.registerIcon("minecharacter:"
				+ this.getUnlocalizedName().replace("item.", ""));
	}

}
