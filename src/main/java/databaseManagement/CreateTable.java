/*
* Makes postges DB for all types of operations 
 * 
 */
package databaseManagement;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import inputOutput.CustomScanner;

/**
 * @author Garvit Jain
 *
 */
public class CreateTable {

	public static void main(String args[]) {

		try {
			Connection c = null;
			Statement stmt = null;
			System.out.println("Enter the url");
			String url = CustomScanner.sc.nextLine();
			System.out.println("Enter the username");
			String user = CustomScanner.sc.nextLine();
			System.out.println("Enter the password");
			String password = CustomScanner.sc.nextLine();

			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(url, user, password);
			stmt = c.createStatement();
			stmt.execute("Create Table translator(id int primary key, phrase varchar)");
			stmt.execute("Create Table abouttoday(id int primary key, choice char)");
			stmt.execute("Create Table goto(id int primary key, startDate date, type char, value int)");
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
