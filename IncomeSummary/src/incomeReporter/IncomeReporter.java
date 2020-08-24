/**
 * 
 */
package incomeReporter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Garvit Jain
 *
 */
public class IncomeReporter {

	/**
	 * @param records 
	 * @param args
	 */
	
	public static void publishReport(String inputFile, String outputFile) throws IOException {
		
		
		
		//call loader
		ArrayList<Record> records = Loader.readCSV(inputFile);
		
		//call processReport
		ProcessRecords.processRecords(records);
		
		//sort records
		Collections.sort(records, Record.CustomComparator);
		
		//write Report
		WriteReport.writeReport(records, outputFile);
	}
	
	public static void main(String[] args) throws IOException {
		
		String inputFile = "C:\\Users\\user\\eclipse-workspace\\IncomeSummary\\src\\input.csv";
		String outputFile = "C:\\Users\\user\\eclipse-workspace\\IncomeSummary\\src\\output.csv";
		publishReport(inputFile, outputFile);
		return;
	}

}
