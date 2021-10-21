package com.api.utilityClasses;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.normalPojoClasses.TestId;
import com.google.gson.Gson;
import com.quizEntities.*;
import com.quizEntities.TestTable.result;
import com.quizEntities.TestTable.status;

public class LinkValidation {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public LinkValidation()
	{
		super();
	}
	
	public LinkValidation(HttpServletRequest request, HttpServletResponse response)
	{
		this.request = request;
		this.response = response;
	}
	
	public static LinkValidation getObject(HttpServletRequest request, HttpServletResponse response)
	{
		return new LinkValidation(request,response);
	}
	
	
	public void validateLink() throws IOException
	{
		String jbString=Reading.readJson(request);
		System.out.println(jbString);
        
        //GSON conversion
        Gson gson = new Gson();
        TestId[] testIds = gson.fromJson(jbString, TestId[].class);
        System.out.println(testIds);
        
        Long originalTestId=0l;
       
        for(TestId i:testIds)
        {
        	originalTestId = Long.parseLong(i.getTestIdString());
        }
        
        //Expiry time checking
        TestTable entity = (TestTable) OfyService.ofy().load().type(TestTable.class).id(originalTestId).now();
        String expirytime = entity.getExpiredAt();
        
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = new Date();
        sd.setTimeZone(TimeZone.getTimeZone("IST"));
        String currenttimeString=sd.format(date).toString();
        System.out.println(currenttimeString);
        
        Boolean value=false;
		try {
			value = TimeUtilityClass.compareTime(currenttimeString, expirytime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(value);
        
        PrintWriter out = response.getWriter(); //Printwriter object
	    response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        if(value==true && entity.getR()==result.NIL)
        {
    		//TestTable entity = (TestTable) OfyService.ofy().load().type(TestTable.class).id(originalTestId).now();
    		
    		TestTable newEntity = new TestTable(entity.getTestId(), entity.getUserId(), entity.getDuration(), entity.getExpiredAt(), entity.getQuestions(), entity.getMark(),status.PENDING, entity.getR());
    		
    		OfyService.ofy().save().entity(newEntity).now();
    		String contentString = "[{\"status\":\"1\"}]";
    		out.print(new Gson().toJson(contentString));
    		out.flush();
        }
        
        else
        {
    
    		//TestTable entity = (TestTable) OfyService.ofy().load().type(TestTable.class).id(originalTestId).now();
    		
    		TestTable newEntity = new TestTable(entity.getTestId(), entity.getUserId(), entity.getDuration(), entity.getExpiredAt(), entity.getQuestions(), entity.getMark(),status.EXPIRED, entity.getR());
    		
    		OfyService.ofy().save().entity(newEntity).now();
    		
    		String contentString = "[{\"status\":\"0\"}]";
    		out.print(new Gson().toJson(contentString));
    		out.flush();
        }
	}
}
