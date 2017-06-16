package tbdtestpackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	String newDegree="";
	String newField;
    String newSchool;
    String newYearGrad;
	 ArrayList <String> degreeAr = new ArrayList <String> ();
	 ArrayList <String> fieldAr = new ArrayList <String> ();
	 ArrayList <String> schoolAr = new ArrayList <String> ();
	 ArrayList <String> yearGradAr = new ArrayList <String> ();
	 ArrayList <String> workTitleAr = new ArrayList <String> ();
	 ArrayList <String> workCompAr = new ArrayList <String> ();
	 ArrayList <String> workDurAr = new ArrayList <String> ();
	 ArrayList <String> dutyAr = new ArrayList <String> ();
	 ArrayList <String> skillAr = new ArrayList <String> ();
	 ArrayList <String> proficiencyAr = new ArrayList <String> ();
	
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
		
		 for(int countBox =2;countBox<3; countBox++){
		     newDegree="degree"+countBox;
		     newField="field"+countBox;
		     newSchool="school"+countBox;
		     newYearGrad="YearGrad"+countBox;
		     countBox++;
		degreeAr.add(request.getParameter(newDegree));
		fieldAr.add(request.getParameter(newField));
		schoolAr.add(request.getParameter(newSchool));
		yearGradAr.add(request.getParameter(newYearGrad));
		 }
		System.out.println(fieldAr);
		String workTitle=request.getParameter("workTitle");
		String workComp=request.getParameter("workComp");
		String workDur=request.getParameter("workDur");
		String duty=request.getParameter("duty");
		String workTitle2=request.getParameter("workTitle2");
		String workComp2=request.getParameter("workComp2");
		String workDur2=request.getParameter("workDur2");
		String duty2=request.getParameter("duty2");
		String skill=request.getParameter("skill");
		String proficiency=request.getParameter("proficiency");
		String skill2=request.getParameter("skill2");
		String proficiency2=request.getParameter("proficiency2");
		String message="this is my message";
		
		
	
		
		
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
		
  		
  		pstmt = con.prepareStatement("Insert into Education(degree,field,school,YearGrad) values (?,?,?,?) ");
		for(int i =0; i<degreeAr.size();i++){
  		pstmt.setString(1, degreeAr.get(i));
		pstmt.setString(2, fieldAr.get(i));
		pstmt.setString(3,schoolAr.get(i));
		pstmt.setString(4, yearGradAr.get(i));}
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
		
  		pstmt = con.prepareStatement("Insert into Work(WorkTitle,WorkComp,WorkDur,duty) values (?,?,?,?) ");
		pstmt.setString(1, workTitle2);
		pstmt.setString(2, workComp2);
		pstmt.setString(3, workDur2);
		pstmt.setString(4, duty2);
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
		
		pstmt = con.prepareStatement("Insert into Skills(skillName,proficiency) values (?,?) ");
		pstmt.setString(1, skill2);
		pstmt.setString(2, proficiency2);

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
		
		/*    Output for names  */
		
		request.setAttribute("FirstLine", fName+" "+middle+" "+lName);
		request.setAttribute("email", email);
		
		/* Output for names  */
		
		/* Output for education  */
		request.setAttribute("education", degree+" in "+field+" "+school+", "+YearGrad);
		String content="";
		for (int i=0; i<degreeAr.size(); i++){
		content=content+degreeAr.get(i)+" in "+fieldAr.get(i)+ " "+schoolAr.get(i)+", "+yearGradAr.get(i);
				}
		request.setAttribute("education2", content);
		/*  Output for education  */
		
		/*  Output for work   */
		request.setAttribute("work" , workTitle);
		request.setAttribute("workComp", workComp+", "+workDur);
		request.setAttribute("duty", duty);
		
		request.setAttribute("work2" , workTitle2);
		request.setAttribute("workComp2", workComp2+", "+workDur2);
		request.setAttribute("duty2", duty2);
		
		/*  Output for work  */
		
		/* Output for skills  */
		request.setAttribute("skill" , skill);
		request.setAttribute("proficiency", proficiency);
		
		request.setAttribute("skill2" , skill2);
		request.setAttribute("proficiency2", proficiency2);
		
		/*  Output for skills  */
		getServletContext().getRequestDispatcher("/NewJSPFile.jsp").forward(request,response);
		
		
	}

}
