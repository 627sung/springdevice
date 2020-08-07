package com.kh.spring19;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
public class Test02 {

	@Autowired
	private JavaMailSender sender; //메일샌더를 가져다가 쓰겟다 /

	@Test
	public void test() {
		log.debug("sender = " + sender);
		//메시지 생성
		SimpleMailMessage message = new SimpleMailMessage();
		
		//메시지 정보 설정 : 제목, 내용, 받는사람, 참조, 숨은참조
		message.setSubject("테스트 메일2");
		message.setText("테스트 메일의 본문 내용입니다!");
		
		String[] to = {"q27kes@hanmail.com"};
		message.setTo(to);
		
		String[] cc = {"627sung@naver.com"};
		message.setCc(cc);
		
	//	String[] bcc = {이멜아이디@naver.com"}; //숨은참조
	//	message.setBcc(bcc);
		
		//메시지 전송
		sender.send(message);

		
		
	}
	
}




