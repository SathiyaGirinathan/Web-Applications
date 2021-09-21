package com.contactApp;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Stringify;

import io.grpc.internal.AutoConfiguredLoadBalancerFactory;

@Entity
public class ContactApp implements Serializable{
	@Id Long Empid;
	@Index String emplString;
	@Index  String userName;
	@Index  String emailid;
	private String age;
	@Index private String phoneNo;
	
	public ContactApp() {
		
	}
	
	public ContactApp(String EmpId,String userName, String age, String emailID, String phoneNo)
	{
		this.Empid=Long.parseLong(EmpId);
		this.userName=userName;
		this.age=age;
		this.emailid=emailID;
		this.phoneNo=phoneNo;
		this.emplString=EmpId;
	}
	
	public Long getId()
	{
		return Empid;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public String getEmailId()
	{
		return emailid;
	}
	
	public String getPhoneNo()
	{
		return phoneNo;
	}
	
	public String getAge()
	{
		return age;
	}
	
}
