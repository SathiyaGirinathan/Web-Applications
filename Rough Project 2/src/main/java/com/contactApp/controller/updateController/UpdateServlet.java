package com.contactApp.controller.updateController;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactApp.ContactApp;
import com.contactApp.OfyService;



/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	static String EmployeeId;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pWriter=response.getWriter();

		EmployeeId = request.getParameter("empid");
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String emailId=request.getParameter("email");
		String phoneNo=request.getParameter("mobile");
		ContactApp entity = (ContactApp)ofy().load().type(ContactApp.class).id(Long.parseLong(EmployeeId)).now();
		try {
			if(nullOrNotNull() && EmployeeId.equals(entity.getId().toString())&& !name.isEmpty())
			{
				ContactApp cApp=new ContactApp(entity.getId().toString(),name,entity.getAge(),entity.getEmailId(),entity.getPhoneNo());
				
				ofy().save().entity(cApp).now();
				
				if (nullOrNotNull() && EmployeeId.equals(entity.getId().toString())&&!emailId.isEmpty()) {
					entity = (ContactApp)OfyService.ofy().load().type(ContactApp.class).id(Long.parseLong(EmployeeId)).now();
					cApp=new ContactApp(entity.getId().toString(),entity.getUserName(),entity.getAge(),emailId,entity.getPhoneNo());
					
					ofy().save().entity(cApp).now();
				}
				if (nullOrNotNull() && EmployeeId.equals(entity.getId().toString())&&!phoneNo.isEmpty()) {
					entity = (ContactApp)OfyService.ofy().load().type(ContactApp.class).id(Long.parseLong(EmployeeId)).now();
					cApp=new ContactApp(entity.getId().toString(),entity.getUserName(),entity.getAge(),entity.getEmailId(),phoneNo);
					
					ofy().save().entity(cApp).now();
				}
				response.getWriter().println("\r\n"
						+ "<html>\r\n"
						+ "<center><body><script>alert('Hi, Your Contact is Updated Successfully !')</script></body></center>\r\n"
						+ "</html>");
				
			}
			
			else if (nullOrNotNull() && EmployeeId.equals(entity.getId().toString())&&!emailId.isEmpty()) {
				ContactApp cApp=new ContactApp(entity.getId().toString(),entity.getUserName(),entity.getAge(),emailId,entity.getPhoneNo());
				
				ofy().save().entity(cApp).now();
				
				if (nullOrNotNull() && EmployeeId.equals(entity.getId().toString())&&!phoneNo.isEmpty()) {
					entity = (ContactApp)OfyService.ofy().load().type(ContactApp.class).id(Long.parseLong(EmployeeId)).now();
					cApp=new ContactApp(entity.getId().toString(),entity.getUserName(),entity.getAge(),entity.getEmailId(),phoneNo);
					
					ofy().save().entity(cApp).now();
				}
				if (nullOrNotNull() && EmployeeId.equals(entity.getId().toString())&&!name.isEmpty()) {
					entity = (ContactApp)OfyService.ofy().load().type(ContactApp.class).id(Long.parseLong(EmployeeId)).now();
					cApp=new ContactApp(entity.getId().toString(),name,entity.getAge(),entity.getEmailId(),entity.getPhoneNo());
					
					ofy().save().entity(cApp).now();
				}
				response.getWriter().println("\r\n"
						+ "<html>\r\n"
						+ "<center><body><script>alert('Hi, Your Contact is Updated Successfully !')</script></body></center>\r\n"
						+ "</html>");
			}
			
			else if (nullOrNotNull() && EmployeeId.equals(entity.getId().toString())&&!phoneNo.isEmpty()) {
				ContactApp cApp=new ContactApp(entity.getId().toString(),entity.getUserName(),entity.getAge(),entity.getEmailId(),phoneNo);
				
				ofy().save().entity(cApp).now();
				
				if (nullOrNotNull() && EmployeeId.equals(entity.getId().toString())&&!emailId.isEmpty()) {
					entity = (ContactApp)OfyService.ofy().load().type(ContactApp.class).id(Long.parseLong(EmployeeId)).now();
					cApp=new ContactApp(entity.getId().toString(),entity.getUserName(),entity.getAge(),emailId,entity.getPhoneNo());
					
					ofy().save().entity(cApp).now();
				}
				if (nullOrNotNull() && EmployeeId.equals(entity.getId().toString())&&!name.isEmpty()) {
					entity = (ContactApp)OfyService.ofy().load().type(ContactApp.class).id(Long.parseLong(EmployeeId)).now();
					cApp=new ContactApp(entity.getId().toString(),name,entity.getAge(),entity.getEmailId(),entity.getPhoneNo());
					
					ofy().save().entity(cApp).now();
				}
				response.getWriter().println("\r\n"
						+ "<html>\r\n"
						+ "<center><body><script>alert('Hi, Your Contact is Updated Successfully !')</script></body></center>\r\n"
						+ "</html>");
			}

			else {
				{
					pWriter.println("<html>\r\n"
							+ "<body>\r\n"
							+ "<br><br>\r\n"
							+ "<h1>Sorry, Your Contact is not found !</h1>\r\n"
							+ "</body>\r\n"
							+ "</html>\r\n"
							+ "\r\n"
							+ "");
					response.getWriter().println("\r\n"
							+ "<html>\r\n"
							+ "<center><h2>\r\n"
							+ "Do you want to use our Service again?<br><br>Then Click here <a href='index.html'>Services Page</a>\r\n"
							+ "</h2></center>\r\n"
							+ "</html>");
				}
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			pWriter.println("<html>\r\n"
					+ "<body>\r\n"
					+ "<br><br>\r\n"
					+ "<center><h1>Sorry, Your Contact is not found !</h1></center>\r\n"
					+ "</body>\r\n"
					+ "</html>\r\n"
					+ "\r\n"
					+ "");
			response.getWriter().println("\r\n"
					+ "<html>\r\n"
					+ "<center><h2>\r\n"
					+ "Do you want to use our Service again?<br><br>Then Click here <a href='index.html'>Services Page</a>\r\n"
					+ "</h2></center>\r\n"
					+ "</html>");
		}

		RequestDispatcher rd= request.getRequestDispatcher("index.html");
		rd.forward(request, response);
	}
	
	boolean nullOrNotNull()
	{
		if(!EmployeeId.isEmpty())
		{
			return true;
		}
		else {
			return false;
		}
	}

}
