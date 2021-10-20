package com.api.utilityClasses;

import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.normalPojoClasses.Marks;
import com.api.normalPojoClasses.ValidatingPojo;
import com.google.gson.Gson;
import com.quizEntities.*;
import com.quizEntities.TestTable.result;
import com.quizEntities.TestTable.status;

public class AnswerValidation {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public AnswerValidation()
	{
		super();
	}
	
	public AnswerValidation(HttpServletRequest request, HttpServletResponse response)
	{
		this.request=request;
		this.response = response;
	}
	
	public static AnswerValidation getObject(HttpServletRequest request,HttpServletResponse response)
	{
		return new AnswerValidation(request, response);
	}
	
	public void validateAnswers()
	{
		int correctAns=0;
		String jb = Reading.readJson(request);
        //Gson Data
        System.out.println(jb);
        Gson gson = new Gson();
        ValidatingPojo[] pojos=gson.fromJson(jb.toString(), ValidatingPojo[].class);

        //Getting TestId
        String pojoString=pojos[pojos.length-1].getTestIdString();
        
        //Answer validating
        for(ValidatingPojo vPojo : pojos)
        {
        	//System.out.print(vPojo.getQuestionString());
        	List<QuestionPaper> list=OfyService.ofy().load().type(QuestionPaper.class).filter("questionString", vPojo.getQuestionString()).list();
        	ListIterator<QuestionPaper> iterator =list.listIterator();
        	
        	while (iterator.hasNext()) {
				QuestionPaper entity = (QuestionPaper) iterator.next();
				//System.out.println(entity.getQuestionString()+" "+vPojo.getQuestionString());
				if(vPojo.getOption().equals(entity.getAnswer()))
				{
					correctAns++;
				}
			}
        }
        
        System.out.println("The marks he got is: "+ correctAns);
        //System.out.println(pojoString);
        savingMarks(pojoString,correctAns);
        
        //sendingResponse(response);   
	 }
	
	private void savingMarks(String id,int correctAns) {
		// TODO Auto-generated method stub
		TestTable entity=(TestTable)OfyService.ofy().load().type(TestTable.class).id(Long.parseLong(id)).now();
		
		String questionsString=entity.getQuestions();
		status statuString = status.COMPLETED;
		result r;
		if(correctAns > 6)
		{
			r =result.PASS;
		}
		else {
			r = result.FAIL;
		}
		 
		TestTable table = new TestTable(entity.getTestId(),entity.getUserId(),entity.getDuration(),entity.getExpiredAt(),questionsString,new Marks(10,correctAns),statuString,r);
		OfyService.ofy().save().entity(table).now();
	}
}
