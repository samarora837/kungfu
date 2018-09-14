package com.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.VO.ClassSessionVO;
import com.VO.FeesVO;

public class FeesDAO {
	
	public void insert(FeesVO FeesVO){
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
		 
		 
		  session.save(FeesVO);
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
	public List<FeesVO> load(FeesVO fvo)
	{
		
		List<FeesVO> ls=new ArrayList<FeesVO>();
		
		Session session=null;
		
		try
		{
			SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
			session=sessionFactory.openSession();
			System.out.println("inside load");
			Query q=session.createQuery("from FeesVO");
			ls=q.list();
			System.out.println("done" + ls.size());
		}
		catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		finally
		{
			//session.flush();
			//session.close();
		}
		return ls;
	}



}
