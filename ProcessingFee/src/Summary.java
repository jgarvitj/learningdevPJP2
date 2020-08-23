import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Generate and prints Summary of transaction fees
 */

/**
 * @author Garvit Jain
 *
 */

public class Summary {
	@SuppressWarnings("deprecation")
	public static void generateSummary(ArrayList<Transaction> transactions) {
		FileWriter fw;
		try {
			fw = new FileWriter("C:\\Users\\user\\eclipse-workspace\\ProcessingFee\\src\\output.csv");
			for(Transaction transaction : transactions) {
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(transaction.getClientId());
				stringBuilder.append(",");
				stringBuilder.append(transaction.getType());
				stringBuilder.append(",");
				stringBuilder.append(transaction.getDate().getDate());
				stringBuilder.append(transaction.getDate().getMonth());
				stringBuilder.append(transaction.getDate().getYear());
				stringBuilder.append(",");
				stringBuilder.append(transaction.isPriority());
				stringBuilder.append(",");
				stringBuilder.append(transaction.getFee());
				stringBuilder.append("\n");
				fw.write(stringBuilder.toString());
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}
}
