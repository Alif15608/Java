package menu ;

import foodDetails.IFoodTypes ;
import general.Options ;

public class MainMenu
{
	public void executeMainMenu()
	{
		IFoodTypes.foodMainMenu() ;
		
		Options objOP = new Options() ;
		objOP.options() ;
	}
}