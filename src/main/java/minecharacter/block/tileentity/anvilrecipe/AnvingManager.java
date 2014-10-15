package minecharacter.block.tileentity.anvilrecipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import minecharacter.block.container.InventoryAnvil;
import minecharacter.misc.InitItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
public class AnvingManager {
	
	
	private static final AnvingManager instance = new AnvingManager();
	
	 private List<IAnvilRecipe> recipes = new ArrayList<IAnvilRecipe>();
	  public static final AnvingManager getInstance()
	  {
	    return instance;
	  }


	  public AnvingManager(){
		  addRecipe(new ItemStack(InitItem.excaliburBlade, 1), new Object[] { "     ", "DXDDD", "     ", Character.valueOf('X'), Item.diamond, Character.valueOf('D'), InitItem.etherealIngot });

		    addRecipe(new ItemStack(InitItem.excaliburHandle, 1), new Object[] { "DDXDD", "  D  ", "  X  ", Character.valueOf('X'), Item.diamond, Character.valueOf('D'), InitItem.etherealIngot });

		    addRecipe(new ItemStack(InitItem.excalibur, 1), new Object[] { " X", "D ", Character.valueOf('X'), InitItem.excaliburBlade, Character.valueOf('D'), InitItem.excaliburHandle });

		    addRecipe(new ItemStack(InitItem.luciferBlade, 1), new Object[] { " D D ", "DDDDX", " D D ", Character.valueOf('X'), InitItem.luciferite, Character.valueOf('D'), InitItem.demonite });

		    addRecipe(new ItemStack(InitItem.luciferHandle, 1), new Object[] { "DDXDD", "  D  ", "  X  ", Character.valueOf('X'), InitItem.luciferite, Character.valueOf('D'), InitItem.demonite });

		    addRecipe(new ItemStack(InitItem.lucifer, 1), new Object[] { " X", "D ", Character.valueOf('X'), InitItem.luciferBlade, Character.valueOf('D'), InitItem.luciferHandle });

		    addRecipe(new ItemStack(InitItem.reaperBlade, 1), new Object[] { "DDDDD", "XXXXX", Character.valueOf('X'), InitItem.luciferite, Character.valueOf('D'), InitItem.demonite });

		    addRecipe(new ItemStack(InitItem.netherHandle, 1), new Object[] { "     ", "XDDDX", "     ", Character.valueOf('X'), InitItem.luciferite, Character.valueOf('D'), InitItem.demonite });

		    addRecipe(new ItemStack(InitItem.reaper, 1), new Object[] { " X", "D ", Character.valueOf('X'), InitItem.reaperBlade, Character.valueOf('D'), InitItem.netherHandle });

		    addRecipe(new ItemStack(InitItem.mattockBlade, 1), new Object[] { "XDDDD", "  DDD", "    D", Character.valueOf('D'), InitItem.etherealIngot, Character.valueOf('X'), Item.diamond });

		    addRecipe(new ItemStack(InitItem.mattock, 1), new Object[] { " D", "X ", Character.valueOf('X'), Item.diamond, Character.valueOf('D'), InitItem.mattockBlade });

		    addRecipe(new ItemStack(InitItem.tomahawkBlade, 1), new Object[] { "XDDDD", "XD   ", "X    ", Character.valueOf('D'), InitItem.etherealIngot, Character.valueOf('X'),Item.diamond });

		    addRecipe(new ItemStack(InitItem.tomahawk, 1), new Object[] { " D", "X ", Character.valueOf('X'), Item.diamond, Character.valueOf('D'), InitItem.tomahawkBlade });

		    addRecipe(new ItemStack(InitItem.mjolnirBlade, 1), new Object[] { "XDDDX", "DDDDD", "XDDDX", Character.valueOf('D'), InitItem.etherealIngot, Character.valueOf('X'),Item.diamond });

		    addRecipe(new ItemStack(InitItem.mjolnirHandle, 1), new Object[] { "VVVVV", "XDDDD", "VVVVV", Character.valueOf('D'), InitItem.etherealIngot, Character.valueOf('X'),Item.diamond, Character.valueOf('V'), Item.diamond });

		    addRecipe(new ItemStack(InitItem.mjolnir, 1), new Object[] { " D", "X ", Character.valueOf('X'), InitItem.mjolnirHandle, Character.valueOf('D'), InitItem.mjolnirBlade });

		    addRecipe(new ItemStack(InitItem.netherAxeBlade, 1), new Object[] { "XDDDD", "XDD D", " XD  ", Character.valueOf('D'), InitItem.demonite, Character.valueOf('X'), InitItem.luciferite });

		    addRecipe(new ItemStack(InitItem.netherAxe, 1), new Object[] { " D", "X ", Character.valueOf('X'), InitItem.netherHandle, Character.valueOf('D'), InitItem.netherAxeBlade });

		    addRecipe(new ItemStack(InitItem.netherPickaxeBlade, 1), new Object[] { "XDDDX", "  DDX", "    X", Character.valueOf('D'), InitItem.demonite, Character.valueOf('X'), InitItem.luciferite });

		    addRecipe(new ItemStack(InitItem.netherPickaxe, 1), new Object[] { " D", "X ", Character.valueOf('X'), InitItem.netherHandle, Character.valueOf('D'), InitItem.netherPickaxeBlade });

		    addRecipe(new ItemStack(InitItem.lanceBlade, 1), new Object[] { "     ", "XDXDX", "     ", Character.valueOf('D'), InitItem.etherealIngot, Character.valueOf('X'),Item.diamond });

		    addRecipe(new ItemStack(InitItem.lanceHandle, 1), new Object[] { "   D ", "XDXDX", "   D ", Character.valueOf('D'), InitItem.etherealIngot, Character.valueOf('X'),Item.diamond });

		    addRecipe(new ItemStack(InitItem.lance, 1), new Object[] { "D ", " X", Character.valueOf('X'), InitItem.lanceHandle, Character.valueOf('D'), InitItem.lanceBlade });

		    addRecipe(new ItemStack(InitItem.mechanicBow, 1), new Object[] { " DDD ", "D   D", "VVVVV", Character.valueOf('D'), Item.ingotIron, Character.valueOf('V'),Item.silk });

		    addRecipe(new ItemStack(InitItem.etherBow, 1), new Object[] { " DXD ", "D   D", "VVVVV", Character.valueOf('D'), InitItem.etherealIngot, Character.valueOf('X'),Item.diamond, Character.valueOf('V'),Item.silk });

		    addRecipe(new ItemStack(InitItem.netherBow, 1), new Object[] { " DXD ", "D   D", "VVVVV", Character.valueOf('D'), InitItem.demonite, Character.valueOf('X'), InitItem.luciferite, Character.valueOf('V'),Item.silk });

		    addRecipe(new ItemStack(InitItem.shuriken, 4), new Object[] { " X ", "XXX", " X ", Character.valueOf('X'), InitItem.assassinSteel });

		    addRecipe(new ItemStack(InitItem.draggerBlade, 1), new Object[] { "     ", "XXXXX", "     ", Character.valueOf('X'), InitItem.assassinSteel });

		    addRecipe(new ItemStack(InitItem.draggerHandle, 1), new Object[] { "XXXX", " XX ", " XX ", Character.valueOf('X'), Item.diamond });

		    addRecipe(new ItemStack(InitItem.dragger, 1), new Object[] { " D", "X ", Character.valueOf('D'), InitItem.draggerBlade, Character.valueOf('X'), InitItem.draggerHandle });

		    addRecipe(new ItemStack(InitItem.smokeGrenade, 4), new Object[] { " DDD ", "DXVXD", " DDD ", Character.valueOf('X'), Item.coal, Character.valueOf('V'), Item.ingotIron, Character.valueOf('D'), InitItem.assassinSteel });

		    addRecipe(new ItemStack(InitItem.knightChest, 1), new Object[] { "DXDXD", " DXD ", " DDD ", Character.valueOf('D'), InitItem.etherealIngot, Character.valueOf('X'),Item.diamond });

		    addRecipe(new ItemStack(InitItem.knightHelmet, 1), new Object[] { " DXD ", "DXDXD", "D   D", Character.valueOf('D'), InitItem.etherealIngot, Character.valueOf('X'),Item.diamond });

		    addRecipe(new ItemStack(InitItem.knightLegs, 1), new Object[] { "DXDDX", "   DD", "DXDDX", Character.valueOf('D'), InitItem.etherealIngot, Character.valueOf('X'),Item.diamond });

		    addRecipe(new ItemStack(InitItem.knightBoots, 1), new Object[] { " D D ", " X X ", "DD DD", Character.valueOf('D'), InitItem.etherealIngot, Character.valueOf('X'),Item.diamond });

		    addRecipe(new ItemStack(InitItem.grimChest, 1), new Object[] { "DDDDD", " DDD ", " DDD ", Character.valueOf('D'), InitItem.soul });

		    addRecipe(new ItemStack(InitItem.grimHelmet, 1), new Object[] { " DDD ", "DDDDD", "D   D", Character.valueOf('D'), InitItem.soul });

		    addRecipe(new ItemStack(InitItem.grimLegs, 1), new Object[] { "DDDDD", "   DD", "DDDDD", Character.valueOf('D'), InitItem.soul });

		    addRecipe(new ItemStack(InitItem.grimBoots, 1), new Object[] { " D D ", " D D ", "DD DD", Character.valueOf('D'), InitItem.soul });

		    addRecipe(new ItemStack(InitItem.mageChest, 1), new Object[] { "DDDDD", " DDD ", " DDD ", Character.valueOf('D'), InitItem.magicString });

		    addRecipe(new ItemStack(InitItem.mageHelmet, 1), new Object[] { " DDD ", "DDDDD", "D   D", Character.valueOf('D'), InitItem.magicString });

		    addRecipe(new ItemStack(InitItem.mageLegs, 1), new Object[] { "DDDDD", "   DD", "DDDDD", Character.valueOf('D'), InitItem.magicString });

		    addRecipe(new ItemStack(InitItem.mageBoots, 1), new Object[] { " D D ", " D D ", "DD DD", Character.valueOf('D'), InitItem.magicString });

		    addRecipe(new ItemStack(InitItem.archerChest, 1), new Object[] { "DDDDD", " DXD ", " DDD ", Character.valueOf('D'),Item.silk, Character.valueOf('X'), InitItem.quiver });

		    addRecipe(new ItemStack(InitItem.archerHelmet, 1), new Object[] { " DDD ", "DDDDD", "D   D", Character.valueOf('D'),Item.silk });

		    addRecipe(new ItemStack(InitItem.archerLegs, 1), new Object[] { "DDDDD", "   DD", "DDDDD", Character.valueOf('D'),Item.silk });

		    addRecipe(new ItemStack(InitItem.archerBoots, 1), new Object[] { " D D ", " D D ", "DD DD", Character.valueOf('D'),Item.silk });

		    addRecipe(new ItemStack(InitItem.assassinChest, 1), new Object[] { "DDDDD", " DDD ", " DDD ", Character.valueOf('D'), new ItemStack(Block.cloth, 1, 15) });

		    addRecipe(new ItemStack(InitItem.assassinHelmet, 1), new Object[] { " DDD ", "DDDDD", "D   D", Character.valueOf('D'), new ItemStack(Block.cloth, 1, 15) });

		    addRecipe(new ItemStack(InitItem.assassinLegs, 1), new Object[] { "DDDDD", "   DD", "DDDDD", Character.valueOf('D'), new ItemStack(Block.cloth, 1, 15) });

		    addRecipe(new ItemStack(InitItem.assassinBoots, 1), new Object[] { " D D ", " D D ", "DD DD", Character.valueOf('D'), new ItemStack(Block.cloth, 1, 15) });
		    
	  }
	

