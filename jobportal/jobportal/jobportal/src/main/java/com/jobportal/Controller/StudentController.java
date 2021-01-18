package com.jobportal.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jobportal.Model.AppliedJob;
import com.jobportal.Model.Create_vacancy;
import com.jobportal.Model.Student;
import com.jobportal.Model.UserRegister;
import com.jobportal.Service.StudentService;
import com.mchange.v2.cfg.PropertiesConfigSource.Parse;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", exposedHeaders = "Authorization")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	JSONObject json = new JSONObject();
	
	@PostMapping("/save_student")
//	@RequestMapping(value="/student",method=RequestMethod.POST)
	public int save_student(@ModelAttribute("data") @Valid Student student, 
			BindingResult result,
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response,
			RedirectAttributes flashdata
		
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
	    
//	    String path=session.getServletContext().getRealPath("/");  
//        String filename=file.getOriginalFilename(); 
//        
//        System.out.println(path+" "+filename);  

	  String f_name = jsonObj.getString("f_name");
	  student.setF_name(f_name);
	  
	  String m_name = jsonObj.getString("m_name");
	  student.setM_name(m_name);
	  
	  String l_name = jsonObj.getString("l_name");
	  student.setL_name(l_name);
	  
	  String contact_no = jsonObj.getString("contact_no");
	  student.setContact_no(contact_no);
	  
	  String dob = jsonObj.getString("dob");
	  student.setDob(dob);
	  
	  String gender = jsonObj.getString("gender");
	  student.setGender(gender);
	  
	  String email_id = jsonObj.getString("email_id");
	  student.setEmail_id(email_id);
	  
	  String address = jsonObj.getString("address");
	  student.setAddress(address);
	  
	  String clg_name_10 = jsonObj.getString("clg_name_10");
	  student.setClg_name_10(clg_name_10);
	  
	  String passing_yr_10 = jsonObj.getString("passing_yr_10");
	  student.setPassing_yr_10(passing_yr_10);
	  
	  String percent_10 = jsonObj.getString("percent_10");
	  student.setPercent_10(percent_10);
	  
	  String clg_name_12 = jsonObj.getString("clg_name_12");
	  student.setClg_name_12(clg_name_12);
	  
	  String passing_yr_12 = jsonObj.getString("passing_yr_12");
	  student.setPassing_yr_12(passing_yr_12);
	  
	  String percent_12 = jsonObj.getString("percent_12");
	  student.setPercent_12(percent_12);
	  
	  String degree = jsonObj.getString("degree");
	  student.setDegree(degree);
	  
	  String passing_yr_degree = jsonObj.getString("passing_yr_degree");
	  student.setPassing_yr_degree(passing_yr_degree);
	  
	  String percent_degree = jsonObj.getString("percent_degree");
	  student.setPercent_degree(percent_degree);
	  
	  
	  
	  try {
		  String last_org =jsonObj.getString("last_org");
		  student.setLast_org(last_org);
		  
		  String exp_years=jsonObj.getString("exp_years");
		  student.setExp_years(exp_years);
		  
		  String last_ctc=jsonObj.getString("last_ctc");
		  student.setLast_ctc(last_ctc);
		  
		  String notice_period=jsonObj.getString("notice_period");
		  student.setNotice_period(notice_period);
		  
		  
	  }catch(Exception e) {
		  student.setLast_org("NA");
		  student.setExp_years("NA");
		  student.setLast_ctc("NA");
		  student.setNotice_period("NA");
	  }
	  
//	  String file = jsonObj.getString("file");
//	 String[] file1 = file.split("\\");
//	 String data1 = file1[2];
	  
	  try {
		  String key_skills =jsonObj.getString("key_skills");
		  student.setKey_skills(key_skills);
		  
		  
		  String projects=jsonObj.getString("projects");
		  student.setProjects(projects);
		  
		  String certifications=jsonObj.getString("certifications");
		  student.setCertifications(certifications);
		  
	  }catch(Exception e) {
		  student.setKey_skills("NA");
		  student.setProjects("NA");
		  student.setCertifications("NA");
		  
	  }
	 

	  int id = studentService.getUserByEmailId(email_id);
	  
	  student.setUser_id(id);
	  

		Properties props = System.getProperties();
		 props.setProperty("mail.transport.protocol", "smtp");
		        props.setProperty("mail.smtp.host", "smtp.gmail.com");
		        props.setProperty("mail.smtp.port", "587");
		        props.setProperty("mail.smtp.user", "karampurimegha@gmail.com");
		        props.setProperty("mail.smtp.password", "megha786");
		        props.setProperty("mail.smtp.starttls.enable", "true");
		        props.setProperty("mail.smtp.auth", "true");
		        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");


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
		            message.setSubject("");
		            message.setFrom(new InternetAddress("karampurimegha@gmail.com"));
		            message.addRecipients(Message.RecipientType.TO, email_id);

		            MimeMultipart multipart = new MimeMultipart();

		            MimeBodyPart messageBodyPart = new MimeBodyPart();
		            // Using numeric values 
		            int randomPin   =(int) (Math.random()*900000000)+100000000; 
		             String otp  = String.valueOf(randomPin); 
		            
		            System.out.println("otp="+otp);
		         
		           
		            messageBodyPart.setContent(otp, "text/html");

		            multipart.addBodyPart(messageBodyPart);
		            message.setContent(multipart);

		            transport.connect();
		            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
		            transport.close();
		        }catch (Exception e) {
		        	e.printStackTrace();
					// TODO: handle exception
				}
	 student.setStudent_active("1"); 
	  
	 int flag=studentService.save_student(student);
	  
		return flag;
		
		
	}
	
	  @GetMapping("/get_student/{student_id}")  
	  public List<Student> get_student(@PathVariable("student_id") int student_id,Student student) {  
	         
	         return studentService.get_student(student_id);  
	          
	    }  
	  
	  @PostMapping("/save_update_student")
	  public int save_update_student(@ModelAttribute("data") @Valid Student student,
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
		    
		    Integer student_id = jsonObj.getInt("student_id");
			  student.setStudent_id(student_id);
			  

			  String f_name = jsonObj.getString("f_name");
			  student.setF_name(f_name);
			  
			  String m_name = jsonObj.getString("m_name");
			  student.setM_name(m_name);
			  
			  String l_name = jsonObj.getString("l_name");
			  student.setL_name(l_name);
			  
			  String contact_no = jsonObj.getString("contact_no");
			  student.setContact_no(contact_no);
			  
			  String dob = jsonObj.getString("dob");
			  student.setDob(dob);
			  
			  String gender = jsonObj.getString("gender");
			  student.setGender(gender);
			  
			  String email_id = jsonObj.getString("email_id");
			  student.setEmail_id(email_id);
			  
			  String address = jsonObj.getString("address");
			  student.setAddress(address);
			  
			  String clg_name_10 = jsonObj.getString("clg_name_10");
			  student.setClg_name_10(clg_name_10);
			  
			  String passing_yr_10 = jsonObj.getString("passing_yr_10");
			  student.setPassing_yr_10(passing_yr_10);
			  
			  String percent_10 = jsonObj.getString("percent_10");
			  student.setPercent_10(percent_10);
			  
			  String clg_name_12 = jsonObj.getString("clg_name_12");
			  student.setClg_name_12(clg_name_12);
			  
			  String passing_yr_12 = jsonObj.getString("passing_yr_12");
			  student.setPassing_yr_12(passing_yr_12);
			  
			  String percent_12 = jsonObj.getString("percent_12");
			  student.setPercent_12(percent_12);
			  
			  String degree = jsonObj.getString("degree");
			  student.setDegree(degree);
			  
			  String passing_yr_degree = jsonObj.getString("passing_yr_degree");
			  student.setPassing_yr_degree(passing_yr_degree);
			  
			  String percent_degree = jsonObj.getString("percent_degree");
			  student.setPercent_degree(percent_degree);
			  
			  
			  
			  try {
				  String last_org =jsonObj.getString("last_org");
				  student.setLast_org(last_org);
				  
				  String exp_years=jsonObj.getString("exp_years");
				  student.setExp_years(exp_years);
				  
				  String last_ctc=jsonObj.getString("last_ctc");
				  student.setLast_ctc(last_ctc);
				  
				  String notice_period=jsonObj.getString("notice_period");
				  student.setNotice_period(notice_period);
				  
				  
			  }catch(Exception e) {
				  student.setLast_org("NA");
				  student.setExp_years("NA");
				  student.setLast_ctc("NA");
				  student.setNotice_period("NA");
			  }
			  
//			  String file = jsonObj.getString("file");
//			 String[] file1 = file.split("\\");
//			 String data1 = file1[2];
			  
			  try {
				  String key_skills =jsonObj.getString("key_skills");
				  student.setKey_skills(key_skills);
				  
				  
				  String projects=jsonObj.getString("projects");
				  student.setProjects(projects);
				  
				  String certifications=jsonObj.getString("certifications");
				  student.setCertifications(certifications);
				  
			  }catch(Exception e) {
				  student.setKey_skills("NA");
				  student.setProjects("NA");
				  student.setCertifications("NA");
				  
			  }
			  int id = studentService.getUserByEmailId(email_id);
			  
			  student.setUser_id(id);
			  
			  
			 student.setStudent_active("1"); 
			  
			 int flag=studentService.save_update_student(student);
			  
				return flag;
				
				
			}
