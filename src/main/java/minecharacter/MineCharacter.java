package minecharacter;


import java.util.Random;

import minecharacter.block.tileentity.TileEntityOrb;
import minecharacter.block.tileentity.TileEntityPan;
import minecharacter.misc.CreativeTabMineCharacter;
import minecharacter.misc.EventHandler;
import minecharacter.misc.InitBlock;
import minecharacter.misc.InitItem;
import minecharacter.misc.Localization;
import minecharacter.misc.ModIdConfig;
import minecharacter.misc.TickHandler;
import minecharacter.network.PacketHandler;
import minecharacter.proxy.CommonProxy;
import minecharacter.world.WorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@NetworkMod(serverSideRequired = false, clientSideRequired = true,packetHandler=PacketHandler.class,channels={"minecharacter"})
@Mod(modid = "MineCharacter", name = "MineCharacter", version = "@VERSION@")
public class MineCharacter implements IFuelHandler {
	
	   //CreativeTabs 
		public static CreativeTabs tabMineCharacter = new CreativeTabMineCharacter(CreativeTabs.getNextID(),"MineCharacter");
		public static Random ran=new Random();
		@Mod.Instance("MineCharacter")
		public static MineCharacter instance;

		@SidedProxy(clientSide = "minecharacter.proxy.ClientProxy", serverSide = "minecharacter.proxy.CommonProxy")
		public static CommonProxy proxy;
		@Mod.EventHandler
	public void preInitMod(FMLPreInitializationEvent event){
		new ModIdConfig(event.getSuggestedConfigurationFile());
		new InitBlock().initBlock();
		new InitItem().initItem();
		  GameRegistry.registerTileEntity(TileEntityOrb.class, "tileentityorb");
		  GameRegistry.registerTileEntity(TileEntityPan.class, "tileentitypan");
			Localization.addLocalization("/assets/minecharacter/lang/", "en_US");
	}
		@Mod.EventHandler
	public void InitMod(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	
	  GameRegistry.registerWorldGenerator(new WorldGenerator());
	  NetworkRegistry.instance().registerGuiHandler(this, proxy);
		MinecraftForge.setToolClass(InitItem.mattock, "pickaxe", 4);
		MinecraftForge.setToolClass(InitItem.tomahawk, "axe", 4);
		MinecraftForge.setToolClass(InitItem.netherAxe, "axe", 4);
		MinecraftForge.setToolClass(InitItem.netherPickaxe, "pickaxe", 4);
		
		TickRegistry.registerTickHandler(new TickHandler(), Side.SERVER);
		TickRegistry.registerTickHandler(new TickHandler(), Side.CLIENT);
		loadRepice();
		loadSmelt();
		GameRegistry.registerFuelHandler(this);	
		proxy.registerRenderInformation();
	
	}
	
