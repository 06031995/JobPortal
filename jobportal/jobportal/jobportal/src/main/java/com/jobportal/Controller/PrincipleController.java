package com.jobportal.Controller;

import java.io.BufferedReader;
import java.io.IOException;
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
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.Model.AppliedJob;
import com.jobportal.Model.Create_vacancy;
import com.jobportal.Model.Principle;
import com.jobportal.Service.PrincipleService;
import com.jobportal.Service.StudentService;

@RestController
@RequestMapping("/principle")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", exposedHeaders = "Authorization")
public class PrincipleController {

	@Autowired
	private PrincipleService principleService;
	
	JSONObject json = new JSONObject();
	
	 @PostMapping("/save_principle")
	  public int save_principle(@ModelAttribute("data") @Valid Principle principle, 
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


//		  int student_id = jsonObj.getInt("student_id");
//		  applied_job.setStudent_id(student_id);
		     String principle_name = jsonObj.getString("principle_name");
		     principle.setPrinciple_name(principle_name);
		     
		     String principle_ph = jsonObj.getString("principle_ph");
		     principle.setPrinciple_ph(principle_ph);
		     
		     String college_name = jsonObj.getString("college_name");
		     principle.setCollege_name(college_name);
		     
		     String college_code = jsonObj.getString("college_code");
		     principle.setCollege_code(college_code);
		     
		     String college_ph = jsonObj.getString("college_ph");
		     principle.setCollege_ph(college_ph);
		     
		     String email = jsonObj.getString("email");
		     principle.setEmail(email);
		     
		     String address = jsonObj.getString("address");
		     principle.setAddress(address);
		     
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
			            message.addRecipients(Message.RecipientType.TO, email);

			            MimeMultipart multipart = new MimeMultipart();

			            MimeBodyPart messageBodyPart = new MimeBodyPart();
			            // Using numeric values 
			            int randomPin   =(int) (Math.random()*900000000)+100000000; 
			            String  otp  = String.valueOf(randomPin); 
			            
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
		     
		     
		   int flag = principleService.savePrinciple(principle);
		    return flag;
	 }
	 
		@GetMapping("/totalPrinciple")
		  public long totalPrinciple(){
		  return principleService.totalPrinciple();
		  }
		
		@GetMapping("/principle_list")
		  public List<Principle> getprinciple_list(){
		  return principleService.getprinciple_list();
		  }
		
	 
}
