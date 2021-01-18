package com.jobportal.Controller;

import java.text.SimpleDateFormat; 

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jobportal.Model.Admin_login;
import com.jobportal.Model.AppliedJob;
import com.jobportal.Model.Create_vacancy;
import com.jobportal.Model.Student;
import com.jobportal.Model.UserRegister;
import com.jobportal.Service.Admin_loginService;
import com.jobportal.Service.UserService;

@RestController
@RequestMapping("/admin_login")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", exposedHeaders = "Authorization")
public class AdminLoginController {

	@Autowired
	private Admin_loginService admin_loginservice;
	
	JSONObject json = new JSONObject();
	
	@PostMapping("/adminLogin")  
    public int adminLogin(@RequestBody Admin_login admin_login)  
    {  
        int status;  
        
      System.out.println("email="+admin_login.getEmail());
      System.out.println("pass="+admin_login.getPassword());
        // Authenticate User.  
        status = admin_loginservice.adminLogin(admin_login.getEmail(), admin_login.getPassword());  
         return status; 
    }  
	@PostMapping("/adminSendOtp")
	public String adminSendOtp(@RequestBody Admin_login admin_login)
	{
		
		String email=admin_login.getEmail();
	  int id= admin_loginservice.adminSendOtp(admin_login);
		String otp  = null;
		String msg = "0";
		 if (id>0) {
			 String token = UUID.randomUUID().toString();

				//int result = admin_loginService.updateAdminDetail(token,id);




				Properties props = System.getProperties();
				 props.setProperty("mail.transport.protocol", "smtp");
				        props.setProperty("mail.smtp.host", "smtp.gmail.com");
				        props.setProperty("mail.smtp.port", "587");
				        props.setProperty("mail.smtp.user", "karampurimegha@gmail.com");
				        props.setProperty("mail.smtp.password", "megha786");
				        props.setProperty("mail.smtp.starttls.enable", "true");
				        props.setProperty("mail.smtp.auth", "true");


				        Session session = Session.getInstance(props, new javax.mail.Authenticator(){
				            protected PasswordAuthentication getPasswordAuthentication() {
				                return new PasswordAuthentication(
				                    "karampurimegha@gmail.com", "megha786");// Specify the Username and the PassWord
				            }
				        });


				        session.setDebug(false);

				        try {
				            Transport transport = session.getTransport();

				            MimeMessage message = new MimeMessage(session);
				            message.setSubject("Password Reset Request");
				            message.setFrom(new InternetAddress("karampurimegha@gmail.com"));
				            message.addRecipients(Message.RecipientType.TO, email);

				            MimeMultipart multipart = new MimeMultipart();

				            MimeBodyPart messageBodyPart = new MimeBodyPart();
				            // Using numeric values 
				            int randomPin   =(int) (Math.random()*900000)+100000; 
				             otp  = String.valueOf(randomPin); 
				            
				            System.out.println("otp="+otp);
				            
				            String msgBody  ="Your one time password is "+otp+" for Forgot Password at this OTP is valid for 2 Minutes";

				            messageBodyPart.setContent(msgBody, "text/html");

				            multipart.addBodyPart(messageBodyPart);
				            message.setContent(multipart);

				            transport.connect();
				            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
				            transport.close();
				            return otp;
				        }
				        catch (MessagingException e) {
				            e.printStackTrace();
				        }
				        return otp;

		} else {

			 return msg;
		}
		
	}
	@PostMapping("/adminNewPass")
	public int adminNewPass(@RequestBody Admin_login admin_login) {
//		String mail = userRegister.getEmail();
//		String pass = userRegister.getPassword();
//		Strin
		return admin_loginservice.adminNewPass(admin_login);
	}
	
	
	@PostMapping("/create_vacancy")
	public int createVacancy(@ModelAttribute("data") @Valid  Create_vacancy create_Vacancy, 
	HttpServletRequest request, 
	HttpServletResponse response

) throws IOException{
		
		
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    json=new JSONObject();
	   
	    String data = "";   
	    StringBuilder builder = new StringBuilder();
	    BufferedReader reader = request.getReader();
	    String line;
	    while ((line = reader.readLine()) != null) {
	        builder.append(line);
	    }
	    data = builder.toString();
	    System.out.println(data);
	    JSONObject jsonObj = new JSONObject(data);
	    System.out.println(jsonObj);
	   

	  String post = jsonObj.getString("post");
	  create_Vacancy.setPost(post);
	  
	  
	  String company_name = jsonObj.getString("company_name");
	  create_Vacancy.setCompany_name(company_name);
	  
	  String year_of_exp = jsonObj.getString("year_of_exp");
	  create_Vacancy.setYear_of_exp(year_of_exp);
	  
	  
	  String vacancy = jsonObj.getString("vacancy");
	  create_Vacancy.setVacancy(vacancy);
	  
	  String location = jsonObj.getString("location");
	  create_Vacancy.setLocation(location);
	  
	  String salary = jsonObj.getString("salary");
	  create_Vacancy.setSalary(salary);
	  
	  String required_skill = jsonObj.getString("required_skill");
	  create_Vacancy.setRequired_skill(required_skill);
	  
	  String job_desc = jsonObj.getString("job_desc");
	  create_Vacancy.setJob_desc(job_desc);
	  
	  String industry_type = jsonObj.getString("industry_type");
	  create_Vacancy.setIndustry_type(industry_type);
	  
	  String function_area = jsonObj.getString("function_area");
	  create_Vacancy.setFunction_area(function_area);
	  
	  String role = jsonObj.getString("role");
	  create_Vacancy.setRole(role);
	  
	  String employment_type = jsonObj.getString("employment_type");
	  create_Vacancy.setEmployment_type(employment_type);
	  
	  String education = jsonObj.getString("education");
	  create_Vacancy.setEducation(education);
	  
	  
	  String website = jsonObj.getString("website");
	  create_Vacancy.setWebsite(website);
	  
	  
	  String address = jsonObj.getString("address");
	  create_Vacancy.setAddress(address);
	  
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    Date date = new Date();  
//	    String dat= formatter.format(date);
//	    arr[] =dat
	    System.out.println(formatter.format(date));
	    
	    create_Vacancy.setCreated_date(formatter.format(date));
	    
	    create_Vacancy.setUpdated_date(formatter.format(date));
	    
	    create_Vacancy.setCv_active("1");
	  
	    create_Vacancy.setCreated_by("Megha");
	    
	   int flag= admin_loginservice.create_vacancy(create_Vacancy);
		
		return flag;
	}
	
