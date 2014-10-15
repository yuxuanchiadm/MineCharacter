package minecharacter.misc;

import java.io.File;

import net.minecraftforge.common.Configuration;


public class ModIdConfig {

	public static int woodHammerId;
	public static int stoneHammerId;
	public static int ironHammerId;
	public static int goldHammerId;
	public static int diamondHammerId;
	public static int orbId;
	public static int fireOrbId;
	public static int iceOrbId;
	public static int lifeOrbId;
	public static int deathOrbId;
	public static int fireStaffId;
	public static int iceStaffId;
	public static int lifeStaffId;
	public static int deathStaffId;
	public static int knightHelmetId;
	public static int knightChestId;
	public static int knightLegsId;
	public static int knightBootsId;
	public static int grimHelmetId;
	public static int grimChestId;
	public static int grimLegsId;
	public static int grimBootsId;
	public static int mageHelmetId;
	public static int mageChestId;
	public static int  mageLegsId;
	public static int mageBootsId;
	public static int archerHelmetId;
	public static int archerChestId;
	public static int archerLegsId;
	public static int archerBootsId;
	public static int ninjaHelmetId;
	public static int ninjaChestId;
	public static int ninjaLegsId;
	public static int ninjaBootsId;
	public static int  runeId;
	public static int fireRuneId;
	public static int iceRuneId;
	public static int lifeRuneId;
	public static int deathRuneId;
	public static int soulId;
	public static int luciferId;
	public static int reaperId;
	public static int mechanicBowId;
	public static int etherBowId;
	public static int netherBowId;
	public static int excaliburId;
	public static int lanceId;
	public static int mjolnirId;
	public static int mattockId;
	public static int tomahawkId;
	public static int beerId;
	public static int excaliburHandleId;
	public static int excaliburBladeId;
	public static int luciferHandleId;
	public static int luciferBladeId;
	public static int netherHandleId;
	public static int reaperBladeId;
	public static int mattockBladeId;
	public static int mjolnirHandleId;
	public static int mjolnirBladeId;
	public static int netherAxeBladeId;
	public static int netherPickaxeBladeId;
	public static int lanceHandleId;
	public static int lanceBladeId;
	public static int tomahawkBladeId;
	public static int magicPowderId;
	public static int batId;
	public static int friedEggId;
	public static int omeletteId;
	public static int magicStringId;
	public static int nethercoalId;
	public static int demoniteId;
	public static int luciferiteId;
	public static int etherealIngotId;
	public static int firePowderId;
	public static int icePowderId;
	public static int lifePowderId;
	public static int deathPowderId;
	public static int etherealPowderId;
	public static int smokeGrenadeId;
	public static int shurikenId;
	public static int ninjaSteelId;
	public static int katanaId;
	public static int katanaHandleId;
	public static int katanaBladeId;
	public static int quiverId;
	public static int netherAxeId;
	public static int netherPickaxeId;
	
	//block
	public static int blockOmeletteId;
	public static int blockNethercoalId;
	public static int blockDemoniteId;
	public static int blockLuciferiteId;
	public static int blockWheatId;
	public static int blockOrbId;
	public static int spongeId;
	public static int airId;
	public static int panId;
	public static int blockAnvilId;
	
	public ModIdConfig(File file) {
		final Configuration config=new Configuration(file);
		hendlerId(config);
		
	}

