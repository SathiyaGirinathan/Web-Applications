package com.contactApp.controller.deleteController;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactApp.ContactApp;


/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empidString=request.getParameter("empid");
		Long empLong=Long.parseLong(empidString);
		
		ofy().delete().type(ContactApp.class).id(empLong).now();
		response.getWriter().println("\r\n"
				+ "<html>\r\n"
				+ "<center><script>alert('Hi, That Contact Deleted Successfully !')</script></center>\r\n"
				+ "</html>");
		RequestDispatcher rd= request.getRequestDispatcher("index.html");
		rd.forward(request, response);
	}



}
