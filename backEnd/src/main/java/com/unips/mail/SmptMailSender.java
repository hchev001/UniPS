package com.unips.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unips.entity.Business;

import java.util.Properties;

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
		final String body= "<h1>Welcome to UniPS</h1>\n" +
						 	"<p>Thanks a lot for registering with us. " + 
						 	"Flow the link bellow to activate your account.</p>\n" +
						 	"<p><a href=\"" + link  +"\">" + link + "</a></p>\n" +
						 	"<p>Enjoy!</p>";
		send(to, subject, body);
	}
	
	@Async
	public void sendUserVerificationEmailBusiness(String to, String link) throws MessagingException {
		
		final String subject = "Welcome to UniPS";
		final String body= "<h1>Welcome to UniPS</h1>\n" +
						 	"<p>Thanks a lot for registering with us. " + 
						 	"Flow the link bellow to verify your account.</p>\n" +
						 	"<p><a href=\"" + link  +"\">" + link + "</a></p>\n" +
						 	"<p>After verifying you email address we will check the provided information</p>" +
						 	" and will be sending you a 'Welcome Bussiness email soon." +
						 	"<p>Thanks a lot for your patience</p>";
		
		
		System.out.println("to: " + to);
		System.out.println("subject: " + subject);
		System.out.println("body: " + body);
		send(to, subject, body);
	}
	
	@Async
	public void sendUserVerificationEmailToAdmins(Business business, String link) throws MessagingException, JsonProcessingException {
		
		final String data = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(business);
		final String subject = "New Business signed up.";
		final String body= "<h1>A new business has been signed up</h1>\n" +
						 	"<p>The Business Entity bellow has registred and account:" +
						 	data +
						 	"Flow the link bellow to approve the account.</p>\n" +
						 	"<p><a href=\"" + link  +"\">" + link + "</a></p>\n" +
						 	"<p>After verifying you email address we will check the provided information</p>" +
						 	" and will be sending you a 'Welcome Bussiness email soon." +
						 	"<p>Thanks a lot for your patience</p>";
		
		String to = env.getProperty("unips.mail");
		 
		System.out.println("to: " + to);
		System.out.println("subject: " + subject);
		System.out.println("body: " + body);
		send(to, subject, body);
	}
}
