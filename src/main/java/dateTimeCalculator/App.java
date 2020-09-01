/**
 * 
 */
package dateTimeCalculator;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import inputOutput.*;
import language.Language;

/**
 * @author Garvit Jain
 *
 */
public class App {

	public static void main(String[] args) {

		// Persist and record session operations
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHms");
		String fileName = date.format(formatter);
		// System.out.println(fileName);
		Record.setFileName(
				"C:\\Users\\user\\eclipse-workspace\\dateTimeCalculator\\Data\\SessionHistory\\" + fileName + ".csv");
		System.out.println(Record.getFileName());
		File sessionHistory = new File(Record.getFileName());
		try {
			if (sessionHistory.createNewFile()) {
				System.out.println("File created");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Language selection
		System.out.println("Press 1 for en-US");
		System.out.println("Press 2 for en-GB");
		System.out.println("Press 3 for fr");
		System.out.println("Press 4 for en-IN");

		int lt = CustomScanner.sc.nextInt();
		CustomScanner.sc.nextLine();
		String languageTag;
		if (lt == 1) {
			languageTag = "en-US";
		} else if (lt == 3) {
			languageTag = "fr";
		} else if (lt == 4) {
			languageTag = "en-IN";
		} else {
			languageTag = "en-GB";
		}
		Language.setLanguageTag(languageTag);

		// Operation for Date Time Calculator
		DateTime operation = new DateTime();
		operation.calcRunner();
		System.out.println("Exiting session");
		return;
	}
}
