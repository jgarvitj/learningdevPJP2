/**
 * 
 */
package incomeReporter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Garvit Jain
 *
 */
public class WriteReport {
	
	public static void writeReport(ArrayList<Record> records, String filePath) {
		FileWriter fw;
		try {
			fw = new FileWriter(filePath);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(Record record : records) {

				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(record.getName());
				stringBuilder.append(",");
				stringBuilder.append(record.getGender());
				stringBuilder.append(",");
				stringBuilder.append(record.getAmountInUSD());
				stringBuilder.append("\n");
				bw.write(stringBuilder.toString());
				bw.newLine();
			}
			bw.close();
			System.out.println("Success");
		} catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		
		return;
	}

}
