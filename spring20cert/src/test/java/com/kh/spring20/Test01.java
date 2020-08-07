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

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)//Spring과 JUnit4를 연동
@ContextConfiguration(locations = {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})//설정파일 위치 정보
@WebAppConfiguration//웹과 관련된 설정을 무시
@Slf4j
public class Test01 {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		log.debug("sqlSession= {}",sqlSession);
		
		//랜덤번호생성(db에 안간다 service에넣고 모듈화 )
		//첫번째 테스트 :sqlSession을 이용한 insert 테스트 
		Random r= new Random();
		int n =r.nextInt(1000000)+0;
		Format f = new DecimalFormat("000000"); //6글자로 고정~
		String secret =f.format(n);
		
		
		//db저장( db에 간다 dao에 너놓고 모듈화)
	
		CertDto certDto = CertDto.builder().who("127.0.0.1").secret(secret).build();
		sqlSession.insert("cert.regist",certDto);
	}
	
}
