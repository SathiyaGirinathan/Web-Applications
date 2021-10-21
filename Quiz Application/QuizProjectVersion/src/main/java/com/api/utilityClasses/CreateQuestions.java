package com.api.utilityClasses;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.quizEntities.OfyService;
import com.quizEntities.QuestionPaper;

public class CreateQuestions {
	
	HttpServletResponse response;
	HttpServletRequest request;
	
	public CreateQuestions(HttpServletRequest request, HttpServletResponse response)
	{
		this.request=request;
		this.response=response;
	}
	
	public static CreateQuestions getObject(HttpServletRequest request, HttpServletResponse response)
	{
		return  new CreateQuestions(request, response);
	}
	
	public void pushQuestions() throws ServletException, IOException
	{
		    String jb = Reading.readJson(request);
	        System.out.println(jb);
	        
	        //Using GSON api
	        Gson gson = new Gson();
	        QuestionPaper[] qPaper = gson.fromJson(jb, QuestionPaper[].class);
	        System.out.println(qPaper);
	        long i=0;
	        
	        List<QuestionPaper> list = OfyService.ofy().load().type(QuestionPaper.class).list();
	        ListIterator<QuestionPaper> iterator = list.listIterator();
	        
	        //To get the correct ID value for questions
	        while(iterator.hasNext())
	        {
	        	QuestionPaper entity = (QuestionPaper) iterator.next();
	        	i = entity.getIdLong();
	        }
	        
	        if(i==0)
	        {
	        	i=0;
	        }
	        boolean b=false;
	        for(QuestionPaper qPaper2:qPaper)
	        {
	        	QuestionPaper qp = new QuestionPaper(++i, qPaper2.getQuestionString(), qPaper2.getOption1(), qPaper2.getOption2(), qPaper2.getOption3(), qPaper2.getOption4(), qPaper2.getAnswer(), "JAVA");
	        	OfyService.ofy().save().entity(qp).now();
	        	b=true;
	        }
	        
	        PrintWriter out = response.getWriter();
	        if(b==true)
	        {
	        	response.setContentType("application/json");
				String contentString = "[{\"status\":\"1\"}]";
	    		out.print(new Gson().toJson(contentString));
	    		out.flush();
	        }
	        else if(b==false)
	        {
				response.setContentType("application/json");
				String contentString = "[{\"status\":\"0\"}]";
	    		out.print(new Gson().toJson(contentString));
	    		out.flush();
	        }
	        //Provide response MUST BE INCLUDED
	}

}
