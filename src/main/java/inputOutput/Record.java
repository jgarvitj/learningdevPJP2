/**
 * 
 */
package inputOutput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Garvit Jain
 *
 */
public class Record {

	private static String fileName;

	public static void recordOp(String op) throws IOException {
		System.out.println(op);
		FileWriter fw;

		fw = new FileWriter(fileName, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(op);
		bw.newLine();
		bw.close();
		fw.close();

	}

	public static String getFileName() {
		return fileName;
	}

	public static void setFileName(String fileName) {
		Record.fileName = fileName;
	}
}
