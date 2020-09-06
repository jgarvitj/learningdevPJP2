/**
 * 
 */
package dateTimeCalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import databaseManagement.FileOperations;
import inputOutput.CustomScanner;
import inputOutput.History;

/**
 * @author Garvit Jain
 *
 */

@Component
class DateTimeInstance implements Runnable {

	@Autowired
	private AboutToday today;

	@Autowired
	private GoTo goTo;

	@Autowired
	private Translator translator;

	private boolean checkChoice(char choice) {
		if (choice == 'a' || choice == 'h' || choice == 'c' || choice == 'p' || choice == 'i') {
			return true;
		}
		return false;
	}

	private void serviceProvider(char choice) throws InterruptedException {
		if (choice == 'a') {
//			today = new AboutToday();
			Thread todayThread = new Thread(today);
			todayThread.start();
			todayThread.join();
		}
		if (choice == 'c') {
//			goTo = new GoTo();
			Thread goToThread = new Thread(goTo);
			goToThread.start();
			goToThread.join();
		}
		if (choice == 'h') {
			History.getSessionHistory();
		}
		if (choice == 'p') {
//			translator = new Translator();
			Thread tThread = new Thread(translator);
			tThread.start();
			tThread.join();
		}
		if (choice == 'i') {
			FileOperations.operateFileRequest();
		}
	}

	public void run() {
		System.out.println("Date Time Calculator");
		System.out.println("Press a to know about today");
		System.out.println("Press h to check history of operations in this session");
		System.out.println("Press c to calculate date");
		System.out.println("Press i to take input from file. (Paste the file in Data folder with the name input.csv)");
		System.out.println("Press p to go to a date by entering phrases");
		System.out.println("Choose operation");

		try {
			char choice = CustomScanner.sc.findInLine(".").charAt(0);
			CustomScanner.sc.nextLine();
			if (checkChoice(choice)) {
				serviceProvider(choice);
			}
		} catch (Exception NoSuchElementException) {
			System.out.println("Failed to allocate resources for scanner");
			NoSuchElementException.printStackTrace();
		}
	}
}
