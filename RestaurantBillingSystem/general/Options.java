package general ;

import menu.* ;

import java.util.Scanner ;

public class Options
{
	private InputOrder objInputOrder ;
	private SubMenu objSubMenu ;
	private MainMenu objMainMenu = new MainMenu() ;
	
	public void options() 
		{
		try
		{
			System.out.print("\nSelect Option: ") ;
			Scanner sc0 = new Scanner(System.in) ;
			int var0 = sc0.nextInt() ;
			if(var0 > 0 && var0 <6)
				subMenu(var0) ;
			else if(var0 == 0)
				objMainMenu.executeMainMenu() ;
			else if(var0 == 100)
			{
				objInputOrder = new InputOrder(var0) ;
				objInputOrder.displayOrder() ;
			}
			else
			{
				System.out.println("Wrong Option. Plese Select Between 1 To 5") ;
				options() ;
			}
		}
		catch(Exception e)
		{
			System.out.println("\nInvalid Option. Enter Integer\n"+ e+ "n") ;
			objMainMenu.executeMainMenu() ;
		}
	}
	
	private void subMenu(int var0) 
	{
		objSubMenu = new SubMenu(var0) ;
		objSubMenu.display() ;
		
		objInputOrder = new InputOrder(var0) ;
		objInputOrder.displayOrder() ;
	}
	
	
}