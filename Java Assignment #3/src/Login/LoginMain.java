package Login;
import java.io.IOException;
import java.util.Scanner;
import java.util.SplittableRandom;

import User.UserMenu;

public class LoginMain {
	
	public static void checkCreds() throws IOException {
		
		//Create Scanner Object
		Scanner input = new Scanner(System.in);
		
		//Declare Variables
		boolean loop = true;
		
		String checkUName, checkPW;
		
		String uName = "1";
		String password = "1";
	
		do {
			
			//Store username
			System.out.println("Username:");
			checkUName = input.next();
			
			//Store password
			System.out.println("Password:");
			checkPW = input.next();
			
			//Check if the username and password is right
			if(uName.equals(checkUName) && password.equals(checkPW)) {
				
				OTP.sendOTP();
				loop = false;
				//Call 2FA/OTP Method
				
				
				
			} else {
				
				System.out.println("ERROR >> Invalid Password!");
				loop = true;
				
			}
			
		} while(loop);
		
		
	}
	
	public static String getEmail() {
		
		//Declare Scanner Object
		Scanner input = new Scanner(System.in);
		
		//Declare Variables
		String email = "";
		boolean loop = true;
		
		//Ask user for an email
		do {
			
			System.out.println("What is your email");
			email = input.next();
			if(email.contains("@") && email.contains(".ca") || email.contains(".com")) {
				
				loop = false;
				
				
			} else {
				
				System.out.println("ERROR >> Invalid Input");
				loop = true;
				
			}
			
		} while(loop);
		
		//Return email 
		return email;
		
	}
	
	

}
