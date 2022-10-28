package voucher ;

import java.util.Scanner;

public class Voucher
{
	String voucherCode = new String("Discount10") ; //10% Voucher
	
	public int voCd(int bill) 
	{
		Scanner vCd = new Scanner(System.in) ;
		
		System.out.print("Enter The Voucher Code :: ") ;
		String uCd = vCd.nextLine() ;
	
		if((uCd.equals(voucherCode)) || (uCd.equals(voucherCode.toUpperCase())) || (uCd.equals(voucherCode.toLowerCase())))
		{
			int discount ;
			discount = ( ( (bill * 10) / 100 ) ) ;
			bill -= discount ;
			System.out.println("Discount: "+ discount+"\n") ;
			return bill ;
		}
		else
		{
			System.out.println("No Voucher\n") ;
			return bill ;
		}
	}
}
