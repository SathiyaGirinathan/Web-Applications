package com.contactApp.controller.readController;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactApp.ContactApp;
import com.google.gson.Gson;


/**
 * Servlet implementation class ReadServlet
 */
@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
	static String Name;
	private Gson gson = new Gson();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Name = request.getParameter("name");
		 System.out.println(Name);
		/* ContactApp entity = (ContactApp)ofy().load().type(ContactApp.class).id(Long.parseLong(Name)).now();
	
		 String JsonString = this.gson.toJson(entity);
	     PrintWriter out = response.getWriter();
	     response.setContentType("application/json");
	     response.setCharacterEncoding("UTF-8");
	     out.print(JsonString);
	     out.write(JsonString);
	     System.out.println(JsonString);*/
		
	  //   out.flush();		
		List<ContactApp> list=ofy().load().type(ContactApp.class).filter("emplString", Name).list();
		List<ContactApp> list1=ofy().load().type(ContactApp.class).filter("userName", Name).list();
		List<ContactApp> list2=ofy().load().type(ContactApp.class).filter("emailid", Name).list();
		List<ContactApp> list3=ofy().load().type(ContactApp.class).filter("phoneNo", Name).list();
		
		PrintWriter out=response.getWriter();

		ListIterator<ContactApp> iterator = list.listIterator();
		ListIterator<ContactApp> iterator1 = list1.listIterator();
		ListIterator<ContactApp> iterator2 = list2.listIterator();
		ListIterator<ContactApp> iterator3 = list3.listIterator();
		
		if(!list.isEmpty() || !list1.isEmpty() || !list2.isEmpty() || !list3.isEmpty())
		{
		
			Integer i=1;
			out.println("<html><body><center><table border=2><tr><th>Si.No</th><th>Employee Id</th><th>Name</th><th>Age</th><th>Email Id</th><th>Phone No</th></tr>");
			while (iterator.hasNext()) 
			{
				ContactApp entity = (ContactApp) iterator.next();
				out.println("<tr><td>"+i+"</td><td>"+entity.getId()+"</td><td>"+entity.getUserName()+"</td><td>"+entity.getAge()+"</td><td>"+entity.getEmailId()+"</td><td>"+entity.getPhoneNo());
				i++;
			}
			while (iterator1.hasNext()) 
			{
				ContactApp entity = (ContactApp) iterator1.next();
				out.println("<tr><td>"+i+"</td><td>"+entity.getId()+"</td><td>"+entity.getUserName()+"</td><td>"+entity.getAge()+"</td><td>"+entity.getEmailId()+"</td><td>"+entity.getPhoneNo());
				i++;
			}
			while (iterator2.hasNext()) 
			{
				ContactApp entity = (ContactApp) iterator2.next();
				out.println("<tr><td>"+i+"</td><td>"+entity.getId()+"</td><td>"+entity.getUserName()+"</td><td>"+entity.getAge()+"</td><td>"+entity.getEmailId()+"</td><td>"+entity.getPhoneNo());
				i++;
			}
			while (iterator3.hasNext()) 
			{
				ContactApp entity = (ContactApp) iterator3.next();
				out.println("<tr><td>"+i+"</td><td>"+entity.getId()+"</td><td>"+entity.getUserName()+"</td><td>"+entity.getAge()+"</td><td>"+entity.getEmailId()+"</td><td>"+entity.getPhoneNo());
				i++;
			}
			out.println("</table></center></body></html>");
			response.getWriter().println("\r\n"
					+ "<html>\r\n"
					+ "<center><h2>\r\n"
					+ "Do you want to use our Service again?<br><br>Then Click here <a href='index.html'>Services Page</a>\r\n"
					+ "</h2></center>\r\n"
					+ "</html>");
		}
		else if(list.isEmpty() || list1.isEmpty() || list2.isEmpty() || list3.isEmpty())
		{
			response.getWriter().println("\r\n"
					+ "<html>\r\n"
					+ "<center><h1>Hi Sorry, Your contact detail is not found in our Database</h1></center>\r\n"
					+ "</html>\r\n"
					+ "\r\n"
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

}
