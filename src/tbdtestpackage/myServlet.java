package tbdtestpackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class myServlet
 */
@WebServlet("/myServlet")
public class myServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

    public myServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fName=request.getParameter("firstName");
		String message="this is my message";
		request.setAttribute("message", fName);
		
		getServletContext().getRequestDispatcher("/NewJSPFile.jsp").forward(request,response);
	}

}
