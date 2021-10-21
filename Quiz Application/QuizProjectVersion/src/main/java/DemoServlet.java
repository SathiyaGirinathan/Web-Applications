import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.quizEntities.OfyService;
import com.quizEntities.TestTable;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("uid");
		String testIdString = request.getParameter("testId")	;
		System.out.println(idString+" "+testIdString);
		
		//long testId =Long.parseLong(testIdString);
		response.setContentType("application/json");
		//RequestDispatcher rDispatcher = request.getRequestDispatcher("test.html?testId="+testIdString);
		TestTable entity = OfyService.ofy().load().type(TestTable.class).id(Long.parseLong(testIdString)).now();
		if(entity.getUserId()==Long.parseLong(idString))
		{
			PrintWriter out = response.getWriter();
			String contentString = "[{\"status\":\"1\"}]";
    		out.print(new Gson().toJson(contentString));
    		out.flush();
		}
		else {
			PrintWriter out = response.getWriter();
			String contentString = "[{\"status\":\"0\"}]";
    		out.print(new Gson().toJson(contentString));
    		out.flush();
		}
	}

}
