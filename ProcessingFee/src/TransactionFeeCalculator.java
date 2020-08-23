/**
 * Calculates fee for each transaction
 */

/**
 * @author Garvit Jain
 *
 */
public class TransactionFeeCalculator {
	
	public static void calculateFee(Transaction t, boolean isNormal) {
		if(isNormal) {
			//Normal Transaction fee calculator
			if(t.isPriority()) {
				t.setFee(500);
				return;
			}
			if(t.getType().equalsIgnoreCase("sell") || t.getType().equalsIgnoreCase("withdraw")) {
				t.setFee(100);
				return;
			}
			t.setFee(50);
			return;
		}
		else {
			//IntraDay Transaction fee calculator
			t.setFee(10);
			return;
		}
	}

}
