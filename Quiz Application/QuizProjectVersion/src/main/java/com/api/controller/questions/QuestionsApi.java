package com.api.controller.questions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.utilityClasses.CreateQuestions;
import com.api.utilityClasses.FetchQuestions;

/**
 * Servlet implementation class Questions
 */
@WebServlet(name = "api/v1/Questions", urlPatterns = { "/api/v1/Questions" })
public class QuestionsApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //Constructor
	public QuestionsApi() {
        super();
    }
	
	//GET Method
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//Fetching the questions
		   FetchQuestions.getObject(request, response).getQuestions();
	}

	//PUT Method
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//Creating the questions
		    CreateQuestions.getObject(request, response).pushQuestions();
	}

}
