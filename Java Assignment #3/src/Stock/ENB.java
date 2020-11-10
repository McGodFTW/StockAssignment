package Stock;

import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Map.Entry;

import User.UserMenu;

public class ENB extends Stocks implements TID {	
	
	//Create objects
	public NumberFormat cashFormat = NumberFormat.getCurrencyInstance();
	Scanner input = new Scanner(System.in);
	
	//Declare variables
	public static double cost;
	boolean loop = true;
	static int quantity;
	public static String type;
	
	//Default Constructor
	public ENB() {
		
	}
	
	//Overrided Constructor
	public ENB(int q) {
		
		quantity = q;
		
	}
	
	//Method ran when user buys this stock
	public void buy() throws IOException {

		String choice = "";
		
		super.setPrice("ENB");
		
		//Ask user how much stocks they want to buy and ensure it's a valid number and that they can afford it
		do {

			System.out.println("How much Enbridge stocks are you going to buy?:");
			//Make sure input is a valid int
			try {

				do {
					quantity = input.nextInt();
					if(quantity <=  0) {
						
						System.out.println("ERROR >> Enter a number higher than 1!");
						loop = true;
						
					} else {
						
						loop = false;
						
					}
					
				} while(loop);

			} catch (InputMismatchException e) {

				System.out.println("ERROR >> Invalid Input (Must be Integers)");
				String flush = input.next();
				loop = true;

			}

		} while (loop);
		
		//Set price of stocks
		cost = quantity * super.getPrice();
		
		//Ask user if they are sure they want to purchase this stock
		System.out.println("Are you sure you would like to purchase " + quantity + "x " + super.getStock().toUpperCase() + " stocks for " + cashFormat.format(cost) + "? (Y/N)");
		choice = input.next();
		
		//Do an action based off their response
		switch (choice.toLowerCase()) {

		case "y":
			//Make sure theyt have enough money to purchase the stock
			if(AccountNumbers.balance > cost) {
				
				AccountNumbers.balance -= cost;
				AccountNumbers.ENBShares += quantity;
				type = "Bought: ";
				transaction();
				UserMenu.userMenu();
				
			} else {
				
				System.out.println("ERROR >> Insufficient Balance!\n");
				UserMenu.userMenu();
				
			}
			
			break;
		//Cancel Purchase
		case "n":
			System.out.println("Purchase Canceled!\n");
			UserMenu.userMenu();
			break;
		//Cancel program is input is invalid
		default:
			System.out.println("ERROR >> Invalid Output! Canceling purchase!\n");
			UserMenu.userMenu();
			break;
		}

	}
	
	//Method ran when user tries to sell stock
	public void sell() throws IOException {
		
		String choice = "";
		
		super.setPrice("ENB");
		//Ask user how much stocks they want to sell and ensure it's a valid number 
		do {

			System.out.println("How much Enbridge stocks are you going to sell?:");
			
			//Make sure that the input is an int
			try {
				do {
					quantity = input.nextInt();
					if(quantity <=  0) {
					
					System.out.println("ERROR >> Enter a number higher than 1!");
					loop = true;
					
					} else {
					
					loop = false;
					
					}
				
				} while(loop);

			} catch (InputMismatchException e) {

				System.out.println("ERROR >> Invalid Input (Must be Integers)");
				String flush = input.next();
				loop = true;

			}

		} while (loop);
		
		//Calculate Cost price
		cost = quantity * super.getPrice();
		
		//Ask the user if they are sure they would like to purchase the stock
		System.out.println("Are you sure you would like to sell " + quantity + "x " + super.getStock().toUpperCase() + " stocks for " + cashFormat.format(cost) + "? (Y/N)");
		choice = input.next();
		
		//Do an action based off their response
		switch (choice.toLowerCase()) {
		
		//Make sure they have the stocks they want to sell
		case "y":

			if(AccountNumbers.ENBShares >= quantity) {
				
				AccountNumbers.balance += cost;
				AccountNumbers.ENBShares--;
				AccountNumbers.ownedStocks--;
				type = "Sold: ";
				transaction();
				UserMenu.userMenu();
				
			} else {
				
				System.out.println("ERROR >> Insufficient Stocks!\n");
				UserMenu.userMenu();
				
			}
			
			break;
		//Cancel purchase
		case "n":
			System.out.println("Purchase Canceled!\n");
			UserMenu.userMenu();
			break;
		//If option isn't listed cancel purchase
		default:
			System.out.println("ERROR >> Invalid Output! Canceling purchase!\n");
			UserMenu.userMenu();
			break;
		}
		

	}
	
	//Implement the method used to get information about this transaction
	public HashMap<String, String> transaction() {
		//Print Deafult action message
		System.out.println(actionMessage);
		//Get Date
		LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //Declare Variables
        String dateFormatted = date.format(dateFormatter);
        String pInfo = type + quantity + "x " + stock.toUpperCase() + " shares at " + cashFormat.format(cost) + " per share";
		//Print out the transaction information
        System.out.println(pInfo + " >> " + dateFormatted + "\n");
        //Put the transaction information in a hashmap
        TID.put(dateFormatted, pInfo);
		
		
		return AccountNumbers.TID;
		
	}


}
