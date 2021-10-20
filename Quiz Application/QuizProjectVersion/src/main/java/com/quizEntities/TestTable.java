package com.quizEntities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.api.normalPojoClasses.Marks;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class TestTable implements Serializable{
	
	@Id Long testId;
	@Index Long userId;
	String duration;
	String expiredAt;
	String questions;
	Marks mark;
	
	public enum status
	{
		COMPLETED, PENDING, EXPIRED, NOTATTENDED
	};
	
	public enum result
	{
		PASS, FAIL, NIL
	};
	
	status s;
	result r;
	
	public TestTable()
	{
		super();
	}

	public TestTable(Long testId, Long userId, String duration, String expiredAt, String questions, Marks mark,
			status s, result r) {
		super();
		this.testId = testId;
		this.userId = userId;
		this.duration = duration;
		this.expiredAt = expiredAt;
		this.questions = questions;
		this.mark = mark;
		this.s = s;
		this.r = r;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getExpiredAt() {
		return expiredAt;
	}

	public void setExpiredAt(String expiredAt) {
		this.expiredAt = expiredAt;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public Marks getMark() {
		return mark;
	}

	public void setMark(Marks mark) {
		this.mark = mark;
	}

	public status getS() {
		return s;
	}

	public void setS(status s) {
		this.s = s;
	}

	public result getR() {
		return r;
	}

	public void setR(result r) {
		this.r = r;
	}

}
