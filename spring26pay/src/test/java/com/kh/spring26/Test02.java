package com.kh.spring26;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring26.pay.KakaoPayResultVo;
import com.kh.spring26.pay.KakaoPayStartVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test02 {
//2번 테스트
// 테스트 1번에서 변하는 값들을 변수화 
//  api 요청 결과를 받아서 확인 	
	
	@Test
	public void test() throws URISyntaxException {
		//필요한 데이터를 미리 변수로 선언 
		KakaoPayStartVO startVO = KakaoPayStartVO.builder()
				.partner_order_id(UUID.randomUUID().toString()) //랜덤 시리얼 번호
				.partner_user_id("nyaaaaaaanyaaaa11")
				.item_name("피카츄뱃살")
				.quantity(5)
				.total_amount(500000)
				.build();
		
		
		log.info("결제 테스트 시작");
		
		//1.서버에서 서버로 요청을 보내기 위해 Spring에서는 RestTemplate을 제공 
		RestTemplate template= new RestTemplate();
		
		
		//2.h2 Header 생성 
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization","KakaoAK e79020720cc1021b8ed74eba33df0289");
		headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

		//3.body 생성 
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("cid", "TC0ONETIME");
		body.add("partner_order_id",startVO.getPartner_order_id());
		body.add("partner_user_id", startVO.getPartner_user_id());
		body.add("item_name", startVO.getItem_name());
		body.add("quantity", String.valueOf(startVO.getQuantity()));
		body.add("total_amount", String.valueOf(startVO.getTotal_amount()));
		body.add("tax_free_amount", "0");
		//주의 반드시 주소는 API에서 승인된 URL을 사용해야 한다. 
		body.add("approval_url", "http://localhost:8080/spring26/pay/success");
		body.add("cancel_url", "http://localhost:8080/spring26/pay/cancel");
		body.add("fail_url", "http://localhost:8080/spring26/pay/fail");

		//4.Header와 Body 를 합성
		
		HttpEntity<MultiValueMap<String, String>> entity =new HttpEntity<>(body,headers);
		
		
		
		//5.
		URI uri = new URI("https://kapi.kakao.com/v1/payment/ready");
		
		//6.준비 완료 template 이용하여 요청을 전송한다.
		
		//template.postForLocation(uri, entity);
		
		KakaoPayResultVo resultVo = template.postForObject(uri, entity,	KakaoPayResultVo.class );
		
		log.info("resultVo={}",resultVo );
		log.info("주소:{}" ,resultVo.getNext_redirect_pc_url());
		log.info("결제 테스트 종료");

	}
}
