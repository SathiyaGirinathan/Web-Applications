package com.quizEntities;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class QuestionPaper implements Serializable{
	@Id long idLong;
	//@Index int questionNo;
	@Index String questionString;
	String option1;
	String option2;
	String option3;
	String option4;
	@Index String answer;
	@Index String TAG;
	
	public QuestionPaper()
	{
		super();
	}
	
	public QuestionPaper(long idLong, String questionString, String option1, String option2, String option3,
			String option4, String answer, String tAG) {
		this.idLong = idLong;
		this.questionString = questionString;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.answer = answer;
		TAG = tAG;
		
		
	}
	public long getIdLong() {
		return idLong;
	}
	public void setIdLong(long idLong) {
		this.idLong = idLong;
	}
	public String getQuestionString() {
		return questionString;
	}
	public void setQuestionString(String questionString) {
		this.questionString = questionString;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getTAG() {
		return TAG;
	}
	public void setTAG(String tAG) {
		TAG = tAG;
	}
}
