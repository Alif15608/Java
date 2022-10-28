package general ;

import billing.* ;
import menu.MainMenu ;
import voucher.Voucher ;
import foodDetails.IFoodDetails ;

import java.util.Scanner ;

public class InputOrder extends Billing implements IFoodDetails
{
	private int foodOption ;
	private int itemNo ;
	private int itemQuantity ;
	
	private MainMenu objMainMenu = new MainMenu() ;
	private BillFile Fobj = new BillFile() ;
	private Voucher objV = new Voucher() ;
	
	public InputOrder()	{}
	public InputOrder(int foodOption)
	{
		this.foodOption = foodOption ;
	}
	
	public void displayOrder()
	{
		switch(foodOption)
		{
			case 1:
				checkSelection(5) ;
				break;
			case 2:
				checkSelection(4) ;
				break;
			case 3:
				checkSelection(2) ;
				break;
			case 4:
				checkSelection(3) ;
				break;
			case 5:
				checkSelection(5) ;
				break;
			case 100:
				displayBill() ;
				break;
		}	
	}
	
	public void sendInFile(String s, int Q, int P) //s=item name || Q=item quantity || P=price
	{
		Fobj.writeInFile(s, Q, P) ;
		if(totalBill != 0)
			Fobj.readFromFile() ;
	}
	
	public void displayBill()
	{
		if(OS == 0)
			defaultBill() ;
		else if (OS == 1)
		{
			sendInFile("Current Amount", 1, currentBill) ;
			discount = currentBill ;
			objV = new Voucher() ;
			currentBill = objV.voCd(currentBill) ;
			totalBill = totalBill+currentBill ;
			if(totalBill !=0)
			{
				discount = discount - currentBill ;
				if(discount == 0 )
					sendInFile("Discount Amount", 0, discount) ;
				else
					sendInFile("Discount Amount", 1, discount) ;
			}
			sendInFile("Total Amount", 1, totalBill) ;
		}
		else
			System.exit(0);
	}
	
	private void checkSelection(int U) //U=Highest item number | 1=Lowest Item Number 
	{
		try
		{
			do
			{
			System.out.print("Enter: ") ;
				Scanner fO = new Scanner(System.in) ;
				itemNo = fO.nextInt() ;
				if(itemNo<U+1 && itemNo>0)
				{
					switch(foodOption)
					{
						case 1:
							System.out.println(type1[itemNo-1]) ;
							System.out.print("Quantity: ") ;
							Scanner fQ1 = new Scanner(System.in) ;
							itemQuantity = fQ1.nextInt() ;
							currentBill = currentBill+ price1[itemNo-1]*itemQuantity ;
							itemBill =  price1[itemNo-1]*itemQuantity ;
							System.out.println("Price: "+ itemBill) ;
							sendInFile(type1[itemNo-1], itemQuantity, itemBill);
							break ;
						case 2:
							System.out.println(type2[itemNo-1]) ;
							System.out.print("Quantity: ") ;
							Scanner fQ2 = new Scanner(System.in) ;
							itemQuantity = fQ2.nextInt() ;
							currentBill = currentBill+ price2[itemNo-1]*itemQuantity ;
							itemBill =  price2[itemNo-1]*itemQuantity ;
							System.out.println("Price: "+ itemBill) ;
							sendInFile(type2[itemNo-1], itemQuantity, itemBill);
							break ;
						case 3:
							System.out.println(type3[itemNo-1]) ;
							System.out.print("Quantity: ") ;
							Scanner fQ3 = new Scanner(System.in) ;
							itemQuantity = fQ3.nextInt() ;
							currentBill = currentBill+ price3[itemNo-1]*itemQuantity ;
							itemBill =  price3[itemNo-1]*itemQuantity ;
							System.out.println("Price: "+ itemBill) ;
							sendInFile(type3[itemNo-1], itemQuantity, itemBill);
							break ;
						case 4:
							System.out.println(type4[itemNo-1]) ;
							System.out.print("Quantity: ") ;
							Scanner fQ4 = new Scanner(System.in) ;
							itemQuantity = fQ4.nextInt() ;
							currentBill = currentBill+ price4[itemNo-1]*itemQuantity ;
							itemBill =  price4[itemNo-1]*itemQuantity ;
							System.out.println("Price: "+ itemBill) ;
							sendInFile(type4[itemNo-1], itemQuantity, itemBill);
							break ;
						case 5:
							System.out.println(type5[itemNo-1]) ;
							System.out.print("Quantity: ") ;
							Scanner fQ5 = new Scanner(System.in) ;
							itemQuantity = fQ5.nextInt() ;
							currentBill = currentBill+ price5[itemNo-1]*itemQuantity ;
							itemBill =  price5[itemNo-1]*itemQuantity ;
							System.out.println("Price: "+ itemBill) ;
							sendInFile(type5[itemNo-1], itemQuantity, itemBill);
							break ;
					}
					if(itemNo == 0 || itemNo == 100)
						break;
				}
				else if(itemNo == 0 || itemNo == 100)
					break;
				else
				{
					System.out.println("Wrong Item Number. Plese Select Between 1"+ " To "+ U) ;
					checkSelection(U) ;
				}
			} while(true) ;
		}
		catch(Exception e)
		{
			System.out.println("\nInvalid Item Number. Enter Integer.\n"+ e+ "\n") ;
			checkSelection(U) ;
		}		
		if(itemNo == 0)
		{
			System.out.println("Current Amount: "+ currentBill) ;
			objMainMenu.executeMainMenu() ;
		}
		else
		{
			OS++ ;
			displayBill() ;
		}
			
	}
}
