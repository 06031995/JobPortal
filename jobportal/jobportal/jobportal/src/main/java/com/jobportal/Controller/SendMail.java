package com.jobportal.Controller;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.Multipart;
import javax.mail.internet.MimeMultipart;

import com.itextpdf.io.IOException;

public class SendMail {

	
	public static void send(String to, String sub, 
            String msg, final String user,String attachement)
{ 
//create an instance of Properties Class   
Properties props = new Properties();

props.put("mail.smtp.host", "smtp.gmail.com");
//below mentioned mail.smtp.port is optional
props.put("mail.smtp.port", "587");		
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable", "true");
props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

Session session = Session.getInstance(props,new javax.mail.Authenticator()
{
protected PasswordAuthentication getPasswordAuthentication() 
{
return new PasswordAuthentication(user,"megha786");
}
});

try
{


MimeMessage message = new MimeMessage(session);
message.setFrom(new InternetAddress(user));
message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
message.setSubject(sub);
message.setText(msg);

System.out.println("/n Body part Created");

Multipart multipart=new MimeMultipart();

if(attachement !=null ) {
	MimeBodyPart attachPart = new MimeBodyPart();
	attachPart.attachFile(attachement);
	multipart.addBodyPart(attachPart);

}

//set the multi-Part as email
	message.setContent(multipart);
/* Transport class is used to deliver the message to the recipients */

Transport.send(message);


}
catch(Exception e)
{
e.printStackTrace();
}
}  
}
