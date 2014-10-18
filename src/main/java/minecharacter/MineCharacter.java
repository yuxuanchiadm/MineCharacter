package minecharacter;

import java.util.EnumMap;
import java.util.Random;

import minecharacter.block.tileentity.TileEntityOrb;
import minecharacter.block.tileentity.TileEntityPan;
import minecharacter.entity.EntityShuriken;
import minecharacter.entity.EntityTomahawk;
import minecharacter.item.crafting.SpongeRecipe;
import minecharacter.misc.CreativeTabMineCharacter;
import minecharacter.misc.EventHandler;
import minecharacter.misc.InitBlock;
import minecharacter.misc.InitItem;
import minecharacter.misc.Localization;
import minecharacter.network.PacketHandler;
import minecharacter.proxy.CommonProxy;
import minecharacter.world.WorldGenerator;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = "MineCharacter", name = "MineCharacter", version = "@VERSION@")
public class MineCharacter implements IFuelHandler {

	// CreativeTabs
	public static CreativeTabs tabMineCharacter = new CreativeTabMineCharacter(
			CreativeTabs.getNextID(), "MineCharacter");
	public static Random ran = new Random();
	@Mod.Instance("MineCharacter")
	public static MineCharacter instance;

	@SidedProxy(clientSide = "minecharacter.proxy.ClientProxy", serverSide = "minecharacter.proxy.CommonProxy")
	public static CommonProxy proxy;

	public EnumMap<Side, FMLEmbeddedChannel> channels;

	@Mod.EventHandler
	public void preInitMod(FMLPreInitializationEvent event) {
		new InitBlock().initBlock();
		new InitItem().initItem();
		GameRegistry.registerTileEntity(TileEntityOrb.class, "tileentityorb");
		GameRegistry.registerTileEntity(TileEntityPan.class, "tileentitypan");
		Localization.addLocalization("/assets/minecharacter/lang/", "en_US");
	}

	@Mod.EventHandler
	public void InitMod(FMLInitializationEvent event) {
		channels = NetworkRegistry.INSTANCE.newChannel("minecharacter",
				new PacketHandler());

		MinecraftForge.EVENT_BUS.register(new EventHandler());

		GameRegistry.registerWorldGenerator(new WorldGenerator(), 0);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);

		loadRepice();
		loadSmelt();
		GameRegistry.registerFuelHandler(this);
		proxy.registerRenderInformation();

