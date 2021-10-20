package com.api.controller.answers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.utilityClasses.AnswerValidation;
import com.api.utilityClasses.Results;

/**
 * Servlet implementation class AnswersApi
 */
@WebServlet(name = "api/v1/AnswersApi", urlPatterns = { "/api/v1/AnswersApi" })
public class AnswersApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public AnswersApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Result
		Results.getObject(request, response).getResult();
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Answer Validation
		AnswerValidation.getObject(request, response).validateAnswers();
	}

}