			@GetMapping("/mng_vacancy")
			  public List<Create_vacancy>mng_vacancy(){
			  return admin_loginservice.mng_vacancy();
			  }
			  
			  @PostMapping("/delete_vacancy")
			  
			  public int delete_vacancy(
					  @ModelAttribute  @Valid Create_vacancy cv,
					  HttpServletRequest request,
					  HttpServletResponse response
					  )throws IOException{
					response.setContentType("application/json");
				    response.setCharacterEncoding("UTF-8");
				    json=new JSONObject();
				   
				    String data = "";   
				    StringBuilder builder = new StringBuilder();
				    BufferedReader reader = request.getReader();
				    String line;
				    while ((line = reader.readLine()) != null) {
				        builder.append(line);
				    }
				    data = builder.toString();
				    System.out.println(data);
				    JSONObject jsonObj = new JSONObject(data);
				    System.out.println(jsonObj);
				    


				  int delete_id = jsonObj.getInt("delete_id");
				  int flag =  admin_loginservice.delete_vacancy(delete_id);
	
				  	return flag;
			  }
			  @PostMapping("/update_vacancy")
				public int update_vacancy(@ModelAttribute("data") @Valid  Create_vacancy create_Vacancy, 
				HttpServletRequest request, 
				HttpServletResponse response

			) throws IOException{
					
					
					response.setContentType("application/json");
				    response.setCharacterEncoding("UTF-8");
				    json=new JSONObject();
				   
				    String data = "";   
				    StringBuilder builder = new StringBuilder();
				    BufferedReader reader = request.getReader();
				    String line;
				    while ((line = reader.readLine()) != null) {
				        builder.append(line);
				    }
				    data = builder.toString();
				    System.out.println(data);
				    JSONObject jsonObj = new JSONObject(data);
				    System.out.println(jsonObj);
				   
                  int cv_id = jsonObj.getInt("cv_id");
                  create_Vacancy.setCv_id(cv_id);
                  
				  String post = jsonObj.getString("post");
				  create_Vacancy.setPost(post);
				  
				  
				  String company_name = jsonObj.getString("company_name");
				  create_Vacancy.setCompany_name(company_name);
				  
				  String year_of_exp = jsonObj.getString("year_of_exp");
				  create_Vacancy.setYear_of_exp(year_of_exp);
				  
				  
				  String vacancy = jsonObj.getString("vacancy");
				  create_Vacancy.setVacancy(vacancy);
				  
				  String location = jsonObj.getString("location");
				  create_Vacancy.setLocation(location);
				  
				  String salary = jsonObj.getString("salary");
				  create_Vacancy.setSalary(salary);
				  
				  String required_skill = jsonObj.getString("required_skill");
				  create_Vacancy.setRequired_skill(required_skill);
				  
				  String job_desc = jsonObj.getString("job_desc");
				  create_Vacancy.setJob_desc(job_desc);
				  
				  String industry_type = jsonObj.getString("industry_type");
				  create_Vacancy.setIndustry_type(industry_type);
				  
				  String function_area = jsonObj.getString("function_area");
				  create_Vacancy.setFunction_area(function_area);
				  
				  String role = jsonObj.getString("role");
				  create_Vacancy.setRole(role);
				  
				  String employment_type = jsonObj.getString("employment_type");
				  create_Vacancy.setEmployment_type(employment_type);
				  
				  String education = jsonObj.getString("education");
				  create_Vacancy.setEducation(education);
				  
				  
				  String website = jsonObj.getString("website");
				  create_Vacancy.setWebsite(website);
				  
				  
				  String address = jsonObj.getString("address");
				  create_Vacancy.setAddress(address);
				  
				  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
				    Date date = new Date();  
				    System.out.println(formatter.format(date));
				    
				    create_Vacancy.setCreated_date(formatter.format(date));
				    
				    create_Vacancy.setUpdated_date(formatter.format(date));
				    
				    create_Vacancy.setCv_active("1");
				  
				    create_Vacancy.setCreated_by("Megha");
				    
				   int flag= admin_loginservice.update_vacancy(create_Vacancy);
					
					return flag;
				}

