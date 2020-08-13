package com.kh.spring26;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test01 {
//1번 테스트
// 서버간의 연결하기
// 카카오 api 결제 준비 요청 보내기 
	
	
	@Test
	public void test() throws URISyntaxException {
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
		body.add("partner_order_id","anything1");
		body.add("partner_user_id", "anything2");
		body.add("item_name", "피카츄 대뱃살");
		body.add("quantity", String.valueOf(5));
		body.add("total_amount", String.valueOf(500000));
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
		
		template.postForLocation(uri, entity);
		
		
		log.info("결제 테스트 종료");

	}
}
