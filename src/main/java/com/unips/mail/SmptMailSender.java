package com.unips.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SmptMailSender {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	private void send (String to, String subject, String body) throws MessagingException {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body, true);
		
		javaMailSender.send(message);
	}
	
	public void sendUserVerificationEmail(String to, String link) throws MessagingException {
		
		final String subject = "Welcome to UniPS";
		final String body= "<h1>Welcome to UniPS</h1>\n" +
						 	"<p>Thanks a lot for registering with us. " + 
						 	"Flow the link bellow to activate your account.</p>\n" +
						 	"<p><a href=\"" + link  +"\">" + link + "</a></p>\n" +
						 	"<p>Enjoy!</p>";
		
		
		System.out.println("to: " + to);
		System.out.println("subject: " + subject);
		System.out.println("body: " + body);
		send(to, subject, body);
	}
}
