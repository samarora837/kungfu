package com.handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.FeesDAO;
import com.VO.FeesVO;

/**
 * Servlet implementation class PurposeOfFees
 */
@WebServlet("/PurposeOfFees")
public class PurposeOfFees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurposeOfFees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String purposeOfFees=request.getParameter("purposeOfFees");
		String amount=request.getParameter("amount");
		
		FeesVO fvo = new FeesVO();
		FeesDAO fdao = new FeesDAO();
		
		fvo.setItem_Name(purposeOfFees);
		fvo.setItem_Fees(Integer.parseInt(amount));
		fdao.insert(fvo);
		
		
		  //if insert is successful
		   String message = "Purpose of fees added successfully";
	       response.setContentType("text/html");
				  
		   request.setAttribute("message", message);
		   RequestDispatcher view = request.getRequestDispatcher("PurposeOfFees.jsp");
		   view.forward(request, response);
	}

}
