package com.jobportal.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jobportal.Dao.TokenDao;
import com.jobportal.Model.Token;

@Repository("tokenDao")
public class TokenDaoImpl implements TokenDao{

	@Autowired
	SessionFactory sessionFactory;

	public long getTokenDetail(String email) {
		Session session=null;
		try {
			session= sessionFactory.getCurrentSession();
			Query<Token> query=session.createQuery("from token where email_id=:email");
			query.setParameter("email",email);
			List<Token> list=query.list();
			if(list.size()>0) {
				return list.get(0).getToken_id();
			}
			else {
				return 0;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error:"+e.getMessage());
		}
		finally  
        {  
            session.flush();  
        }  
          
        return 0;  
    }  

	public Boolean updateToken(String email, String token, String string) {
		// TODO Auto-generated method stub
		 Session session = null;  
	        try   
	        {  
	            session = sessionFactory.getCurrentSession();  
	            Query theQuery = null;        
	              
	            theQuery = session.createQuery("Update token set authenticationToken='"+token+"',secretKey='"+string+"' where email_id='"+email+"'");  
//	                  
//	            theQuery.setParameter("authenticationToken", token);  
//	            theQuery.setParameter("email_id", email);  
//	            theQuery.setParameter("secretKey", string);  
	            int result = theQuery.executeUpdate();  
                
	            if(result == 1)  
	            {  
	                return true;  
	            }  
	            else  
	            {  
	                return false;  
	            }  
	        }  
	        catch(Exception exception)  
	        {  
	            System.out.println("Error while updating token :: " + exception.getMessage());  
	            return false;  
	        }  
	        finally  
	        {  
	            session.flush();  
	        }             
	      
	}

	public void saveUserEmail(String email, int status) {
		 Session session = null;   
	        try  
	        {  
	            session = sessionFactory.getCurrentSession();  
	            Token t = new Token();  
	            t.setU_id(status);  
	            t.setEmail_id(email);  
	            session.save(t);   
	        }  
	        catch(Exception exception)  
	        {  
	            System.out.println("Exception in saving UserEmail In Token Table :: " + exception.getMessage());  
	        }  
	        finally  
	        {  
	            session.flush();  
	        }  
	          
	    }  
}
