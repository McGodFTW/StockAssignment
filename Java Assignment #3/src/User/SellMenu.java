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

public class SellMenu extends AccountNumbers {
	
	
	
	public static void sellMenu() throws IOException {
		
		//Create the objects
		TSLA t = new TSLA();
		AMZN a = new AMZN();
		NVDA n = new NVDA();
		AMD am = new AMD();
		AAPL aa = new AAPL();
		TD td = new TD();
		KO ko = new KO();
		ENB enb = new ENB();
		APHA apha = new APHA();
		BTC btc = new BTC();
		
		//Create scanner object and variable
		boolean loop = true;
		Scanner input = new Scanner(System.in);
		//Ask the user what stock they would like to sell
		System.out.println("What stock would you like to sell:\n");
		
		int choice;
		
			//Do while the input is invalid
			do {
				
				System.out.println("1. Apple (AAPL)\n2. AMD (AMD)\n3. Amazon (AMZN)\n4. Aphria (APHA)\n5. Bitcoin (BTC)\n6. Enbridge (ENB)\n7. Coco-Cola (KO)\n8. Nvidia (NVDA)\n9. Toronto-Dominion (TD)\n10. Tesla (TSLA)\n11. User Menu\n");
				
				//Make sure input is a valid int
				try {
					
					choice = input.nextInt();
					loop = false;
					switch(choice) {
					
					case 1:
						aa.sell();
						loop = false;
						break;
					case 2:
						am.sell();
						loop = false;
						break;
					case 3:
						a.sell();
						break;
					case 4:
						apha.sell();
						break;
					case 5:
						btc.sell();
						break;
					case 6:
						enb.sell();
						break;
					case 7:
						ko.sell();
						break;
					case 8:
						n.sell();
						break;
					case 9:
						td.sell();
						break;
					case 10:
						t.sell();
						break;
					case 11:
						UserMenu.userMenu();
						break;
					default:
						System.out.println("ERROR >> Invalid Input\n");
						loop = true;
						break;
						
				
					}
					
				}catch(InputMismatchException e) {
					
					System.out.println("ERROR >> Invalid Input\n");
					String flush = input.next();
					
				}
				
			} while(loop);

		
	}

}
