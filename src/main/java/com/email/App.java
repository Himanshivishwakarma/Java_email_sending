  package com.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String message= "This is my first email which is sent by a java program which is written by me and thanks Harsh bhaiyya we got to learn a new thing . ";
        String subject= "send_email";
        String to= "himanshiv.bca2021@ssism.org";
        String from="sapanvishwakarma2005@gmail.com";
        sendEmail(message , subject , to , from);
       
    }

	private static void sendEmail(String message, String subject, String to, String from) {
	// variable for gmail
		
		String host= "smtp.gmail.com";
		
	// get the system propertices
		
	    Properties properties = System.getProperties();
		System.out.println("PROPERTIES"+properties);
		
	// setting important information to properties object
		
	   properties.put("mail.smtp.host",host);
	   properties.put("mail.smtp.port","465");
	   properties.put("mail.smtp.ssl.enable","true");
	   properties.put("mail.smtp.auth", "true");
	   
	// Setp 1: to get the session object....
	   
	     Session  session=Session.getInstance(properties, new Authenticator() {

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			
			return new PasswordAuthentication("sapanvishwakarma2005@gmail.com","kjrggjwnigdtalum");
		}
		   
	});
	   
	     session.setDebug(true);
	   
	   // Step 2 : compose the message [text , multi media]
	   MimeMessage m= new MimeMessage(session);
	   
	   // from email id
	   try {
		
		   m.setFrom(from);
		   
		   // adding resipient to message
		   
		   m.addRecipient(Message.RecipientType.TO ,new InternetAddress(to));
		   
		   // adding subject to message
		   
		   m.setSubject(subject);
		   
		   // adding text to message
		   
		   m.setText(message);
		   
		   // send email
		   
		   // Step 3 : send the message using Transport class
		    Transport.send(m);
		   
		   System.out.println("Sent successfully your email !!");
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
