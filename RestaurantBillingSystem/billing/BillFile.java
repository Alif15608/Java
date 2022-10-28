package billing ;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BillFile
{
	private File file[]=new File[2];//to create a File
	private FileWriter writer;		//to write in a file
	private FileReader reader;		//to read from a file
	private BufferedReader bfr;		//to read file content
	
	public void writeInFile(String s, int Q, int P) //s=item name || Q=item quantity || P=price)
	{
		/*
			creating a file and writing in it genarates compile time exceptions (Checked Exceptions).
			So, we need to write the whole thing in try-catch.
		*/
		try
		{
			file[0] = new File("C:/Users/ASUS/Downloads/3rd Semester/Java/Project/RestaurantBillingSystem/Database/OrderList/OrderHistory.txt");	//Declaring a file named named History.txt for creating.
			file[0].createNewFile();									//If the file does not exists, creates and opens the file. else, just opens the file
			writer = new FileWriter(file[0], true);						//creating the writer object to write in the file.
			writer.write(s+"\r"+"\n"+"Qx"+Q+"\t"+"Tk. "+P+"\r"+"\n");	//writing a string s in the file. the "\r" and "\n" has been concat to go to a newline.
			writer.flush();												//After writing, we need to flush to indicate that we have completed writing.
			writer.close();												//After flushing, we need to close the file to save our writing.
		
			file[1] = new File("C:/Users/ASUS/Downloads/3rd Semester/Java/Project/RestaurantBillingSystem/Database/OrderList/CurrentOrder.txt");
			file[1].createNewFile();
			writer = new FileWriter(file[1], true);
			writer.write(s+"\r"+"\n"+"Qx"+Q+"\t"+"Tk. "+P+"\r"+"\n");
			writer.flush();									
			writer.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	public void readFromFile()
	{
		/*
			reading from a file genarates compile time exceptions (Checked Exceptions).
			So, we need to write the whole thing in try-catch.
		*/
		
		try
		{
			reader = new FileReader(file[1]);		//creating the reader object to read from a file.
			bfr = new BufferedReader(reader);		//creating the BufferedReader object using the reader object to read the file content.
			String text="", temp;					//declaring two string variables to read the file content and storing them.
			
			while((temp=bfr.readLine())!=null)		//reading one line from the file, storing it in the variable temp and checking whether it is null or not. It will be null at the end of reading from the file.
			{
				text=text+temp+"\n"+"\r";			//storing the temp string in text by concating it with text and "\n" and "\r" is used to go to a newline.
			}
			
			System.out.print(text);   				//printing the whole string in console.
			reader.close();							//closing the file.
			
			//Emptying The Current File
			file[1] = new File("C:/Users/ASUS/Downloads/3rd Semester/Java/Project/RestaurantBillingSystem/Database/OrderList/CurrentOrder.txt");
			file[1].createNewFile();
			writer = new FileWriter(file[1]);
			writer.flush();									
			writer.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
}