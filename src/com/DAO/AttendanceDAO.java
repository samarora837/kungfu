package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.VO.AttendanceVO;

public class AttendanceDAO {

	public void insert(AttendanceVO avo){
		Session session = null;


		try{
			// This step will read hibernate.cfg.xml 

			//and prepare hibernate for use
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session =sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			//Create new instance of Contact and set 

			//values in it by reading them from form object
			System.out.println("Inserting Record");
			session.save(avo);
			tr.commit();
			System.out.println("Done");
		}catch(Exception e){
			e.printStackTrace();

		}finally{
			// Actual contact insertion will happen at this step
			// session.flush();
			// session.close();

		}

	}
	public List<AttendanceVO> searchAttendance(AttendanceVO attendanceVO){

		Session session = null;
		List<AttendanceVO> attendanceList = null;
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session =sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			//Create new instance of Contact and set 
			String qry = "From AttendanceVO  ";
			System.out.println("Student Num"+attendanceVO.getStudent_Num() );
			System.out.println("Attendance Date "+attendanceVO.getAttendance_date() );

			System.out.println("Level "+attendanceVO.getCsvo() );

			if(attendanceVO.getStudent_Num() != null){
				qry = qry + " where student_Num = '" + attendanceVO.getStudent_Num() +"' ";
			}
			
			if(attendanceVO.getAttendance_date() != null){
				if(attendanceVO.getStudent_Num() != null)
					qry = qry + " AND ";
				else
					qry = qry+" where ";
				
				qry = qry+ "attendance_date = '"+ attendanceVO.getAttendance_date()+ "' ";

			}
			if(attendanceVO.getCsvo() != null){
				if((attendanceVO.getStudent_Num() != null) || (attendanceVO.getAttendance_date() != null))
					qry = qry + " AND ";
				else
					qry = qry + " where ";
				
				qry = qry+"csvo = '"+ attendanceVO.getCsvo() +"'";
			}
			System.out.println("Query"+qry.toString());
			Query query = session.createQuery(qry.toString());
			
			/*if(attendanceVO.getStudent_Num() != null){
				query.setParameter("std_num",attendanceVO.getStudent_Num());
				System.out.println("std_num"+attendanceVO.getStudent_Num());
			}
			
			if(attendanceVO.getAttendance_date() != null){
				query.setParameter("atnd_date",attendanceVO.getAttendance_date());
				System.out.println("atnd_date"+attendanceVO.getAttendance_date());

			}
			if(attendanceVO.getCsvo() != null){
				query.setParameter("class_level",attendanceVO.getCsvo());
				System.out.println("class_level"+attendanceVO.getCsvo());

			}*/
			
			attendanceList = query.list();
			if(attendanceList != null){
				System.out.println("attendanceList size"+attendanceList.size());
			}
			tr.commit();
			System.out.println("Done");
			
		}catch(Exception e){
			e.printStackTrace();

		}finally{
			// Actual contact insertion will happen at this step
			// session.flush();
			// session.close();

		}

		return attendanceList;
	}

}
