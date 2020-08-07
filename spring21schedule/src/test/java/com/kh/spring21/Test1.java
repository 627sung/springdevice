package com.kh.spring21;

import javax.swing.JOptionPane;

import org.junit.runner.RunWith;
import org.springframework.core.env.JOptCommandLinePropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import lombok.extern.slf4j.Slf4j;



@RunWith(SpringJUnit4ClassRunner.class) // Spring과 JUnit4를 연동
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" }) // 설정파일 위치 정보
@WebAppConfiguration // 웹과 관련된 설정을 무시
@Slf4j
public class Test1 {
		public static void main(String[] args ) {
			//1개의 스레드(main)을 이용하여 두가지 작업을 수행
			// 1앞 작업이 완료되어야 뒤 작업이 실행됨(Blocking)
			
			
			
			
			for(int i =1; i<100; i++) {
				log.debug("i={}",i);
				

			}
			JOptionPane.showMessageDialog(null, "안녕하시렵니까?");

			
		}
}
