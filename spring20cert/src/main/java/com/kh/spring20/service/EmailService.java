package com.kh.spring20.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
 //이메일 발송(첨부파일x)
//준비물: 제목, 내용 , 받는사람, 참조, 숨은참조 ->SimpleMailMessage
//결과물: void
	
void sendSimpleMessage(SimpleMailMessage message);	
void sendSimpleMessage(String email, String titles, String text);
}
