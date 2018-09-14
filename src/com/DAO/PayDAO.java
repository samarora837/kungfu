package com.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.VO.PayVO;

public class PayDAO {


	public void insert(PayVO PayVO){
		Session session = null;
		 

		  try{
		  // This step will read hibernate.cfg.xml 
		//and prepare hibernate for use
			  
		System.out.println("ïnside feesdao");
		  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		 session =sessionFactory.openSession();
		 Transaction tr=session.beginTransaction();
		 System.out.println("in feesdao after creating session object" );
		  //Create new instance of Contact and set 

		//values in it by reading them from form object
		 System.out.println("Inserting Record");
		 
		 
		  session.save(PayVO);
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
	
	public List search1(PayVO pvo)
	{
		
		List ls=new ArrayList();
		
		Session session=null;
		
		try
		{
			SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
			session=sessionFactory.openSession();
			System.out.println("inside load1 in paydao");
			Query q=session.createQuery("from PayVO where Student_Number='"+pvo.getStudent_Number()+"' and  payment_Date='"+pvo.getPayment_Date()+"'");
			ls=q.list();
			System.out.println("done" + ls.size());
		}
		catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		finally
		{
			session.flush();
			session.close();
		}
		return ls;
	}
	
	public List search2(PayVO pvo)
	{
		
		List ls=new ArrayList();
		
		Session session=null;
		
		try
		{
			SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
			session=sessionFactory.openSession();
			System.out.println("inside load1 in paydao");
			Query q=session.createQuery("from PayVO where Student_Number='"+pvo.getStudent_Number()+"'");
			ls=q.list();
			System.out.println("done" + ls.size());
		}
		catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		finally
		{
			session.flush();
			session.close();
		}
		return ls;
	}
	public List search3(PayVO pvo)
	{
		
		List ls=new ArrayList();
		
		Session session=null;
		
		try
		{
			SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
			session=sessionFactory.openSession();
			System.out.println("inside load1 in paydao");
			Query q=session.createQuery("from PayVO where payment_Date='"+pvo.getPayment_Date()+"'");
			ls=q.list();
			System.out.println("done" + ls.size());
		}
		catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		finally
		{
			session.flush();
			session.close();
		}
		return ls;
	}
	
	public List<PayVO> searchFees(PayVO payVO){

		Session session = null;
		List<PayVO> feeList = null;
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session =sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			//Create new instance of Contact and set 
			String qry = "From PayVO  ";
			System.out.println("Student Num"+payVO.getStudent_Number() );
			System.out.println("Payment Date "+payVO.getPayment_Date() );
			/*System.out.println("item name "+payVO.getItem_Name() );*/

			if(payVO.getStudent_Number() != null){
				qry = qry + " where Student_Number = '" + payVO.getStudent_Number() +"' ";
			}
			
			if(payVO.getPayment_Date() != null){
				if(payVO.getStudent_Number() != null)
					qry = qry + " AND ";
				else
					qry = qry+" where ";
				
				qry = qry+ "payment_Date = '"+ payVO.getPayment_Date()+ "' ";

			}
			/*if(payVO.getItem_Name() != null){
				if((payVO.getStudent_Number() != null) || (payVO.getPayment_Date() != null))
					qry = qry + " AND ";
				else
					qry = qry + " where ";
				
				qry = qry+"item_Name = '"+ payVO.getItem_Name()  +"'";
			}*/
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
			
			feeList = query.list();
			if(feeList != null){
				System.out.println("feeList size"+feeList.size());
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

		return feeList;
	}

}
