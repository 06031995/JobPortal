package com.jobportal.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jobportal.Dao.PrincipleDao;
import com.jobportal.Model.Create_vacancy;
import com.jobportal.Model.Principle;

@Repository("principleDao")
public class PrincipleDaoImpl implements PrincipleDao{

	 @Autowired  
	    private SessionFactory sessionFactory;

	public int savePrinciple(Principle principle) {
		Session session = null;  
        try  
        {  
            session = sessionFactory.getCurrentSession();  
              
            Integer id = (Integer) session.save(principle);  
            return id;  
        }  
        catch(Exception exception)  
        {  
            System.out.println("Excecption while saving admin Details : " + exception.getMessage());  
            return 0;  
        }  
        finally  
        {  
            session.flush();  
        }  
}

	public long totalPrinciple() {
		Session session = null;
		 Session currentSession = sessionFactory.getCurrentSession();
		 String hql = "select count(principle_id) from principle_profile";
		 Query query = currentSession.createQuery(hql);
		Long count=(Long) query.uniqueResult();
		return count;
	}

	public List<Principle> getprinciple_list() {
		 Session session = null;
		 Session currentSession = sessionFactory.getCurrentSession();
		 Query query=currentSession.createQuery("from principle_profile");
		 List<Principle> list=query.getResultList();  
		        return list;
	}
	
//	public long count_of_currentappliedForJob() {
//		Session session = null;
//		 Session currentSession = sessionFactory.getCurrentSession();
//		 String hql = "select count(applied_job_id) from applied_job where date=CURDATE()";
//		 Query query = currentSession.createQuery(hql);
//		Long count=(Long) query.uniqueResult();
//		return count;
//	}
}
