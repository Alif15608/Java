import foodDetails.IFoodTypes ;
import general.Options ;
import menu.MainMenu ;

import java.util.Scanner ;

public class Main
{
	public static void  main(String[] arg)
	{
		IFoodTypes.instructions() ;
		
		MainMenu objMM = new MainMenu() ;
		objMM.executeMainMenu() ;
	}
}