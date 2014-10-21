package minecharacter.misc;

import minecharacter.MineCharacter;
import minecharacter.item.CharItemArmor;
import minecharacter.item.ItemHammer;
import minecharacter.item.ItemMineCharacter;
import minecharacter.item.ItemNetherAxe;
import minecharacter.item.ItemNetherPickaxe;
import minecharacter.item.archer.ItemEtherBow;
import minecharacter.item.archer.ItemMechanicBow;
import minecharacter.item.archer.ItemNetherBow;
import minecharacter.item.assassin.ItemDragger;
import minecharacter.item.assassin.ItemShuriken;
import minecharacter.item.assassin.ItemSmokeGrenade;
import minecharacter.item.food.CharItemFood;
import minecharacter.item.food.ItemBeer;
import minecharacter.item.food.ItemOmelette;
import minecharacter.item.grim.ItemLucifer;
import minecharacter.item.grim.ItemReaper;
import minecharacter.item.knight.ItemExcalibur;
import minecharacter.item.knight.ItemLance;
import minecharacter.item.knight.ItemMattock;
import minecharacter.item.knight.ItemMjolnir;
import minecharacter.item.knight.ItemTomahawk;
import minecharacter.item.mage.ItemStaff;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class InitItem {

	// item
	public static Item woodHammer;
	public static Item stoneHammer;
	public static Item ironHammer;
	public static Item goldHammer;
	public static Item diamondHammer;
	public static Item fireStaff;
	public static Item iceStaff;
	public static Item lifeStaff;
	public static Item deathStaff;
	public static Item orb;
	public static Item fireOrb;
	public static Item iceOrb;
	public static Item lifeOrb;
	public static Item deathOrb;
	public static ItemArmor knightHelmet;
	public static ItemArmor knightChest;
	public static ItemArmor knightLegs;
	public static ItemArmor knightBoots;
	public static ItemArmor grimHelmet;
	public static ItemArmor grimChest;
	public static ItemArmor grimLegs;
	public static ItemArmor grimBoots;
	public static ItemArmor mageHelmet;
	public static ItemArmor mageChest;
	public static ItemArmor mageLegs;
	public static ItemArmor mageBoots;
	public static ItemArmor archerHelmet;
	public static ItemArmor archerChest;
	public static ItemArmor archerLegs;
	public static ItemArmor archerBoots;
	public static ItemArmor assassinHelmet;
	public static ItemArmor assassinChest;
	public static ItemArmor assassinLegs;
	public static ItemArmor assassinBoots;
	public static Item rune;
	public static Item fireRune;
	public static Item iceRune;
	public static Item lifeRune;
	public static Item deathRune;
	public static Item soul;
	public static Item lucifer;
	public static Item reaper;
	public static Item mechanicBow;
	public static Item etherBow;
	public static Item netherBow;
	public static Item excalibur;
	public static Item lance;
	public static Item mjolnir;
	public static Item mattock;
	public static Item tomahawk;
	public static ItemFood beer;
	public static Item excaliburHandle;
	public static Item excaliburBlade;
	public static Item luciferHandle;
	public static Item luciferBlade;
	public static Item netherHandle;
	public static Item reaperBlade;
	public static Item mattockBlade;
	public static Item mjolnirHandle;
	public static Item mjolnirBlade;
	public static Item netherAxeBlade;
	public static Item netherPickaxeBlade;
	public static Item lanceHandle;
	public static Item lanceBlade;
	public static Item tomahawkBlade;
	public static Item magicPowder;
	public static ItemFood friedEgg;
	public static Item omelette;
	public static Item magicString;
	public static Item nethercoal;
	public static Item demonite;
	public static Item luciferite;
	public static Item etherealIngot;
	public static Item firePowder;
	public static Item icePowder;
	public static Item lifePowder;
	public static Item deathPowder;
	public static Item etherealPowder;
	public static Item smokeGrenade;
	public static Item shuriken;
	public static Item assassinSteel;
	public static Item dragger;
	public static Item draggerHandle;
	public static Item draggerBlade;
	public static Item quiver;
	public static Item netherAxe;
	public static Item netherPickaxe;
	public static final ArmorMaterial KNIGHT = EnumHelper.addArmorMaterial(
			"KNIGHT", 33, new int[] { 5, 15, 10, 5 }, 30);
	public static final ArmorMaterial GRIM = EnumHelper.addArmorMaterial(
			"GRIM", -1, new int[] { 0, 0, 0, 0 }, 30);
	public static final ToolMaterial ETHER = EnumHelper.addToolMaterial(
			"ETHER", 3, 3122, 15.0F, 6, 30);
	public static final ToolMaterial NETHER = EnumHelper.addToolMaterial(
			"NETHER", 3, 2341, 15.0F, 10, 5);
	public static final ToolMaterial ASSASSIN = EnumHelper.addToolMaterial(
			"ASSASSIN", 3, 635, 15.0F, 5, 15);
	public static final ToolMaterial NORTH = EnumHelper.addToolMaterial(
			"NORTH", 3, 635, 15.0F, 5, 15);

	public void initItem() {
		omelette = new ItemOmelette(InitBlock.blockOmelette)
				.setUnlocalizedName("omelette");
		woodHammer = new ItemHammer(ToolMaterial.WOOD)
				.setUnlocalizedName("woodhammer");
		stoneHammer = new ItemHammer(ToolMaterial.STONE)
				.setUnlocalizedName("stonehammer");
		ironHammer = new ItemHammer(ToolMaterial.IRON)
				.setUnlocalizedName("ironhammer");
		goldHammer = new ItemHammer(ToolMaterial.GOLD)
				.setUnlocalizedName("goldhammer");
		diamondHammer = new ItemHammer(ToolMaterial.EMERALD)
				.setUnlocalizedName("diamondhammer");

		orb = new ItemMineCharacter().setUnlocalizedName("orb");
		fireOrb = new ItemMineCharacter().setUnlocalizedName("fireOrb")
				.setContainerItem(orb);
		iceOrb = new ItemMineCharacter().setUnlocalizedName("iceOrb")
				.setContainerItem(orb);
		lifeOrb = new ItemMineCharacter().setUnlocalizedName("lifeOrb")
				.setContainerItem(orb);
		deathOrb = new ItemMineCharacter().setUnlocalizedName("deathOrb")
				.setContainerItem(orb);

		fireStaff = new ItemStaff(1).setUnlocalizedName("fireStaff");
		iceStaff = new ItemStaff(2).setUnlocalizedName("iceStaff");
		lifeStaff = new ItemStaff(3).setUnlocalizedName("lifeStaff");
		deathStaff = new ItemStaff(4).setUnlocalizedName("deathStaff");

		knightHelmet = (ItemArmor) new CharItemArmor(KNIGHT,
				MineCharacter.proxy.addArmor("knight"), 0)
				.setUnlocalizedName("knightHelmet");
		knightChest = (ItemArmor) new CharItemArmor(KNIGHT,
				MineCharacter.proxy.addArmor("knight"), 1)
				.setUnlocalizedName("knightChest");
		knightLegs = (ItemArmor) new CharItemArmor(KNIGHT,
				MineCharacter.proxy.addArmor("knight"), 2)
				.setUnlocalizedName("knightLegs");
		knightBoots = (ItemArmor) new CharItemArmor(KNIGHT,
				MineCharacter.proxy.addArmor("knight"), 3)
				.setUnlocalizedName("knightBoots");

		grimHelmet = (ItemArmor) new CharItemArmor(GRIM,
				MineCharacter.proxy.addArmor("grim"), 0)
				.setUnlocalizedName("grimHelmet");
		grimChest = (ItemArmor) new CharItemArmor(GRIM,
				MineCharacter.proxy.addArmor("grim"), 1)
				.setUnlocalizedName("grimChest");
		grimLegs = (ItemArmor) new CharItemArmor(GRIM,
				MineCharacter.proxy.addArmor("grim"), 2)
				.setUnlocalizedName("grimLegs");
		grimBoots = (ItemArmor) new CharItemArmor(GRIM,
				MineCharacter.proxy.addArmor("grim"), 3)
				.setUnlocalizedName("grimBoots");

		mageHelmet = (ItemArmor) new CharItemArmor(GRIM,
				MineCharacter.proxy.addArmor("mage"), 0)
				.setUnlocalizedName("mageHelmet");
		mageChest = (ItemArmor) new CharItemArmor(GRIM,
				MineCharacter.proxy.addArmor("mage"), 1)
				.setUnlocalizedName("mageChest");
		mageLegs = (ItemArmor) new CharItemArmor(GRIM,
				MineCharacter.proxy.addArmor("mage"), 2)
				.setUnlocalizedName("mageLegs");
		mageBoots = (ItemArmor) new CharItemArmor(GRIM,
				MineCharacter.proxy.addArmor("mage"), 3)
				.setUnlocalizedName("mageBoots");

		archerHelmet = (ItemArmor) new CharItemArmor(GRIM,
				MineCharacter.proxy.addArmor("archer"), 0)
				.setUnlocalizedName("archerHelmet");
		archerChest = (ItemArmor) new CharItemArmor(GRIM,
				MineCharacter.proxy.addArmor("archer"), 1)
				.setUnlocalizedName("archerChest");
		archerLegs = (ItemArmor) new CharItemArmor(GRIM,
				MineCharacter.proxy.addArmor("archer"), 2)
				.setUnlocalizedName("archerLegs");
		archerBoots = (ItemArmor) new CharItemArmor(GRIM,
				MineCharacter.proxy.addArmor("archer"), 3)
				.setUnlocalizedName("archerBoots");

		assassinHelmet = (ItemArmor) new CharItemArmor(GRIM,
				MineCharacter.proxy.addArmor("assassin"), 0)
				.setUnlocalizedName("assassinHelmet");
		assassinChest = (ItemArmor) new CharItemArmor(GRIM,
				MineCharacter.proxy.addArmor("assassin"), 1)
				.setUnlocalizedName("assassinChest");
		assassinLegs = (ItemArmor) new CharItemArmor(GRIM,
				MineCharacter.proxy.addArmor("assassin"), 2)
				.setUnlocalizedName("assassinLegs");
		assassinBoots = (ItemArmor) new CharItemArmor(GRIM,
				MineCharacter.proxy.addArmor("assassin"), 3)
				.setUnlocalizedName("assassinBoots");

		rune = new ItemMineCharacter().setUnlocalizedName("rune");
		fireRune = new ItemMineCharacter().setUnlocalizedName("fireRune");
		iceRune = new ItemMineCharacter().setUnlocalizedName("iceRune");
		lifeRune = new ItemMineCharacter().setUnlocalizedName("lifeRune");
		deathRune = new ItemMineCharacter().setUnlocalizedName("deathRune");

		soul = new ItemMineCharacter().setUnlocalizedName("soul");
		lucifer = new ItemLucifer(NETHER).setUnlocalizedName("lucifer");
		reaper = new ItemReaper(NETHER).setUnlocalizedName("reaper");
		mechanicBow = new ItemMechanicBow().setUnlocalizedName("mechanicBow");
		etherBow = new ItemEtherBow().setUnlocalizedName("etherBow");
		netherBow = new ItemNetherBow().setUnlocalizedName("netherBow");

		excalibur = new ItemExcalibur(ETHER).setUnlocalizedName("excalibur");
		lance = new ItemLance(ETHER).setUnlocalizedName("lance");
		mjolnir = new ItemMjolnir(ETHER).setUnlocalizedName("mjolnir");
		mattock = new ItemMattock(ETHER).setUnlocalizedName("mattock");
		tomahawk = new ItemTomahawk(ETHER).setUnlocalizedName("tomahawk");

		beer = (ItemFood) new ItemBeer(4, 1.0F, false).setAlwaysEdible()
				.setPotionEffect(9, 20 * 10, 0, 0.33F)
				.setUnlocalizedName("beer");

		excaliburHandle = new ItemMineCharacter()
				.setUnlocalizedName("excaliburHandle");
		excaliburBlade = new ItemMineCharacter()
				.setUnlocalizedName("excaliburBlade");
		luciferHandle = new ItemMineCharacter()
				.setUnlocalizedName("luciferHandle");
		luciferBlade = new ItemMineCharacter()
				.setUnlocalizedName("luciferBlade");
		netherHandle = new ItemMineCharacter()
				.setUnlocalizedName("netherHandle");
		reaperBlade = new ItemMineCharacter().setUnlocalizedName("reaperBlade");
		mattockBlade = new ItemMineCharacter()
				.setUnlocalizedName("mattockBlade");

		mjolnirHandle = new ItemMineCharacter()
				.setUnlocalizedName("mjolnirHandle");
		mjolnirBlade = new ItemMineCharacter()
				.setUnlocalizedName("mjolnirBlade");
		netherAxeBlade = new ItemMineCharacter()
				.setUnlocalizedName("netherAxeBlade");
		netherPickaxeBlade = new ItemMineCharacter()
				.setUnlocalizedName("netherPickaxeBlade");
		lanceHandle = new ItemMineCharacter().setUnlocalizedName("lanceHandle");
		lanceBlade = new ItemMineCharacter().setUnlocalizedName("lanceBlade");
		tomahawkBlade = new ItemMineCharacter()
				.setUnlocalizedName("tomahawkBlade");
		magicPowder = new ItemMineCharacter().setUnlocalizedName("magicPowder");

		friedEgg = (ItemFood) new CharItemFood(3, 0.1F, false)
				.setUnlocalizedName("friedEgg");

		magicString = new ItemMineCharacter().setUnlocalizedName("magicString");
		nethercoal = new ItemMineCharacter().setUnlocalizedName("nethercoal");
		demonite = new ItemMineCharacter().setUnlocalizedName("demonite");
		luciferite = new ItemMineCharacter().setUnlocalizedName("luciferite");
		etherealIngot = new ItemMineCharacter()
				.setUnlocalizedName("etherealIngot");

		firePowder = new ItemMineCharacter().setUnlocalizedName("firePowder");
		icePowder = new ItemMineCharacter().setUnlocalizedName("icePowder");
		lifePowder = new ItemMineCharacter().setUnlocalizedName("lifePowder");
		deathPowder = new ItemMineCharacter().setUnlocalizedName("deathPowder");
		etherealPowder = new ItemMineCharacter()
				.setUnlocalizedName("etherealPowder");
		smokeGrenade = new ItemSmokeGrenade()
				.setUnlocalizedName("smokeGrenade");
		shuriken = new ItemShuriken().setUnlocalizedName("shuriken");
		assassinSteel = new ItemMineCharacter()
				.setUnlocalizedName("assassinSteel");
		dragger = new ItemDragger(ASSASSIN).setUnlocalizedName("dragger");
		draggerHandle = new ItemMineCharacter()
				.setUnlocalizedName("draggerHandle");
		draggerBlade = new ItemMineCharacter()
				.setUnlocalizedName("draggerBlade");
		quiver = new ItemMineCharacter().setUnlocalizedName("quiver");
		netherAxe = new ItemNetherAxe(NORTH).setUnlocalizedName("netherAxe");
		netherPickaxe = new ItemNetherPickaxe(NORTH)
				.setUnlocalizedName("netherPickaxe");

		this.registerItems();
	}

	private void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName(),
				"MineCharacter");

	}

	private void registerItems() {
		registerItem(woodHammer);
		registerItem(stoneHammer);
		registerItem(ironHammer);
		registerItem(goldHammer);
		registerItem(diamondHammer);

		registerItem(orb);
		registerItem(fireOrb);
		registerItem(iceOrb);
		registerItem(lifeOrb);
		registerItem(deathOrb);

		registerItem(fireStaff);
		registerItem(iceStaff);
		registerItem(lifeStaff);
		registerItem(deathStaff);

		registerItem(knightHelmet);
		registerItem(knightChest);
		registerItem(knightLegs);
		registerItem(knightBoots);

		registerItem(grimHelmet);
		registerItem(grimChest);
		registerItem(grimLegs);
		registerItem(grimBoots);

		registerItem(mageHelmet);
		registerItem(mageChest);
		registerItem(mageLegs);
		registerItem(mageBoots);

		registerItem(archerHelmet);
		registerItem(archerChest);
		registerItem(archerLegs);
		registerItem(archerBoots);

		registerItem(assassinHelmet);
		registerItem(assassinChest);
		registerItem(assassinLegs);
		registerItem(assassinBoots);

		registerItem(rune);
		registerItem(fireRune);
		registerItem(iceRune);
		registerItem(lifeRune);
		registerItem(deathRune);

		registerItem(soul);
		registerItem(lucifer);
		registerItem(reaper);

		registerItem(mechanicBow);
		registerItem(etherBow);
		registerItem(netherBow);

		registerItem(excalibur);
		registerItem(lance);
		registerItem(mjolnir);
		registerItem(mattock);
		registerItem(tomahawk);

		registerItem(beer);

		registerItem(excaliburHandle);
		registerItem(excaliburBlade);
		registerItem(luciferHandle);
		registerItem(luciferBlade);
		registerItem(netherHandle);
		registerItem(reaperBlade);
		registerItem(mattockBlade);
		registerItem(mjolnirHandle);

		registerItem(mjolnirBlade);
		registerItem(netherAxeBlade);
		registerItem(netherPickaxeBlade);
		registerItem(lanceHandle);

		registerItem(lanceBlade);
		registerItem(tomahawkBlade);
		registerItem(magicPowder);

		registerItem(friedEgg);
		registerItem(omelette);

		registerItem(magicString);
		registerItem(nethercoal);
		registerItem(demonite);
		registerItem(luciferite);
		registerItem(etherealIngot);

		registerItem(firePowder);
		registerItem(icePowder);
		registerItem(lifePowder);
		registerItem(deathPowder);
		registerItem(etherealPowder);

		registerItem(smokeGrenade);
		registerItem(shuriken);

		registerItem(assassinSteel);
		registerItem(dragger);
		registerItem(draggerHandle);
		registerItem(draggerBlade);
		registerItem(quiver);
		registerItem(netherAxe);
		registerItem(netherPickaxe);

	}

}
