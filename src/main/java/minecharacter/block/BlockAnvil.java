package minecharacter.block;

import javax.swing.Icon;

import minecharacter.MineCharacter;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAnvil extends Block {
	IIcon top;
	IIcon bottom;
	IIcon side1;
	IIcon side2;
	IIcon side3;
	IIcon side4;

	public BlockAnvil(Material material) {
		super(material);
		this.setCreativeTab(MineCharacter.tabMineCharacter);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		switch (par1) {
		case 0:
			return bottom;
		case 1:
			return top;
		case 2:
			return side1;
		case 3:
			return side2;
		case 4:
			return side3;
		case 5:
			return side4;

		default:
			break;
		}
		return top;
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9) {
		if (par1World.isRemote) {
			return true;
		}
		par5EntityPlayer.openGui(MineCharacter.instance, 0, par1World, par2,
				par3, par4);
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iIconRegister) {
		this.top = iIconRegister.registerIcon("minecharacter:anvil_0");
		this.side1 = iIconRegister.registerIcon("minecharacter:anvil_1");
		this.side2 = iIconRegister.registerIcon("minecharacter:anvil_1");
		this.side3 = iIconRegister.registerIcon("minecharacter:anvil_2");
		this.side4 = iIconRegister.registerIcon("minecharacter:anvil_2");
		this.bottom = iIconRegister.registerIcon("minecharacter:anvil_3");
	}

}