//	  @GetMapping("/getVacancy")  
//	  public List<Create_vacancy> getVacancy(Create_vacancy cv) {  
//		  
//	  String post= cv.getPost();
//		 String loc = cv.getLocation();
//			 System.out.println(post+loc);
//	         return studentService.getVacancy(cv);  
//	          
//	    }  
//	  
	  @PostMapping("/getVacancy") 
	  public List<Create_vacancy> getVacancy (@ModelAttribute("data") @Valid Create_vacancy cv,
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
			 // cv.setPost(post);
			 String location = jsonObj.getString("location");
			// cv.setLocation(location);
			 List<Create_vacancy> list = studentService.getVacancy(post,location);
			  
			// cv.setPost(post);
			// cv.setLocation(location);
			  
			// cv.setCv_active("1"); 
			  
			 
				return list;
				
				
			}
	  @PostMapping("/save_Applied")
	  public int save_Applied(@ModelAttribute("data") @Valid AppliedJob applied_job, 
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
		    
		  

		  int student_id = jsonObj.getInt("student_id");
		  applied_job.setStudent_id(student_id);
		  
//		  int student_id = studentService.getStudentId(user_id);
//		  applied_job.setStudent_id(student_id);
		  
		  
		  
		  int cv_id = jsonObj.getInt("cv_id");
		  applied_job.setCv_id(cv_id);
		  
		  String com_name = studentService.getCompanyName(cv_id);
		 applied_job.setCompany_name(com_name);
		  
		 
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		    Date date = new Date();  
		    System.out.println(formatter.format(date));
		  applied_job.setDate(formatter.format(date));
		  
		  
		  applied_job.setApplied_active(1);
		  
		 int flag=studentService.save_Applied(applied_job);
		  
			return flag;
			
			
		}
	  
	  
	  @PostMapping("/checkRegisterId")
	  public int checkRegisterId(@ModelAttribute("data") @Valid Student st, 
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

		  int register_id = jsonObj.getInt("register_id");
		  
		 int flag=studentService.checkRegisterId(register_id);
		  
			return flag;
			
			
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
			  List<Student> list=  null;
			
			 
		return list;		
				
				
			}
	  
	  @PostMapping("/getStudentAppliedJob")
	  public List<Create_vacancy>  getStudentAppliedJob(@ModelAttribute("data") @Valid AppliedJob applied_job, 
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
		    


		  int student_id = jsonObj.getInt("student_id");
		  
		  
		  List<Create_vacancy>  flag=studentService.getStudentAppliedJob(student_id);
		  
			return flag;
			
			
		}
	  

	  }
