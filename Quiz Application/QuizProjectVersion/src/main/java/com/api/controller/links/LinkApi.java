package com.api.controller.links;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.utilityClasses.LinkGeneration;
import com.api.utilityClasses.LinkValidation;

@WebServlet(name = "api/v1/LinkApi", urlPatterns = { "/api/v1/LinkApi" })
public class LinkApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LinkApi() {
        super();
    }
    
    //POST method
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Link Generation
		LinkGeneration.getObject(request, response).getLink();
	}
    
    //PUT
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Link Validation
		LinkValidation.getObject(request, response).validateLink();
	}

}
