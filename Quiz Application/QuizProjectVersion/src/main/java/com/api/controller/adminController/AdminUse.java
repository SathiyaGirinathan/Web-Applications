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
			response.setContentType("application/json");
			String contentString = "[{\"status\":\"1\"}]";
    		out.print(new Gson().toJson(contentString));
    		out.flush();
		}
		else {
			response.setContentType("application/json");
			String contentString = "[{\"status\":\"0\"}]";
    		out.print(new Gson().toJson(contentString));
    		out.flush();
		}
	}

}
