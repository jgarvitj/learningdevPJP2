import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * gets sorted matrix of transactions (sorted by clientId, Type, Date, Priority)
 * parses over transactions one client at a time and 
 * calls TransactionFeeCalculator's calculateFee on each transaction
 * maintains a history of each transaction to track intraday transactions
 * returns a matrix of transactions
 */

/**
 * @author Garvit Jain
 *
 */
public class ProcessTransactions {
	
	private static HashMap <String, Transaction> history = new HashMap<String, Transaction>();
	
	public static void processTransactions (ArrayList<Transaction> transactions) {
		
		Iterator<Transaction> it = transactions.iterator();
		
		while(it.hasNext()) {
			Transaction t1 = (Transaction)it.next();
			Transaction t2 = t1;
			
			do {
				if(it.hasNext()) {
					t2 = (Transaction)it.next();
				}
				String tKey = t2.getSecurityId() + t2.getDate();
				
				if(history.containsKey(tKey)) {
					Transaction tComp = history.get(tKey);
					
					if(tComp.getType().equalsIgnoreCase(t2.getType())) {
						TransactionFeeCalculator.calculateFee(t2, true);
					}
					
					else {
						//check if type is opposite
						TransactionFeeCalculator.calculateFee(t2, false);
						TransactionFeeCalculator.calculateFee(tComp, false);
					}	
				}
				
				else {
					TransactionFeeCalculator.calculateFee(t2, true);
					
					history.put(tKey, t2);
				}
				
			}while(t1.getClientId().equals(t2.getClientId()) && it.hasNext());
			
			//for each client history is updated
			history.clear();
		}
		
		
		
	}
}
