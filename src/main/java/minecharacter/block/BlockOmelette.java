package minecharacter.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minecharacter.misc.InitItem;
import net.minecraft.block.BlockCake;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockOmelette extends BlockCake {
	
	private Icon side1;
	private Icon side2;
	private Icon top;
	private Icon bottom;

	public BlockOmelette(int par1) {
		super(par1);
	}

	@Override
	 @SideOnly(Side.CLIENT)
	    public Icon getIcon(int par1, int par2)
	    {
	        return par1 == 1 ? this.top : (par1 == 0 ? this.bottom: (par2 > 0 && par1 == 4 ? this.side2 : this.side1));
	    }
	 
	 @Override
	 @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister par1IconRegister)
	    {
	        this.side1 = par1IconRegister.registerIcon("minecharacter:blockOmelette_1");
	        this.side2 = par1IconRegister.registerIcon("minecharacter:blockOmelette_2");
	        this.top = par1IconRegister.registerIcon("minecharacter:blockOmelette_0");
	        this.bottom = par1IconRegister.registerIcon("minecharacter:blockOmelette_3");
	    }
	 @Override
	 public int idPicked(World par1World, int par2, int par3, int par4)
	    {
	        return InitItem.omelette.itemID;
	    }
}
