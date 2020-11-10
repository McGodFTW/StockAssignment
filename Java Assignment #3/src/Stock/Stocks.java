package Stock;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.NoSuchElementException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public abstract class Stocks extends AccountNumbers {

	static String stock;
	double stockPrice;
	
	
	public void setPrice(String s) throws IOException {
		
		stock = s;
		
		
		String fieldToFiend = "Open";

    	Document doc = Jsoup.connect("https://finance.yahoo.com/quote/" + stock).get();

    	//get the root element
    	Element quoteSummary = doc.getElementById("quote-summary");
    	String value = quoteSummary.getElementsByTag("tr")
    	                           //iterate over the table rows inside
    	                           .stream()
    	                           //find the row with the first td/span containing the label
    	                           .filter(tr -> fieldToFiend.equals(tr.getElementsByTag("span").first().text()))
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
    	stockPrice =  Double.parseDouble(val);
			
	}
	
	public double getPrice() {
		
		return stockPrice;
		
	}
	
	public String getStock() {
		
		return stock;
		
	}
	
	public int getShares() {
		
		int sharesAmnt = 0;
		
		if(stock.equalsIgnoreCase("aapl")) {
			
			sharesAmnt = AAPLShares;
			
		} else if(stock.equalsIgnoreCase("AMD")) {
			
			sharesAmnt = AMDShares;
			
		} else if(stock.equalsIgnoreCase("AMZN")) {
			
			sharesAmnt = AMZNShares;
			
		} else if(stock.equalsIgnoreCase("APHA")) {
			
			sharesAmnt = APHAShares;
			
		} else if(stock.equalsIgnoreCase("BTC")) {
			
			sharesAmnt = BTC;
			
		} else if(stock.equalsIgnoreCase("ENB")) {
			
			sharesAmnt = ENBShares;
			
		} else if(stock.equalsIgnoreCase("KO")) {
			
			sharesAmnt = KOShares;
			
		} else if(stock.equalsIgnoreCase("NVDA")) {
			
			sharesAmnt = NVDAShares;
			
		} else if(stock.equalsIgnoreCase("TD")) {
			
			sharesAmnt = TDShares;
			
		} else if(stock.equalsIgnoreCase("TSLA")) {
			
			sharesAmnt = TSLAShares;
			
		}
		
		return sharesAmnt;
		
	}
	
	public abstract void buy() throws IOException;
	public abstract void sell() throws IOException;
	

}
