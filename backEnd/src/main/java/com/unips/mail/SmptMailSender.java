package com.unips.mail;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unips.entity.Business;
import com.unips.entity.Comment;
import com.unips.entity.User;

@SuppressWarnings("unused")
@Component
public class SmptMailSender {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private Environment env;
	
	
	@Async
	private void send (String to, String subject, String body) throws MessagingException {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body, true);
		
		javaMailSender.send(message);
	}
	
	@Async
	public void sendUserVerificationEmail(String to, String link) throws MessagingException {
	
		final String subject = "Welcome to UniPS";
		
		final String body =  "   <!DOCTYPE html>  "  + 
							 "   <html>  "  + 
							 "     <body>  "  + 
							 "       <h2>  "  + 
							 "       Welcome to UniPS  "  + 
							 "       </h2>  "  + 
							 "       <p>  "  + 
							 "         Your account has been created, please click on the URL below to activate it:  "  + 
							 "       </p>  "  + 
							 "       <p>  "  + 
							 "         <a href=\"" + link + "\">" + link + "</a>  "  + 
							 "       </p>  "  + 
							 "       <p>  "  + 
							 "         Enjoy!  "  + 
							 "       </p>  "  + 
							 "     </body>  "  + 
							 "  </html>  ";
		
		send(to, subject, body);
	}
	
	@Async
	public void sendUserVerificationEmailBusiness(String to, String link) throws MessagingException {
		
		final String subject = "Welcome to UniPS";
		final String body =  "   <!DOCTYPE html>  "  + 
							 "   <html>  "  + 
							 "     <body>  "  + 
							 "       <h2>  "  + 
							 "       Welcome to UniPS  "  + 
							 "       </h2>  "  + 
							 "       <p>  "  + 
							 "         Your account has been created, please click on the URL below to activate it:  "  + 
							 "       </p>  "  + 
							 "       <p>  "  + 
							 "         <a href=\"" + link + "\">" + link + "</a>  "  + 
							 "       </p>  "  + 
							 "       <p>  "  + 
							 "           After verifying your email address; we will check the provided business information. We will be sending you a \"Welcome Business\" as sooon as the process has been completed.  "  + 
							 "       </p>  "  + 
							 "       <p>  "  + 
							 "           If you feel there is something missing in the application that we should know about, please do not hesitate in contacting us.  "  + 
							 "       </p>  "  + 
							 "       <p>  "  + 
							 "           Thanks a lot for your patience.  "  + 
							 "       </p>  "  + 
							 "       <p>  "  + 
							 "         Enjoy!  "  + 
							 "       </p>  "  + 
							 "     </body>  "  + 
							 "  </html>  " ; 
					
		send(to, subject, body);
	}
	
	public void sendUserVerificationEmailAdmins(String to, String link) throws MessagingException {
		
		final String subject = "Welcome to UniPS";
		final String body =  "   <!DOCTYPE html>  "  + 
							 "   <html>  "  + 
							 "     <body>  "  + 
							 "       <h2>  "  + 
							 "       Welcome to UniPS  "  + 
							 "       </h2>  "  + 
							 "       <p>  "  + 
							 "         Your account has been created, please click on the URL below to activate it:  "  + 
							 "       </p>  "  + 
							 "       <p>  "  + 
							 "         <a href=\"" + link + "\">" + link + "</a>  "  + 
							 "       </p>  "  + 
							 "       <p>  "  + 
							 "           After verifying your email address; we will check the provided information. We will be sending you a \"Welcome Admin\" as sooon as the process has been completed.  "  + 
							 "       </p>  "  + 
							 "       <p>  "  + 
							 "           If you feel there is something missing in the application that we should know about, please do not hesitate in contacting us.  "  + 
							 "       </p>  "  + 
							 "       <p>  "  + 
							 "           Thanks a lot for your patience.  "  + 
							 "       </p>  "  + 
							 "       <p>  "  + 
							 "         Enjoy!  "  + 
							 "       </p>  "  + 
							 "     </body>  "  + 
							 "  </html>  " ; 
					
		send(to, subject, body);
	}
	
	@Async
	public void sendUserVerificationEmailToAdmins(Business business, String link) throws MessagingException, JsonProcessingException {
		
		final String subject = "New Business signed up.";
		
		final String body =  "   <!DOCTYPE html>  "  + 
							 "   <html>  "  + 
							 "     <body>  "  + 
							 "       <h2>  "  + 
							 "       New Business entity  "  + 
							 "       </h2>  "  + 
							 "       <p>  "  + 
							 "         The business entity bellow has registered an account.  "  + 
							 "       </p>  "  + 
							 "       <p>Information:</p>  "  + 
							 "       <table  cellpadding=\"5\">  "  + 
							 "         <tbody>  "  + 
							 "           <tr><td><b>username</b></td><td>" + business.getUsername() + "</td></tr>  "  + 
							 "           <tr><td><b>email</b></td><td>" + business.getEmail() + "</td></tr>  "  + 
							 "           <tr><td><b>name</b></td><td>" + business.getName() + "</td></tr>  "  + 
							 "           <tr><td><b>category</b></td><td>" + business.getCategory() + "</td></tr>  "  + 
							 "           <tr><td><b>phone</b></td><td>" + business.getPhone() + "</td></tr>  "  + 
							 "           <tr><td><b>phone business</b></td><td>" + business.getPhoneBusiness() + "</td></tr>  "  + 
							 "         </tbody>  "  + 
							 "       </table>  "  + 
							 "       <p>  "  + 
							 "         After verifying the information, follow the link bellow to approve the account.  "  + 
							 "       </p>  "  + 
							 "       <p>  "  + 
							 "         <a href=\"" + link + "\">" + link + "</a>  "  + 
							 "       </p>  "  + 
							 "       <p>  "  + 
							 "         Thanks  "  + 
							 "       </p>  "  + 
							 "     </body>  "  + 
							 "  </html>  "; 
				
		String to = env.getProperty("unips.mail");
		
		send(to, subject, body);
	}
	
	@Async
	public void sendAdminVerificationEmailToAdmins(User user, String link) throws MessagingException, JsonProcessingException {
		
		final String data = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
		final String subject = "New Admin signed up.";
		
		final String body =  "   <!DOCTYPE html>  "  + 
							 "   <html>  "  + 
							 "     <body>  "  + 
							 "       <h2>  "  + 
							 "       New Admin approval request "  + 
							 "       </h2>  "  + 
							 "       <p>  "  + 
							 "         The user  bellow has registered an account to be an admin account "  + 
							 "       </p>  "  + 
							 "       <p>Information:</p>  "  + 
							 "       <table  cellpadding=\"5\">  "  + 
							 "         <tbody>  "  + 
							 "           <tr><td><b>username</b></td><td>" + user.getUsername() + "</td></tr>  "  + 
							 "           <tr><td><b>email</b></td><td>" + user.getEmail() + "</td></tr>  " + 
							 "         </tbody>  "  + 
							 "       </table>  "  + 
							 "       <p>  "  + 
							 "         After verifying the information, follow the link bellow to approve the account.  "  + 
							 "       </p>  "  + 
							 "       <p>  "  + 
							 "         <a href=\"" + link + "\">" + link + "</a>  "  + 
							 "       </p>  "  + 
							 "       <p>  "  + 
							 "         Thanks  "  + 
							 "       </p>  "  + 
							 "     </body>  "  + 
							 "  </html>  "; 
				
		String to = env.getProperty("unips.mail");
		 
		send(to, subject, body);
	}
	
	@Async
	public void sendThankYouEmail(String to, String link) throws MessagingException {
	
		final String subject = "Welcome to UniPS";
		
		final String body =  "   <!DOCTYPE html>  "  + 
							 "   <html>  "  + 
							 "     <body>  "  + 
							 "       <h2>  "  + 
							 "       Welcome to UniPS  "  + 
							 "       </h2>  "  + 
							 "       <p>  "  + 
							 "         Your account has been activated, you can login now using the link bellow:  "  + 
							 "       </p>  "  + 
							 "       <p>  "  + 
							 "         <a href=\"" + link + "\">" + link + "</a>  "  + 
							 "       </p>  "  + 
							 "       <p>  "  + 
							 "         Enjoy!  "  + 
							 "       </p>  "  + 
							 "     </body>  "  + 
							 "  </html>  ";
		
		send(to, subject, body);
	}
	
	@Async
	public void sendCommentFlagNotificationToAdmins(Comment comment) throws MessagingException {
	
		final String subject = "New comment has been flagged.";
		final String body =  "   <!DOCTYPE html>  "  + 
							 "   <html>  "  + 
							 "     <body>  "  + 
							 "       <h2>  "  + 
							 "       New comment flag  "  + 
							 "       </h2>  "  + 
							 "       <p>  "  + 
							 "         The comment bellow has been flagged  "  + 
							 "       </p>  "  + 
							 "       <p>Information:</p>  "  + getTableFromObject(comment) +
							 "       <p>  "  + 
							 "         Log into your acccount to resolve.  "  + 
							 "       </p>  "  +
							 "       <p>  "  + 
							 "         Thanks  "  + 
							 "       </p>  "  + 
							 "     </body>  "  + 
							 "  </html>  "; 
				
		String to = env.getProperty("unips.mail");
		 
		send(to, subject, body);
	}
	
	private String getTableFromObject(Object object){
		
		final String tableStart = "<table  cellpadding=\"5\">\n<tbody>\n";
		final String tableEnd = "</tbody> \n </table> \n";
		final String rowStart = "<tr><td><b>";
		final String rowMiddle = "</b></td><td>";
		final String rowEnd = "</td></tr>\n";
		
		Method[] methods = object.getClass().getDeclaredMethods();
		
		String table = tableStart;
		
		for (Method method : methods) {
			if ( method.getName().startsWith("get")) {
				String field = method.getName().substring(3);
				field = Character.toUpperCase(field.charAt(0)) + field.substring(1);
				
				String value;
				try {
					Object result = method.invoke(object, new Object[0]);
					value = result.toString();
				} catch (Exception e) {
					value = "";
				}
				table += (rowStart + field + rowMiddle + value + rowEnd); 
			}
		}
		
		table += tableEnd;
		System.out.println(table);
		return table;
	}
}
