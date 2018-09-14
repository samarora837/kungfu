package com.DAO;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.VO.AssignRankVO;
import com.VO.AttendanceVO;
import com.VO.RankReqVO;
import com.VO.RankVO;

public class RankDAO {
	Session session = null;

	public RankDAO() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session =sessionFactory.openSession();
	}
	public boolean insert(RankVO RankVO){

		boolean flag = false;

		try{
			System.out.println("ïnside feesdao");
			Transaction tr=session.beginTransaction();
			System.out.println("in rankdao after creating session object" );
			System.out.println("Inserting Rank Record");
			session.save(RankVO);


			Set<RankReqVO> rankReqSet = RankVO.getRankreqSet();
			Iterator<RankReqVO> iterator = rankReqSet.iterator();
			while (iterator.hasNext()) {
				RankReqVO rankReqVO = iterator.next();
				rankReqVO.setRank(RankVO);
				session.save(rankReqVO);
			}

			tr.commit();
			flag = true;
			System.out.println("Rank insert Done");
			//return flag;
		}catch(Exception e){
			e.printStackTrace();

		}
		return flag;
	}

	public List<RankVO> getRanks(){
		List<RankVO> rankList = null;
		try{			
			Query query = session.createQuery("from RankVO ");
			rankList = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}

		return rankList;
	}

	public String assignRank(AssignRankVO assignRankVO){
		String result = null;
		try{
				System.out.println("inside assignRank");
				String rank_name = assignRankVO.getRankName();
				System.out.println("rank name "+rank_name);
				String hql = "UPDATE StudentVO set rank = :rankname "  + 
						"WHERE student_num = :sid";
				Query query = session.createQuery(hql);
				query.setParameter("sid", assignRankVO.getStudent_NUM());
				query.setParameter("rankname", rank_name);
				int rest = query.executeUpdate();
				System.out.println("Rows affected: " + rest);
				 session.flush();
			     session.clear();
			if(rest == 1){
				result = "Rank Assigned Successfully";
				Transaction tr=session.beginTransaction();
				System.out.println("in Assignrankdao after creating session object" );
				System.out.println("Assigning Rank Record");
				session.save(assignRankVO);
				tr.commit();
			}else{
				result = "Wrong Student ID. Please enter correct STudent ID";
			}			
			System.out.println("Rank assign Done");
		}catch(Exception e){
			e.printStackTrace();

		}

		return result;
	}
	public List<RankVO> searchRank(String rank, String student_num) {

		Session session = null;
		List<RankVO> attendanceList = null;
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session =sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			//Create new instance of Contact and set 
			String qry = "From AssignRankVO  ";
			
			if(rank != null && ! "".equals(rank.trim())){
				qry = qry + " where rankName = '" + rank +"' ";
			}
			
			if(student_num != null && ! "".equals(student_num.trim())){
				if(rank != null && ! "".equals(rank.trim()))
					qry = qry + " AND ";
				else
					qry = qry+" where ";
				
				qry = qry+ "student_NUM = '"+ student_num+ "' ";

			}
			
			System.out.println("Query"+qry.toString());
			Query query = session.createQuery(qry.toString());

			attendanceList = query.list();
			if(attendanceList != null){
				System.out.println("attendanceList size"+attendanceList.size());
			}
			tr.commit();
			System.out.println("Done");
			
		}catch(Exception e){
			e.printStackTrace();

		}

		return attendanceList;
	}

}