	private void hendlerId(Configuration config) {
		config.load();
		//weapon
		ModIdConfig.woodHammerId=config.getItem("Wood Hammer", 11000).getInt();
		ModIdConfig.stoneHammerId=config.getItem("Stone Hammer", 11001).getInt();
		ModIdConfig.ironHammerId=config.getItem("Iron Hammer", 11002).getInt();
		ModIdConfig.goldHammerId=config.getItem("Gold Hammer", 11003).getInt();
		ModIdConfig.diamondHammerId=config.getItem("Diamond Hammer", 11004).getInt();
		ModIdConfig.orbId=config.getItem("Orb", 11009).getInt();
		ModIdConfig.fireOrbId=config.getItem("Fire Orb", 11010).getInt();
		ModIdConfig.iceOrbId=config.getItem("Ice Orb", 11011).getInt();
		ModIdConfig.lifeOrbId=config.getItem("Life Orb", 11012).getInt();
		ModIdConfig.deathOrbId=config.getItem("Death Orb", 11013).getInt();
		ModIdConfig.fireStaffId=config.getItem("Fire Staff", 11005).getInt();
		ModIdConfig.iceStaffId=config.getItem("Ice Staff", 11006).getInt();
		ModIdConfig.lifeStaffId=config.getItem("Life Staff", 11007).getInt();
		ModIdConfig.deathStaffId=config.getItem("Death Staff", 11008).getInt();
		ModIdConfig.knightHelmetId=config.getItem("Knight Helmet", 11009).getInt();
		ModIdConfig.knightChestId=config.getItem("Knight Chest", 11010).getInt();
		ModIdConfig.knightLegsId=config.getItem("Knight Legs", 11011).getInt();
		ModIdConfig.knightBootsId=config.getItem("Knight Boots", 11012).getInt();
		ModIdConfig.grimHelmetId=config.getItem("Grim Helmet", 11013).getInt();
		ModIdConfig.grimChestId=config.getItem("Grim Chest", 11014).getInt();
		ModIdConfig.grimLegsId=config.getItem("Grim Legs", 11015).getInt();
		ModIdConfig.grimBootsId=config.getItem("Grim Boots", 11016).getInt();
		ModIdConfig.mageHelmetId=config.getItem("Mage Helmet", 11017).getInt();
		ModIdConfig.mageChestId=config.getItem("Mage Chest", 11018).getInt();
		ModIdConfig.mageLegsId=config.getItem("Mage Legs", 11019).getInt();
		ModIdConfig.mageBootsId=config.getItem("Mage Boots", 11020).getInt();
		ModIdConfig.archerHelmetId=config.getItem("Archer Helmet", 11021).getInt();
		ModIdConfig.archerChestId=config.getItem("Archer Chest", 11022).getInt();
		ModIdConfig.archerLegsId=config.getItem("Archer Legs", 11023).getInt();
		ModIdConfig.archerBootsId=config.getItem("Archer Boots", 11024).getInt();
		ModIdConfig.ninjaHelmetId=config.getItem("Ninja Helmet", 11025).getInt();
		ModIdConfig.ninjaChestId=config.getItem("Ninja Chest", 11026).getInt();
		ModIdConfig.ninjaLegsId=config.getItem("Ninja Legs", 11027).getInt();
		ModIdConfig.ninjaBootsId=config.getItem("Ninja Boots", 11028).getInt();
		ModIdConfig.runeId=config.getItem("Rune", 11029).getInt();
		ModIdConfig.fireRuneId=config.getItem("Fire Rune", 11030).getInt();
		ModIdConfig.iceRuneId=config.getItem("Ice Rune", 11031).getInt();
		ModIdConfig.lifeRuneId=config.getItem("Life Rune", 11032).getInt();
		ModIdConfig.deathRuneId=config.getItem("Death Rune", 11033).getInt();
		ModIdConfig.soulId=config.getItem("Soul", 11034).getInt();
		ModIdConfig.luciferId=config.getItem("Lucifer", 11035).getInt();
		ModIdConfig.reaperId=config.getItem("Reaper",11036).getInt();
		ModIdConfig.mechanicBowId=config.getItem("Mechanic Bow", 11037).getInt();
		ModIdConfig.etherBowId=config.getItem("Ether Bow", 11038).getInt();
		ModIdConfig.netherBowId=config.getItem("Nether Bow", 11039).getInt();
		ModIdConfig.excaliburId=config.getItem("Excalibur", 11040).getInt();
		ModIdConfig.lanceId=config.getItem("Lance", 11041).getInt();
		ModIdConfig.mjolnirId =config.getItem("Mjolnr", 11042).getInt();
		ModIdConfig.mattockId=config.getItem("Mattock", 11043).getInt();
		ModIdConfig.tomahawkId=config.getItem("Tomahawk", 11044).getInt();
		ModIdConfig.beerId=config.getItem("Beer", 11045).getInt();
		ModIdConfig.excaliburHandleId=config.getItem("Excalibur Handle", 11046).getInt();
		ModIdConfig.excaliburBladeId=config.getItem("Excalibur Blade", 11047).getInt();
		ModIdConfig.luciferHandleId=config.getItem("Lucifer Handle", 11048).getInt();
		ModIdConfig.luciferBladeId=config.getItem("Lucifer Blade", 11049).getInt();
		ModIdConfig.netherHandleId=config.getItem("Nether Handle", 11050).getInt();
		ModIdConfig.reaperBladeId=config.getItem("Reaper Blade", 11051).getInt();
		ModIdConfig.mattockBladeId=config.getItem("Mattock Blade", 11052).getInt();
		ModIdConfig.mjolnirHandleId=config.getItem("Mjolnir Handle", 11053).getInt();
		ModIdConfig.mjolnirBladeId=config.getItem("Mjolnir Blade", 11054).getInt();
		ModIdConfig.netherAxeBladeId=config.getItem("Nether Axe Blade", 11055).getInt();
		ModIdConfig.netherPickaxeBladeId=config.getItem("Nether Pickaxe Blade", 11056).getInt();	
		ModIdConfig.lanceHandleId=config.getItem("Lance Handle", 11057).getInt();
		ModIdConfig.lanceBladeId=config.getItem("Lance Blade", 11058).getInt();	
		ModIdConfig.tomahawkBladeId=config.getItem("Tomahawk Blade", 11059).getInt();
		ModIdConfig.magicPowderId=config.getItem("Magic PowderId", 11060).getInt();
		ModIdConfig.batId=config.getItem("Bat", 11061).getInt();
		ModIdConfig.friedEggId=config.getItem("Fried Egg",11062).getInt();
		ModIdConfig.omeletteId=config.getItem("Omelette", 11063).getInt();
		ModIdConfig.magicStringId=config.getItem("Magic String", 11064).getInt();
		ModIdConfig.nethercoalId=config.getItem("Nethercoal", 11065).getInt();
		ModIdConfig.demoniteId=config.getItem("Demonite", 11066).getInt();
		ModIdConfig.luciferiteId=config.getItem("Luciferite", 11067).getInt();
		ModIdConfig.etherealIngotId=config.getItem("Ethereal Ingot", 11068).getInt();
		ModIdConfig.firePowderId=config.getItem("Fire Powder", 11069).getInt();
		ModIdConfig.icePowderId=config.getItem("Ice Powder", 11070).getInt();
		ModIdConfig.lifePowderId=config.getItem("Life Powder", 11071).getInt();
		ModIdConfig.deathPowderId=config.getItem("Death Powder", 11072).getInt();
		ModIdConfig.etherealPowderId=config.getItem("Ethereal Powder", 11073).getInt();
		ModIdConfig.smokeGrenadeId=config.getItem("Smoke Grenade", 11074).getInt();
		ModIdConfig.shurikenId=config.getItem("Shuriken", 11075).getInt();
		ModIdConfig.ninjaSteelId=config.getItem("Ninja Steel", 11076).getInt();
		ModIdConfig.katanaId=config.getItem("Katana", 11077).getInt();
		ModIdConfig.katanaHandleId=config.getItem("Katana Handle", 11078).getInt();
		ModIdConfig.katanaBladeId=config.getItem("Katana Blade", 11079).getInt();
	    ModIdConfig.quiverId=config.getItem("Quiver", 11080).getInt();
	    ModIdConfig.netherAxeId=config.getItem(" netherAxe", 11081).getInt();
	    ModIdConfig.netherPickaxeId=config.getItem("netherPickaxe", 11082).getInt();
	   
	    ModIdConfig.blockOmeletteId=config.getBlock("Block Omelette", 1234).getInt();
	    ModIdConfig.blockNethercoalId=config.getBlock("Block Nethercoal", 1235).getInt();
	    ModIdConfig.blockDemoniteId=config.getBlock("Block Demonite", 1236).getInt();
	    ModIdConfig.blockLuciferiteId=config.getBlock("Block Luciferite", 1237).getInt();
	    ModIdConfig.blockWheatId=config.getBlock("Wheat", 1238).getInt();
	    ModIdConfig.blockOrbId=config.getBlock("Block Orb", 1239).getInt();
		ModIdConfig.spongeId=config.getBlock("Block sponge", 1240).getInt();
		ModIdConfig.airId=config.getBlock("Block air", 1241).getInt();
		ModIdConfig.panId=config.getBlock("Block pan", 1242).getInt();
		ModIdConfig.blockAnvilId=config.getBlock("Block anvil", 1243).getInt();
	
		config.save();
		
	}


}
