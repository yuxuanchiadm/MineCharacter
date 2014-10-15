package minecharacter.block;

import java.util.List;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minecharacter.MineCharacter;
import minecharacter.block.tileentity.TileEntityOrb;
import minecharacter.entity.EntityLightningOrb;
import minecharacter.misc.InitBlock;
import minecharacter.misc.InitItem;
import minecharacter.network.PacketOrbChange;
import minecharacter.network.PacketSpawnItem;
import minecharacter.network.PacketSpawnLighting;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockOrb extends BlockContainer {
	public BlockOrb(int par1) {
		super(par1,Material.rock);
		this.setCreativeTab(MineCharacter.tabMineCharacter);
		this.setLightValue(0.72F);
		this.setLightOpacity(1);
	}
	@Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
	@Override
    public boolean isOpaqueCube()
    {
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
//		System.out.println(FMLCommonHandler.instance().getEffectiveSide().name());
		TileEntity tile=par1World.getBlockTileEntity(par2, par3, par4);
		if(tile instanceof TileEntityOrb){
			TileEntityOrb tileorb=(TileEntityOrb) tile;
			if(tileorb.getBlockMetadata()==0){
				if(par5EntityPlayer.inventory.getCurrentItem()!=null){
					ItemStack stack=par5EntityPlayer.inventory.getCurrentItem();
					if(stack.itemID==InitItem.orb.itemID||
					   stack.itemID==InitItem.fireOrb.itemID||
					   stack.itemID==InitItem.iceOrb.itemID||
					   stack.itemID==InitItem.lifeOrb.itemID||
					   stack.itemID==InitItem.deathOrb.itemID){
							if(stack.itemID==InitItem.orb.itemID){

								par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
								}
							if(stack.itemID==InitItem.fireOrb.itemID){

								par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);	
							}
							if(stack.itemID==InitItem.iceOrb.itemID){
								par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
								}
							if(stack.itemID==InitItem.lifeOrb.itemID){
								par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
							}
							if(stack.itemID==InitItem.deathOrb.itemID){
								par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
							}
							par5EntityPlayer.inventory.consumeInventoryItem(stack.itemID);
							return true;
						}
						
					}
					
				}
				else {
					if(tileorb.getBlockMetadata()==1){
						if(FMLCommonHandler.instance().getEffectiveSide()==Side.CLIENT)
							PacketSpawnItem.spawnItem(InitItem.orb.itemID,0,1,par2,par3,par4);

						par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
						}
					if(tileorb.getBlockMetadata()==2){
						if(FMLCommonHandler.instance().getEffectiveSide()==Side.CLIENT)
							PacketSpawnItem.spawnItem(InitItem.fireOrb.itemID,0,1,par2,par3,par4);

						par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
						}
					else if(tileorb.getBlockMetadata()==3){
						if(FMLCommonHandler.instance().getEffectiveSide()==Side.CLIENT)
							PacketSpawnItem.spawnItem(InitItem.iceOrb.itemID,0,1,par2,par3,par4);

						par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
						}
					else if(tileorb.getBlockMetadata()==4){
						if(FMLCommonHandler.instance().getEffectiveSide()==Side.CLIENT)
							PacketSpawnItem.spawnItem(InitItem.lifeOrb.itemID,0,1,par2,par3,par4);
						par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
						}
					else if(tileorb.getBlockMetadata()==5){
						if(FMLCommonHandler.instance().getEffectiveSide()==Side.CLIENT)
							PacketSpawnItem.spawnItem(InitItem.deathOrb.itemID,0,1,par2,par3,par4);
						par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
						}
					return true;
					}
			
				
		}
		
		return true;
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3,
			int par4, int par5) {
	if(!par1World.isAirBlock(par2, par3, par4)){
		TileEntity tile=par1World.getBlockTileEntity(par2, par3, par4);
		if(tile!=null&&tile instanceof TileEntityOrb){
			TileEntityOrb orb=(TileEntityOrb) tile;
			if(orb.getBlockMetadata()>1){
				for(int i=-2;i<3;i++) 
					for(int j=-2;j<3;j++){
						
						if(par1World.getBlockId(par2 + i, par3, par4 + j) == Block.redstoneWire.blockID||(par1World.getBlockId(par2 + i, par3, par4 + j) == Block.redstoneLampActive.blockID&& 
								par1World.getBlockId(par2 + i, par3 + 1, par4 + j) == Block.pressurePlatePlanks.blockID)){
							
			                  int i1 = par2 + i;
			                  int j1 = par3;
			                  int k1 = par4 + j;
			                  int flag = 0;
 			                  @SuppressWarnings("rawtypes")
							List items = par1World.getEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getBoundingBox(i1, j1 + 1, k1, i1 + 1, j1 + 2, k1 + 1));
  			                  if (items.size() < 1)
			                  {
			                    return;
			                  }
			                  
			                  if (((EntityItem)items.get(0)).getEntityItem().itemID == InitItem.magicPowder.itemID||((EntityItem)items.get(0)).getEntityItem().itemID == Item.ingotIron.itemID )
			                  {
			                    flag = 1;
			                  }
			                  else if (((EntityItem)items.get(0)).getEntityItem().itemID  == InitItem.rune.itemID)
			                  {
			                    flag = 2;
			                  }
			                  else
			                  {
			                    flag = 3;
			                  }
			                  if (flag == 1)
			                  {
			                    if ((par1World.getBlockId(i1 - 2, j1, k1 - 2) == InitBlock.blockOrb.blockID) && 
			                    	(par1World.getBlockId(i1 + 2, j1, k1 - 2) == InitBlock.blockOrb.blockID) && 
			                    	(par1World.getBlockId(i1 + 2, j1, k1 + 2) ==InitBlock.blockOrb.blockID) && 
			                    	(par1World.getBlockId(i1 - 2, j1, k1 + 2) == InitBlock.blockOrb.blockID) && 	
			                    	
			                    	(par1World.getBlockId(i1 - 2, j1, k1-1) == Block.redstoneWire.blockID) && 
			                    	(par1World.getBlockId(i1 -2, j1, k1) == Block.redstoneWire.blockID) &&
			                    	(par1World.getBlockId(i1-2, j1, k1 + 1) == Block.redstoneWire.blockID) && 
			                    	(par1World.getBlockId(i1-1, j1, k1) == Block.redstoneWire.blockID) && 
			                    	
			                    	(par1World.getBlockId(i1, j1, k1 -1) == Block.redstoneWire.blockID) && 
			                    	(par1World.getBlockId(i1, j1, k1-2) == Block.redstoneWire.blockID) && 
			                    	(par1World.getBlockId(i1-1, j1, k1 -2) == Block.redstoneWire.blockID) && 	
			                    	(par1World.getBlockId(i1+1, j1, k1 -2) == Block.redstoneWire.blockID) && 
			                    	
			                    	(par1World.getBlockId(i1 + 1, j1, k1 ) == Block.redstoneWire.blockID) && 
		 	                    	(par1World.getBlockId(i1 + 2, j1, k1 + 0) == Block.redstoneWire.blockID) && 
			                    	(par1World.getBlockId(i1 + 2, j1, k1 - 1) == Block.redstoneWire.blockID) && 
			                    	(par1World.getBlockId(i1 + 2, j1, k1 + 1) == Block.redstoneWire.blockID) && 
			                    	
			                    	(par1World.getBlockId(i1+1, j1, k1+2) == Block.redstoneWire.blockID) && 
			                    	(par1World.getBlockId(i1-1, j1, k1+2) == Block.redstoneWire.blockID) && 
			                       	(par1World.getBlockId(i1, j1, k1 + 1) == Block.redstoneWire.blockID) && 
			                    	(par1World.getBlockId(i1, j1, k1 + 2) == Block.redstoneWire.blockID) &&       		                    	
			                    				                    				                    	
			                    	(par1World.getBlockId(i1 - 1, j1, k1 - 1) == 0) && 
			                    	(par1World.getBlockId(i1 + 1, j1, k1 - 1) == 0) && 
			                    	(par1World.getBlockId(i1 + 1, j1, k1 + 1) == 0) && 
			                    	(par1World.getBlockId(i1 - 1, j1, k1 + 1) == 0))
			                    {
			                      TileEntityOrb t1 = (TileEntityOrb)par1World.getBlockTileEntity(i1 - 2, j1, k1 - 2);
			                      TileEntityOrb t2 = (TileEntityOrb)par1World.getBlockTileEntity(i1 + 2, j1, k1 - 2);
			                      TileEntityOrb t3 = (TileEntityOrb)par1World.getBlockTileEntity(i1 + 2, j1, k1 + 2);
			                      TileEntityOrb t4 = (TileEntityOrb)par1World.getBlockTileEntity(i1 - 2, j1, k1 + 2);
			                      if ((t1.getBlockMetadata()>1)
			                    		  && (t2.getBlockMetadata()>1)
			                    		  && (t3.getBlockMetadata()>1) 
			                    		  && (t4.getBlockMetadata()>1))
			                      {
			                          if ((t1.getBlockMetadata() != t2.getBlockMetadata()) && 
			                        	  (t1.getBlockMetadata() != t3.getBlockMetadata()) && 
			                        	  (t1.getBlockMetadata() != t4.getBlockMetadata()) && 
			                        	  (t2.getBlockMetadata() != t3.getBlockMetadata()) && 
			                        	  (t2.getBlockMetadata() != t4.getBlockMetadata()) && 
			                        	  (t3.getBlockMetadata() != t4.getBlockMetadata()))
			                          {
			                            
			                        	  PacketSpawnLighting.spawnlight(i1, j1, k1,0);
		      
			                        	  EntityLightningOrb lightning = new EntityLightningOrb(par1World, i1 + 0.5F, j1 + 1.5F, k1 + 0.5F,0);
			                       
				                          par1World.spawnEntityInWorld(lightning);
			                        	  PacketOrbChange.orbChange(i1 - 2, j1, k1 - 2, 1); 	 
			                        	 PacketOrbChange.orbChange(i1 + 2, j1, k1 - 2, 1);
			                        	 PacketOrbChange.orbChange(i1 + 2, j1, k1 + 2, 1);
			                        	 PacketOrbChange.orbChange(i1 - 2, j1, k1 + 2, 1);
			                        	 par1World.setBlockMetadataWithNotify(i1 - 2, j1, k1 - 2, 1, 2);
			                        	 par1World.setBlockMetadataWithNotify(i1 + 2, j1, k1 - 2, 1, 2);
			                        	 par1World.setBlockMetadataWithNotify(i1 + 2, j1, k1 + 2, 1, 2);
			                        	 par1World.setBlockMetadataWithNotify(i1 - 2, j1, k1 + 2, 1, 2);
			                          }
			                        
			                      }
			                    }
			                  }
			                  if (flag == 2)
			                  {
			                	  if ((par1World.getBlockId(i1 - 2, j1, k1 - 2) == InitBlock.blockOrb.blockID) && 
					                    	(par1World.getBlockId(i1 + 2, j1, k1 - 2) == InitBlock.blockOrb.blockID) && 
					                    	(par1World.getBlockId(i1 + 2, j1, k1 + 2) ==InitBlock.blockOrb.blockID) && 
					                    	(par1World.getBlockId(i1 - 2, j1, k1 + 2) == InitBlock.blockOrb.blockID) && 	
					                    	
					                    	(par1World.getBlockId(i1 - 2, j1, k1-1) == Block.redstoneWire.blockID) && 
					                    	(par1World.getBlockId(i1 -2, j1, k1) == Block.redstoneWire.blockID) &&
					                    	(par1World.getBlockId(i1-2, j1, k1 + 1) == Block.redstoneWire.blockID) && 
					                    	(par1World.getBlockId(i1-1, j1, k1) == Block.redstoneWire.blockID) && 
					                    	
					                    	(par1World.getBlockId(i1, j1, k1 -1) == Block.redstoneWire.blockID) && 
					                    	(par1World.getBlockId(i1, j1, k1-2) == Block.redstoneWire.blockID) && 
					                    	(par1World.getBlockId(i1-1, j1, k1 -2) == Block.redstoneWire.blockID) && 	
					                    	(par1World.getBlockId(i1+1, j1, k1 -2) == Block.redstoneWire.blockID) && 
					                    	
					                    	(par1World.getBlockId(i1 + 1, j1, k1 ) == Block.redstoneWire.blockID) && 
				 	                    	(par1World.getBlockId(i1 + 2, j1, k1 + 0) == Block.redstoneWire.blockID) && 
					                    	(par1World.getBlockId(i1 + 2, j1, k1 - 1) == Block.redstoneWire.blockID) && 
					                    	(par1World.getBlockId(i1 + 2, j1, k1 + 1) == Block.redstoneWire.blockID) && 
					                    	
					                    	(par1World.getBlockId(i1+1, j1, k1+2) == Block.redstoneWire.blockID) && 
					                    	(par1World.getBlockId(i1-1, j1, k1+2) == Block.redstoneWire.blockID) && 
					                       	(par1World.getBlockId(i1, j1, k1 + 1) == Block.redstoneWire.blockID) && 
					                    	(par1World.getBlockId(i1, j1, k1 + 2) == Block.redstoneWire.blockID) &&       		                    	
					                    				                    				                    	
					                    	(par1World.getBlockId(i1 - 1, j1, k1 - 1) == 0) && 
					                    	(par1World.getBlockId(i1 + 1, j1, k1 - 1) == 0) && 
					                    	(par1World.getBlockId(i1 + 1, j1, k1 + 1) == 0) && 
					                    	(par1World.getBlockId(i1 - 1, j1, k1 + 1) == 0))
					                    {
			                      TileEntityOrb t1 = (TileEntityOrb)par1World.getBlockTileEntity(i1 - 2, j1, k1 - 2);
			                      TileEntityOrb t2 = (TileEntityOrb)par1World.getBlockTileEntity(i1 + 2, j1, k1 - 2);
			                      TileEntityOrb t3 = (TileEntityOrb)par1World.getBlockTileEntity(i1 + 2, j1, k1 + 2);
			                      TileEntityOrb t4 = (TileEntityOrb)par1World.getBlockTileEntity(i1 - 2, j1, k1 + 2);
			                        if ((t1.getBlockMetadata() >0) && (t2.getBlockMetadata()>0) && (t3.getBlockMetadata() >0) && (t4.getBlockMetadata() >0))
			                        {
			                          if ((t1.getBlockMetadata() == t2.getBlockMetadata()) && (t3.getBlockMetadata() == t4.getBlockMetadata()) && (t1.getBlockMetadata() == t3.getBlockMetadata()) && (t2.getBlockMetadata() == t4.getBlockMetadata()) && (t1.getBlockMetadata() == t4.getBlockMetadata()) && (t3.getBlockMetadata() == t2.getBlockMetadata()))
			                          {
			                        	  PacketSpawnLighting.spawnlight(i1, j1, k1,t1.getBlockMetadata());
			                		      
			                        	  EntityLightningOrb lightning = new EntityLightningOrb(par1World, i1 + 0.5F, j1 + 1.5F, k1 + 0.5F,t1.getBlockMetadata()-1);
			                       
				                          par1World.spawnEntityInWorld(lightning);
			                        	  
			                            
			                            
			                           PacketOrbChange.orbChange(i1 - 2, j1, k1 - 2, 1); 	 
				                        	 PacketOrbChange.orbChange(i1 + 2, j1, k1 - 2, 1);
				                        	 PacketOrbChange.orbChange(i1 + 2, j1, k1 + 2, 1);
				                        	 PacketOrbChange.orbChange(i1 - 2, j1, k1 + 2, 1);
				                          	 par1World.setBlockMetadataWithNotify(i1 - 2, j1, k1 - 2, 1, 2);
				                        	 par1World.setBlockMetadataWithNotify(i1 + 2, j1, k1 - 2, 1, 2);
				                        	 par1World.setBlockMetadataWithNotify(i1 + 2, j1, k1 + 2, 1, 2);
				                        	 par1World.setBlockMetadataWithNotify(i1 - 2, j1, k1 + 2, 1, 2);
			                          }
			                        }
			                      
			                    }
			                  }
			                  if (flag == 3)
			                  {
			                    
			                  }				
						}

					}
			}
		}
		
	}
		
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityOrb();
	}
	
//	@Override
//	@SideOnly(Side.CLIENT)
//	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
//		return par1==1?this.top:par1==0?this.bottom:this.side;
//	}
//
	@Override
	@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister par1IconRegister) {
   this.blockIcon = par1IconRegister.registerIcon("minecharacter:"+this.getUnlocalizedName());
	}

}
