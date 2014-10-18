package minecharacter.block;

import java.util.List;

import scala.tools.nsc.transform.patmat.Logic.PropositionalLogic.Sym;
import minecharacter.MineCharacter;
import minecharacter.block.tileentity.TileEntityOrb;
import minecharacter.entity.EntityLightningOrb;
import minecharacter.misc.InitBlock;
import minecharacter.misc.InitItem;
import minecharacter.network.PacketOrbChange;
import minecharacter.network.PacketSpawnLighting;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOrb extends BlockContainer {
	public BlockOrb() {
		super(Material.rock);
		this.setCreativeTab(MineCharacter.tabMineCharacter);
		this.setLightLevel(0.72F);
		this.setLightOpacity(1);
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9) {

		TileEntity tile = par1World.getTileEntity(par2, par3, par4);
		if (tile instanceof TileEntityOrb) {
			TileEntityOrb tileorb = (TileEntityOrb) tile;
			if (tileorb.getBlockMetadata() == 0) {
				if (par5EntityPlayer.inventory.getCurrentItem() != null) {
					ItemStack stack = par5EntityPlayer.inventory
							.getCurrentItem();
					Item item = stack.getItem();
					if (item.equals(InitItem.orb)
							|| item.equals(InitItem.fireOrb)
							|| item.equals(InitItem.iceOrb)
							|| item.equals(InitItem.lifeOrb)
							|| item.equals(InitItem.deathOrb)) {
						if (item.equals(InitItem.orb)) {

							par1World.setBlockMetadataWithNotify(par2, par3,
									par4, 1, 2);
						}
						if (item.equals(InitItem.fireOrb)) {

							par1World.setBlockMetadataWithNotify(par2, par3,
									par4, 2, 2);
						}
						if (item.equals(InitItem.iceOrb)) {
							par1World.setBlockMetadataWithNotify(par2, par3,
									par4, 3, 2);
						}
						if (item.equals(InitItem.lifeOrb)) {
							par1World.setBlockMetadataWithNotify(par2, par3,
									par4, 4, 2);
						}
						if (item.equals(InitItem.deathOrb)) {
							par1World.setBlockMetadataWithNotify(par2, par3,
									par4, 5, 2);
						}
						par5EntityPlayer.inventory.consumeInventoryItem(item);
						return true;
					}

				}

			} else {
				if (tileorb.getBlockMetadata() == 1) {
					if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER) {
						par1World.spawnEntityInWorld(new EntityItem(par1World,
								par2, par3, par4, new ItemStack(InitItem.orb,
										1, 0)));
					}
					par1World
							.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);

				}
				if (tileorb.getBlockMetadata() == 2) {
					if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER) {
						par1World.spawnEntityInWorld(new EntityItem(par1World,
								par2, par3, par4, new ItemStack(
										InitItem.fireOrb, 1, 0)));
					}
					par1World
							.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
				} else if (tileorb.getBlockMetadata() == 3) {
					if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER) {
						par1World.spawnEntityInWorld(new EntityItem(par1World,
								par2, par3, par4, new ItemStack(
										InitItem.iceOrb, 1, 0)));
					}
					par1World
							.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
				} else if (tileorb.getBlockMetadata() == 4) {
					if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER) {
						par1World.spawnEntityInWorld(new EntityItem(par1World,
								par2, par3, par4, new ItemStack(
										InitItem.lifeOrb, 1, 0)));
					}
					par1World
							.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
				} else if (tileorb.getBlockMetadata() == 5) {
					if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER) {
						par1World.spawnEntityInWorld(new EntityItem(par1World,
								par2, par3, par4, new ItemStack(
										InitItem.deathOrb, 1, 0)));
					}
					par1World
							.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
				}
				return true;
			}

		}

		return true;
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3,
			int par4, Block block) {
		if (!par1World.isAirBlock(par2, par3, par4)) {
			TileEntity tile = par1World.getTileEntity(par2, par3, par4);
			if (tile != null && tile instanceof TileEntityOrb) {
				TileEntityOrb orb = (TileEntityOrb) tile;
				if (orb.getBlockMetadata() > 1) {
					for (int i = -2; i < 3; i++)
						for (int j = -2; j < 3; j++) {
							
//par1World.setBlock(par2 + i,par3, par4 + j,Blocks.cake);
							if (Block.isEqualTo(par1World.getBlock(par2 + i,par3, par4 + j), Blocks.redstone_wire)||
							    (Block.isEqualTo(par1World.getBlock(par2 + i, par3,par4 + j),Blocks.lit_redstone_lamp)&& Block.isEqualTo(par1World.getBlock(par2 + i, par3 + 1, par4+ j),Blocks.wooden_pressure_plate))
							    ) {
									
									
								int i1 = par2 + i;
								int j1 = par3;
								int k1 = par4 + j;
								int flag = 0;
			
								List items = par1World.getEntitiesWithinAABB(EntityItem.class, 
										AxisAlignedBB.getBoundingBox(
												i1,j1 + 1, 
												k1,i1 + 1, 
												j1 + 2,k1 + 1
												));
								if (items.size() < 1) {
									return;
								}
								

								if (((EntityItem) items.get(0)).getEntityItem().getItem().equals(InitItem.magicPowder)
									||((EntityItem) items.get(0)).getEntityItem().getItem().equals(Items.iron_ingot)) {
									flag = 1;
								} else if (((EntityItem) items.get(0))
										.getEntityItem().equals(InitItem.rune)) {
									flag = 2;
								} else {
									flag = 3;
								}
								if (flag == 1) {
//									par1World.setBlock(i1, j1, k1,Blocks);
									if (Block.isEqualTo(par1World.getBlock(i1 - 2, j1, k1 - 2),InitBlock.blockOrb)
											&& Block.isEqualTo(par1World.getBlock(i1 + 2, j1,k1 - 2),InitBlock.blockOrb)
											&& Block.isEqualTo(par1World.getBlock(i1 + 2, j1,k1 + 2),InitBlock.blockOrb)
											&& Block.isEqualTo(par1World.getBlock(i1 - 2, j1,k1 + 2),InitBlock.blockOrb)
											&& Block.isEqualTo(par1World.getBlock(i1 - 2, j1,k1 - 1),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1 - 2, j1,k1),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1 - 2, j1,k1 + 1),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1 - 1, j1,k1),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1, j1,k1 - 1),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1, j1,k1 - 2),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1 - 1, j1,k1 - 2),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1 + 1, j1,k1 - 2),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1 + 1, j1,k1),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1 + 2, j1,k1 + 0),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1 + 2, j1,k1 - 1),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1 + 2, j1,k1 + 1),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1 + 1, j1,k1 + 2),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1 - 1, j1,k1 + 2),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1, j1,k1 + 1),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1, j1,k1 + 2),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1 - 1, j1,k1 - 1),Blocks.air)
											&& Block.isEqualTo(par1World.getBlock(i1 + 1, j1,k1 - 1),Blocks.air)
											&& Block.isEqualTo(par1World.getBlock(i1 + 1, j1,k1 + 1),Blocks.air)
											&& Block.isEqualTo(par1World.getBlock(i1 - 1, j1,k1 + 1),Blocks.air)
										) {
										TileEntityOrb t1 = (TileEntityOrb) par1World
												.getTileEntity(i1 - 2, j1,
														k1 - 2);
										TileEntityOrb t2 = (TileEntityOrb) par1World
												.getTileEntity(i1 + 2, j1,
														k1 - 2);
										TileEntityOrb t3 = (TileEntityOrb) par1World
												.getTileEntity(i1 + 2, j1,
														k1 + 2);
										TileEntityOrb t4 = (TileEntityOrb) par1World
												.getTileEntity(i1 - 2, j1,
														k1 + 2);
										if ((t1.getBlockMetadata() > 1)
												&& (t2.getBlockMetadata() > 1)
												&& (t3.getBlockMetadata() > 1)
												&& (t4.getBlockMetadata() > 1)) {
											if ((t1.getBlockMetadata() != t2
													.getBlockMetadata())
													&& (t1.getBlockMetadata() != t3
															.getBlockMetadata())
													&& (t1.getBlockMetadata() != t4
															.getBlockMetadata())
													&& (t2.getBlockMetadata() != t3
															.getBlockMetadata())
													&& (t2.getBlockMetadata() != t4
															.getBlockMetadata())
													&& (t3.getBlockMetadata() != t4
															.getBlockMetadata())) {

												PacketSpawnLighting.spawnlight(
														i1, j1, k1, 0);

												EntityLightningOrb lightning = new EntityLightningOrb(
														par1World, i1 + 0.5F,
														j1 + 1.5F, k1 + 0.5F, 0);

												par1World
														.spawnEntityInWorld(lightning);
												PacketOrbChange.orbChange(
														i1 - 2, j1, k1 - 2, 1);
												PacketOrbChange.orbChange(
														i1 + 2, j1, k1 - 2, 1);
												PacketOrbChange.orbChange(
														i1 + 2, j1, k1 + 2, 1);
												PacketOrbChange.orbChange(
														i1 - 2, j1, k1 + 2, 1);
												par1World
														.setBlockMetadataWithNotify(
																i1 - 2, j1,
																k1 - 2, 1, 2);
												par1World
														.setBlockMetadataWithNotify(
																i1 + 2, j1,
																k1 - 2, 1, 2);
												par1World
														.setBlockMetadataWithNotify(
																i1 + 2, j1,
																k1 + 2, 1, 2);
												par1World
														.setBlockMetadataWithNotify(
																i1 - 2, j1,
																k1 + 2, 1, 2);
											}

										}
									}
								}
								if (flag == 2) {
									if (
											Block.isEqualTo(par1World.getBlock(i1 - 2, j1, k1 - 2),InitBlock.blockOrb)
											&& Block.isEqualTo(par1World.getBlock(i1 + 2, j1,k1 - 2),InitBlock.blockOrb)
											&& Block.isEqualTo(par1World.getBlock(i1 + 2, j1,k1 + 2),InitBlock.blockOrb)
											&& Block.isEqualTo(par1World.getBlock(i1 - 2, j1,k1 + 2),InitBlock.blockOrb)
											&&Block.isEqualTo(par1World.getBlock(i1 - 2, j1,k1 - 1),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1 - 2, j1,k1),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1 - 2, j1,k1 + 1),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1 - 1, j1,k1),Blocks.redstone_wire)
											&&Block.isEqualTo(par1World.getBlock(i1, j1, k1 - 1),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1, j1,k1 - 2), Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1 - 1, j1,k1 - 2) , Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1 + 1, j1,k1 - 2) , Blocks.redstone_wire)
											&&Block.isEqualTo(par1World.getBlock(i1 + 1, j1, k1),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1 + 2, j1,k1 + 0),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1 + 2, j1,k1 - 1),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1 + 2, j1,k1 + 1),Blocks.redstone_wire)
											&&Block.isEqualTo(par1World.getBlock(i1 + 1, j1,k1 + 2),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1 - 1, j1,k1 + 2),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1, j1,k1 + 1),Blocks.redstone_wire)
											&& Block.isEqualTo(par1World.getBlock(i1, j1,k1 + 2),Blocks.redstone_wire)
											&&Block.isEqualTo(par1World.getBlock(i1 - 1, j1,k1 - 1),Blocks.air)
											&& Block.isEqualTo(par1World.getBlock(i1 + 1, j1,k1 - 1),Blocks.air)
											&& Block.isEqualTo(par1World.getBlock(i1 + 1, j1,k1 + 1),Blocks.air)
											&& Block.isEqualTo(par1World.getBlock(i1 - 1, j1,k1 + 1),Blocks.air)
											) {
										TileEntityOrb t1 = (TileEntityOrb) par1World
												.getTileEntity(i1 - 2, j1,
														k1 - 2);
										TileEntityOrb t2 = (TileEntityOrb) par1World
												.getTileEntity(i1 + 2, j1,
														k1 - 2);
										TileEntityOrb t3 = (TileEntityOrb) par1World
												.getTileEntity(i1 + 2, j1,
														k1 + 2);
										TileEntityOrb t4 = (TileEntityOrb) par1World
												.getTileEntity(i1 - 2, j1,
														k1 + 2);
										if ((t1.getBlockMetadata() > 0)
												&& (t2.getBlockMetadata() > 0)
												&& (t3.getBlockMetadata() > 0)
												&& (t4.getBlockMetadata() > 0)) {
											if ((t1.getBlockMetadata() == t2
													.getBlockMetadata())
													&& (t3.getBlockMetadata() == t4
															.getBlockMetadata())
													&& (t1.getBlockMetadata() == t3
															.getBlockMetadata())
													&& (t2.getBlockMetadata() == t4
															.getBlockMetadata())
													&& (t1.getBlockMetadata() == t4
															.getBlockMetadata())
													&& (t3.getBlockMetadata() == t2
															.getBlockMetadata())) {
												PacketSpawnLighting.spawnlight(
														i1, j1, k1,
														t1.getBlockMetadata());

												EntityLightningOrb lightning = new EntityLightningOrb(
														par1World,
														i1 + 0.5F,
														j1 + 1.5F,
														k1 + 0.5F,
														t1.getBlockMetadata() - 1);

												par1World
														.spawnEntityInWorld(lightning);

												PacketOrbChange.orbChange(
														i1 - 2, j1, k1 - 2, 1);
												PacketOrbChange.orbChange(
														i1 + 2, j1, k1 - 2, 1);
												PacketOrbChange.orbChange(
														i1 + 2, j1, k1 + 2, 1);
												PacketOrbChange.orbChange(
														i1 - 2, j1, k1 + 2, 1);
												par1World
														.setBlockMetadataWithNotify(
																i1 - 2, j1,
																k1 - 2, 1, 2);
												par1World
														.setBlockMetadataWithNotify(
																i1 + 2, j1,
																k1 - 2, 1, 2);
												par1World
														.setBlockMetadataWithNotify(
																i1 + 2, j1,
																k1 + 2, 1, 2);
												par1World
														.setBlockMetadataWithNotify(
																i1 - 2, j1,
																k1 + 2, 1, 2);
											}
										}

									}
								}
								if (flag == 3) {

								}
							}

						}
				}
			}

		}

	}

	@Override
	public TileEntity createNewTileEntity(World world, int par2) {
		return new TileEntityOrb();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("minecharacter:"
				+ this.getUnlocalizedName());
	}

}
