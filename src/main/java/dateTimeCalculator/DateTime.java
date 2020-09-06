/**
 * 
 */
package dateTimeCalculator;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import inputOutput.CustomScanner;
import inputOutput.Record;
import language.Language;

/**
 * @author Garvit Jain
 *
 */

@Component
public class DateTime {

	@Autowired
	private DateTimeInstance operation;

	private void operationRunner() {
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

//		operation = new DateTimeInstance();
		Thread opThread = new Thread(operation);
		opThread.start();
		try {

			opThread.join();

			System.out.println("Press e to exit");
			System.out.println("Press any key for another DateTime calculation");

			char choice = CustomScanner.sc.findInLine(".").charAt(0);
			CustomScanner.sc.nextLine();

			if (choice != 'e') {
				operationRunner();
			}
		} catch (InterruptedException e) {
			System.out.println("Date Time Instance failed due to Interrupted Ex");
			e.printStackTrace();
		}
	}

	public void calcRunner() {

		// Persist and record session operations
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHms");
		String fileName = date.format(formatter);

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
		operationRunner();
	}

}
