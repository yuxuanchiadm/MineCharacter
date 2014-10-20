package minecharacter.block.tileentity.anvilrecipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import minecharacter.block.container.InventoryAnvil;
import minecharacter.misc.InitItem;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class AnvingManager {

	private static final AnvingManager instance = new AnvingManager();

	private List<IAnvilRecipe> recipes = new ArrayList<IAnvilRecipe>();

	public static final AnvingManager getInstance() {
		return instance;
	}

	public AnvingManager() {
		addRecipe(new ItemStack(InitItem.excaliburBlade, 1), new Object[] {
				"     ", "DXDDD", "     ", 'X', Items.diamond, 'D',
				InitItem.etherealIngot });
		addRecipe(new ItemStack(InitItem.excaliburHandle, 1), new Object[] {
				"DDXDD", "  D  ", "  X  ", 'X',
				Items.diamond, 'D', InitItem.etherealIngot });

		addRecipe(new ItemStack(InitItem.excalibur, 1), new Object[] { " X",
				"D ", 'X', InitItem.excaliburBlade,
				'D', InitItem.excaliburHandle });

		addRecipe(
				new ItemStack(InitItem.luciferBlade, 1),
				new Object[] { " D D ", "DDDDX", " D D ",
						'X', InitItem.luciferite,
						'D', InitItem.demonite });

		addRecipe(
				new ItemStack(InitItem.luciferHandle, 1),
				new Object[] { "DDXDD", "  D  ", "  X  ",
						'X', InitItem.luciferite,
						'D', InitItem.demonite });

		addRecipe(new ItemStack(InitItem.lucifer, 1),
				new Object[] { " X", "D ", 'X',
						InitItem.luciferBlade, 'D',
						InitItem.luciferHandle });

		addRecipe(new ItemStack(InitItem.reaperBlade, 1), new Object[] {
				"DDDDD", "XXXXX", 'X', InitItem.luciferite,
				'D', InitItem.demonite });

		addRecipe(
				new ItemStack(InitItem.netherHandle, 1),
				new Object[] { "     ", "XDDDX", "     ",
						'X', InitItem.luciferite,
						'D', InitItem.demonite });

		addRecipe(new ItemStack(InitItem.reaper, 1),
				new Object[] { " X", "D ", 'X',
						InitItem.reaperBlade, 'D',
						InitItem.netherHandle });

		addRecipe(new ItemStack(InitItem.mattockBlade, 1), new Object[] {
				"XDDDD", "  DDD", "    D", 'D',
				InitItem.etherealIngot, 'X', Items.diamond });

		addRecipe(new ItemStack(InitItem.mattock, 1),
				new Object[] { " D", "X ", 'X',
						Items.diamond, 'D',
						InitItem.mattockBlade });

		addRecipe(new ItemStack(InitItem.tomahawkBlade, 1), new Object[] {
				"XDDDD", "XD   ", "X    ", 'D',
				InitItem.etherealIngot, 'X', Items.diamond });

		addRecipe(new ItemStack(InitItem.tomahawk, 1),
				new Object[] { " D", "X ", 'X',
						Items.diamond, 'D',
						InitItem.tomahawkBlade });

		addRecipe(new ItemStack(InitItem.mjolnirBlade, 1), new Object[] {
				"XDDDX", "DDDDD", "XDDDX", 'D',
				InitItem.etherealIngot, 'X', Items.diamond });

		addRecipe(new ItemStack(InitItem.mjolnirHandle, 1), new Object[] {
				"VVVVV", "XDDDD", "VVVVV", 'D',
				InitItem.etherealIngot, 'X', Items.diamond,
				'V', Items.diamond });

		addRecipe(new ItemStack(InitItem.mjolnir, 1),
				new Object[] { " D", "X ", 'X',
						InitItem.mjolnirHandle, 'D',
						InitItem.mjolnirBlade });

		addRecipe(
				new ItemStack(InitItem.netherAxeBlade, 1),
				new Object[] { "XDDDD", "XDD D", " XD  ",
						'D', InitItem.demonite,
						'X', InitItem.luciferite });

		addRecipe(new ItemStack(InitItem.netherAxe, 1),
				new Object[] { " D", "X ", 'X',
						InitItem.netherHandle, 'D',
						InitItem.netherAxeBlade });

		addRecipe(
				new ItemStack(InitItem.netherPickaxeBlade, 1),
				new Object[] { "XDDDX", "  DDX", "    X",
						'D', InitItem.demonite,
						'X', InitItem.luciferite });

		addRecipe(new ItemStack(InitItem.netherPickaxe, 1), new Object[] {
				" D", "X ", 'X', InitItem.netherHandle,
				'D', InitItem.netherPickaxeBlade });

		addRecipe(new ItemStack(InitItem.lanceBlade, 1), new Object[] {
				"     ", "XDXDX", "     ", 'D',
				InitItem.etherealIngot, 'X', Items.diamond });

		addRecipe(new ItemStack(InitItem.lanceHandle, 1), new Object[] {
				"   D ", "XDXDX", "   D ", 'D',
				InitItem.etherealIngot, 'X', Items.diamond });

		addRecipe(new ItemStack(InitItem.lance, 1),
				new Object[] { "D ", " X", 'X',
						InitItem.lanceHandle, 'D',
						InitItem.lanceBlade });

		addRecipe(new ItemStack(InitItem.mechanicBow, 1), new Object[] {
				" DDD ", "D   D", "VVVVV", 'D',
				Items.iron_ingot, 'V', Items.string });

		addRecipe(new ItemStack(InitItem.etherBow, 1), new Object[] { " DXD ",
				"D   D", "VVVVV", 'D',
				InitItem.etherealIngot, 'X', Items.diamond,
				'V', Items.string });

		addRecipe(
				new ItemStack(InitItem.netherBow, 1),
				new Object[] { " DXD ", "D   D", "VVVVV",
						'D', InitItem.demonite,
						'X', InitItem.luciferite,
						'V', Items.string });

		addRecipe(new ItemStack(InitItem.shuriken, 4), new Object[] { " X ",
				"XXX", " X ", 'X', InitItem.assassinSteel });

		addRecipe(new ItemStack(InitItem.draggerBlade, 1), new Object[] {
				"     ", "XXXXX", "     ", 'X',
				InitItem.assassinSteel });

		addRecipe(new ItemStack(InitItem.draggerHandle, 1), new Object[] {
				"XXXX", " XX ", " XX ", 'X', Items.diamond });

		addRecipe(new ItemStack(InitItem.dragger, 1),
				new Object[] { " D", "X ", 'D',
						InitItem.draggerBlade, 'X',
						InitItem.draggerHandle });

		addRecipe(
				new ItemStack(InitItem.smokeGrenade, 4),
				new Object[] { " DDD ", "DXVXD", " DDD ",
						'X', Items.coal,
						'V', Items.iron_ingot,
						'D', InitItem.assassinSteel });

		addRecipe(new ItemStack(InitItem.knightChest, 1), new Object[] {
				"DXDXD", " DXD ", " DDD ", 'D',
				InitItem.etherealIngot, 'X', Items.diamond });

		addRecipe(new ItemStack(InitItem.knightHelmet, 1), new Object[] {
				" DXD ", "DXDXD", "D   D", 'D',
				InitItem.etherealIngot, 'X', Items.diamond });

		addRecipe(new ItemStack(InitItem.knightLegs, 1), new Object[] {
				"DXDDX", "   DD", "DXDDX", 'D',
				InitItem.etherealIngot, 'X', Items.diamond });

		addRecipe(new ItemStack(InitItem.knightBoots, 1), new Object[] {
				" D D ", " X X ", "DD DD", 'D',
				InitItem.etherealIngot, 'X', Items.diamond });

		addRecipe(new ItemStack(InitItem.grimChest, 1), new Object[] { "DDDDD",
				" DDD ", " DDD ", 'D', InitItem.soul });

		addRecipe(new ItemStack(InitItem.grimHelmet, 1), new Object[] {
				" DDD ", "DDDDD", "D   D", 'D',
				InitItem.soul });

		addRecipe(new ItemStack(InitItem.grimLegs, 1), new Object[] { "DDDDD",
				"   DD", "DDDDD", 'D', InitItem.soul });

		addRecipe(new ItemStack(InitItem.grimBoots, 1), new Object[] { " D D ",
				" D D ", "DD DD", 'D', InitItem.soul });

		addRecipe(
				new ItemStack(InitItem.mageChest, 1),
				new Object[] { "DDDDD", " DDD ", " DDD ",
						'D', InitItem.magicString });

		addRecipe(new ItemStack(InitItem.mageHelmet, 1), new Object[] {
				" DDD ", "DDDDD", "D   D", 'D',
				InitItem.magicString });

		addRecipe(
				new ItemStack(InitItem.mageLegs, 1),
				new Object[] { "DDDDD", "   DD", "DDDDD",
						'D', InitItem.magicString });

		addRecipe(
				new ItemStack(InitItem.mageBoots, 1),
				new Object[] { " D D ", " D D ", "DD DD",
						'D', InitItem.magicString });

		addRecipe(new ItemStack(InitItem.archerChest, 1), new Object[] {
				"DDDDD", " DXD ", " DDD ", 'D',
				Items.string, 'X', InitItem.quiver });

		addRecipe(
				new ItemStack(InitItem.archerHelmet, 1),
				new Object[] { " DDD ", "DDDDD", "D   D",
						'D', Items.string });

		addRecipe(
				new ItemStack(InitItem.archerLegs, 1),
				new Object[] { "DDDDD", "   DD", "DDDDD",
						'D', Items.string });

		addRecipe(
				new ItemStack(InitItem.archerBoots, 1),
				new Object[] { " D D ", " D D ", "DD DD",
						'D', Items.string });

		addRecipe(new ItemStack(InitItem.assassinChest, 1), new Object[] {
				"DDDDD", " DDD ", " DDD ", 'D',
				new ItemStack(Blocks.wool, 1, 15) });

		addRecipe(new ItemStack(InitItem.assassinHelmet, 1), new Object[] {
				" DDD ", "DDDDD", "D   D", 'D',
				new ItemStack(Blocks.wool, 1, 15) });

		addRecipe(new ItemStack(InitItem.assassinLegs, 1), new Object[] {
				"DDDDD", "   DD", "DDDDD", 'D',
				new ItemStack(Blocks.wool, 1, 15) });

		addRecipe(new ItemStack(InitItem.assassinBoots, 1), new Object[] {
				" D D ", " D D ", "DD DD", 'D',
				new ItemStack(Blocks.wool, 1, 15) });

	}

	void addRecipe(ItemStack itemstack, Object... par2ArrayOfObj) {
		String s = "";
		int i = 0;
		int j = 0;
		int k = 0;

		if (par2ArrayOfObj[i] instanceof String[]) {
			String[] astring = (String[]) ((String[]) par2ArrayOfObj[i++]);

			for (int l = 0; l < astring.length; ++l) {
				String s1 = astring[l];
				++k;
				j = s1.length();
				s = s + s1;
			}
		} else {
			while (par2ArrayOfObj[i] instanceof String) {
				String s2 = (String) par2ArrayOfObj[i++];
				++k;
				j = s2.length();
				s = s + s2;
			}
		}

		HashMap<Character, ItemStack> hashmap = new HashMap<Character, ItemStack>();
		for (; i < par2ArrayOfObj.length; i += 2) {
			Character character = (Character) par2ArrayOfObj[i];
			ItemStack itemstack1 = null;
			if ((par2ArrayOfObj[(i + 1)] instanceof Item)) {
				itemstack1 = new ItemStack((Item) par2ArrayOfObj[(i + 1)]);
			} else if ((par2ArrayOfObj[(i + 1)] instanceof Block)) {
				itemstack1 = new ItemStack((Block) par2ArrayOfObj[(i + 1)], 1,
						-1);
			} else if ((par2ArrayOfObj[(i + 1)] instanceof ItemStack)) {
				itemstack1 = (ItemStack) par2ArrayOfObj[(i + 1)];
			}
			hashmap.put(character, itemstack1);
		}

		ItemStack[] aitemstack = new ItemStack[j * k];
		for (int i1 = 0; i1 < j * k; i1++) {
			char c = s.charAt(i1);
			if (hashmap.containsKey(Character.valueOf(c))) {
				aitemstack[i1] = ((ItemStack) hashmap.get(Character.valueOf(c)))
						.copy();
			} else {
				aitemstack[i1] = null;
			}
		}
		AnvilRecipes re = new AnvilRecipes(j, k, aitemstack, itemstack);
		recipes.add(re);

	}

	public ItemStack findMatchingRecipe(InventoryAnvil par1InventoryCrafting,
			World par2World) {
		for (int k = 0; k < recipes.size(); k++) {
			IAnvilRecipe irecipe = (IAnvilRecipe) recipes.get(k);
			if (irecipe.matches(par1InventoryCrafting, par2World)) {
				return irecipe.getCraftingResult(par1InventoryCrafting);
			}
		}
		return null;
	}

	public List<IAnvilRecipe> getRecipeList() {
		return recipes;
	}

}
