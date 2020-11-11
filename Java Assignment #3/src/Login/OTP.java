package Login;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.SplittableRandom;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import User.UserMenu;

public class OTP {
	
	static String otp;
	
	//Method to generate a random otp
	public static String generateOTP() {
		
		//Delcare Random Number Generator
		SplittableRandom splittableRandom = new SplittableRandom();
		//Declare String Builder
		StringBuilder generatedOTP = new StringBuilder();
		
		//Create for loop to create OTP
		for (int i = 0; i < 6; i++) {

		    int randomNumber = splittableRandom.nextInt(0, 9);
		    generatedOTP.append(randomNumber);
		    
		}
		
		//Return OTP
		return generatedOTP.toString();
		
	}
	
	//Send user the email with the OTP
	public static void sendOTP() throws IOException {
		
		//The number from the method above save it to the otp var
		otp = generateOTP();
		
		String toEmail = LoginMain.getEmail();
		
		//Setup login info
		String email = "torontofiredepartment234@gmail.com";
		String password = "thisisapassword";
		String host = "smtp.gmail.com";
		
		//Declare properties object
		Properties smtpConfig = System.getProperties();
		
		//Setup the config for the properties
		smtpConfig.put("mail.smtp.starttls.enable", "true");
		smtpConfig.put("mail.smtp.user", email);
		smtpConfig.put("mail.smtp.password", password);
		smtpConfig.put("mail.smtp.host", host);
		smtpConfig.put("mail.smtp.port", "587");
		smtpConfig.put("mail.smtp.auth", "true");
		
		//Create an emaail session with the config given
		Session createSession = Session.getDefaultInstance(smtpConfig);
		
		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(createSession);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(email));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

			// Set Subject: header field
			message.setSubject("Investment Portfolio OTP Email!");

			// Now set the actual message
			message.setText(otp);

			// Send message
			Transport transport = createSession.getTransport("smtp");
			transport.connect(host, email, password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			System.out.println("OTP Sent!");
			checkOTP();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void checkOTP() throws IOException {
		
		//Declare Objects
		Scanner input = new Scanner(System.in);
		
		//Declare Variables
		int chances = 3;
		String enteredOTP;
		
		do {
			
			//Ask user to input OTP
			System.out.println("Enter your one-time password that was emailed to you!");
			enteredOTP = input.next();
			
			//Check if OTP matches
			if(otp.equalsIgnoreCase(enteredOTP)) {
				
				System.out.println("SUCCESSFUL >> You are now logged in!");
				UserMenu.userMenu();
				break;
				
				
			} else {
				
				System.out.println("ERROR >> Your password was incorrect! You have " + chances + " more tries left");
				chances--;
				
			}
			
		}while(chances > 0);
		
		if(chances == 0) {
			
			System.out.println("Ran out of tries... Exiting Program.");
			System.exit(0);
			
		} else {
		
			
		}
		
		
	}



}
