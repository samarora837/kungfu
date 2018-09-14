package com.handler;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.StudentDAO;
import com.VO.StudentVO;

/**
 * Servlet implementation class StudentInfo
 */
@WebServlet("/StudentInfo")
public class StudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside studentinfo controller");
		  //message = "Record added successfully";
		   response.setContentType("text/html");
		   //response.addHeader("message", message);
		   request.setAttribute("message", "Please find below Student Details");
		   
		  // String snumber = request.getParameter("studentID");
		   String snumber=request.getParameter("studentID");
		   System.out.println("user entered this snumber " + snumber);
		   StudentVO svo = new StudentVO();
		   svo.setStudent_Number(snumber);
		   
		   StudentDAO sdao = new StudentDAO();
		   System.out.println("after StudentDAO.search method");
		   List<StudentVO> ls=sdao.search(svo);
		   System.out.println("this is the list" + ls);
		   
		   System.out.println("before controller session");
		  
		   System.out.println("after controller session");
		   StudentVO studentData = null;
		   if(ls != null && ls.size() == 1){
			   studentData = ls.get(0);
		   }
		   request.setAttribute("studentDetails",studentData);
		   System.out.println("after session set");
			
			RequestDispatcher view = request.getRequestDispatcher("StudentInfo.jsp");
			view.forward(request, response);
			
		  
		   /*st.setFname("Ravneet Kaur");
		   st.setLname("Sidhu");
		   st.setAddressl1("3015 Sandwich");
		   st.setCity("Windsor");
		   st.setCountry("Canada");
		   st.setDateofbirth("02-Dec-1990");
		   request.setAttribute("studentDetails", st);*/
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