		EntityRegistry.registerModEntity(EntityTomahawk.class, "Tomahawk", 590,
				this, 64, 20, false);
		EntityRegistry.registerModEntity(EntityShuriken.class, "Shuriken", 591,
				this, 64, 10, true);
	}

	private void loadSmelt() {
		GameRegistry.addSmelting(InitBlock.blockDemonite, new ItemStack(
				InitItem.demonite), 0.5F);
		GameRegistry.addSmelting(InitBlock.blockLuciferite, new ItemStack(
				InitItem.luciferite), 0.5F);
		GameRegistry.addSmelting(Items.egg, new ItemStack(InitItem.friedEgg),
				0.1F);
		GameRegistry.addSmelting(Blocks.soul_sand,
				new ItemStack(InitItem.soul), 0.1F);
		GameRegistry.addSmelting(InitItem.etherealPowder, new ItemStack(
				InitItem.etherealIngot), 0.1F);

	}

	private void loadRepice() {
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.ice), new Object[] {
				"XXX", "XXX", "XXX", Character.valueOf('X'), Blocks.snow });

		GameRegistry.addShapedRecipe(new ItemStack(InitItem.woodHammer, 1),
				new Object[] { " XX", "//X", " XX", Character.valueOf('/'),
						Items.stick, Character.valueOf('X'), Blocks.planks });

		GameRegistry
				.addShapedRecipe(
						new ItemStack(InitItem.stoneHammer, 1),
						new Object[] { " XX", "//X", " XX",
								Character.valueOf('/'), Items.stick,
								Character.valueOf('X'), Blocks.cobblestone });

		GameRegistry
				.addShapedRecipe(
						new ItemStack(InitItem.ironHammer, 1),
						new Object[] { " XX", "//X", " XX",
								Character.valueOf('/'), Items.stick,
								Character.valueOf('X'), Items.iron_ingot });

		GameRegistry.addShapedRecipe(new ItemStack(InitItem.diamondHammer, 1),
				new Object[] { " XX", "//X", " XX", Character.valueOf('/'),
						Items.stick, Character.valueOf('X'), Items.diamond });

		GameRegistry
				.addShapedRecipe(
						new ItemStack(InitItem.goldHammer, 1),
						new Object[] { " XX", "//X", " XX",
								Character.valueOf('/'), Items.stick,
								Character.valueOf('X'), Items.gold_ingot });

		GameRegistry
				.addShapedRecipe(
						new ItemStack(InitItem.fireStaff, 1),
						new Object[] { " X ", " / ", " / ",
								Character.valueOf('/'), Items.stick,
								Character.valueOf('X'), InitItem.fireOrb });

		GameRegistry.addShapedRecipe(new ItemStack(InitItem.iceStaff, 1),
				new Object[] { " X ", " / ", " / ", Character.valueOf('/'),
						Items.stick, Character.valueOf('X'), InitItem.iceOrb });

		GameRegistry
				.addShapedRecipe(
						new ItemStack(InitItem.lifeStaff, 1),
						new Object[] { " X ", " / ", " / ",
								Character.valueOf('/'), Items.stick,
								Character.valueOf('X'), InitItem.lifeOrb });

		GameRegistry
				.addShapedRecipe(
						new ItemStack(InitItem.deathStaff, 1),
						new Object[] { " X ", " / ", " / ",
								Character.valueOf('/'), Items.stick,
								Character.valueOf('X'), InitItem.deathOrb });

		GameRegistry.addShapedRecipe(new ItemStack(InitItem.orb, 4),
				new Object[] { " X ", "X X", " X ", Character.valueOf('X'),
						Blocks.glass });

		GameRegistry.addShapedRecipe(new ItemStack(InitItem.bat, 1),
				new Object[] { "  X", " X ", "/  ", Character.valueOf('/'),
						Items.stick, Character.valueOf('X'), Blocks.planks });

		GameRegistry.addShapedRecipe(new ItemStack(InitBlock.blockAnvil, 1),
				new Object[] { "XXX", " X ", "XXX", Character.valueOf('X'),
						Items.iron_ingot });

		GameRegistry
				.addShapedRecipe(new ItemStack(InitBlock.blockWheat, 1, 0),
						new Object[] { "XX", "XX", Character.valueOf('X'),
								Items.wheat });

		GameRegistry.addShapedRecipe(new ItemStack(InitItem.omelette, 1),
				new Object[] { "XXX", "XXX", "XXX", Character.valueOf('X'),
						Items.egg });

		GameRegistry
				.addShapedRecipe(new ItemStack(InitBlock.pan, 1), new Object[] {
						"  /", "XX ", "XX ", Character.valueOf('X'),
						Items.iron_ingot, Character.valueOf('/'), Items.stick });

		GameRegistry.addShapedRecipe(new ItemStack(InitItem.beer, 1),
				new Object[] { "X", "V", Character.valueOf('X'), Items.wheat,
						Character.valueOf('V'),
						new ItemStack(Items.potionitem, 1, 0) });

		GameRegistry.addShapedRecipe(new ItemStack(InitItem.quiver, 1),
				new Object[] { "//X", "/X ", "X  ", Character.valueOf('X'),
						Items.arrow, Character.valueOf('/'), Items.string });

		GameRegistry.addShapedRecipe(new ItemStack(InitBlock.blockOrb, 1),
				new Object[] { "X X", "XXX", Character.valueOf('X'),
						Blocks.obsidian });

		GameRegistry.addRecipe(new SpongeRecipe());

		GameRegistry.addShapelessRecipe(new ItemStack(InitItem.magicPowder, 1),
				new Object[] { Items.redstone, Items.glowstone_dust });

		GameRegistry.addShapelessRecipe(new ItemStack(InitItem.magicString, 1),
				new Object[] { InitItem.magicPowder, Items.string });

		GameRegistry.addShapelessRecipe(new ItemStack(InitItem.iceOrb, 1),
				new Object[] { InitItem.icePowder, InitItem.orb });

		GameRegistry.addShapelessRecipe(new ItemStack(InitItem.fireOrb, 1),
				new Object[] { InitItem.firePowder, InitItem.orb });

		GameRegistry.addShapelessRecipe(new ItemStack(InitItem.lifeOrb, 1),
				new Object[] { InitItem.lifePowder, InitItem.orb });

		GameRegistry.addShapelessRecipe(new ItemStack(InitItem.deathOrb, 1),
				new Object[] { InitItem.deathPowder, InitItem.orb });

		GameRegistry.addShapelessRecipe(new ItemStack(InitItem.icePowder, 4),
				new Object[] { Blocks.ice, InitItem.magicPowder });

		GameRegistry.addShapelessRecipe(new ItemStack(InitItem.firePowder, 4),
				new Object[] { Items.blaze_powder, InitItem.magicPowder });

		GameRegistry.addShapelessRecipe(new ItemStack(InitItem.lifePowder, 4),
				new Object[] { Items.emerald, InitItem.magicPowder });

		GameRegistry.addShapelessRecipe(new ItemStack(InitItem.deathPowder, 4),
				new Object[] { Items.ender_eye, InitItem.magicPowder });

		GameRegistry.addShapelessRecipe(new ItemStack(InitItem.rune, 1),
				new Object[] { Blocks.stone, Blocks.cobblestone });

		GameRegistry.addShapelessRecipe(new ItemStack(Items.wheat, 2),
				new Object[] { InitBlock.blockWheat });

	}

	@Override
	public int getBurnTime(ItemStack fuel) {
		if (fuel.getItem().equals(InitItem.nethercoal))
			return 1000;
		return 0;
	}

}
