import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Load's the transaction data and return an ArrayList of transactions
 */

/**
 * @author Garvit Jain
 *
 */
public class Loader {
	public static ArrayList <Transaction> readCSV(String filePath) throws IOException {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line = br.readLine();
			char y = 'Y';
			while(line != null) {
				String[] t = line.split(",");
				Transaction transaction = new Transaction();
				transaction.setClientId(t[2]);
				transaction.setSecurityId(t[3]);
				transaction.setType(t[4]);
				transaction.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(t[5]));
				
				if(t[7].charAt(0) == y) {
					transaction.setPriority(true);
				}
				else {
					transaction.setPriority(false);
				}
				line = br.readLine();
				
				transactions.add(transaction);
			}
		}
		catch(Exception e) {
			System.out.println("Loader failed");
			e.printStackTrace();
		}
		
		return transactions;
	}

}
