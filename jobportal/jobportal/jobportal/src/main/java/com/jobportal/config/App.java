package com.jobportal.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jobportal.Dao.Admin_loginDao;
import com.jobportal.Dao.PrincipleDao;
import com.jobportal.Dao.StudentDao;
import com.jobportal.Dao.UserDao;
import com.jobportal.DaoImpl.Admin_loginDaoImpl;
import com.jobportal.DaoImpl.PrincipleDaoImpl;
import com.jobportal.DaoImpl.StudentDaoImpl;
import com.jobportal.DaoImpl.UserDaoImpl;
import com.jobportal.Service.Admin_loginService;
import com.jobportal.Service.PrincipleService;
import com.jobportal.Service.StudentService;
import com.jobportal.Service.TokenService;
import com.jobportal.Service.UserService;
import com.jobportal.ServiceImpl.Admin_loginServiceImpl;
import com.jobportal.ServiceImpl.PrincipleServiceImpl;
import com.jobportal.ServiceImpl.StudentServiceImpl;
import com.jobportal.ServiceImpl.TokenServiceImpl;
import com.jobportal.ServiceImpl.UserServiceImpl;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Hello world!
 *
 */
@Configuration  
@EnableWebMvc  
@EnableTransactionManagement  
@ComponentScan("com.jobportal")  

@PropertySource(value = { "classpath:application.properties" })  
public class App implements WebMvcConfigurer {  
    
  @Autowired  
  private Environment env;  
    
  @Bean  
  public DataSource myDataSource() {  
        
      // create connection pool  
      ComboPooledDataSource myDataSource = new ComboPooledDataSource();  

      // set the jdbc driver  
      try {  
          myDataSource.setDriverClass("com.mysql.jdbc.Driver");         
      }  
      catch (PropertyVetoException exc) {  
          throw new RuntimeException(exc);  
      }  
        
      // set database connection props  
      myDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jobportal");  
      myDataSource.setUser(env.getProperty("jdbc.user"));  
      myDataSource.setPassword(env.getProperty("jdbc.password"));  
                
      // set connection pool props  
      myDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));  
      myDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));  
      myDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));       
      myDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));  

      return myDataSource;  
  }  
    
  private Properties getHibernateProperties() {  

      // set hibernate properties  
      Properties props = new Properties();  
      props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));  
      props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));  
      props.setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql"));  
      props.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl"));  
      return props;                 
  }  
    
  // need a helper method   
      // read environment property and convert to int  
        
      private int getIntProperty(String propName) {  
            
          String propVal = env.getProperty(propName);  
            
          // now convert to int  
          int intPropVal = Integer.parseInt(propVal);  
          return intPropVal;  
      }  
        
      @Bean  
      public LocalSessionFactoryBean sessionFactory(){  
            
          // create session factory  
          LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();  
            
          // set the properties  
          sessionFactory.setDataSource(myDataSource());  
          sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));  
          sessionFactory.setHibernateProperties(getHibernateProperties());  
            
          return sessionFactory;  
      }  
        
      @Bean  
      @Autowired  
      public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {  
            
          // setup transaction manager based on session factory  
          HibernateTransactionManager txManager = new HibernateTransactionManager();  
          txManager.setSessionFactory(sessionFactory);  

          return txManager;  
      }     
     @Bean
     public UserService userService() {
    	 return new UserServiceImpl();
     }
     @Bean
     public UserDao userDao() {
    	 return new UserDaoImpl();
     }
     
    @Bean
    public TokenService tokenService() {
    	return new TokenServiceImpl();
    }
    @Bean
    public Admin_loginService admin_loginService() {
   	 return new Admin_loginServiceImpl();
    }
    @Bean
    public Admin_loginDao admin_loginDao() {
   	 return new Admin_loginDaoImpl();
    }
    
    @Bean
    public StudentService studentService() {
   	 return new StudentServiceImpl();
    }
    @Bean
    public StudentDao studentDao() {
   	 return new StudentDaoImpl();
    }
    
    @Bean
    public PrincipleService principleService() {
   	 return new PrincipleServiceImpl();
    }
    @Bean
    public PrincipleDao principleDao() {
   	 return new PrincipleDaoImpl();
    }
    
}  
