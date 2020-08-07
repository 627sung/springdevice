package com.kh.spring19;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

//Mime Message 보내기
//html 형태의 메일전송
//첨부파일 전송

//여기서 하려는 테스트는 "Spring을 연동시킨" 테스트
@RunWith(SpringJUnit4ClassRunner.class)//Spring과 JUnit4를 연동
@ContextConfiguration(locations = {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})//설정파일 위치 정보
@WebAppConfiguration//웹과 관련된 설정을 무시
@Slf4j
public class Test04 {

	@Autowired
	private JavaMailSender sender;
	
	/**
	 * @throws MessagingException
	 */
	@Test
	public void test() throws MessagingException {
	//	log.debug("sender= "+sender);
	//	log.debug("sender= {} "+sender);

	//Mime Message 생성
		MimeMessage message = sender.createMimeMessage();

	//Mime Message는 형태가 복잡하기에 Helper 도구가 존재함
		
	MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
	
	//helper전송설정
	String[] to= {"627sung@naver.com"};
	helper.setTo(to);
	
	//cc와 bcc는 생략
	helper.setSubject("마임메시지 테스트 ");
	helper.setText("<a href='http://localhost:8080/spring19/'>접속하기</a>" , true);

	
String url = ServletUriComponentsBuilder
	.fromCurrentContextPath()//현재 context path 기준
	.port(8080)
	.path("/")
	.queryParam("test", "hello")
	.queryParam("good", "bye")
	.toUriString();
helper.setText("<a href='"+url+"'>접속하기</a>" , true);
	
	
	//전송
	
	sender.send(message);
	
	
	
	}
	
	
}
