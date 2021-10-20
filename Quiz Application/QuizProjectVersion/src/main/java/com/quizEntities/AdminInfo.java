package com.quizEntities;

import java.io.Serializable;

import com.google.appengine.api.search.query.ExpressionParser.name_return;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class AdminInfo implements Serializable{

	@Id Long adminId;
	@Index String adminName;
	
	//Constructor
	public AdminInfo()
	{
		super();
	}
	
	public AdminInfo(String adminName) {
		super();
		//this.adminId = adminId;
		this.adminName = adminName;
	}
	//Getters and Setters
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	
}
