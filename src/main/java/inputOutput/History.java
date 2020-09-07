/**
 * 
 */
package inputOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Garvit Jain
 *
 */
public class History {

	private static BufferedReader br;

	private static void displayHistory(String filePath) throws IOException {
		int count = 0;

		try {
			br = new BufferedReader(new FileReader(filePath));
			String line = br.readLine();

			while (line != null) {
				if (count % 10 == 0) {
					System.out.println("Press e to exit");
					System.out.println("Press any other key to view more");
					char choice = CustomScanner.sc.findInLine(".").charAt(0);
					CustomScanner.sc.nextLine();
					if (choice == 'e') {
						return;
					}
				}

				System.out.println(line);
				line = br.readLine();
				count++;
				br.close();
			}
		} catch (IOException e) {
			br.close();
			e.printStackTrace();
		}
		
	}

	public static void getSessionHistory() throws IOException {
		String filePath = Record.getFileName();
		displayHistory(filePath);
		return;
	}

	public static void getHistory(String filePath) throws IOException {
		displayHistory(filePath);
		return;
	}
}
