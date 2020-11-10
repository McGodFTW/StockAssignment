//Name: Harish
//Date 11/10/2020
//Purpose: Create a program which allows for me to purchase and or sell stocks, view my net-worth, and view my transactions

package User;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Map.Entry;

import Login.LoginMain;
import Stock.Stocks;

public class InvestmentPortfolio {
	
	public static void main(String[] args) throws IOException  {
		
		//Call the main menu function
		mainMenu();
		
	}
	
	//Method to print main menu
	public static void mainMenu() throws IOException {
		
		int choice = 0;
		boolean loop = true;
		
		Scanner input = new Scanner(System.in);
		
		
		//Ask the user what they want to access
		do {
			System.out.println("--- Harish's Investment Portfolio ---");
			System.out.println("1. Login\n2. Show Transaction\n3. Exit");
			
			//Make sure that the user's input is a valid int
			try {
				
				//Ask the user for the int
				choice = input.nextInt();
				//Do an action based off input
				switch(choice) {
				//Call Login Page
				case 1:
					LoginMain.checkCreds();
					loop = false;
					break;
				//gte Transaction Hist
				case 2:
					
					//Check is the hashmap has value
					if(Stocks.TID.size() == 0) {
						
						System.out.println("No Transaction History!\n");
						
					} else {
						
						System.out.println("\n-=+ Transaction History +=-");
						for (Entry<String, String> getInfo : Stocks.TID.entrySet()) {
							
							String date = getInfo.getKey();
							String pInfo = getInfo.getValue();
							
							System.out.println(date + " >> " + pInfo);
							
						}
						System.out.println("\n-=+                     +=-\n");
						
					}
					
					
					break;
				//Exit
				case 3:
					System.exit(0);
					break;
				default:
					System.out.println("ERROR >> Invalid Input");
					loop = true;
					break;
					
			
				}
				
			}catch(InputMismatchException e) {
				
				System.out.println("ERROR >> Invalid Input");
				String flush = input.next();
				
			}
			
		}while(loop);
		
		
	}

}
