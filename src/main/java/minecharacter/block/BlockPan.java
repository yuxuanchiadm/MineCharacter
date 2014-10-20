package minecharacter.block;

import minecharacter.MineCharacter;
import minecharacter.block.tileentity.TileEntityPan;
import minecharacter.misc.InitItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPan extends BlockContainer {

	public BlockPan() {
		super(Material.rock);
		this.setCreativeTab(MineCharacter.tabMineCharacter);
		this.setLightLevel(0.2F);
		this.setLightOpacity(3);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
		this.setHardness(0.7F);
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public void onBlockHarvested(World par1World, int par2, int par3, int par4,
			int par5, EntityPlayer par6EntityPlayer) {

		TileEntity tile = par1World.getTileEntity(par2, par3, par4);
		if (tile != null && tile instanceof TileEntityPan) {
			TileEntityPan pan = (TileEntityPan) tile;
			if (pan.inPan != null)
				par1World.spawnEntityInWorld(new EntityItem(par1World, par2,
						par3, par4, pan.inPan));

		}

		super.onBlockHarvested(par1World, par2, par3, par4, par5,
				par6EntityPlayer);

	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9) {

		TileEntity tile = par1World.getTileEntity(par2, par3, par4);
		if (tile != null && tile instanceof TileEntityPan) {
			TileEntityPan pan = (TileEntityPan) tile;
			if (pan.inPan == null) {
				if (par5EntityPlayer.inventory.getCurrentItem() != null) {
					if (canCook(par5EntityPlayer.inventory.getCurrentItem())) {
						pan.inPan = par5EntityPlayer.inventory.getCurrentItem()
								.splitStack(1);
						par1World.markBlockForUpdate(par2, par3, par4);
					}
				} else {
					return true;
				}
			} else {
				if (!par1World.isRemote)
					par1World.spawnEntityInWorld(new EntityItem(par1World,
							par2, par3, par4, pan.inPan));

				pan.inPan = null;
				par1World.markBlockForUpdate(par2, par3, par4);

			}

		}

		return true;
	}

	private boolean canCook(ItemStack currentItem) {
		ItemStack stack = FurnaceRecipes.smelting().getSmeltingResult(
				currentItem);
		if (stack == null) {
			return false;
		}
		Item itemMayCook = stack.getItem();
		if (itemMayCook == Items.cooked_chicken
				|| itemMayCook == Items.cooked_porkchop
				|| itemMayCook == InitItem.friedEgg
				|| itemMayCook == Items.cooked_beef
				|| itemMayCook == Items.baked_potato
				|| itemMayCook == Items.cooked_fished
				|| itemMayCook instanceof ItemFood)
			return true;
		return false;
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("minecharacter:"
				+ this.getUnlocalizedName().replace("tile.", ""));
	}

	private void func_149930_e(World world, int posX, int poxY, int posZ) {
		if (world.isRemote) {
			return;
		}

		Block localBlock1 = world.getBlock(posX, poxY, posZ - 1);
		Block localBlock2 = world.getBlock(posX, poxY, posZ + 1);
		Block localBlock3 = world.getBlock(posX - 1, poxY, posZ);
		Block localBlock4 = world.getBlock(posX + 1, poxY, posZ);

		int i = 0;
		if ((localBlock1.func_149730_j()) && (!localBlock2.func_149730_j()))
			i = 1;
		if ((localBlock2.func_149730_j()) && (!localBlock1.func_149730_j()))
			i = 0;
		if ((localBlock3.func_149730_j()) && (!localBlock4.func_149730_j()))
			i = 3;
		if ((localBlock4.func_149730_j()) && (!localBlock3.func_149730_j()))
			i = 2;
		world.setBlockMetadataWithNotify(posX, poxY, posZ, i, 2);
	}

	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4,
			EntityLivingBase par5EntityLiving, ItemStack par6ItemStack) {

		int l = MathHelper
				.floor_double((double) (par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (l == 0) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
		}

		if (l == 1) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
		}

		if (l == 2) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
		}

		if (l == 3) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
		}
		super.onBlockPlacedBy(par1World, par2, par3, par4, par5EntityLiving,
				par6ItemStack);
	}

	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		super.onBlockAdded(par1World, par2, par3, par4);
		this.func_149930_e(par1World, par2, par3, par4);
	}

	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		return new TileEntityPan();
	}

}
