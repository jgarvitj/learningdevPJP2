/**
 * 
 */
package databaseManagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dateTimeCalculator.AboutToday;
import inputOutput.CustomScanner;
import language.Language;

/**
 * @author Garvit Jain
 *
 */
public class FileOperations {
	
	static String url = "jdbc:postgresql://localhost:5432/dateTimeCalculator";
	static String user = "postgres";
	static String password = "";
	

	private static void loadFileRequestsToDb() {
		
		Connection c = null;
		
		try {
			int batchSize = 20;
			int countAboutToday = 0;
//			int countPhrases = 0;
//			int countCalculate = 0;
			String inputFilePath = "C:\\Users\\user\\eclipse-workspace\\dateTimeCalculator\\Data\\Input\\input.csv";
			
			
			System.out.println("Enter the url");
			String url = CustomScanner.sc.nextLine();
			System.out.println("Enter the username");
			String user = CustomScanner.sc.nextLine();
			System.out.println("Enter the password");
			
			

			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(url, user, password);
			c.setAutoCommit(false);
			
			String sqlA = "INSERT INTO abouttime (id, choice) VALUES (?, ?)";
//			String sqlT = "INSERT INTO translator (id, phrase) VALUES (" + countPhrases + ", ?)";
//			String sqlC = "INSERT INTO goto (id, startdate, type, value) VALUES (" + countCalculate + ", ?, ?, ?)";
			
			PreparedStatement stmtA = c.prepareStatement(sqlA);
//			PreparedStatement stmtT = c.prepareStatement(sqlT);
//			PreparedStatement stmtC = c.prepareStatement(sqlC);
			
			
			BufferedReader lineReader = new BufferedReader(new FileReader(inputFilePath));
			String line;

			while ((line = lineReader.readLine()) != null) {
				String[] data = line.split(",");
				if (data[0].equalsIgnoreCase("a")) {
					String choice = data[1];
					stmtA.setInt(1, countAboutToday);
					countAboutToday++;
					stmtA.setString(2, choice);
//					int x = stmtA.executeUpdate();
//					if(x > 0) {
//						System.out.println("Row inserted");
//					}
					if (countAboutToday % batchSize == 0) {
						stmtA.executeBatch();
					}
				}
				if (data[0].equalsIgnoreCase("p")) {

				}
				if (data[0].equalsIgnoreCase("c")) {

				}

			}
//			stmtA.executeBatch();
			System.out.println("here");
			lineReader.close();
			c.commit();
			c.close();

		} catch (Exception e) {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	private static void processAboutToday() {
		try {
			
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection(url, user, password);
			Statement stmt = c.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM abouttime");
			System.out.println(resultSet.getFetchSize());
			
			while(resultSet.next()) {
				char choice = resultSet.getString("choice").charAt(0);
				System.out.println(resultSet.getType());
				AboutToday.findResult(choice); 
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void processGoTo() {

	}

	private static void processTranslator() {

	}

	public static void operateFileRequest() {

		Language.setLanguageTag("en-US");
		loadFileRequestsToDb();
		processAboutToday();
		processGoTo();
		processTranslator();
	}
}
