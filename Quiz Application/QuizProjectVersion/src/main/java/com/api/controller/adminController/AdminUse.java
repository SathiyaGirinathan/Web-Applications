package com.api.controller.adminController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.normalPojoClasses.AdminJSON;
import com.api.utilityClasses.Reading;
import com.google.gson.Gson;
import com.quizEntities.*;

@WebServlet(name= "/api/v1/adminInfo", urlPatterns = {"/api/v1/adminInfo"})
public class AdminUse extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String jb = Reading.readJson(request);
		
		Gson gson = new Gson();
		
		AdminJSON[] jsons = gson.fromJson(jb, AdminJSON[].class);
		
		String name = null,passwordString = null;
		for(AdminJSON i : jsons)
		{
			name=i.getNameString();
			passwordString=i.getPasswordString();
		}
		
		Long idLong=(long) this.hashCode();
		
		if(passwordString.equals("12345"))
		{
			AdminInfo ai = new AdminInfo(name);
			OfyService.ofy().save().entity(ai).now();
			//request.getRequestDispatcher("/option.html").forward(request, response);
			response.setContentType("text/html");
			out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "\r\n"
					+ "<style>\r\n"
					+ ".button {\r\n"
					+ "  background-color: #4CAF50; /* Green */\r\n"
					+ "  border: none;\r\n"
					+ "  color: white;\r\n"
					+ "  padding: 15px 32px;\r\n"
					+ "  text-align: center;\r\n"
					+ "  text-decoration: none;\r\n"
					+ "  display: inline-block;\r\n"
					+ "  font-size: 16px;\r\n"
					+ "  margin: 4px 2px;\r\n"
					+ "  cursor: pointer;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".button2 {background-color: #008CBA;} /* Blue */\r\n"
					+ ".button3 {background-color: #f44336;} /* Red */ \r\n"
					+ ".button4 {background-color: #e7e7e7; color: black;} /* Gray */ \r\n"
					+ ".button5 {background-color: #555555;} /* Black */\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "input[type=submit] {\r\n"
					+ "  border: 2px solid red; /*rewriting standard style, it is necessary to be able to change the size*/\r\n"
					+ "  font-size:20px;\r\n"
					+ "  height: 70px;\r\n"
					+ "  width: 200px\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "</style>\r\n"
					+ "\r\n"
					+ "<body bgcolor=\"#ADD8E6\">\r\n"
					+ "<br>\r\n"
					+ "<center><h1>Hi, Hello Welcome</h1></center>\r\n"
					+ "<center>\r\n"
					+ "<form action=\"/fetch.html\">\r\n"
					+ "    <input type=\"submit\" value=\"Create test\" />\r\n"
					+ "</form>\r\n"
					+ "<br>\r\n"
					+ "\r\n"
					+ "<form action=\"/input.html\">\r\n"
					+ "    <input type=\"submit\" value=\"Add Question\" />\r\n"
					+ "</form>\r\n"
					+ "\r\n"
					+ "</center>\r\n"
					+ "</body>\r\n"
					+ "</html>");
			out.flush();
		}
	}

}
