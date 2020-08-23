import java.io.IOException;
import java.util.ArrayList;

/**
 * Main class which handles the control flow
 * Control flow:
 * Loader loads an ArrayList transactions
 * sort all transactions
 * Process Transactions
 * Generate Summary
 */

/**
 * @author Garvit Jain
 *
 */
public class FeeCalculator {

	public static void main(String[] args) throws IOException {
		
		String filePath = "C:\\Users\\user\\eclipse-workspace\\ProcessingFee\\src\\input.csv";	
		
		ArrayList<Transaction> transactions = Loader.readCSV(filePath);
		
		
		Sorter.sortTransactions(transactions);
		
		ProcessTransactions.processTransactions(transactions);
		
		Summary.generateSummary(transactions);
		System.out.println("Success");
		
		return;

	}

}
