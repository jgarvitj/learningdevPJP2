package model;

public class CalculateModel {

	private char type;
	private int value;
	private String date1;

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	@Override
	public String toString() {
		return "CalculateModel [type=" + type + ", value=" + value + ", date1=" + date1 + "]";
	}

}