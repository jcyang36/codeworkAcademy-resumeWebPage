package tbdtestpackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
		String YearGrad=request.getParameter("YearGrad");
		String workTitle=request.getParameter("workTitle");
		String workComp=request.getParameter("workComp");
		String workDur=request.getParameter("workDur");
		String duty=request.getParameter("duty");
		String skill=request.getParameter("skill");
		String proficiency=request.getParameter("proficiency");
		String message="this is my message";
		
		
		request.setAttribute("FirstLine", fName+" "+middle+" "+lName);
		request.setAttribute("email", email);
		request.setAttribute("education",degree+" in "+field);
		request.setAttribute("classof",school+", "+YearGrad);
		request.setAttribute("work" , workTitle);
		request.setAttribute("workComp", workComp+", "+workDur);
		request.setAttribute("duty", duty);
		
		getServletContext().getRequestDispatcher("/NewJSPFile.jsp").forward(request,response);
		
		
		/* Processing for Names */  
		
		try{Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection("jdbc:mysql://localhost/WeekFourChallenge?"+ "user=root&password=password" );
		
		pstmt = con.prepareStatement("Insert into Resumes(FirstName, Middle, LastName, email) values (?,?,?,?) ");
		pstmt.setString(1, fName);
		pstmt.setString(2, middle);
		pstmt.setString(3, lName);
		pstmt.setString(4, email);
  		pstmt.executeUpdate();
		
  		
	

		}catch(SQLException e){
			e.printStackTrace();
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				//rs.close();
				pstmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		/* Processing for Names */
		
		
		/* Processing for Education */
		try{Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection("jdbc:mysql://localhost/WeekFourChallenge?"+ "user=root&password=password" );
		
		pstmt = con.prepareStatement("Insert into Education(degree,field,school,YearGrad) values (?,?,?,?) ");
		pstmt.setString(1, degree);
		pstmt.setString(2, field);
		pstmt.setString(3, school);
		pstmt.setString(4, YearGrad);
  		pstmt.executeUpdate();
		
  		
	

		}catch(SQLException e){
			e.printStackTrace();
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				//rs.close();
				pstmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		/* Processing for Education  */
		
		/* Processing for Work */
		try{Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection("jdbc:mysql://localhost/WeekFourChallenge?"+ "user=root&password=password" );
		
		pstmt = con.prepareStatement("Insert into Work(WorkTitle,WorkComp,WorkDur,duty) values (?,?,?,?) ");
		pstmt.setString(1, workTitle);
		pstmt.setString(2, workComp);
		pstmt.setString(3, workDur);
		pstmt.setString(4, duty);
  		pstmt.executeUpdate();
		
  		
	

		}catch(SQLException e){
			e.printStackTrace();
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				//rs.close();
				pstmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		
		/* Processing for Work */
		/* Processing for Skills */
		try{Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection("jdbc:mysql://localhost/WeekFourChallenge?"+ "user=root&password=password" );
		
		pstmt = con.prepareStatement("Insert into Skills(skillName,proficiency) values (?,?) ");
		pstmt.setString(1, skill);
		pstmt.setString(2, proficiency);

  		pstmt.executeUpdate();
		
  		
	

		}catch(SQLException e){
			e.printStackTrace();
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				//rs.close();
				pstmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		
		/* Processing for Skills */
		
		
	}

}
