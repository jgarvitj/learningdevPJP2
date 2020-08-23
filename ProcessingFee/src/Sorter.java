import java.util.ArrayList;
import java.util.Collections;

/**
 * overrides the compare method
 */

/**
 * @author Garvit Jain
 *
 */


public class Sorter {
	 
	public static void sortTransactions(ArrayList<Transaction> transactions) {
		Collections.sort(transactions, Transaction.CustomComparator);
		
	}
}
