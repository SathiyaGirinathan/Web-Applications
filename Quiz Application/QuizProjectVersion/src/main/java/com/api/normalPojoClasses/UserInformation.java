package com.api.normalPojoClasses;


public class UserInformation {
	String userId, dateTime;

	public UserInformation(String userId, String dateTime) {
		super();
		this.userId = userId;
		this.dateTime = dateTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
}
