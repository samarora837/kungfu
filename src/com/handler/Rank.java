package com.handler;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.RankDAO;
import com.VO.RankReqVO;
import com.VO.RankVO;


/**
 * Servlet implementation class Rank
 */

public class Rank extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public List<String> requirements=new ArrayList<String>();
	private String message;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Rank() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> list = new ArrayList<>();
		list.add("item1");
		list.add("item2");
		list.add("item3");

		request.setAttribute("ranks", list);
		request.getRequestDispatcher("Rank.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String countParam = request.getParameter("countOfRequirements");
		System.out.println("countParam:" +countParam);
		Set<RankReqVO> rankReqSet = new HashSet<RankReqVO>();
		int count =0;
		if(countParam != null && !"".equals(countParam.trim())){
			count=Integer.parseInt(request.getParameter("countOfRequirements"));
			System.out.println("count:" +count);
		}
		
		if(count >= 0){
			for(int i=0;i<=count;i++)
			{
				//adding requirements to the list
				String desc = request.getParameter("requirement["+i+"]");
				if(desc != null && !"".equals(desc.trim()) ){
					System.out.println("Requirement Description"+desc);
					RankReqVO rankReqVO = new RankReqVO();
					rankReqVO.setRank_req_desc(desc);
					rankReqSet.add(rankReqVO);
				}
			}
		}
		//getting all the form input parameters
		String rankName=request.getParameter("rankName");
		String requiredRank=request.getParameter("requiredRank");
		System.out.println("Rank Name"+rankName);
		System.out.println("requiredRank"+requiredRank);
		RankVO rankvo = new RankVO();
		rankvo.setRank_name(rankName);
		rankvo.setRankreqSet(rankReqSet);
		RankDAO rankDAO = new RankDAO();
		boolean resultFlag = rankDAO.insert(rankvo);
		//if insert is successful
		if(resultFlag){
			message = "Rank added successfully";
		}else{
			message = "Error in adding rank";
		}
		response.setContentType("text/html");

		request.setAttribute("message", message);
		RequestDispatcher view = request.getRequestDispatcher("Rank.jsp");
		view.forward(request, response);
	}

}
