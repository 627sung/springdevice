package com.kh.spring19;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import lombok.extern.slf4j.Slf4j;

//직접 도구를 생성해서 이메일을 보내는 예제
//필요한 의존성 목록
// - spring-context-support
// - java mail-api
//필요한 외부도구
// - gmail 계정(구글 계정)
// - 주의 : https://www.google.com/settings/security/lesssecureapps 접속 후 보안 수준 낮춤 설정
@Slf4j
public class Test01 {

	private JavaMailSenderImpl sender;
	
	@Before//@Test를 진행하기 전에 실행할 내용을 작성(준비작업)
	public void prepare() {
		log.debug("before 실행");
		
		JavaMailSenderImpl impl = new JavaMailSenderImpl();
		
		//impl에 필요한 설정을 수행
		//- 계정 설정
		impl.setHost("smtp.gmail.com");
		impl.setPort(587);
		impl.setUsername("testlongtimenosee@gmail.com");
		impl.setPassword("shehdghks1234");
		
		//- 옵션 설정
		Properties prop = new Properties();//Map<Object, Object> 형태
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", true);
		
		impl.setJavaMailProperties(prop);
		
		//sender에 대입
		sender = impl;
	}
	
	@Test
	public void test() {
		log.debug("test 실행");
		
		//메시지 생성
		SimpleMailMessage message = new SimpleMailMessage();
		
		//메시지 정보 설정 : 제목, 내용, 받는사람, 참조, 숨은참조
		message.setSubject("테스트 메일");
		message.setText("테스트 메일의 본문 내용입니다!");
		
		String[] to = {"q27kes@hanmail.com"};
		message.setTo(to);
		
		String[] cc = {"627sung@naver.com"};
		message.setCc(cc);
		
	//	String[] bcc = {이멜아이디@naver.com"};
	//	message.setBcc(bcc);
		
		//메시지 전송
		sender.send(message);
	}
	
	@After//@Test 이후 실행될 내용을 작성(마무리) 
	public void finish() {
		log.debug("after 실행");
	}
	
}