	void addRecipe(ItemStack itemstack, Object ... par2ArrayOfObj)
	  {
	    String s = "";
	    int i = 0;
	    int j = 0;//行宽
	    int k = 0;//行数
	   
	      while ((par2ArrayOfObj[i] instanceof String))
	      {
	        String s1 = (String)par2ArrayOfObj[(i++)];
	        k++;
	        j = s1.length();
	        s = s + s1;
	      }
	 
		HashMap<Character,ItemStack> hashmap = new HashMap<Character,ItemStack>();
	    for (; i < par2ArrayOfObj.length; i += 2)
	    {
	      Character character = (Character)par2ArrayOfObj[i];
	      ItemStack itemstack1 = null;
	      if ((par2ArrayOfObj[(i + 1)] instanceof Item))
	      {
	        itemstack1 = new ItemStack((Item)par2ArrayOfObj[(i + 1)]);
	      }
	      else if ((par2ArrayOfObj[(i + 1)] instanceof Block))
	      {
	        itemstack1 = new ItemStack((Block)par2ArrayOfObj[(i + 1)], 1, -1);
	      }
	      else if ((par2ArrayOfObj[(i + 1)] instanceof ItemStack))
	      {
	        itemstack1 = (ItemStack)par2ArrayOfObj[(i + 1)];
	      }
	      hashmap.put(character, itemstack1);
	    }

	    ItemStack[] aitemstack = new ItemStack[j * k];
	    for (int i1 = 0; i1 < j * k; i1++)
	    {
	      char c = s.charAt(i1);
	      if (hashmap.containsKey(Character.valueOf(c)))
	      {
	        aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c))).copy();
	      }
	      else {
	        aitemstack[i1] = null;
	      }
	    }
	    AnvilRecipes re= new AnvilRecipes(j, k, aitemstack, itemstack);
	    recipes.add(re);
	
	  }

	


	
	 


	public ItemStack findMatchingRecipe(InventoryAnvil inventoryanvil)
	  {
	    
	    for (int k = 0; k < recipes.size(); k++)
	    {
	      IAnvilRecipe irecipe = (IAnvilRecipe)recipes.get(k);
	      if (irecipe.matches(inventoryanvil))
	      {
	        return irecipe.getCraftingResult(inventoryanvil);
	      }
	    }

	    return null;
	  }

	public List<IAnvilRecipe> getRecipeList()
	  {
	    return recipes;
	  }
	
}
