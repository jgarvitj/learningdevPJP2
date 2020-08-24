/**
 * 
 */
package incomeReporter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Garvit Jain
 *
 */
public class Loader {
	public static ArrayList <Record> readCSV(String filePath) throws IOException {
		ArrayList<Record> records = new ArrayList<Record>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line = br.readLine();
			while(line != null) {
				String[] t = line.split(",");
				Record record = new Record();
				
				String city = t[0];
				String country = new String(t[1]);
				if(country.equalsIgnoreCase("M") || country.equalsIgnoreCase("F")) {
					record.setName(city);
					record.setGender(t[1]);
					record.setCurrency(t[2]);
					record.setAmount(Double.parseDouble(t[3]));
				}
				else {
					record.setName(country);
					record.setGender(t[2]);
					record.setCurrency(t[3]);
					record.setAmount(Double.parseDouble(t[4]));
				}
				
				
				line = br.readLine();
				
				records.add(record);
			}
		}
		catch(Exception e) {
			System.out.println("Loader failed");
			e.printStackTrace();
		}
		
		return records;
	}
}
