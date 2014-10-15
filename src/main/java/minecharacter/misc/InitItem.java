package minecharacter.misc;

import cpw.mods.fml.common.registry.GameRegistry;
import minecharacter.MineCharacter;
import minecharacter.item.CharItemArmor;
import minecharacter.item.ItemBat;
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
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraftforge.common.EnumHelper;

public class InitItem {

	//item
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
	public static ItemArmor  mageLegs;
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
	public static Item bat;
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
	public static final EnumArmorMaterial KNIGHT = EnumHelper.addArmorMaterial("KNIGHT", 33, new int[] { 5, 15, 10, 5 }, 30);
	public static final EnumArmorMaterial GRIM = EnumHelper.addArmorMaterial("GRIM", -1, new int[] { 0, 0, 0, 0 }, 30);
	public static final EnumToolMaterial ETHER = EnumHelper.addToolMaterial("ETHER", 3, 3122, 15.0F, 6, 30);
	public static final EnumToolMaterial NETHER = EnumHelper.addToolMaterial("NETHER", 3, 2341, 15.0F, 10, 5);
	public static final EnumToolMaterial ASSASSIN = EnumHelper.addToolMaterial("ASSASSIN", 3, 635, 15.0F, 5, 15);
	public static final EnumToolMaterial NORTH = EnumHelper.addToolMaterial("NORTH", 3, 635, 15.0F,5, 15);
	public void initItem() {
		  omelette=new ItemOmelette(ModIdConfig.omeletteId, InitBlock.blockOmelette).setUnlocalizedName("omelette");
			woodHammer=new ItemHammer(ModIdConfig.woodHammerId,EnumToolMaterial.WOOD).setUnlocalizedName("woodhammer");
			stoneHammer=new ItemHammer(ModIdConfig.stoneHammerId,EnumToolMaterial.STONE).setUnlocalizedName("stonehammer");
			ironHammer=new ItemHammer(ModIdConfig.ironHammerId,EnumToolMaterial.IRON).setUnlocalizedName("ironhammer");
			goldHammer=new ItemHammer(ModIdConfig.goldHammerId,EnumToolMaterial.GOLD).setUnlocalizedName("goldhammer");
			diamondHammer=new ItemHammer(ModIdConfig.diamondHammerId, EnumToolMaterial.EMERALD).setUnlocalizedName("diamondhammer");
			
			orb=new ItemMineCharacter(ModIdConfig.orbId).setUnlocalizedName("orb");
			fireOrb=new ItemMineCharacter(ModIdConfig.fireOrbId).setUnlocalizedName("fireOrb").setContainerItem(orb);
			iceOrb=new ItemMineCharacter(ModIdConfig.iceOrbId).setUnlocalizedName("iceOrb").setContainerItem(orb);
			lifeOrb=new ItemMineCharacter(ModIdConfig.lifeOrbId).setUnlocalizedName("lifeOrb").setContainerItem(orb);
			deathOrb=new ItemMineCharacter(ModIdConfig.deathOrbId).setUnlocalizedName("deathOrb").setContainerItem(orb);

			fireStaff=new ItemStaff(ModIdConfig.fireStaffId,1).setUnlocalizedName("fireStaff");
			iceStaff=new ItemStaff(ModIdConfig.iceStaffId,2).setUnlocalizedName("iceStaff");
			lifeStaff=new ItemStaff(ModIdConfig.lifeStaffId,3).setUnlocalizedName("lifeStaff");
			deathStaff=new ItemStaff(ModIdConfig.deathStaffId,4).setUnlocalizedName("deathStaff");
			
			knightHelmet=(ItemArmor) new CharItemArmor(ModIdConfig.knightHelmetId, KNIGHT,  MineCharacter.proxy.addArmor("knight"), 0).setUnlocalizedName("knightHelmet");
			knightChest=(ItemArmor) new CharItemArmor(ModIdConfig.knightChestId, KNIGHT, MineCharacter.proxy.addArmor("knight"), 1).setUnlocalizedName("knightChest");
			knightLegs=(ItemArmor) new CharItemArmor(ModIdConfig.knightLegsId, KNIGHT, MineCharacter.proxy.addArmor("knight"), 2).setUnlocalizedName("knightLegs");
			knightBoots=(ItemArmor) new CharItemArmor(ModIdConfig.knightBootsId, KNIGHT, MineCharacter.proxy.addArmor("knight"), 3).setUnlocalizedName("knightBoots");

			grimHelmet=(ItemArmor) new CharItemArmor(ModIdConfig.grimHelmetId, GRIM, MineCharacter.proxy.addArmor("grim"), 0).setUnlocalizedName("grimHelmet");
			grimChest=(ItemArmor) new CharItemArmor(ModIdConfig.grimChestId, GRIM, MineCharacter.proxy.addArmor("grim"), 1).setUnlocalizedName("grimChest");
			grimLegs=(ItemArmor) new CharItemArmor(ModIdConfig.grimLegsId, GRIM, MineCharacter.proxy.addArmor("grim"), 2).setUnlocalizedName("grimLegs");
			grimBoots=(ItemArmor) new CharItemArmor(ModIdConfig.grimBootsId, GRIM, MineCharacter.proxy.addArmor("grim"), 3).setUnlocalizedName("grimBoots");
		
			mageHelmet=(ItemArmor) new CharItemArmor(ModIdConfig.mageHelmetId, GRIM, MineCharacter.proxy.addArmor("mage"), 0).setUnlocalizedName("mageHelmet");
			mageChest=(ItemArmor) new CharItemArmor(ModIdConfig.mageChestId, GRIM, MineCharacter.proxy.addArmor("mage"), 1).setUnlocalizedName("mageChest");
			mageLegs=(ItemArmor) new CharItemArmor(ModIdConfig.mageLegsId, GRIM, MineCharacter.proxy.addArmor("mage"), 2).setUnlocalizedName("mageLegs");
			mageBoots=(ItemArmor) new CharItemArmor(ModIdConfig.mageBootsId, GRIM, MineCharacter.proxy.addArmor("mage"), 3).setUnlocalizedName("mageBoots");
			
			archerHelmet=(ItemArmor) new CharItemArmor(ModIdConfig.archerHelmetId, GRIM, MineCharacter.proxy.addArmor("archer"), 0).setUnlocalizedName("archerHelmet");
			archerChest=(ItemArmor) new CharItemArmor(ModIdConfig.archerChestId, GRIM, MineCharacter.proxy.addArmor("archer"), 1).setUnlocalizedName("archerChest");
			archerLegs=(ItemArmor) new CharItemArmor(ModIdConfig.archerLegsId, GRIM, MineCharacter.proxy.addArmor("archer"), 2).setUnlocalizedName("archerLegs");
			archerBoots=(ItemArmor) new CharItemArmor(ModIdConfig.archerBootsId, GRIM, MineCharacter.proxy.addArmor("archer"), 3).setUnlocalizedName("archerBoots");
			
			assassinHelmet=(ItemArmor) new CharItemArmor(ModIdConfig.ninjaHelmetId, GRIM, MineCharacter.proxy.addArmor("assassin"), 0).setUnlocalizedName("assassinHelmet");
			assassinChest=(ItemArmor) new CharItemArmor(ModIdConfig.ninjaChestId, GRIM, MineCharacter.proxy.addArmor("assassin"), 1).setUnlocalizedName("assassinChest");
			assassinLegs=(ItemArmor) new CharItemArmor(ModIdConfig.ninjaLegsId, GRIM, MineCharacter.proxy.addArmor("assassin"), 2).setUnlocalizedName("assassinLegs");
			assassinBoots=(ItemArmor) new CharItemArmor(ModIdConfig.ninjaBootsId, GRIM, MineCharacter.proxy.addArmor("assassin"), 3).setUnlocalizedName("assassinBoots");
		
			rune=new ItemMineCharacter(ModIdConfig.runeId).setUnlocalizedName("rune");
			fireRune=new ItemMineCharacter(ModIdConfig.fireRuneId).setUnlocalizedName("fireRune");
			iceRune=new ItemMineCharacter(ModIdConfig.iceRuneId).setUnlocalizedName("iceRune");
			lifeRune=new ItemMineCharacter(ModIdConfig.lifeRuneId).setUnlocalizedName("lifeRune");
			deathRune=new ItemMineCharacter(ModIdConfig.deathRuneId).setUnlocalizedName("deathRune");
			
			soul=new ItemMineCharacter(ModIdConfig.soulId).setUnlocalizedName("soul");
			lucifer=new ItemLucifer(ModIdConfig.luciferId, NETHER).setUnlocalizedName("lucifer");
			reaper=new ItemReaper(ModIdConfig.reaperId,NETHER).setUnlocalizedName("reaper");
			mechanicBow=new ItemMechanicBow(ModIdConfig.mechanicBowId).setUnlocalizedName("mechanicBow");
			etherBow=new ItemEtherBow(ModIdConfig.etherBowId).setUnlocalizedName("etherBow");
			netherBow=new ItemNetherBow(ModIdConfig.netherBowId).setUnlocalizedName("netherBow");
			
			excalibur=new ItemExcalibur(ModIdConfig.excaliburId, ETHER).setUnlocalizedName("excalibur");
			lance=new ItemLance(ModIdConfig.lanceId,ETHER).setUnlocalizedName("lance");
			mjolnir=new ItemMjolnir(ModIdConfig.mjolnirId, ETHER).setUnlocalizedName("mjolnir");
			mattock=new ItemMattock(ModIdConfig.mattockId, ETHER).setUnlocalizedName("mattock");
			tomahawk=new ItemTomahawk(ModIdConfig.tomahawkId,ETHER).setUnlocalizedName("tomahawk");
			
			beer=(ItemFood) new ItemBeer(ModIdConfig.beerId,4, 1.0F, false).setAlwaysEdible().setPotionEffect(9, 20*10, 0, 0.33F).setUnlocalizedName("beer");
			
			excaliburHandle=new ItemMineCharacter(ModIdConfig.excaliburHandleId).setUnlocalizedName("excaliburHandle");
			excaliburBlade=new ItemMineCharacter(ModIdConfig.excaliburBladeId).setUnlocalizedName("excaliburBlade");
			luciferHandle=new ItemMineCharacter(ModIdConfig.luciferHandleId).setUnlocalizedName("luciferHandle");
			luciferBlade=new ItemMineCharacter(ModIdConfig.luciferBladeId).setUnlocalizedName("luciferBlade");
			netherHandle=new ItemMineCharacter(ModIdConfig.netherHandleId ).setUnlocalizedName("netherHandle");
			reaperBlade=new ItemMineCharacter(ModIdConfig.reaperBladeId ).setUnlocalizedName("reaperBlade");
			mattockBlade=new ItemMineCharacter(ModIdConfig.mattockBladeId ).setUnlocalizedName("mattockBlade");
			
			mjolnirHandle=new ItemMineCharacter(ModIdConfig.mjolnirHandleId).setUnlocalizedName("mjolnirHandle");
			mjolnirBlade=new ItemMineCharacter(ModIdConfig.mjolnirBladeId).setUnlocalizedName("mjolnirBlade");
			netherAxeBlade=new ItemMineCharacter(ModIdConfig.netherAxeBladeId).setUnlocalizedName("netherAxeBlade");
			netherPickaxeBlade=new ItemMineCharacter(ModIdConfig.netherPickaxeBladeId).setUnlocalizedName("netherPickaxeBlade");	
			lanceHandle=new ItemMineCharacter(ModIdConfig.lanceHandleId).setUnlocalizedName("lanceHandle");
			lanceBlade=new ItemMineCharacter(ModIdConfig.lanceBladeId).setUnlocalizedName("lanceBlade");	
			tomahawkBlade=new ItemMineCharacter(ModIdConfig.tomahawkBladeId).setUnlocalizedName("tomahawkBlade");
			magicPowder=new ItemMineCharacter(ModIdConfig.magicPowderId).setUnlocalizedName("magicPowder");
			
			bat=new ItemBat(ModIdConfig.batId).setUnlocalizedName("bat");
			friedEgg=(ItemFood) new CharItemFood(ModIdConfig.friedEggId, 3, 0.1F, false).setUnlocalizedName("friedEgg");
			
			magicString=new ItemMineCharacter(ModIdConfig.magicStringId).setUnlocalizedName("magicString");
			nethercoal=new ItemMineCharacter(ModIdConfig.nethercoalId).setUnlocalizedName("nethercoal");
		    demonite=new ItemMineCharacter(ModIdConfig.demoniteId).setUnlocalizedName("demonite");
		    luciferite=new ItemMineCharacter(ModIdConfig.luciferiteId).setUnlocalizedName("luciferite");
		    etherealIngot=new ItemMineCharacter(ModIdConfig.etherealIngotId).setUnlocalizedName("etherealIngot");
		   
		    firePowder=new ItemMineCharacter(ModIdConfig.firePowderId).setUnlocalizedName("firePowder");
		   icePowder=new ItemMineCharacter(ModIdConfig.icePowderId).setUnlocalizedName("icePowder");
		    lifePowder=new ItemMineCharacter(ModIdConfig.lifePowderId).setUnlocalizedName("lifePowder");
		    deathPowder=new ItemMineCharacter(ModIdConfig.deathPowderId).setUnlocalizedName("deathPowder");
		    etherealPowder=new ItemMineCharacter(ModIdConfig.etherealPowderId).setUnlocalizedName("etherealPowder");
			smokeGrenade=new ItemSmokeGrenade(ModIdConfig.smokeGrenadeId).setUnlocalizedName("smokeGrenade");
		    shuriken=new ItemShuriken(ModIdConfig.shurikenId).setUnlocalizedName("shuriken");
		    assassinSteel=new ItemMineCharacter(ModIdConfig.ninjaSteelId).setUnlocalizedName("assassinSteel");
			dragger=new ItemDragger(ModIdConfig.katanaId, ASSASSIN).setUnlocalizedName("dragger");
			draggerHandle=new ItemMineCharacter(ModIdConfig.katanaHandleId).setUnlocalizedName("draggerHandle");
			draggerBlade=new ItemMineCharacter(ModIdConfig.katanaBladeId).setUnlocalizedName("draggerBlade");
		    quiver=new ItemMineCharacter(ModIdConfig.quiverId).setUnlocalizedName("quiver");
		    netherAxe=new ItemNetherAxe(ModIdConfig.netherAxeId,NORTH).setUnlocalizedName("netherAxe");
		    netherPickaxe=new ItemNetherPickaxe(ModIdConfig.netherPickaxeId,NORTH).setUnlocalizedName("netherPickaxe");
	
		    this.registerItems();
	}

	private void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName(), "MineCharacter");

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
			registerItem(bat);
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
