
/**
 * 
 */
package dateTimeCalculator;

import java.io.IOException;
import java.time.LocalDate;

import inputOutput.CustomScanner;
import inputOutput.Record;
import language.Language;

/**
 * @author Garvit Jain
 *
 */
public class Translator implements Runnable {

	private static LocalDate date = LocalDate.now();
	private static char type = 'd';
	private static int value = 2;
	private static boolean isAdd = true;

	private void convertPhrase(String phrase) {

	}

	public void run() {

		System.out.println("Enter phrase");
		String phrase = CustomScanner.sc.nextLine();
		convertPhrase(phrase);
		String result = Calculator.calculate(date, type, value, isAdd);
		System.out.println(result);
		String operation = Language.getLanguageTag() + ",Phrases," + "," + phrase + "," + result;
		try {
			Record.recordOp(operation);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}