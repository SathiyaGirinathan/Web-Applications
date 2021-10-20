package com.api.utilityClasses;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.normalPojoClasses.Marks;
import com.api.normalPojoClasses.UserInformation;
import com.google.api.services.discovery.model.RestMethod.Response;
import com.google.gson.Gson;
import com.quizEntities.*;
import com.quizEntities.TestTable.result;
import com.quizEntities.TestTable.status;

public class LinkGeneration {
	
	HttpServletRequest request;
	HttpServletResponse response;

	public LinkGeneration(HttpServletRequest request, HttpServletResponse response)
	{
		this.request = request;
		this.response=response;
	}
	
	public static LinkGeneration getObject(HttpServletRequest request, HttpServletResponse response)
	{
		return new LinkGeneration(request, response);
	}
	
	public void getLink() throws IOException
	{
		String jb = Reading.readJson(request);
		
		Gson gson = new Gson();
		UserInformation[] infos = gson.fromJson(jb, UserInformation[].class);
		
		String userIdString=null;
	 	String time = null;
		for(UserInformation info : infos)
		{
			userIdString = info.getUserId();
			time = info.getDateTime();
		}

	 	String parsingTimeString = time.substring(0,10)+" "+time.substring(11);

	    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date=new Date();
		try {
			date = sd.parse(parsingTimeString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
       // sd.setTimeZone(TimeZone.getTimeZone("IST"));
        System.out.println(sd.format(date).toString());
        
       String ModifiedDateAndTime=sd.format(date).toString();
        
	 System.out.println(ModifiedDateAndTime);
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
     
     //22:40
     String duration = "00:05";
     long testId=(long) hashCode();
   //  TestTable table = new TestTable();
    //String statuString =TestTable.status
    TestTable tb = new TestTable(testId,Long.parseLong(userIdString),duration,ModifiedDateAndTime,strNew,new Marks(10,0),status.NOTATTENDED,result.NIL);
    
    OfyService.ofy().save().entity(tb).now();
    
    generateLink(userIdString,response);
	}
	
	
	void generateLink(String userId,HttpServletResponse response) throws IOException
	{
		List<TestTable> tables= OfyService.ofy().load().type(TestTable.class).filter("userId",Long.parseLong(userId)).list();
		ListIterator<TestTable> iterator = tables.listIterator();
		Long testId = null;
		
		while (iterator.hasNext()) 
		{
			TestTable entity = (TestTable) iterator.next();
			if(entity.getUserId()==Long.parseLong(userId))
			{
				testId=entity.getTestId();
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("    \r\n"
						+ "<html>\r\n"
						+ "	<body>\r\n"
						+ "		<a href=\"/proceed.html?testId="+testId+"\">Right click and Copy this link</a>\r\n"
						+ "	</body>\r\n"
						+ "</html>   \r\n"
						+ "    ");
				break;
			}
		}
	}
}
