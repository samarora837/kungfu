package com.handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updateStudentInfo
 */
@WebServlet("/updateStudentInfo")
public class updateStudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateStudentInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("******in servlet**********");
		   // Set response content type
			String id = request.getParameter("studentID");
		   String name = request.getParameter("name");
		   String mobile = request.getParameter("mobile");
		   String email = request.getParameter("email");
		   String address = request.getParameter("address");
		   String joiningDate = request.getParameter("joiningDate");
		   String dateofbirth = request.getParameter("dob");
		   String isadult = request.getParameter("isadult");
		   String fatherName = request.getParameter("fatherName");
		   String fathermobile = request.getParameter("fathermobile");
		   String fatheremail = request.getParameter("fatheremail");
		   String motherName = request.getParameter("motherName");
		   String mothermobile = request.getParameter("mothermobile");
		   String motheremail = request.getParameter("motheremail");
		   String isparentStudent = request.getParameter("isparentStudent");
		   System.out.println("student id"+id);
		   System.out.println("name"+name);
		   System.out.println("mobile"+mobile);
		   System.out.println("email"+email);
		   System.out.println("address"+address);
		   System.out.println("joiningDate"+joiningDate);
		   System.out.println("dateofbirth"+dateofbirth);
		   System.out.println("isadult"+isadult);
		   System.out.println("fatherNameame"+fatherName);
		   System.out.println("fathermobile"+fathermobile);
		   System.out.println("fatheremail"+fatheremail);
		   System.out.println("fathermobile"+fathermobile);
		   System.out.println("motherName"+motherName);
		   System.out.println("mothermobile"+mothermobile);
		   System.out.println("motheremail"+motheremail);
		   System.out.println("isparentStudent"+isparentStudent);
		   message = "Student record updated successfully";
		   response.setContentType("text/html");
		   //response.addHeader("message", message);
		  request.setAttribute("message",message);
		  // request.setAttribute("studentId", "23123123");
		  RequestDispatcher view = request.getRequestDispatcher("StudentInfo.jsp");
		  view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
