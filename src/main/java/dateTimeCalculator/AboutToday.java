/**
 * 
 */
package dateTimeCalculator;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.Locale;

import org.springframework.stereotype.Component;

import inputOutput.*;
import language.Language;

/**
 * @author Garvit Jain
 *
 */

@Component
public class AboutToday implements Runnable {

	public static void findResult(char choice) {
		System.out.println("at");
		String languageTag = Language.getLanguageTag();
		Locale locale = new Locale(languageTag);
		LocalDate today = LocalDate.now();
		String result;

		if (choice == 'd') {
			result = today.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
		} else {
			result = String.valueOf(today.get(WeekFields.of(Locale.forLanguageTag(languageTag)).weekOfWeekBasedYear()));
		}
		System.out.println(result);
		String operation = Language.getLanguageTag() + ",AboutToday," + choice + "," + result;

		try {
			Record.recordOp(operation);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void run() {

		System.out.println("Choose d to know day and w to know week number");
		char choice = CustomScanner.sc.findInLine(".").charAt(0);
		CustomScanner.sc.nextLine();

		findResult(choice);

	}

}
