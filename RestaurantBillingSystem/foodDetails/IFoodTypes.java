package foodDetails ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public interface IFoodTypes
{
	public static void foodMainMenu()
	{
		System.out.println("\n"+ "||||| Welcome To Food Xpress |||||"+ "\n") ;
		System.out.println("1. Burger & Pizza") ;
		System.out.println("2. Sub & Sandwitch") ;
		System.out.println("3. Rice") ;
		System.out.println("4. Special Items") ;
		System.out.println("5. Beverages") ;
	}
	public static void instructions()
	{
		FileReader reader ;
		BufferedReader bfr ;
		try
		{
		reader = new FileReader("C:/Users/ASUS/Downloads/3rd Semester/Java/Project/RestaurantBillingSystem/Database/instructions.txt") ;
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