				@GetMapping("/count_of_register")
				  public long count_of_register(){
				  return admin_loginservice.count_of_register();
				  }
				@GetMapping("/count_of_current_vacancy")
				  public long count_of_current_vacancy(){
				  return admin_loginservice.count_of_current_vacancy();
				  }
				
				@GetMapping("/count_of_appliedForJob")
				  public long count_of_appliedForJob(){
				  return admin_loginservice.count_of_appliedForJob();
				  }
				
				@GetMapping("/count_of_currentappliedForJob")
				  public long count_of_currentappliedForJob(){
				  return admin_loginservice.count_of_currentappliedForJob();
				  }
				
				@GetMapping("/getCompanyList")
				  public List<Create_vacancy> getCompanyList(){
				  return admin_loginservice.getCompanyList();
				  }
				  
				  
				  @PostMapping("/getCompanyWiseList") 
				  public List<Student> getCompanyWiseList (@ModelAttribute("data") @Valid AppliedJob ap,
							HttpServletRequest request, 
							HttpServletResponse response
							
						
						) throws IOException{
						response.setContentType("application/json");
					    response.setCharacterEncoding("UTF-8");
					    json=new JSONObject();
					   
					    String data = "";   
					    StringBuilder builder = new StringBuilder();
					    BufferedReader reader = request.getReader();
					    String line;
					    while ((line = reader.readLine()) != null) {
					        builder.append(line);
					    }
					    data = builder.toString();
					    System.out.println(data);
					    JSONObject jsonObj = new JSONObject(data);
					    System.out.println(jsonObj);
					    
					   

						  String company_name = jsonObj.getString("company_name");
						  List<Student> list=  admin_loginservice.getComWiseStudentData(company_name);
						
//						  for(int i=0;i<list.size();i++) {
//						  System.out.println("student data="+list.get(i));
//						  }
						 
					return list;		
							
							
						}
}
