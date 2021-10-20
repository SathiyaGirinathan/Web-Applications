package com.api.controller.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quizEntities.OfyService;
import com.quizEntities.QuestionPaper;
import com.quizEntities.TestTable;
import com.quizEntities.TestTable.status;;

@WebServlet(name = "api/v1/TestQuestions", urlPatterns = { "/api/v1/TestQuestions" })
public class TestQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String testidString = request.getParameter("testId");
		TestTable table= OfyService.ofy().load().type(TestTable.class).id(Long.parseLong(testidString)).now();
		if(table.getS() != status.COMPLETED && table.getS()!=status.EXPIRED)
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
		
		else
		{	
			   ObjectMapper oMapper = new ObjectMapper();
		       PrintWriter out = response.getWriter();
		       String s = "[{\"status\":\"0\"}]";
			   response.setContentType("application/json");
		       response.setCharacterEncoding("UTF-8");
		       out.println(oMapper.writeValueAsString(s));
		       out.flush();  
		}	      
	}
}
