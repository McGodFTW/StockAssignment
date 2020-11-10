package User;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;



public class UserMenu {
	
	//Method to print out method  
	public static void userMenu() throws IOException {
		
		NetWorth n = new NetWorth();
		BuyMenu b = new BuyMenu();
		boolean loop = true;
		int choice;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome Harish! What would you like to do?:\n");
		
		
		do {
			
			System.out.println("1. Buy Stocks\n2. Sell Stocks\n3. Net Worth\n4. Main Menu\n");
			
			try {
				
				choice = input.nextInt();
				
				switch(choice) {
				
				case 1:
					
					b.buyMenu();
					loop = false;
					break;
				case 2:
					SellMenu.sellMenu();
					loop = false;
					break;
				case 3:
					n.netWorth();
					loop = false;
					break;
				case 4:
					InvestmentPortfolio.mainMenu();
					loop = false;
					break;
				default:
					System.out.println("ERROR >> Invalid Input\n");
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
