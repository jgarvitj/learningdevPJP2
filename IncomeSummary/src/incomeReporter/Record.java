package incomeReporter;

import java.util.Comparator;

/**
 * Class to handle a record 
 */


/**
 * @author Garvit Jain
 *
 */
public class Record {
	
	private String name;
	private String gender;
	private String currency;
	private double amount;
	private double amountInUSD;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String t) {
		this.gender = t;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getAmountInUSD() {
		return amountInUSD;
	}
	public void setAmountInUSD(double amountInUSD) {
		this.amountInUSD = amountInUSD;
	}
	
	public static Comparator<Record> CustomComparator = new Comparator<Record>() { 
		
		public int compare(Record t1, Record t2) {
			if(!t1.getName().equals(t2.getName())) {
				return t1.getName().compareTo(t2.getName());
			}
			if(t1.getGender() != t2.getGender()) {
				if(t1.getGender().equalsIgnoreCase("M")) {
					return 1;
				}
				else return -1;
			}
			if(t1.getAmountInUSD() > t2.getAmountInUSD())
				return 1;
			return -1;
		}
	};
	

}
