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
    String newWorkTitle;
	String newWorkComp;
    String newWorkDur;
    String newDuty;
    String newSkill;
    String newProficiency;
    String educontent="";
    String workcontent="";
    String skillcontent="";
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
		
		/* Input for education */
		String degree=request.getParameter("degree");
		String field=request.getParameter("field");
		String school=request.getParameter("school");
		String YearGrad=request.getParameter("YearGrad");
		
		 for(int countBox =2;countBox<4; countBox++){
		     newDegree="degree"+countBox;
		     newField="field"+countBox;
		     newSchool="school"+countBox;
		     newYearGrad="YearGrad"+countBox;
		     countBox++;
		     //these if statements don't actually get used...
		     if (newDegree!=""){
		    	 degreeAr.add(request.getParameter(newDegree));}
		     else{degreeAr.add("");
		     }
		     if (newField!=""){
		 		fieldAr.add(request.getParameter(newField));
		 	}else{fieldAr.add("");	 
		      }
		     if (newSchool!=""){
			 		schoolAr.add(request.getParameter(newSchool));
			 }else{schoolAr.add("");	  
			  }
		     if (newYearGrad!=""){
			 		yearGradAr.add(request.getParameter(newYearGrad));
			 }else{yearGradAr.add("");	  
			  }
		 }		
		 
		 /*  Input for education   */
		 
		 /* Input for work */
		 	String workTitle=request.getParameter("workTitle");
			String workComp=request.getParameter("workComp");
			String workDur=request.getParameter("workDur");
			String duty=request.getParameter("duty");
			
			 for(int countBox =2;countBox<3; countBox++){
			     newWorkTitle="workTitle"+countBox;
			     newWorkComp="workComp"+countBox;
			     newWorkDur="workDur"+countBox;
			     newDuty="duty"+countBox;
			     countBox++;
			   //these if statements don't actually get used...
			     if (newWorkTitle!=""){
			    	 workTitleAr.add(request.getParameter(newWorkTitle));}
			     else{workTitleAr.add("");
			     }
			     if (newWorkComp!=""){
			 		workCompAr.add(request.getParameter(newWorkComp));
			 	}else{workCompAr.add("");	 
			      }
			     if (newWorkDur!=""){
				 		workDurAr.add(request.getParameter(newWorkDur));
				 }else{workDurAr.add("");	  
				  }
			     if (newDuty!=""){
				 		dutyAr.add(request.getParameter(newDuty));
				 }else{dutyAr.add("");	  
				  }
			 }	  
			   
			 	
			 /* Input for work */
		
			 /* Input for skills*/
			 	String skill=request.getParameter("skill");
				String proficiency=request.getParameter("proficiency");
				
				
				 for(int countBox =2;countBox<3; countBox++){
				     newSkill="skill"+countBox;
				     newProficiency="proficiency"+countBox;
				    
				     countBox++;
				   //these if statements don't actually get used...
				     if (skill!=""){
				    	 skillAr.add(request.getParameter(newSkill));}
				     else{skillAr.add("");
				     }
				     if (proficiency!=""){
				 		proficiencyAr.add(request.getParameter(newProficiency));
				 	}else{proficiencyAr.add("");	 
				      }
				   
				 }	  
				   
				 	
				 /* Input for skills */
		
		String message="this is my message";
		
		
	/* Processing to clear database 
		try{Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection("jdbc:mysql://localhost/WeekFourChallenge?"+ "user=root&password=password" );
		
		stmt = con.createStatement();		
  		stmt.executeUpdate("truncate table Resumes");
  		stmt = con.createStatement();
  		stmt.executeUpdate("truncate table Education");
  		stmt = con.createStatement();
  		stmt.executeUpdate("truncate table Work");
  		stmt = con.createStatement();
  		stmt.executeUpdate("truncate table Skills");
  		
	

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
	 Processing to clear database	*/
		
		
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
		for(int i =0; i<workTitleAr.size();i++){
  		pstmt.setString(1, workTitleAr.get(i));
		pstmt.setString(2, workCompAr.get(i));
		pstmt.setString(3,workDurAr.get(i));
		pstmt.setString(4, dutyAr.get(i));}
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
		for(int i =0; i<skillAr.size();i++){
  		pstmt.setString(1, skillAr.get(i));
		pstmt.setString(2, proficiencyAr.get(i));}
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
		request.setAttribute("education", degree+" in "+field+" <br/>"+school+", "+YearGrad);
		
		for (int i=0; i<degreeAr.size(); i++){
			 if (educontent!=""){
		educontent=educontent+degreeAr.get(i)+" in "+fieldAr.get(i)+ " <br/>"+schoolAr.get(i)+", "+yearGradAr.get(i);
			 }
			 else{educontent=degreeAr.get(i)+" in "+fieldAr.get(i)+ " <br/>"+schoolAr.get(i)+", "+yearGradAr.get(i);
				 }
				}
		request.setAttribute("education2", educontent);
		/*  Output for education  */
		
		/*  Output for work   */
		request.setAttribute("work" , workTitle +" <br/>"+workComp+", "+workDur+" <br/>"+duty);
		
		
		
		for(int i=0; i<workTitleAr.size(); i++){
			workcontent=workcontent+workTitleAr.get(i) +" <br/>"+workCompAr.get(i)+", "+workDurAr.get(i)+" <br/>"+dutyAr.get(i);
			
		}
		request.setAttribute("work2", workcontent);
		/*  Output for work  */
		
		/* Output for skills  */
		request.setAttribute("skill" , skill+", "+proficiency);
		
		
		for(int i=0; i<skillAr.size(); i++){
			skillcontent=skillcontent+skillAr.get(i) +", "+proficiencyAr.get(i);
			
		}
		request.setAttribute("skill2", skillcontent);
		/*  Output for skills  */
		getServletContext().getRequestDispatcher("/NewJSPFile.jsp").forward(request,response);
		
		
	}

}
