package com.api.normalPojoClasses;


public class ValidatingPojo {
	String questionString;
	String option;
	String testIdString;
	
	
	public ValidatingPojo(String questionString, String option, String testIdString) {
		super();
		this.questionString = questionString;
		this.option = option;
		this.testIdString = testIdString;
	}
	
	
	public String getQuestionString() {
		return questionString;
	}
	public void setQuestionString(String questionString) {
		this.questionString = questionString;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getTestIdString() {
		return testIdString;
	}
	public void setTestIdString(String testIdString) {
		this.testIdString = testIdString;
	}
	
}
