package minecharacter.nei;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import minecharacter.block.gui.GuiAnvil;
import minecharacter.block.tileentity.anvilrecipe.AnvilRecipes;
import minecharacter.block.tileentity.anvilrecipe.AnvingManager;
import minecharacter.block.tileentity.anvilrecipe.IAnvilRecipe;
import minecharacter.misc.InitItem;
import minecharacter.misc.Localization;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;

public class AnvilNEIRepice extends TemplateRecipeHandler {

	public class Anvilpair extends CachedRecipe {
		public ArrayList<PositionedStack> ingredients;
		public PositionedStack result;

		public Anvilpair(AnvilRecipes recipe) {
			this(recipe.recipeWidth, recipe.recipeHeight, recipe.recipeItems,
					recipe.getRecipeOutput());
		}


		@Override
		public PositionedStack getOtherStack()
        {
            return new PositionedStack(new ItemStack(InitItem.diamondHammer,1,0), 138, 6);
        }
		public Anvilpair(int recipeWidth, int recipeHeight,
				ItemStack[] recipeItems, ItemStack recipeOutput) {
			result = new PositionedStack(recipeOutput, 138, 38);
			ingredients = new ArrayList<PositionedStack>();
			setIngredients(recipeWidth, recipeHeight, recipeItems);
		}

		public void setIngredients(int width, int height, Object[] items) {
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					if (items[y * width + x] == null)
						continue;

					PositionedStack stack = new PositionedStack(items[y * width
							+ x], 7 + x * 18, 6 + y * 18, false);
					stack.setMaxSize(1);
					ingredients.add(stack);
				}
			}
		}

		@Override
		public List<PositionedStack> getIngredients() {
			return getCycledIngredients(cycleticks / 20, ingredients);
		}

		public PositionedStack getResult() {
			return result;
		}

		public void computeVisuals() {
			for (PositionedStack p : ingredients)
				p.generatePermutations();

			result.generatePermutations();
		}

	}

	@Override
	public String getRecipeName() {
		return Localization.get("gui.anvil");
	}

	@Override
	public String getGuiTexture() {
		return "minecharacter:textures/gui/anvil.png";
	}

	@Override
	public Class<? extends GuiContainer> getGuiClass() {
		return GuiAnvil.class;
	}

	@Override
	public String getOverlayIdentifier() {
		return "anvil";
	}

	@Override
	public void loadTransferRects() {
		transferRects.add(new RecipeTransferRect(new Rectangle(50, 23, 18, 18),
				"anvil"));
	}

	

	 @Override
	    public void loadCraftingRecipes(String outputId, Object... results)
	    {
	        if(outputId.equals("anvil") && getClass() == AnvilNEIRepice.class)
	        {
	            List<IAnvilRecipe> allrecipes = AnvingManager.getInstance().getRecipeList();
	            for(IAnvilRecipe irecipe : allrecipes)
	            {
	                Anvilpair recipe = null;
	                if(irecipe instanceof AnvilRecipes)
	                    recipe = new Anvilpair((AnvilRecipes)irecipe);
	                

	                if(recipe == null)
	                    continue;

	                recipe.computeVisuals();
	                arecipes.add(recipe);
	            }
	        }
	        else
	        {
	            super.loadCraftingRecipes(outputId, results);
	        }
	    }
	@Override
	public void loadCraftingRecipes(ItemStack result) {

        List<IAnvilRecipe> allrecipes = AnvingManager.getInstance().getRecipeList();
        for(IAnvilRecipe irecipe : allrecipes)
        {
            if(NEIServerUtils.areStacksSameTypeCrafting(irecipe.getRecipeOutput(), result))
            {
                Anvilpair recipe = null;
                if(irecipe instanceof AnvilRecipes)
                    recipe = new Anvilpair((AnvilRecipes)irecipe);
           
                
                if(recipe == null)
                    continue;
                
                recipe.computeVisuals();
                arecipes.add(recipe);
            }
	}
	}

}
