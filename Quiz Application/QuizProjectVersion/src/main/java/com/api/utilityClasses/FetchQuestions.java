package com.api.utilityClasses;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quizEntities.OfyService;
import com.quizEntities.QuestionPaper;

public class FetchQuestions {
	
	
	HttpServletResponse response;
	HttpServletRequest request;
	
	public FetchQuestions(HttpServletRequest request, HttpServletResponse response)
	{
		this.request=request;
		this.response=response;
	}
	
	public static FetchQuestions getObject(HttpServletRequest request, HttpServletResponse response)
	{
		return  new FetchQuestions(request, response);
	}
	
	
	
	public void getQuestions() throws ServletException, IOException
	{
		 String str="[";
		 List<QuestionPaper> list = OfyService.ofy().load().type(QuestionPaper.class).list();
	     ListIterator<QuestionPaper> iterator = list.listIterator();
	     
	     while(iterator.hasNext())
	     {
	        	QuestionPaper entity = (QuestionPaper) iterator.next();
	        	if(entity.getTAG().equalsIgnoreCase("java"))
	        	{
	        		str += "{\"questionString\":\""+entity.getQuestionString() +"\",\"option1\":\""+entity.getOption1()+"\",\"option2\":\""+entity.getOption2()+"\",\"option3\":\""+entity.getOption3()+"\",\"option4\":\""+entity.getOption4()+"\"},";
	        	}
	     }
	     str += "}";
	     String strNew = str.substring(0, str.length()-2);
	     strNew += "]";
	  //   System.out.println(strNew);
	  // Using Object Mapper
        ObjectMapper oMapper = new ObjectMapper();
        PrintWriter out = response.getWriter();
	    response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println(oMapper.writeValueAsString(strNew));
        out.flush();         
	}
}
