package minecharacter.item.knight;

import java.util.Set;

import minecharacter.MineCharacter;
import minecharacter.entity.EntityTomahawk;
import minecharacter.misc.InitItem;
import minecharacter.misc.Localization;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

import com.google.common.collect.Sets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTomahawk extends ItemTool {
	private static final Set blocksEffectiveAgainst = Sets
			.newHashSet(new Block[] { Blocks.planks, Blocks.bookshelf,
					Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin,
					Blocks.lit_pumpkin });

	public ItemTomahawk(ToolMaterial par3EnumToolMaterial) {
		super(3, par3EnumToolMaterial, blocksEffectiveAgainst);
		this.setCreativeTab(MineCharacter.tabMineCharacter);
	}

	@Override
	public float func_150893_a(ItemStack par1ItemStack, Block par2Block) {
		return par2Block != null
				&& (par2Block.getMaterial() == Material.wood
						|| par2Block.getMaterial() == Material.plants || par2Block
						.getMaterial() == Material.vine) ? this.efficiencyOnProperMaterial
				: super.func_150893_a(par1ItemStack, par2Block);
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 3600 * 20;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer, int par4) {
		int j = this.getMaxItemUseDuration(par1ItemStack) - par4;
		float f = j / 20.0F;
		if (f > 1.0F) {
			if (MineCharacter.proxy.isEquid(par3EntityPlayer, "knight")
					|| par3EntityPlayer.capabilities.isCreativeMode) {
				EntityTomahawk entityTomahawk = new EntityTomahawk(par2World,
						par1ItemStack, par3EntityPlayer, f * 2.0F);
				par2World.playSoundAtEntity(par3EntityPlayer, "random.bow",
						1.0F, 1.0F / (Item.itemRand.nextFloat() * 0.4F + 1.2F)
								+ f * 0.5F);
				par3EntityPlayer.inventory
						.consumeInventoryItem(InitItem.tomahawk);

				if (!par2World.isRemote) {
					par2World.spawnEntityInWorld(entityTomahawk);
				}
			}
		}

	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {

		par3EntityPlayer.setItemInUse(par1ItemStack,
				this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.bow;
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
