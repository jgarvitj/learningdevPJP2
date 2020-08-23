/**
 * Class for the attributes of transactions
 */

/**
 * @author Garvit Jain
 *
 */
import java.util.Comparator;
import java.util.Date;

public class Transaction {
	private String clientId;
	private String securityId;
	private String type;
	private Date date;
	private boolean isPriority;
	private int fee;
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getSecurityId() {
		return securityId;
	}
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isPriority() {
		return isPriority;
	}
	public void setPriority(boolean isPriority) {
		this.isPriority = isPriority;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	
	public static Comparator<Transaction> CustomComparator = new Comparator<Transaction>() { 
		
		public int compare(Transaction t1, Transaction t2) {
			if(!t1.getClientId().equals(t2.getClientId())) {
				return t1.getClientId().compareTo(t2.getClientId());
			}
			if(!t1.getType().equals(t2.getClientId())) {
				return t1.getType().compareTo(t2.getType());
			}
			if(!t1.getDate().equals(t2.getDate())) {
				return t1.getDate().compareTo(t2.getDate());
			}
			if(!t1.isPriority()) {
				return -1;
			}
			return 1;
		}
	};
	
	

	
}
