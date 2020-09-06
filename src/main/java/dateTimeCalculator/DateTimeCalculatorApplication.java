/**
 * 
 */
package dateTimeCalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Garvit Jain
 *
 */

@ComponentScan("dateTimeCalculator")
@SpringBootApplication
public class DateTimeCalculatorApplication {

	private static DateTime operation;

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(DateTimeCalculatorApplication.class, args);

		// Operation for Date Time Calculator

		operation = (DateTime) applicationContext.getBean(DateTime.class);

//		DateTime operation = new DateTime();
		operation.calcRunner();
		System.out.println("Exiting session");
		return;
	}
}
