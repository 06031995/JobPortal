package com.jobportal.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jobportal.Dao.UserDao;
import com.jobportal.Model.PrincipleRegister;
import com.jobportal.Model.UserRegister;

@Repository("userDao")  
public class UserDaoImpl implements UserDao{

	// Autowired SessionFactory Object So that we can get session object used for interaction with Database.  
    @Autowired  
    private SessionFactory sessionFactory;  
          
    /* 
     * Register Admin Details.  
    */  
	public int saveUserDetail(UserRegister userRegister) {
		 Session session = null;  
	        try  
	        {  
	            session = sessionFactory.getCurrentSession();  
	              
	            Integer id = (Integer) session.save(userRegister);  
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

	public int saveLogin(String email, String password) {
		   Session session = null;  
	        try  
	        {  
	            session = sessionFactory.getCurrentSession();  
	              
	            Query query = session.createQuery("from user_register where email=:email and password=:password");  
	            query.setParameter("email", email);  
	            query.setParameter("password", password);  
	            List<UserRegister> list = query.list();  
	              
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
	public int findUserByEmail(String email) {
		Session session = null;  
		        try  
		        {  
		        	System.out.print("email=="+email);
		            session = sessionFactory.getCurrentSession();  
		              
		            Query query = session.createQuery("from user_register where email='"+email+"'");  
		            List<UserRegister> list = query.list();  
		              
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
		            System.out.println("Excecption while checking mail : " + exception.getMessage());  
		            return 0;  
		        }  
		        finally  
		        {  
		            session.flush();  
		        } 
		}



		public int updateUserDetail(String token,int id) {
		Session session = null;  
		        try  
		        {  
		        	System.out.print("token=="+token);
		            session = sessionFactory.getCurrentSession();  
		              
		            Query query = session.createQuery("update user_register set resetToken='"+token+"' where user_id="+id);  
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

		public int newPass(UserRegister userRegister) {
			String mail = userRegister.getEmail();
			String pass = userRegister.getPassword();
			Session session = null;  
	        try  
	        {  
	            session = sessionFactory.getCurrentSession();  
	              
	            Query query = session.createQuery("update user_register set password='"+pass+"' where email='"+mail+"'");  
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

		public int prinipleRegister(PrincipleRegister principleRegister) {
			 Session session = null;  
		        try  
		        {  
		            session = sessionFactory.getCurrentSession();  
		              
		            Integer id = (Integer) session.save(principleRegister);  
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

		public int savePrincipleLogin(String email, String password) {
			 Session session = null;  
		        try  
		        {  
		            session = sessionFactory.getCurrentSession();  
		              
		            Query query = session.createQuery("from principle_register where email='"+email+"' and password='"+password+"'");  
//		            query.setParameter("email", email);  
//		            query.setParameter("password", password);  
		            List<PrincipleRegister> list = query.list();  
		              
		            int size = list.size();  
		            if(size == 1)  
		            {  
		                return list.get(0).getPrinciple_id();  
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

		public int newPrinciplePass(PrincipleRegister principleRegister) {
			String mail = principleRegister.getEmail();
			String pass = principleRegister.getPassword();
			Session session = null;  
	        try  
	        {  
	            session = sessionFactory.getCurrentSession();  
	              
	            Query query = session.createQuery("update principle_register set password='"+pass+"' where email='"+mail+"'");  
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

		public int checkeuser(String email) {
		
			Session session = null;  
	        try  
	        {  
	            session = sessionFactory.getCurrentSession();  
	              
	            Query query = session.createQuery("from user_register where email='"+email+"'");  
	            List<UserRegister> result = query.list();
	            
	            if(result.size()>0)  
	            {  
	                return result.get(0).getUser_id();
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

		
	



}
