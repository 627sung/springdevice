package com.kh.spring20;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring20.entity.CertDto;
import com.kh.spring20.repository.CertDao;
import com.kh.spring20.service.CertService;
import com.kh.spring20.service.EmailService;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class) // Spring과 JUnit4를 연동
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" }) // 설정파일 위치 정보
@WebAppConfiguration // 웹과 관련된 설정을 무시
@Slf4j
public class Test5 {

	@Autowired 
	private CertService certService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired 
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		CertDto certDto = sqlSession.selectOne("cert.validate",
				CertDto.builder()
				.who("127.0.0.1")
				.secret("641805")
				.build());
		sqlSession.delete("cert.remove", certDto);
		log.debug("certDto={}",certDto);
		
	}

	
}
