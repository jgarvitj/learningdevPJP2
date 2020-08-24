/**
 * 
 */
package incomeReporter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Garvit Jain
 *
 */
public class ProcessRecords {
	
	private static HashMap<String, Double> currencyToUSD = new HashMap <String, Double>();
	
	public static void processRecords(ArrayList<Record> records) {
		
		currencyToUSD.put("USD", 1.0);
		currencyToUSD.put("INR", 66.0);
		currencyToUSD.put("GBP", 0.67);
		currencyToUSD.put("SGD", 1.5);
		currencyToUSD.put("HKD", 8.0);
	
		
		for(Record r : records) {
			try {
				
				r.setAmountInUSD(r.getAmount() / currencyToUSD.get(r.getCurrency()));
			} catch (Exception e) {
				System.out.println("Record corrupted" + r.getName());
				r.setAmountInUSD(-1.0);
				e.printStackTrace();
			}
		}
		
		return;
		
	}
}
