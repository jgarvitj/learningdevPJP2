package model;

public class AboutTodayModel {

	private char choice;

	public char getChoice() {
		return choice;
	}

	public void setChoice(char choice) {
		this.choice = choice;
	}

	@Override
	public String toString() {
		return "About Today  [choice=" + choice + "]";
	}

}
