package com.handler;

//Import required java libraries
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.StudentDAO;
import com.VO.StudentVO;

public class NewStudent extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String message, studentID;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("******in servlet**********");
		// Set response content type
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String street = request.getParameter("addressl1");
		String city = request.getParameter("city");
		String province = request.getParameter("province");
		String country = request.getParameter("country");
		String postalcode = request.getParameter("postalcode");
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
		String sidMother = request.getParameter("sidMother");
		String sidFather = request.getParameter("sidFather");

		StudentVO StuVO = new StudentVO();
		// String id1= "S" + Long.toString(StuVO.getId());
		// System.out.println("VO's id is: " + StuVO.getId());
		// System.out.println("id1 is : " + id1);

		Random r = new Random();
		String snumber = "S" + Integer.toString(r.nextInt(1000));
		StuVO.setStudent_Number(snumber);
		// StuVO.setStudent_Number(id1);
		StuVO.setFirst_Name(fname);
		StuVO.setLast_Name(lname);
		StuVO.setStreet(street);
		StuVO.setCity(city);
		StuVO.setCountry(country);
		StuVO.setProvince(province);
		StuVO.setPostal_Code(postalcode);

		SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date joining = input.parse(joiningDate);
			Date dob = input.parse(dateofbirth);

			StuVO.setDateofjoining(joining);
			StuVO.setDateofbirth(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		StuVO.setEmail(email);
		StuVO.setMobile(mobile);
		StuVO.setFather_Email(fatheremail);
		StuVO.setFather_Mobile(fathermobile);
		StuVO.setFather_Name(fatherName);
		StuVO.setMother_Name(motherName);
		StuVO.setMother_Mobile(mothermobile);
		StuVO.setMother_Email(motheremail);
		StuVO.setF_Num(sidFather);
		StuVO.setM_Num(sidMother);

		StudentDAO StuDAO = new StudentDAO();
		StuDAO.insert(StuVO);
		studentID = snumber;
		message = "Record added successfully";
		System.out.print(studentID);
		response.setContentType("text/html");
		request.setAttribute("message", message);
		request.setAttribute("studentID", studentID);
		RequestDispatcher view = request.getRequestDispatcher("newstudent.jsp");
		view.forward(request, response);

	}

	public void destroy() {
		// do nothing.
	}
}