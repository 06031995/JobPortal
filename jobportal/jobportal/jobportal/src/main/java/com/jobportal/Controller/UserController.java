package com.jobportal.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jobportal.Model.Principle;
import com.jobportal.Model.PrincipleRegister;
import com.jobportal.Model.UserRegister;
import com.jobportal.Service.TokenService;
import com.jobportal.Service.UserService;
import com.jobportal.Token.GenerateToken;

@RestController  
@RequestMapping("/user")  
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", exposedHeaders = "Authorization")  
public class UserController {
  
	@Autowired
	private UserService userService;
	JSONObject json = new JSONObject();
	@Autowired
	private TokenService tokenService;
	   GenerateToken generateToken = new GenerateToken();  
	   
	@PostMapping("/saveUserDetail")
	public int saveUserDetail(@RequestBody UserRegister userRegister) {
		return userService.saveUserDetail(userRegister);
	}
	@PostMapping("/saveLogin")  
    public ResponseEntity<Integer> login(@RequestBody UserRegister userRegister)  
    {  
        int status;  
        HttpHeaders httpHeader = null;  
      
        // Authenticate User.  
        status = userService.saveLogin(userRegister.getEmail(), userRegister.getPassword());  
          
        /* 
         * If User is authenticated then Do Authorization Task. 
         */  
        if (status > 0)   
        {  
            /* 
             * Generate token. 
             */  
            String tokenData[] = generateToken.createJWT(userRegister.getEmail(), "JavaTpoint", "JWT Token",  
            		 43200000);  
              
            // get Token.  
            String token = tokenData[0];  
              
            System.out.println("Authorization :: " + token);  
  
            // Create the Header Object  
            httpHeader = new HttpHeaders();  
  
            // Add token to the Header.  
            httpHeader.add("Authorization", token);  
  
            // Check if token is already exist.  
            long isUserEmailExists = tokenService.getTokenDetail(userRegister.getEmail());  
              
            /* 
             * If token exist then update Token else create and insert the token. 
             */  
            if (isUserEmailExists > 0)   
            {  
                tokenService.updateToken(userRegister.getEmail(), token, tokenData[1]);  
            }   
            else   
            {  
                tokenService.saveUserEmail(userRegister.getEmail(), status);  
                tokenService.updateToken(userRegister.getEmail(), token, tokenData[1]);  
            }  
  
            return new ResponseEntity<Integer>(status, httpHeader, HttpStatus.OK);  
        }   
          
        // if not authenticated return  status what we get.  
        else   
        {  
            return new ResponseEntity<Integer>(status, httpHeader, HttpStatus.OK);  
        }  
          
       
    }  
	@PostMapping("/sendOtp")
			public String  sendOtp(ModelAndView modelAndView,@RequestBody UserRegister userRegister,HttpServletRequest request) throws AddressException, MessagingException {
				System.out.println("mail======="+userRegister.getEmail());
		 int id = userService.findUserByEmail(userRegister.getEmail());
			String userMail = userRegister.getEmail();
			String otp  = null;
			String msg = "0";
			 if (id>0) {
				 String token = UUID.randomUUID().toString();

					int result = userService.updateUserDetail(token,id);




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
					            message.setSubject("Password Reset Request");
					            message.setFrom(new InternetAddress("karampurimegha@gmail.com"));
					            message.addRecipients(Message.RecipientType.TO, userMail);

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
	@PostMapping("/newPass")
	public int newPass(@RequestBody UserRegister userRegister) {
//		String mail = userRegister.getEmail();
//		String pass = userRegister.getPassword();
//		Strin
		return userService.newPass(userRegister);
	}
	
	@PostMapping("/prinipleRegister")
	public int prinipleRegister(@RequestBody PrincipleRegister principleRegister) {
		return userService.prinipleRegister(principleRegister);
	}
	
	@PostMapping("/prinipleLogin")  
    public ResponseEntity<Integer> login(@RequestBody PrincipleRegister principleRegister)  
    {  
        int status;  
        HttpHeaders httpHeader = null;  
      
        // Authenticate User.  
        status = userService.savePrincipleLogin(principleRegister.getEmail(), principleRegister.getPassword());  
          
        /* 
         * If User is authenticated then Do Authorization Task. 
         */  
        if (status > 0)   
        {  
            /* 
             * Generate token. 
             */  
            String tokenData[] = generateToken.createJWT(principleRegister.getEmail(), "JavaTpoint", "JWT Token",  
            		 43200000);  
              
            // get Token.  
            String token = tokenData[0];  
              
            System.out.println("Authorization :: " + token);  
  
            // Create the Header Object  
            httpHeader = new HttpHeaders();  
  
            // Add token to the Header.  
            httpHeader.add("Authorization", token);  
  
            // Check if token is already exist.  
            long isUserEmailExists = tokenService.getTokenDetail(principleRegister.getEmail());  
              
            /* 
             * If token exist then update Token else create and insert the token. 
             */  
            if (isUserEmailExists > 0)   
            {  
                tokenService.updateToken(principleRegister.getEmail(), token, tokenData[1]);  
            }   
            else   
            {  
                tokenService.saveUserEmail(principleRegister.getEmail(), status);  
                tokenService.updateToken(principleRegister.getEmail(), token, tokenData[1]);  
            }  
  
            return new ResponseEntity<Integer>(status, httpHeader, HttpStatus.OK);  
        }   
          
        // if not authenticated return  status what we get.  
        else   
        {  
            return new ResponseEntity<Integer>(status, httpHeader, HttpStatus.OK);  
        }  
          
       
    }  
	
	@PostMapping("/sendPrincipleOtp")
	public String  sendPrincipleOtp(ModelAndView modelAndView,@RequestBody PrincipleRegister principleRegister,HttpServletRequest request) throws AddressException, MessagingException {
		System.out.println("mail======="+principleRegister.getEmail());
 int id = userService.findUserByEmail(principleRegister.getEmail());
	String userMail = principleRegister.getEmail();
	String otp  = null;
	String msg = "0";
	 if (id>0) {
		 String token = UUID.randomUUID().toString();

//			int result = userService.updatePrincipleDetail(token,id);




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
			            message.setSubject("Password Reset Request");
			            message.setFrom(new InternetAddress("karampurimegha@gmail.com"));
			            message.addRecipients(Message.RecipientType.TO, userMail);

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
	@PostMapping("/setNewPrinciplePass")
	public int setNewPrinciplePass(@RequestBody PrincipleRegister principleRegister) {
//		String mail = userRegister.getEmail();
//		String pass = userRegister.getPassword();
//		Strin
		
		return userService.newPrinciplePass(principleRegister);
	}
	
	
	 @PostMapping("/checkeuser")
	  public int checkeuser(@ModelAttribute("data") @Valid UserRegister userRegister, 
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
		     String email = jsonObj.getString("email");
		   
		     
		  
		    
		     
		     
		   int flag = userService.checkeuser(email);
		    return flag;
	 }
	 


}