package com.handler;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ClassSessionDAO;
import com.DAO.FeesDAO;
import com.DAO.PayDAO;
import com.DAO.StudentDAO;
import com.VO.ClassSessionVO;
import com.VO.FeesVO;
import com.VO.PayVO;
import com.VO.StudentVO;
import com.sun.javafx.application.PlatformImpl;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;



/**
 * Servlet implementation class Fees
 */
@WebServlet("/Fees")
public class Fees extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * Default constructor. 
     */
    public Fees() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("******in servlet*********URL*"+requestURL);
		
		System.out.println("Before vo and dao objects");
		FeesVO fvo=new FeesVO();
		FeesDAO fdao = new FeesDAO();
		List<FeesVO> ls1 = null;
		ls1=fdao.load(fvo);
		System.out.println("after FeesDao.load method");
		System.out.println(  "list is = "+ ls1);

		//HttpSession session=request.getSession();
		//session.setAttribute("classSession",ls1);
		request.setAttribute("FeesList",ls1);
		RequestDispatcher view = request.getRequestDispatcher("PayFees.jsp");
		view.forward(request, response);
		   
		String studentID = request.getParameter("studentID");
		   String paymentDate = request.getParameter("paymentDate");
		   String purposeOfPayment = request.getParameter("purposeOfPayment");
		   String amount = request.getParameter("amount");
		   String comment = request.getParameter("comment");
		   
		   System.out.println("studentID"+studentID);
		   System.out.println("paymentDate"+paymentDate);
		   System.out.println("purposeOfPayment"+purposeOfPayment);
		   System.out.println("amount"+amount);
		   System.out.println("comment is: " + comment);
		   
		   PayVO pvo = new PayVO();
		   PayDAO pdao = new PayDAO();
		   
		   StudentVO svo = new StudentVO();
		   svo.setStudent_Number(studentID);
			   
		   StudentDAO sdao = new StudentDAO();
		   System.out.println("after StudentDAO.search method");
		   List<StudentVO> ls=sdao.search(svo);
		   System.out.println("this is the list" + ls);
			
		   if(ls.size() != 0)
		   {
			   pvo.setItem_Name(purposeOfPayment);
			   pvo.setPaid_Fees(amount);
			   pvo.setStudent_Number(studentID);
			   pvo.setComment(comment);
			   
			   @SuppressWarnings("deprecation")
			   Date payment_date = new Date(paymentDate);
			   pvo.setPayment_Date(payment_date);
			   
			   pdao.insert(pvo);
			   
			   System.out.println("Fees Record added successfully");
			   /*String message = "Fees Record added successfully";
		       response.setContentType("text/html");
					  
			   request.setAttribute("message", message);
			   view = request.getRequestDispatcher("PayFees.jsp");
			   view.forward(request, response);	*/
			   
			   PlatformImpl.startup(() -> {});
				Platform.runLater(new Runnable() {
				    @Override
				    public void run() {
				    	
				    	
				    	
						Alert alert = new Alert(AlertType.INFORMATION);
				        alert.setTitle("Success!!..");
				        alert.setHeaderText(" Fee "+amount+" paid successfully for student " +studentID);
				        alert.setContentText("");
				        alert.showAndWait();
						
				        // Update UI here.
				    }
				});
		       	
		   }
		   else{
			   System.out.println("this student does not exists in the database");
			   
		   }
		   
		   //if insert is successful
		   
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getting all the form input parameters
		System.out.println("******in servlet**********");
		   // Set response content type
		   
	}

}
