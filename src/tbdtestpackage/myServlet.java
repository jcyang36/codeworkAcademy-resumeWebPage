package tbdtestpackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
		

			Connection con = null;
			Statement stmt =null;
			PreparedStatement pstmt= null;
			ResultSet rs = null;
		String fName=request.getParameter("firstName");
		String middle = request.getParameter("Middle");
		String lName=request.getParameter("lastName");
		String email=request.getParameter("email");
		String degree=request.getParameter("degree");
		String field=request.getParameter("field");
		String school=request.getParameter("school");
		String message="this is my message";
		
		
		request.setAttribute("FirstLine", fName+" "+middle+" "+lName);
		request.setAttribute("email", email);
		request.setAttribute("education",degree+" in "+field);
		request.setAttribute("classof",school);
		getServletContext().getRequestDispatcher("/NewJSPFile.jsp").forward(request,response);
		
		
		
		
	}

}
