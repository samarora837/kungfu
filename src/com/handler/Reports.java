package com.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.AttendanceDAO;
import com.DAO.ClassSessionDAO;
import com.DAO.PayDAO;
import com.DAO.RankDAO;
import com.VO.AttendanceVO;
import com.VO.ClassSessionVO;
import com.VO.PayVO;
import com.VO.RankVO;

/**
 * Servlet implementation class Reports
 */
@WebServlet("/Reports")
public class Reports extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Reports() {
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
		/*		if(list != null){
			System.out.println("Length of rank list"+list.size());
			for (int j = 0; j < list.size(); j++) { 
				System.out.println(list.get(j));
			}
		}*/

		ClassSessionVO csvo=new ClassSessionVO();
		ClassSessionDAO csdao = new ClassSessionDAO();
		List<ClassSessionVO> ls1 = null;
		ls1=csdao.load(csvo);

		/*		if(ls1 != null){
			System.out.println("Length of level list"+ls1.size());
			for (int j = 0; j < ls1.size(); j++) { 
				System.out.println(ls1.get(j));
			}
		}*/
		if(request.getRequestURL().toString().contains("serachAttendance")){

			AttendanceVO attendanceVO = new AttendanceVO();
			String attendanceDate = request.getParameter("start_date") ;
			System.out.println("attendanceDate"+attendanceDate);
			System.out.println("student_num"+request.getParameter("student_num"));
			System.out.println("level"+request.getParameter("level") );
			if(( request.getParameter("student_num") != null && !"".equals(request.getParameter("student_num").trim()) )){
				attendanceVO.setStudent_Num(request.getParameter("student_num"));
			}else{
				attendanceVO.setStudent_Num(null);
			}
			if(( request.getParameter("level") != null && !"".equals(request.getParameter("level").trim()) )){
				attendanceVO.setCsvo(request.getParameter("level"));
			}else{
				attendanceVO.setCsvo(null);
			}

			if(attendanceDate != null && !"".equals(attendanceDate.trim()) ){
				Date atndDate = new Date(attendanceDate);
				System.out.println("Attendance Date**********"+atndDate);
				attendanceVO.setAttendance_date( atndDate);
			}

			AttendanceDAO attendanceDAO = new AttendanceDAO();
			List<AttendanceVO> attendanceList = attendanceDAO.searchAttendance(attendanceVO);
			if(attendanceList != null) {
				request.setAttribute("attendanceList",attendanceList);
				if(attendanceList.size() == 0){
					request.setAttribute("messgaeAttendance","No Record Found");
				}
			}else{
				request.setAttribute("messgaeAttendance","No Record Found");
			}
			request.setAttribute("openTab","Attendance");
		}
		if(request.getRequestURL().toString().contains("serachRank")){

			RankVO rankVO = new RankVO();
			String rank = request.getParameter("rank") ;
			String student_num = request.getParameter("student_num");
			RankDAO dao = new RankDAO();
			List<RankVO> rankList = dao.searchRank(rank,student_num);
			if(rankList != null) {
				request.setAttribute("rankList",rankList);
				if(rankList.size() == 0){
					request.setAttribute("messgaeAttendance","No Record Found");
				}
			}else{
				request.setAttribute("messgaeAttendance","No Record Found");
			}
			request.setAttribute("openTab","Rank");
		}
		if(request.getRequestURL().toString().contains("serachFees")){
			String student_num = request.getParameter("student_num");
			String fee_date = request.getParameter("fee_date");

			PayVO pvo = new PayVO();
			Date paymentDate =null;

			if(( student_num != null && !"".equals(student_num.trim()) )){
				pvo.setStudent_Number(student_num);
			}else{
				pvo.setStudent_Number(null);
			}


			if(fee_date != null && !"".equals(fee_date.trim()) ){
				paymentDate = new Date(fee_date);
				pvo.setPayment_Date(paymentDate);
			}

			PayDAO pdao = new PayDAO();
			List<PayVO> feeList = pdao.searchFees(pvo);
			if(feeList != null) {
				System.out.println(feeList.get(0).getStudent_Number());
				request.setAttribute("fees",feeList);
				request.setAttribute("openTab", "Fees");
			}else{
				request.setAttribute("messgaeFees","No Record Found");
			}
		}
		request.setAttribute("levelList",ls1);
		request.setAttribute("ranks", list);
		request.getRequestDispatcher("reports.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
