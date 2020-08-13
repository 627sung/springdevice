package com.kh.spring26;

import java.net.URISyntaxException;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring26.pay.KakaoPayResultVo;
import com.kh.spring26.pay.KakaoPayStartVO;
import com.kh.spring26.service.KakaopayService;

import lombok.extern.slf4j.Slf4j;

//3번테스트
//2번테스트에서 만들어진 KakaoPayService의 prepare를 테스트 
@RunWith(SpringJUnit4ClassRunner.class)//Spring과 JUnit4를 연동
@ContextConfiguration(locations = {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})//설정파일 위치 정보
@WebAppConfiguration//웹과 관련된 설정을 무시
@Slf4j
public class Test03 {

	@Autowired
	private KakaopayService kakaopayService;

	
	@Test
	public void test() throws URISyntaxException {
		KakaoPayStartVO startVO = KakaoPayStartVO.builder()
				.partner_order_id(UUID.randomUUID().toString()) //랜덤 시리얼 번호
				.partner_user_id("nyaaaaaaanyaaaa11")
				.item_name("피카츄뱃살")
				.quantity(5)
				.total_amount(500000)
				.build();
		
		//결제요청
		KakaoPayResultVo resultVo = kakaopayService.prepare(startVO);
		log.info("resultVo = {}" ,resultVo);
		
	}
	
}


