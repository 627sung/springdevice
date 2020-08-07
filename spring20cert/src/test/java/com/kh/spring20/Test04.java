package com.kh.spring20;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring20.repository.CertDao;
import com.kh.spring20.service.CertService;
import com.kh.spring20.service.EmailService;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class) // Spring과 JUnit4를 연동
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" }) // 설정파일 위치 정보
@WebAppConfiguration // 웹과 관련된 설정을 무시
@Slf4j
public class Test04 {

	@Autowired 
	private CertService certService;
	
	@Autowired
	private EmailService emailService;
	
	
	@Test
	public void test() {
		
		//목표 : 인증번호를 만들어서 이메일로 발송
		// 준비물 : 이메일 , 아이피 
		
		String email = "627sung@naver.com";
		String ip = "127.0.0.1";
		
		String secret = certService.generateCertification(ip);
		emailService.sendSimpleMessage(email, "[디지털세상으로가는 인증번호]", "인증번호:"+secret);
	}

	
}
