/**
 * 
 */
package dateTimeCalculator;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.Locale;

import inputOutput.*;
import language.Language;

/**
 * @author Garvit Jain
 *
 */
public class AboutToday implements Runnable {

	public void run() {
		
		String languageTag = Language.getLanguageTag();
		Locale locale = new Locale(languageTag);
		System.out.println("Choose d to know day and w to know week number");
		char choice = CustomScanner.sc.findInLine(".").charAt(0);
		CustomScanner.sc.nextLine();
		LocalDate today = LocalDate.now();
		
		String result;
		if(choice == 'd') {
			result = today.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
		}
		else {
			result = String.valueOf(today.get(WeekFields.of(Locale.forLanguageTag(languageTag)).weekOfWeekBasedYear()));
		}
		System.out.println(result);
		String operation = Language.getLanguageTag() + ",AboutToday," + choice + "," + result;
		
		try {
			Record.recordOp(operation);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
