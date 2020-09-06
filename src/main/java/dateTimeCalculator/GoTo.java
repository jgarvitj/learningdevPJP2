/**
 * 
 */
package dateTimeCalculator;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

import inputOutput.Record;
import language.Language;

/**
 * @author Garvit Jain
 *
 */

@Component
public class GoTo implements Runnable {

	public void run() {
		LocalDate date = LocalDate.now();
		System.out.println("Type: days/w/m/y");
		char type = 'd';
		int value = 2;
		boolean isAdd = true;
		String result = Calculator.calculate(date, type, value, isAdd);
		System.out.println();
		System.out.println(result);
		String operation = Language.getLanguageTag() + ",Calculate," + date.toString() + "," + type + "," + value + ","
				+ isAdd + "," + result;

		try {
			Record.recordOp(operation);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
