package model;

public class LanguageModel {

	private String languageTag;

	public String getLanguageTag() {
		return languageTag;
	}

	public void setLanguageTag(String languageTag) {
		this.languageTag = languageTag;
	}

	@Override
	public String toString() {
		return "Language [languageTag=" + languageTag + "]";
	}

}
