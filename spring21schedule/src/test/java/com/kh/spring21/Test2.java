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
public class Test2 {
		public static void main(String[] args ) {
			//목표: 앞  예제의 작업들을 병렬로 처리 
			// -main을 제외한 별도의 Thread가 필요하다. 
			//Runnable(i)
			//Thread(o)
			
			//스레드 생성 및 구동 
			Thread t = new Thread() {
			@Override
			public void run() {
				//별도의 스레드에서 구동되어야 할 코드의 작성
				for(int i =1; i<1000; i++) {
					log.debug("i={}",i);
					
					
					try {
						Thread.sleep(1000L);
					}catch(Exception e) {}
					
				}				super.run();
			}
				
			}; //생성
			t.start(); // 구동 
			
			
			//알림창
			JOptionPane.showMessageDialog(null, "라면 먹고 갈래?");

		}
}
