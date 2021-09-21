package com.contactApp.servlet.bean;

import java.util.HashMap;

import com.google.api.services.discovery.model.JsonSchema.Variant.Map;

public class ApiResponse {
	private String status_codeString;
	private String messageString;
	private String statuString;
	private HashMap<String,Object> details=new HashMap<>();
	public ApiResponse(String status_codeString, String messageString, String statuString,HashMap<String, Object> details) 
	{
		super();
		this.status_codeString = status_codeString;
		this.messageString = messageString;
		this.statuString = statuString;
		this.details = details;
	}
	
	public String getStatus_codeString() {
		return status_codeString;
	}
	public void setStatus_codeString(String status_codeString) {
		this.status_codeString = status_codeString;
	}
	public String getMessageString() {
		return messageString;
	}
	public void setMessageString(String messageString) {
		this.messageString = messageString;
	}
	public String getStatuString() {
		return statuString;
	}
	public void setStatuString(String statuString) {
		this.statuString = statuString;
	}
	public HashMap<String, Object> getDetails() {
		return details;
	}
	public void setDetails(HashMap<String, Object> details) {
		this.details = details;
	}

}
