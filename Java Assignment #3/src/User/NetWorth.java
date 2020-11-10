package User;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import Stock.AccountNumbers;
import Stock.Stocks;

public class NetWorth extends AccountNumbers {
	
	//Object for the buy menu
	BuyMenu b = new BuyMenu();
	
	//Method to calc networth
	public void netWorth() throws IOException {
		
		//Declare objects and variables
		double total = 0;
		NumberFormat cashFormat = NumberFormat.getCurrencyInstance();
		String stock;
		
		//Chart Title
		System.out.println("Stock Name\tValue of Stock\t\tShares");
	
		try {
			
			//Print out all stocks and the owned amount/value in the stock
			System.out.println("AAPL" + "\t\t" + cashFormat.format((getValue("aapl") * AccountNumbers.AAPLShares)) + "\t\t\t" + AccountNumbers.AAPLShares);
			total += (getValue("aapl") * AccountNumbers.AAPLShares);
			System.out.println("AMD" + "\t\t" + cashFormat.format((getValue("amd") * AccountNumbers.AMDShares)) + "\t\t\t" + AccountNumbers.AMDShares);
			total += (getValue("amd") * AccountNumbers.AMDShares);
			System.out.println("AMZN" + "\t\t" + cashFormat.format((getValue("amzn") * AccountNumbers.AMZNShares)) + "\t\t" + AccountNumbers.AMZNShares);
			total += (getValue("amzn") * AccountNumbers.AMZNShares);
			System.out.println("APHA" + "\t\t" + cashFormat.format((getValue("apha") * AccountNumbers.APHAShares)) + "\t\t\t" + AccountNumbers.APHAShares);
			total += (getValue("apha") * AccountNumbers.APHAShares);
			System.out.println("BTC" + "\t\t" + cashFormat.format((getValue("btc-cad") * AccountNumbers.BTC)) + "\t\t" + AccountNumbers.BTC);
			total += (getValue("BTC-CAD") * AccountNumbers.BTC);
			System.out.println("ENB" + "\t\t" + cashFormat.format((getValue("enb") * AccountNumbers.ENBShares)) + "\t\t\t" + AccountNumbers.ENBShares);
			total += (getValue("ENB") * AccountNumbers.ENBShares);
			System.out.println("KO" + "\t\t" + cashFormat.format((getValue("ko") * AccountNumbers.KOShares)) + "\t\t\t" + AccountNumbers.KOShares);
			total += (getValue("KO") * AccountNumbers.KOShares);
			System.out.println("NVDA" + "\t\t" + cashFormat.format((getValue("nvda") * AccountNumbers.NVDAShares)) + "\t\t\t" + AccountNumbers.NVDAShares);
			total += (getValue("NVDA") * AccountNumbers.NVDAShares);
			System.out.println("TD" + "\t\t" + cashFormat.format((getValue("td") * AccountNumbers.TDShares)) + "\t\t\t" + AccountNumbers.TDShares);
			total += (getValue("TD") * AccountNumbers.TDShares);
			System.out.println("TSLA" + "\t\t" + cashFormat.format((getValue("tsla") * AccountNumbers.TSLAShares)) + "\t\t\t" + AccountNumbers.TSLAShares);
			total += (getValue("TSLA") * AccountNumbers.TSLAShares);
			
			System.out.println("Bank Balance: " + cashFormat.format(AccountNumbers.balance));
			
			//Add your bank balance to it
			total += AccountNumbers.balance;
			
			
		} catch(Exception e) {
			
			System.out.println(e);
			
		}
			
		//Print out total
		System.out.println("Total: " + cashFormat.format(total));
		System.out.println();
		
		//Return to user menu
		UserMenu.userMenu();
		
		
	}
	
	//Method to parse the value if the stock from the web
	public static double getValue(String stock) throws IOException {
		
		String fieldToFind = "Open";
		double stockPrice;

    	Document doc = Jsoup.connect("https://finance.yahoo.com/quote/" + stock).get();

    	//get the root element
    	Element quoteSummary = doc.getElementById("quote-summary");
    	String value = quoteSummary.getElementsByTag("tr")
    	                           //iterate over the table rows inside
    	                           .stream()
    	                           //find the row with the first td/span containing the label
    	                           .filter(tr -> fieldToFind.equals(tr.getElementsByTag("span").first().text()))
    	                           //get the 2nd td and it's span element
    	                           .map(tr -> tr.getElementsByTag("td")
    	                                        .first()
    	                                        .nextElementSibling()
    	                                        .getElementsByTag("span")
    	                                        .first()
    	                                        .text())
    	                           //get the first match
    	                           .findFirst()
    	                           .orElseThrow(NoSuchElementException::new);
    	String val = value.replace(",", "");
    	return stockPrice =  Double.parseDouble(val);
		
	}

}
