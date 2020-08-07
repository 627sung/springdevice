package com.kh.spring19;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring19.service.EmailService;

//여기서 하려는 테스트는 "Spring을 연동시킨" 테스트
@RunWith(SpringJUnit4ClassRunner.class)//Spring과 JUnit4를 연동
@ContextConfiguration(locations = {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})//설정파일 위치 정보
@WebAppConfiguration//웹과 관련된 설정을 무시

public class Test03 {
@Autowired
private EmailService emailservice;

@Test
public void test() {
	emailservice.sendSimpleMessage("627sung@naver.com","경품당첨","사실 경품 아닙니다 잘못 입력함 ");
}









	
}
