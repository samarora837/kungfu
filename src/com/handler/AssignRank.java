package com.handler;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.RankDAO;
import com.VO.AssignRankVO;
import com.VO.RankVO;
import com.VO.StudentVO;

/**
 * Servlet implementation class AssignRank
 */

public class AssignRank extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AssignRank() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<String> list = new ArrayList<>();
		RankDAO rankDao =  new RankDAO();
		List<RankVO> ranklist = rankDao.getRanks();
		if(ranklist != null && ranklist.size() > 0){
			for (int i = 0; i < ranklist.size(); i++) { //i = 1 can be done to avoid white belt
				list.add(ranklist.get(i).getRank_name());
			}
		}
		//to print for debugging purpose
		if(list != null){
			System.out.println("Length of rank list"+list.size());
			for (int j = 0; j < list.size(); j++) { 
				System.out.println(list.get(j));
			}
		}
		request.setAttribute("ranks", list);
		request.getRequestDispatcher("AssignRank.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		String studentID=request.getParameter("studentID");
		String rankName=request.getParameter("rank");
		String dateOfUpgrade=request.getParameter("dateOfUpgrade");
		Date assign_rank_date = new Date(dateOfUpgrade);
		System.out.println("In Handler rankName: "+ rankName);

		AssignRankVO assignRankVO= new AssignRankVO();
		assignRankVO.setAssign_rank_date(assign_rank_date);
		assignRankVO.setStudent_NUM(studentID);
		assignRankVO.setRankName(rankName);

		RankDAO dao =  new RankDAO();
		String message = dao.assignRank(assignRankVO);
		response.setContentType("text/html");
		request.setAttribute("message", message);
		doGet(request,response);
		}

}
