package minecharacter.nei;

import minecharacter.block.gui.GuiAnvil;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEI_Config implements IConfigureNEI {

	@Override
	public void loadConfig() {
		 API.registerRecipeHandler(new AnvilNEIRepice());
	        API.registerUsageHandler(new AnvilNEIRepice());
	        API.registerGuiOverlay(GuiAnvil.class, "anvil");
	}

	@Override
	public String getName() {
		
		return "MineCharacter NEI Pluin";
	}

	@Override
	public String getVersion() {		
		return "1.0.0";
	}

}
