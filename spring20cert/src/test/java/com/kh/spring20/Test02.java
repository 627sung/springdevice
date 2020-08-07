package com.kh.spring20;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;

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

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class) // Spring과 JUnit4를 연동
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" }) // 설정파일 위치 정보
@WebAppConfiguration // 웹과 관련된 설정을 무시
@Slf4j
public class Test02 {
	@Autowired
	private CertService certService;
	@Autowired
	private CertDao certDao;

	@Test
	public void test() {
		String secret = certService.generateSecret();

		CertDto certDto = CertDto.builder()
				.who("127.0.0.1")
				.secret(secret)
				.build();
		
		certDao.insert(certDto);

	}

}
