package minecharacter.item;

import java.util.ArrayList;

import minecharacter.MineCharacter;
import minecharacter.misc.Localization;
import minecharacter.network.PacketSpawnItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNetherPickaxe extends ItemPickaxe {

	public static final Block[] blocksEffectiveAgainst = new Block[] {
			Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab,
			Block.stone, Block.sandStone, Block.cobblestoneMossy,
			Block.oreIron, Block.blockIron, Block.oreCoal, Block.blockGold,
			Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice,
			Block.netherrack, Block.oreLapis, Block.blockLapis,
			Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail,
			Block.railDetector, Block.railPowered, Block.railActivator };

	public ItemNetherPickaxe(int par1, EnumToolMaterial par3EnumToolMaterial) {
		super(par1, par3EnumToolMaterial);
		this.setCreativeTab(MineCharacter.tabMineCharacter);
		this.setMaxDamage(3321);

	}

	@Override
	public boolean canHarvestBlock(Block par1Block) {
		return par1Block == Block.obsidian ? this.toolMaterial
				.getHarvestLevel() == 3
				: (par1Block != Block.blockDiamond
						&& par1Block != Block.oreDiamond ? (par1Block != Block.oreEmerald
						&& par1Block != Block.blockEmerald ? (par1Block != Block.blockGold
						&& par1Block != Block.oreGold ? (par1Block != Block.blockIron
						&& par1Block != Block.oreIron ? (par1Block != Block.blockLapis
						&& par1Block != Block.oreLapis ? (par1Block != Block.oreRedstone
						&& par1Block != Block.oreRedstoneGlowing ? (par1Block.blockMaterial == Material.rock ? true
						: (par1Block.blockMaterial == Material.iron ? true
								: par1Block.blockMaterial == Material.anvil))
						: this.toolMaterial.getHarvestLevel() >= 2)
						: this.toolMaterial.getHarvestLevel() >= 1)
						: this.toolMaterial.getHarvestLevel() >= 1)
						: this.toolMaterial.getHarvestLevel() >= 2)
						: this.toolMaterial.getHarvestLevel() >= 2)
						: this.toolMaterial.getHarvestLevel() >= 2);
	}

	@Override
	public String getItemDisplayName(ItemStack itemstack) {
		return Localization.localize(getUnlocalizedName(itemstack));
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack,
			EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
		par1ItemStack.damageItem(1, par3EntityLiving);
		return super.hitEntity(par1ItemStack, par2EntityLiving,
				par3EntityLiving);
	}

	public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World,
			int blockID, int x, int y, int z, EntityLivingBase par7EntityLiving) {
		if ((super.onBlockDestroyed(par1ItemStack, par2World, blockID, x, y, z,
				par7EntityLiving))
				&& (canHarvestBlock(Block.blocksList[blockID]))) {
			if (par2World.isRemote) {
				int meta = par2World.getBlockMetadata(x, y, z);
				par2World.setBlockToAir(x, y, z);
				ArrayList<ItemStack> items = Block.blocksList[blockID]
						.getBlockDropped(par2World, x, y, z, meta, 0);

				for (ItemStack input : items) {
					ItemStack result = FurnaceRecipes.smelting()
							.getSmeltingResult(input);
					if (result != null) {
					
						for (int var1 = 0; var1 < 5; var1++) {
							double rx = Item.itemRand.nextGaussian() * 0.02D;
							double ry = Item.itemRand.nextGaussian() * 0.02D;
							double rz = Item.itemRand.nextGaussian() * 0.02D;
							double magnitude = 20.0D;
							par2World.spawnParticle("flame", x + 0.5D + rx
									* magnitude, y + 0.5D + ry * magnitude, z
									+ 0.5D + rz * magnitude, -rx, -ry, -rz);
						}

					}

				}

			}

			return true;
		}

		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("minecharacter:"
				+ this.getUnlocalizedName().replace("item.", ""));
	}

}
