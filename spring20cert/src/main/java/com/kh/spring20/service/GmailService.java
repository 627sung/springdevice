package com.kh.spring20.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class GmailService implements EmailService {

	@Autowired 
	private JavaMailSender sender;

	@Override
	public void sendSimpleMessage(SimpleMailMessage message) {
		sender.send(message);
	}

	@Override
	public void sendSimpleMessage(String email, String titles, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject(titles);
		message.setText(text);
		this.sendSimpleMessage(message);
	}
	
	
}
