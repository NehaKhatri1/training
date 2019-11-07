package com.thb.db;


import javax.activation.DataSource;
import javax.activation.FileDataSource;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
public class EmailRunningStandAloneWithImageAsAnAttchment {
	public  static void main(String[] args)throws Exception{
		HtmlEmail htmlEmail=new HtmlEmail(); 
		DefaultAuthenticator authenticator=new DefaultAuthenticator("nehakhatri10@gmail.com","8800236796666"); 
		htmlEmail.setDebug(true);
		htmlEmail.setHostName("smtp.gmail.com"); 
		
	
		
		htmlEmail.setTLS(false);
		htmlEmail.setSSL(true);
		htmlEmail.setSmtpPort(465); 
		htmlEmail.setAuthenticator(authenticator); 
		htmlEmail.setFrom("nehakhatri10@gmail.com"); 
		htmlEmail.addTo("aparneshgaurav@gmail.com"); 
		
//		htmlEmail.addCc("Dinesh.Mahalingam@mu-sigma.com");
		htmlEmail.setSubject("testing mail");

	  EmailAttachment attachment = new EmailAttachment();
		// attachment.setPath("http://localhost:8080/portal1/css/flower2.jpg");
		 // attachment.setPath("D:/flower2.jpg");
	  attachment.setPath("C:\\Users\\Neha\\Desktop\\grid.jpg");
	  		//" http://localhost:8080/portal1/css/flower2.jpg");  
	  attachment.setDisposition(EmailAttachment.ATTACHMENT);
 	  htmlEmail.attach(attachment);
		
		
		htmlEmail.setMsg("SMTP Working"); 
		htmlEmail.send();
		System.out.println("**************DATA SENT SUCCESSFULLY**************");
	}
}
