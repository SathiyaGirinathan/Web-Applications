package com.api.utilityClasses;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quizEntities.*;

public class Results {
	
	HttpServletRequest request;
	HttpServletResponse response;
	
	public Results(HttpServletRequest request, HttpServletResponse response)
	{
		this.request = request;
		this.response=response;
	}
	
	public static Results getObject(HttpServletRequest request, HttpServletResponse response)
	{
		return new Results(request, response);
	}
	
	public void getResult() throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String longString = request.getParameter("testId");
		System.out.println(longString);
		TestTable entity = OfyService.ofy().load().type(TestTable.class).id(Long.parseLong(longString)).now();
		
		out.println("<html><body><center><table border=2><tr><th>Test ID</th><th>User ID</th><th>Maximum Mark of the test</th><th>Your Marks</th><th>Result</th></tr>");
		out.println("<tr><td>"+entity.getTestId()+"</td><td>"+entity.getUserId()+"</td><td>"+entity.getMark().getMaxScore()+"</td><td>"+entity.getMark().getCurrentScore()+"</td><td>"+entity.getR()+"</tr>");
		
		out.println("</table></center></body></html>");
		out.flush();
	}
}