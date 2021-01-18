package com.jobportal.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jobportal.Dao.Admin_loginDao;
import com.jobportal.Model.Admin_login;
import com.jobportal.Model.AppliedJob;
import com.jobportal.Model.Create_vacancy;
import com.jobportal.Model.Student;

@Repository("admin_loginDao")  

public class Admin_loginDaoImpl implements Admin_loginDao{

	
	// Autowired SessionFactory Object So that we can get session object used for interaction with Database.  
    @Autowired  
    private SessionFactory sessionFactory; 
    
	public int adminLogin(String email, String password) {
		Session session = null;  
        try  
        {  
            session = sessionFactory.getCurrentSession();  
              
            Query query = session.createQuery("from admin_login where email=:email and password=:password");  
            query.setParameter("email", email);  
            query.setParameter("password", password);  
            List<Admin_login> list = query.list();  
              
            int size = list.size();  
            if(size == 1)  
            {  
                return 1; 
            }  
            else  
            {  
                return -1;  
            }  
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

	public int adminSendOtp(Admin_login admin_login) {
		String email = admin_login.getEmail();
		Session session = null;  
		try {
			
			 session = sessionFactory.getCurrentSession();  
			 Query query = session.createQuery("from admin_login where email='"+email+"'");  
			 List<Admin_login> list = query.list();  
             
	            int size = list.size();  
	            if(size == 1)  
	            {  
	            	return list.get(0).getLogin_id();  
	            }  
	            else  
	            {  
	                return -1;  
	            }  
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int adminNewPass(Admin_login admin_login) {
		String mail = admin_login.getEmail();
		String pass = admin_login.getPassword();
		Session session = null;  
        try  
        {  
            session = sessionFactory.getCurrentSession();  
              
            Query query = session.createQuery("update admin_login set password='"+pass+"' where email='"+mail+"'");  
            int result = query.executeUpdate();
            if(result == 1)  
            {  
                return 1;
            }  
            else  
            {  
                return -1;  
            }  
        }  
        catch(Exception exception)  
        {  
            System.out.println("Excecption while checking mail : " + exception.getMessage());  
            return 0;  
        }  
	}

	public int create_vacancy(Create_vacancy create_Vacancy) {
		Session session= null;
		try {
			session=sessionFactory.getCurrentSession();
			Integer i = (Integer) session.save(create_Vacancy);
			System.out.println("safasfasfasf="+i);
			
			if(i>=1)  
            {  
                return i;
            }  
            else  
            {  
                return -1;  
            }  
        }  
        catch(Exception exception)  
        {  
            System.out.println("Excecption while saving vacancy : " + exception.getMessage());  
            return 0;  
        }  
	}

	public List<Create_vacancy> mng_vacancy() {
		 Session session = null;
		 Session currentSession = sessionFactory.getCurrentSession();
		 Query query=currentSession.createQuery("from create_vacancy where cv_active=1");
		 List<Create_vacancy> list=query.getResultList();  
		        return list;
	}

	public int delete_vacancy(int delete_id) {
		Session session = null;  
        try  
        {  
            session = sessionFactory.getCurrentSession();  
              
            Query query = session.createQuery("update create_vacancy set cv_active=0 where cv_id="+delete_id);  
            int result = query.executeUpdate();
            if(result == 1)  
            {  
                return 1;
            }  
            else  
            {  
                return -1;  
            }  
        }  
        catch(Exception exception)  
        {  
            System.out.println("Excecption while checking mail : " + exception.getMessage());  
            return 0;  
        }  
	}

	public int update_vacancy(Create_vacancy create_Vacancy) {
		try  
        {  
        	  System.out.println("in DAO1");
           sessionFactory.getCurrentSession().update(create_Vacancy);  
              System.out.println("in DAO");
         
            return 1;  
        }  
        catch(Exception exception)  
        {  
            System.out.println("Excecption while saving admin Details : " + exception.getMessage());  
            return 0;  
        }  
      
}

	public long count_of_register() {
		 Session session = null;
		 Session currentSession = sessionFactory.getCurrentSession();
		
		 String hql = "select count(email) from user_register";
		 Query query = currentSession.createQuery(hql);
		Long count=(Long) query.uniqueResult();
		return count;
	}

	public long count_of_current_vacancy() {
		Session session = null;
		 Session currentSession = sessionFactory.getCurrentSession();
		
		 String hql = "select count(cv_id) from create_vacancy where created_date=CURDATE()";
		 Query query = currentSession.createQuery(hql);
		Long count=(Long) query.uniqueResult();
		return count;
	}

	public long count_of_appliedForJob() {
		Session session = null;
		 Session currentSession = sessionFactory.getCurrentSession();
		 String hql = "select count(applied_job_id) from applied_job";
		 Query query = currentSession.createQuery(hql);
		Long count=(Long) query.uniqueResult();
		return count;
	}

	public long count_of_currentappliedForJob() {
		Session session = null;
		 Session currentSession = sessionFactory.getCurrentSession();
		 String hql = "select count(applied_job_id) from applied_job where date=CURDATE()";
		 Query query = currentSession.createQuery(hql);
		Long count=(Long) query.uniqueResult();
		return count;
	}

	public List<Create_vacancy> getCompanyList() {
		 Session session = null;
		 Session currentSession = sessionFactory.getCurrentSession();
		 Query query=currentSession.createQuery("select company_name  as com from create_vacancy");
		 List<Create_vacancy> list=query.getResultList();  
		        return list;
	}

	public  List<Student> getComWiseStudentData(String company_name) {
		 Session session = null;
		 Session currentSession = sessionFactory.getCurrentSession();
		 Session currentSession1= sessionFactory.getCurrentSession();
		 Query query=currentSession.createQuery("select student_id from applied_job where company_name='"+company_name+"'");
		 List<AppliedJob> list=query.getResultList();  
		 System.out.println("list="+list);
		 List<Student> st= new ArrayList<Student>();
		 List<Student> list1=null;
			for(int i=0;i<list.size();i++) { 
		 Query query1=currentSession1.createQuery("from student where student_id="+list.get(i));
		  list1=query1.list();  
		for(Student li : list1) {
			int student_id =li.getStudent_id();
			String f_name = li.getF_name();
			String m_name = li.getM_name();
			String l_name = li.getL_name();
			String contact_no = li.getContact_no();
			String dob = li.getDob();
			String gender = li.getGender();
			String email_id = li.getEmail_id();
			String address = li.getAddress();
			String clg_name_10 = li.getClg_name_10();
			String passing_yr_10 = li.getPassing_yr_10();
			String percent_10 = li.getPercent_10();
			String clg_name_12 = li.getClg_name_12();
			String passing_yr_12 = li.getPassing_yr_12();
			String percent_12 = li.getPercent_12();
			String degree = li.getDegree();
			String passing_yr_degree = li.getPassing_yr_degree();
			String percent_degree = li.getPercent_degree();
			String last_org = li.getLast_org();
			String exp_years = li.getExp_years();
			String last_ctc = li.getLast_ctc();
			String notice_period = li.getNotice_period();
			String key_skills = li.getKey_skills();
			String projects = li.getProjects();
			String certifications = li.getCertifications();
			String student_active = li.getStudent_active();
			int user_id = li.getUser_id();
			
			Student student = new Student( student_id, f_name,  m_name,  l_name,  contact_no,  dob,
					 gender,  email_id,  address,  clg_name_10,  passing_yr_10,  percent_10,
					 clg_name_12,  passing_yr_12,  percent_12,  degree,  passing_yr_degree,
					 percent_degree,  last_org,  exp_years,  last_ctc,  notice_period,
					 key_skills,  projects,  certifications,  student_active,  user_id);
			st.add(student);
		}
		 System.out.println(list1);
			}
		        return st;
			
	}

//	public List<Create_vacancy> count_of_register() {
//		 Session session = null;
//		 Session currentSession = sessionFactory.getCurrentSession();
//		 Query query=currentSession.createQuery("SELECT count(email) FROM user_register");
//		 List<Create_vacancy> list=query.getResultList();  
//		        return list;
//	}
	
}