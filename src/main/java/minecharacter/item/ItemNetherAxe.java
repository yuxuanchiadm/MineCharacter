package minecharacter.item;

import java.util.Set;

import minecharacter.MineCharacter;
import minecharacter.misc.Localization;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;

import com.google.common.collect.Sets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNetherAxe extends ItemTool {
	private static final Set blocksEffectiveAgainst = Sets
			.newHashSet(new Block[] { Blocks.planks, Blocks.bookshelf,
					Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin,
					Blocks.lit_pumpkin });

	public ItemNetherAxe(ToolMaterial par3EnumToolMaterial) {
		super(3, par3EnumToolMaterial, blocksEffectiveAgainst);
		this.setCreativeTab(MineCharacter.tabMineCharacter);
		this.setMaxDamage(3321);

	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack,
			EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
		par1ItemStack.damageItem(1, par3EntityLiving);
		return super.hitEntity(par1ItemStack, par2EntityLiving,
				par3EntityLiving);
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemStack) {
		return Localization.localize(getUnlocalizedName(itemStack));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("minecharacter:"
				+ this.getUnlocalizedName().replace("item.", ""));
	}

	@Override
	public boolean canHarvestBlock(Block block, ItemStack itemStack) {
		return block.getMaterial() == Material.wood
				|| block.getMaterial() == Material.plants
				|| block.getMaterial() == Material.vine;
	}
}
