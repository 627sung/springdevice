package com.kh.spring19;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
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

import lombok.extern.slf4j.Slf4j;

//여기서 하려는 테스트는 "Spring을 연동시킨" 테스트
@RunWith(SpringJUnit4ClassRunner.class)//Spring과 JUnit4를 연동
@ContextConfiguration(locations = {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})//설정파일 위치 정보
@WebAppConfiguration//웹과 관련된 설정을 무시
@Slf4j
public class Test05 {

	@Autowired
	private JavaMailSender sender;
	
	
	@Test
	public void test() throws MessagingException {
		log.debug("sender= {}",sender);

	//mime Message를 이용한 파일 첨부
	//-javax.actvation.DataSource : 파일정보
		
		
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		String[] to = {"627sung@naver.com"};
		helper.setTo(to);
		helper.setSubject("마임메시지 테스트 ");
		helper.setText("내용생략");

		//첨부파일추가 
		DataSource source =new FileDataSource("D:/파일업로드 과정.png");
		helper.addAttachment(source.getName(), source);
		
		//전송
		sender.send(message);
		
		
	}
	
	
}
