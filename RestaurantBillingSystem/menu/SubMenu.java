package menu ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SubMenu
{
	private int option ;
	private FileReader reader ;
	private BufferedReader bfr ;
	
	public SubMenu(int option)
	{
		this.option = option ;
	}
	
	public void display()
	{
		System.out.print("\n") ;
		try
		{
			switch(option)
			{
			case 1:
				reader = new FileReader("C:/Users/ASUS/Downloads/3rd Semester/Java/Project/RestaurantBillingSystem/Database/FoodItems/Burger&Pizza.txt") ;
				break ;
			case 2:
				reader = new FileReader("C:/Users/ASUS/Downloads/3rd Semester/Java/Project/RestaurantBillingSystem/Database/FoodItems/Sub&Sandwitch.txt") ;
				break ;
			case 3:
				reader = new FileReader("C:/Users/ASUS/Downloads/3rd Semester/Java/Project/RestaurantBillingSystem/Database/FoodItems/Rice.txt") ;
				break ;
			case 4:
				reader = new FileReader("C:/Users/ASUS/Downloads/3rd Semester/Java/Project/RestaurantBillingSystem/Database/FoodItems/SpecialItems.txt") ;
				break ;
			case 5:
				reader = new FileReader("C:/Users/ASUS/Downloads/3rd Semester/Java/Project/RestaurantBillingSystem/Database/FoodItems/Beverages.txt") ;
				break ;
			}
		bfr = new BufferedReader(reader) ;
		String text="", temp ;
			
		while((temp=bfr.readLine())!=null)
			{
				text=text+temp+"\n"+"\r" ;
			}
		System.out.println(text) ;
		reader.close() ;
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace() ;
		}
	}
	
}