	private void loadSmelt() {
		GameRegistry.addSmelting(InitBlock.blockDemonite.blockID, new ItemStack(InitItem.demonite), 0.5F);
	    GameRegistry.addSmelting(InitBlock.blockLuciferite.blockID, new ItemStack(InitItem.luciferite), 0.5F);
	    GameRegistry.addSmelting(Item.egg.itemID, new ItemStack(InitItem.friedEgg), 0.1F);
	    GameRegistry.addSmelting(Block.slowSand.blockID, new ItemStack(InitItem.soul), 0.1F);
	    GameRegistry.addSmelting(InitItem.etherealPowder.itemID, new ItemStack(InitItem.etherealIngot), 0.1F);
		
	}
	private void loadRepice() {
		 GameRegistry.addShapedRecipe(new ItemStack(Block.ice), new Object[] { "XXX", "XXX", "XXX", Character.valueOf('X'), Block.blockSnow });

		    GameRegistry.addShapedRecipe(new ItemStack(InitItem.woodHammer, 1), new Object[] { " XX", "//X", " XX", Character.valueOf('/'),Item.stick, Character.valueOf('X'), Block.planks });

		    GameRegistry.addShapedRecipe(new ItemStack(InitItem.stoneHammer, 1), new Object[] { " XX", "//X", " XX", Character.valueOf('/'), Item.stick, Character.valueOf('X'), Block.cobblestone });

		    GameRegistry.addShapedRecipe(new ItemStack(InitItem.ironHammer, 1), new Object[] { " XX", "//X", " XX", Character.valueOf('/'), Item.stick, Character.valueOf('X'), Item.ingotIron });

		    GameRegistry.addShapedRecipe(new ItemStack(InitItem.diamondHammer, 1), new Object[] { " XX", "//X", " XX", Character.valueOf('/'), Item.stick, Character.valueOf('X'), Item.diamond });

		    GameRegistry.addShapedRecipe(new ItemStack(InitItem.goldHammer, 1), new Object[] { " XX", "//X", " XX", Character.valueOf('/'), Item.stick, Character.valueOf('X'), Item.ingotGold });

		    GameRegistry.addShapedRecipe(new ItemStack(InitItem.fireStaff, 1), new Object[] { " X ", " / ", " / ", Character.valueOf('/'), Item.stick, Character.valueOf('X'), InitItem.fireOrb });

		    GameRegistry.addShapedRecipe(new ItemStack(InitItem.iceStaff, 1), new Object[] { " X ", " / ", " / ", Character.valueOf('/'), Item.stick, Character.valueOf('X'), InitItem.iceOrb });

		    GameRegistry.addShapedRecipe(new ItemStack(InitItem.lifeStaff, 1), new Object[] { " X ", " / ", " / ", Character.valueOf('/'), Item.stick, Character.valueOf('X'), InitItem.lifeOrb });

		    GameRegistry.addShapedRecipe(new ItemStack(InitItem.deathStaff, 1), new Object[] { " X ", " / ", " / ", Character.valueOf('/'), Item.stick, Character.valueOf('X'), InitItem.deathOrb });

		    GameRegistry.addShapedRecipe(new ItemStack(InitItem.orb, 4), new Object[] { " X ", "X X", " X ", Character.valueOf('X'), Block.glass });

		    GameRegistry.addShapedRecipe(new ItemStack(InitItem.bat, 1), new Object[] { "  X", " X ", "/  ", Character.valueOf('/'), Item.stick, Character.valueOf('X'), Block.planks});

		    GameRegistry.addShapedRecipe(new ItemStack(InitBlock.blockAnvil, 1), new Object[] { "XXX", " X ", "XXX", Character.valueOf('X'), Item.ingotIron });

		    GameRegistry.addShapedRecipe(new ItemStack(InitBlock.blockWheat, 1, 0), new Object[] { "XX", "XX", Character.valueOf('X'), Item.wheat });

		    GameRegistry.addShapedRecipe(new ItemStack(InitItem.omelette, 1), new Object[] { "XXX", "XXX", "XXX", Character.valueOf('X'),Item.egg });

		    GameRegistry.addShapedRecipe(new ItemStack(InitBlock.pan, 1), new Object[] { "  /", "XX ", "XX ", Character.valueOf('X'), Item.ingotIron, Character.valueOf('/'), Item.stick });

		    GameRegistry.addShapedRecipe(new ItemStack(InitItem.beer, 1), new Object[] { "X", "V", Character.valueOf('X'), Item.wheat, Character.valueOf('V'), new ItemStack(Item.potion, 1, 0) });

		    GameRegistry.addShapedRecipe(new ItemStack(InitItem.quiver, 1), new Object[] { "//X", "/X ", "X  ", Character.valueOf('X'), Item.arrow, Character.valueOf('/'), Item.silk });

		    GameRegistry.addShapedRecipe(new ItemStack(InitBlock.blockOrb, 1), new Object[] { "X X", "XXX", Character.valueOf('X'),Block.obsidian });

		    GameRegistry.addShapelessRecipe(new ItemStack(InitItem.magicPowder, 1), new Object[] { Item.redstone, Item.glowstone });

		    GameRegistry.addShapelessRecipe(new ItemStack(InitItem.magicString, 1), new Object[] { InitItem.magicPowder, Item.silk });

		    GameRegistry.addShapelessRecipe(new ItemStack(InitItem.iceOrb, 1), new Object[] { InitItem.icePowder, InitItem.orb });

		    GameRegistry.addShapelessRecipe(new ItemStack(InitItem.fireOrb, 1), new Object[] { InitItem.firePowder, InitItem.orb });

		    GameRegistry.addShapelessRecipe(new ItemStack(InitItem.lifeOrb, 1), new Object[] { InitItem.lifePowder, InitItem.orb });

		    GameRegistry.addShapelessRecipe(new ItemStack(InitItem.deathOrb, 1), new Object[] { InitItem.deathPowder, InitItem.orb });

		    GameRegistry.addShapelessRecipe(new ItemStack(InitItem.icePowder, 4), new Object[] { Block.ice, InitItem.magicPowder });

		    GameRegistry.addShapelessRecipe(new ItemStack(InitItem.firePowder, 4), new Object[] { Item.blazePowder, InitItem.magicPowder });

		    GameRegistry.addShapelessRecipe(new ItemStack(InitItem.lifePowder, 4), new Object[] { Item.emerald, InitItem.magicPowder });

		    GameRegistry.addShapelessRecipe(new ItemStack(InitItem.deathPowder, 4), new Object[] { Item.eyeOfEnder, InitItem.magicPowder });

		    GameRegistry.addShapelessRecipe(new ItemStack(InitItem.rune, 1), new Object[] { Block.stone,Block.cobblestone });

		    GameRegistry.addShapelessRecipe(new ItemStack(Item.wheat, 2), new Object[] { InitBlock.blockWheat });
		
	}
	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.itemID == InitItem.nethercoal.itemID)
			return 1000;
		return 0;
	}

}
