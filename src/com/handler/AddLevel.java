package com.handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ClassSessionDAO;
import com.VO.ClassSessionVO;

/**
 * Servlet implementation class AddLevel
 */
public class AddLevel extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String message;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLevel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String levelname = request.getParameter("levelname");
		   String classStarttime = request.getParameter("classStarttime");
		   String classEndtime = request.getParameter("classEndtime");
		   
		   ClassSessionVO csvo = new ClassSessionVO();
		   ClassSessionDAO csdao = new ClassSessionDAO();
		   csvo.setLevel_Name(levelname);
		   csvo.setStart_at(classStarttime);
		   csvo.setEnd_at(classEndtime);
		   csdao.insert(csvo);
		   System.out.println("in addlevel controller after dao.insert call");
		   
		   message = "Level added successfully";
		   response.setContentType("text/html");
		   //response.addHeader("message", message);
		   request.setAttribute("message1", message);
		  RequestDispatcher view = request.getRequestDispatcher("Attendance.jsp");
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
