package com.contactApp.controller.createController;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.contactApp.OfyService;
import com.contactApp.ContactApp;


/**
 * Servlet implementation class StoreServlet
 */
@WebServlet("/StoreServlet")
public class StoreServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().println("");

		String EmpId = request.getParameter("empid");
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String emailId=request.getParameter("email");
		String phoneNo=request.getParameter("mobile");
		
		ContactApp cApp=new ContactApp(EmpId,name,age,emailId,phoneNo);
		OfyService.ofy().save().entity(cApp).now();
		
		response.getWriter().println("<html><body><script>alert('Hi your contact got saved')</script></body></html>");
		RequestDispatcher rd= request.getRequestDispatcher("index.html");
		rd.forward(request, response);
	}

}
