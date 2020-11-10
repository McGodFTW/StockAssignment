package User;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import Stock.AAPL;
import Stock.AMD;
import Stock.AMZN;
import Stock.APHA;
import Stock.AccountNumbers;
import Stock.BTC;
import Stock.ENB;
import Stock.KO;
import Stock.NVDA;
import Stock.Stocks;
import Stock.TD;
import Stock.TSLA;

public class BuyMenu extends AccountNumbers {
	
	//Create Array of Objects
	Stocks s[] = new Stocks[6];
	
	//Method to print out the buy menu and it's options
	public void buyMenu() throws IOException {
		//Create Variables and scanner object
		boolean loop = true;
		Scanner input = new Scanner(System.in);
		
		//Ask the user what stock they would like to sell
		System.out.println("What stock would you like to buy:\n");
		
		int choice;
		
		//Do while owned stock is less than 5 (5 is cap)
		do {
			
			//Do while input is invalid
			do {
				
				System.out.println("1. Apple (AAPL)\n2. AMD (AMD)\n3. Amazon (AMZN)\n4. Aphria (APHA)\n5. Bitcoin (BTC)\n6. Enbridge (ENB)\n7. Coco-Cola (KO)\n8. Nvidia (NVDA)\n9. Toronto-Dominion (TD)\n10. Tesla (TSLA)\n11. User Menu\n");
				
				//Make sure the input is a valid int
				try {
					
					//Get the user input
					choice = input.nextInt();
					loop = false;
					//Do an action based off the user input
					switch(choice) {
					
					case 1:
						
						if(ownedStocks > 5) {
							
							System.out.println("ERROR >> You've hit max amount of ownable stocks!\n");
							UserMenu.userMenu();
							
						} else {
							
							ownedStocks++;
							
							s[ownedStocks] = new AAPL();
							s[ownedStocks].buy();
							
							
						}
						
						loop = false;
						break;
						
					case 2:
						
						if(ownedStocks > 5) {
							
							System.out.println("ERROR >> You've hit max amount of ownable stocks!\n");
							UserMenu.userMenu();
							
						} else {
							
							ownedStocks++;
							
							s[ownedStocks] = new AMD();
							s[ownedStocks].buy();
							
						}
						
						loop = false;
						break;
			
					case 3:
						
						if(ownedStocks > 5) {
							
							System.out.println("ERROR >> You've hit max amount of ownable stocks!\n");
							UserMenu.userMenu();
							
						} else {
							
							ownedStocks++;
							s[ownedStocks] = new AMZN();
							s[ownedStocks].buy();
							
						}
						
						loop = false;
						break;
			
					case 4:
						
						if(ownedStocks > 5) {
							
							System.out.println("ERROR >> You've hit max amount of ownable stocks!\n");
							UserMenu.userMenu();
							
						} else {
							
							ownedStocks++;
							
							s[ownedStocks] = new APHA();
							s[ownedStocks].buy();
							
						}
						
						loop = false;
						break;
				
					case 5:
						
						if(ownedStocks > 5) {
							
							System.out.println("ERROR >> You've hit max amount of ownable stocks!\n");
							UserMenu.userMenu();
							
						} else {
							
							ownedStocks++;
							
							s[ownedStocks] = new BTC();
							s[ownedStocks].buy();
						
							
						}
						
						loop = false;
						break;
						
					case 6:
						
						if(ownedStocks > 5) {
							
							System.out.println("ERROR >> You've hit max amount of ownable stocks!\n");
							UserMenu.userMenu();
							
						} else {
							
							ownedStocks++;
							
							s[ownedStocks] = new ENB();
							s[ownedStocks].buy();
						
							
						}
						
						loop = false;
						break;
						
					case 7:
						
						if(ownedStocks > 5) {
							
							System.out.println("ERROR >> You've hit max amount of ownable stocks!\n");
							UserMenu.userMenu();
							
						} else {
							
							ownedStocks++;
							
							s[ownedStocks] = new KO();
							s[ownedStocks].buy();
						
							
						}
						
						loop = false;
						break;
						
					case 8:
						
						if(ownedStocks > 5) {
							
							System.out.println("ERROR >> You've hit max amount of ownable stocks!\n");
							UserMenu.userMenu();
							
						} else {
							
							ownedStocks++;
							
							s[ownedStocks] = new NVDA();
							s[ownedStocks].buy();
						
							
						}
						
						
						loop = false;
						break;
					case 9:
						
						if(ownedStocks > 5) {
							
							System.out.println("ERROR >> You've hit max amount of ownable stocks!\n");
							UserMenu.userMenu();
							
						} else {
							
							ownedStocks++;
							
							s[ownedStocks] = new TD();
							s[ownedStocks].buy();
						
							
						}
	
						loop = false;
						break;
						
					case 10:
						
						if(ownedStocks > 5) {
							
							System.out.println("ERROR >> You've hit max amount of ownable stocks!\n");
							UserMenu.userMenu();
							
						} else {
							
							ownedStocks++;
							
							s[ownedStocks] = new TSLA();
							s[ownedStocks].buy();
						
							
						}
						
						loop = false;
						break;
						
					case 11:
						UserMenu.userMenu();
						break;
					default:
						System.out.println("ERROR >> Invalid Input\n");
						loop = true;
						break;
						
				
					}
					
					
					System.out.println("STEP BRO UR HURTING ME PLS STOP");
					
				}catch(InputMismatchException e) {
					
					System.out.println("ERROR >> Invalid Input\n");
					String flush = input.next();
					
				}
				
				
				
			} while(loop);
			
		} while(ownedStocks < 5);
		
	}

}
