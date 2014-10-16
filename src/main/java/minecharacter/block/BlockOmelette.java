package minecharacter.block;

import minecharacter.misc.InitItem;
import net.minecraft.block.BlockCake;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOmelette extends BlockCake {

	private IIcon side1;
	private IIcon side2;
	private IIcon top;
	private IIcon bottom;

	public BlockOmelette() {
		super();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		return par1 == 1 ? this.top : (par1 == 0 ? this.bottom : (par2 > 0
				&& par1 == 4 ? this.side2 : this.side1));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.side1 = par1IconRegister
				.registerIcon("minecharacter:blockOmelette_1");
		this.side2 = par1IconRegister
				.registerIcon("minecharacter:blockOmelette_2");
		this.top = par1IconRegister
				.registerIcon("minecharacter:blockOmelette_0");
		this.bottom = par1IconRegister
				.registerIcon("minecharacter:blockOmelette_3");
	}

	@Override
	public int idPicked(World par1World, int par2, int par3, int par4) {
		return InitItem.omelette.itemID;
	}
}
