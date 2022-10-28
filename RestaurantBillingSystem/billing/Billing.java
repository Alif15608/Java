package billing ;

public abstract class Billing
{
	protected int discount = 0 ;
	protected int itemBill = 0;
	protected int OS = 0; //Order Status
	protected static int currentBill = 0;
	protected static int totalBill = 0;
	
	public abstract void displayOrder();
	public abstract void displayBill();
	
	public static void defaultBill()
	{
		System.out.println("No Items Selected :: Amount 0") ;
	}
}