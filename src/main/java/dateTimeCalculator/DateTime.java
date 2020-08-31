/**
 * 
 */
package dateTimeCalculator;

import inputOutput.CustomScanner;
import inputOutput.History;

/**
 * @author Garvit Jain
 *
 */
public class DateTime {

	public void calcRunner() {

		DateTimeInstance operation = new DateTimeInstance();
		Thread opThread = new Thread(operation);
		opThread.start();
		try {

			opThread.join();

			System.out.println("Press e to exit");
			System.out.println("Press any key for another DateTime calculation");

			char choice = CustomScanner.sc.findInLine(".").charAt(0);
			CustomScanner.sc.nextLine();

			if (choice != 'e') {
				calcRunner();
			}
		} catch (InterruptedException e) {
			System.out.println("Date Time Instance failed due to Interrupted Ex");
			e.printStackTrace();
		}
	}

	class DateTimeInstance implements Runnable {

		private boolean checkChoice(char choice) {
			if (choice == 'a' || choice == 'h' || choice == 'c') {
				return true;
			}
			return false;
		}

		private void serviceProvider(char choice) throws InterruptedException {
			if (choice == 'a') {
				AboutToday today = new AboutToday();
				Thread todayThread = new Thread(today);
				todayThread.start();
				todayThread.join();
			}
			if (choice == 'c') {
				GoTo goTo = new GoTo();
				Thread goToThread = new Thread(goTo);
				goToThread.start();
				goToThread.join();
			}
			if (choice == 'h') {
				History.getSessionHistory();
			}
		}

		public void run() {
			System.out.println("Date Time Calculator");
			System.out.println("Press a to know about today");
			System.out.println("Press h to check history of operations in this session");
			System.out.println("Press c to calculate date");
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
}
