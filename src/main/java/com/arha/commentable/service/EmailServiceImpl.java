package com.arha.commentable.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.arha.commentable.props.EmailProps;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailProps emailProps;

	private JavaMailSenderImpl prepareJavaMailSender() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setHost(emailProps.getHost());
		javaMailSender.setPort(emailProps.getPort());
		javaMailSender.setUsername(emailProps.getUsername());
		javaMailSender.setPassword(emailProps.getPassword());
		return javaMailSender;
	}

	@Override
	public void sendEmail(Set<String> to) {
		JavaMailSenderImpl javaMailSender = prepareJavaMailSender();
		SimpleMailMessage message = new SimpleMailMessage();
		String[] toArray = new String[to.size()];
		int i = 0;
		for (String email : to) {
			toArray[i] = email;
			i++;
		}
		message.setTo(toArray);
		message.setFrom(emailProps.getFrom());
		message.setSubject("Notification| Ashish added a commnet on your blog");
		message.setText("sdfghjkl;smsa/;cmlsd/v; dfvbasckasasasf \n asbbasbdas   \n thank you ");
		javaMailSender.send(message);
	}

}
