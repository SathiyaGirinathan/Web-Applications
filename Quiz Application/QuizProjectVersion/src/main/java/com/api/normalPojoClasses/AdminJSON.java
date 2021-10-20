package com.api.normalPojoClasses;

public class AdminJSON {
	String nameString;
	String passwordString;
	
	public AdminJSON()
	{
		super();
	}
	
	public AdminJSON(String nameString, String passwordString) {
		super();
		this.nameString = nameString;
		this.passwordString = passwordString;
	}
	
	
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getPasswordString() {
		return passwordString;
	}
	public void setPasswordString(String passwordString) {
		this.passwordString = passwordString;
	}
	
	
}
