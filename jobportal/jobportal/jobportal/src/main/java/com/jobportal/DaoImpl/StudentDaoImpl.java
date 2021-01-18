package com.jobportal.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jobportal.Dao.StudentDao;
import com.jobportal.Model.AppliedJob;
import com.jobportal.Model.Create_vacancy;
import com.jobportal.Model.Student;
import com.jobportal.Model.UserRegister;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao{
	
	 @Autowired  
	    private SessionFactory sessionFactory;  
	          

	public int save_student(Student student) {
		 Session session = null;  
	        try  
	        {  
	            session = sessionFactory.getCurrentSession();  
	              
	            Integer id = (Integer) session.save(student);  
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


	public int getUserByEmailId(String email_id) {
		
		 Session session = null;  
	        try  
	        {  
	            session = sessionFactory.getCurrentSession();  
	            Query query = session.createQuery("from user_register where email='"+email_id+"'");
	            List<UserRegister> list = ((org.hibernate.query.Query) query).list();  
	              
	            int size = list.size();  
	            if(size == 1)  
	            {  
	                return list.get(0).getUser_id();  
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


	public List<Student> get_student(int student_id) {
		 Session currentSession = sessionFactory.getCurrentSession(); 
		//int student_id= student.getStudent_id();
	        Query query=currentSession.createQuery("from student where student_id="+student_id);  
//	        query.setParameter("student_id", student.getStudent_id());  
	        List<Student> list=query.getResultList(); 
	        System.out.println("list="+list);
	        return list;  
	}


	public int save_update_student(Student student) {
//		 Session session = null;  
	        try  
	        {  
	        	  System.out.println("in DAO1");
	           sessionFactory.getCurrentSession().update(student);  
	              System.out.println("in DAO");
	         //   Integer id =( session.update(student);  
	            return 1;  
	        }  
	        catch(Exception exception)  
	        {  
	            System.out.println("Excecption while saving admin Details : " + exception.getMessage());  
	            return 0;  
	        }  
	      
	}


	public List<Create_vacancy> getVacancy(String post, String location) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		//int student_id= student.getStudent_id();
	        Query query=currentSession.createQuery("from create_vacancy where post='"+post+"'or location='"+location+"'");  
//	        query.setParameter("student_id", student.getStudent_id());  
	        List<Create_vacancy> list=query.getResultList();  
	        return list;  
	}


	public int save_Applied(AppliedJob applied_job) {
		Session session = null;  
        try  
        {  
            session = sessionFactory.getCurrentSession();  
              
            Integer id = (Integer) session.save(applied_job);  
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


	public int getStudentId(int user_id) {
		Session session = null;  
        try  
        {  
            session = sessionFactory.getCurrentSession();  
            Query query=session.createQuery("from student where user_id="+user_id);  
	        List<Student> list=query.getResultList();  
            if(list.size() > 0) {
            	int id =list.get(0).getStudent_id();
            	return id;
            }else {
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


	public String getCompanyName(int cv_id) {
		Session session = null;  
		  List<Create_vacancy> list=null;
        try  
        {  
            session = sessionFactory.getCurrentSession();  
            Query query=session.createQuery("from create_vacancy where cv_id="+cv_id);  
	        list=query.getResultList();  
            if(list.size() > 0) {
            	String Company_name =list.get(0).getCompany_name();
            	return Company_name;
            }else {
            	return "-1";
            }
        }  
        catch(Exception exception)  
        {  
            System.out.println("Excecption while saving admin Details : " + exception.getMessage());  
            return "0";  
        }  
       
	}


	public int checkRegisterId(int register_id) {
		Session session = null;
		 List<Student> list=null;
	        try  
	        {  
	            session = sessionFactory.getCurrentSession();  
	            Query query=session.createQuery("from student where user_id="+register_id);  
		        list=query.getResultList();  
	            if(list.size() > 0) {
	            	int st_id =list.get(0).getStudent_id();
	            	return st_id;
	            }else {
	            	return -1;
	            }
	        }  
	        catch(Exception exception)  
	        {  
	            System.out.println("Excecption while saving admin Details : " + exception.getMessage());  
	            return 0;  
	        }  
	}

	


//	public List<Create_vacancy> getVacancy(Create_vacancy cv) {
//		 Session currentSession = sessionFactory.getCurrentSession(); 
//			//int student_id= student.getStudent_id();
//		 String post= cv.getPost();
//		 String loc = cv.getLocation();
//		        Query query=currentSession.createQuery("from create_vacancy where post='"+post+"'and location='"+loc+"'");  
////		        query.setParameter("student_id", student.getStudent_id());  
//		        List<Create_vacancy> list=query.getResultList();  
//		        return list;  
//		}


//	public List<Create_vacancy> getVacancy(String post, String location) {
//		 Session session = null;  
//		  List<Create_vacancy> list=null;
//	        try  
//	        {  
//	            session = sessionFactory.getCurrentSession();  
//	            Query query = session.createQuery("from user_register where post='"+post+"'location='"+location+"'");
//	          list = ((org.hibernate.query.Query) query).list();  
//	              
//	            int size = list.size();  
//	            if(size == 1)  
//	            {  
//	                return list;
//	            }  
//	           
//	        }  
//	        catch(Exception exception)  
//	        {  
//	            System.out.println("Excecption while saving admin Details : " + exception.getMessage());  
//	           
//	        }  
//	        finally  
//	        {  
//	            session.flush();  
//	        }  
//	}

	
	@Override
	public List<Create_vacancy>  getStudentAppliedJob(int student_id) {
		Session session=null;
		Session session1=null;
		List<AppliedJob> li = null;
		
		List<Create_vacancy>  cv1  = new ArrayList<Create_vacancy>();
		try {
			session=sessionFactory.getCurrentSession();
			Query query = session.createQuery("select cv_id from applied_job where student_id="+student_id);
			li = ((org.hibernate.query.Query) query).list();
			for(int i=0;i<li.size();i++) {
				List<Create_vacancy> cv = null;
				session1=sessionFactory.getCurrentSession();
				Query query1 = session1.createQuery("from create_vacancy where cv_id="+li.get(0));
				cv = ((org.hibernate.query.Query) query1).list();
				for(Create_vacancy c :cv) {
					
					int cv_id = c.getCv_id();
					 String post= c.getPost();
					 String company_name  =c.getCompany_name();
					 String year_of_exp = c.getYear_of_exp();
					 String  vacancy = c.getVacancy();
					  String location= c.getLocation();
					 String salary =c.getSalary();
					 String required_skill= c.getRequired_skill();
					 String job_desc = c.getJob_desc();
					 String industry_type = c.getIndustry_type();
					 String function_area= c.getFunction_area();
					 String role= c.getRole();
					 String employment_type= c.getEmployment_type();
					 String  education  = c.getEducation();
					 String  website = c.getWebsite();
					 String address = c.getAddress();
					 String created_date = c.getCreated_date();
					 String updated_date =c.getUpdated_date();
					 String created_by = c.getCreated_date();
					 String cv_active= c.getCv_active();
					 Create_vacancy cv2= new Create_vacancy(cv_id ,post,  company_name,  year_of_exp,  vacancy,
								 location,  salary,  required_skill,  job_desc,  industry_type,
								 function_area,  role,  employment_type,  education,  website,  address,
								 created_date,  updated_date,  created_by,  cv_active);
					 cv1.add(cv2);
				}
				
				
			}
			return cv1;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cv1;
	}


	


}
