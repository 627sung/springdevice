package com.kh.spring26;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring26.pay.KakaoPayCancleVO;
import com.kh.spring26.pay.KakaoPayHistoryVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test05 {

	// 결제취소테스트

	@Test
	public void test() throws URISyntaxException{

		// 목표 : 결제 취소
		// - 준비물 : tid,cancel_amount	,
		// 결과물 : x
		
		String cid = "TC0ONETIME";

		
		String tid = "T2794529993504000840";
		String cancel_amount = "50000";

		// 1. 도구 생성
		RestTemplate template = new RestTemplate();
		
		//2. Header 생성
				HttpHeaders headers = new HttpHeaders();
				headers.add("Authorization", "KakaoAK fe371652b5d7bbc8b899e03f8d684ea7");
				headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
				//3. Body 생성
				MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
				body.add("cid", "TC0ONETIME");
				body.add("tid", tid);
				body.add("cancel_amount", cancel_amount);
				body.add("cancel_tax_free_amount",String.valueOf(0)); 
				
				//4. Header와 Body를 합성
				HttpEntity<MultiValueMap<String, String>> entity = 
													new HttpEntity<>(body, headers);
				
				//5. 주소 정의
				URI uri = new URI("https://kapi.kakao.com/v1/payment/cancel");
				
				//6.전송
				KakaoPayCancleVO cancleVO=
						template.postForObject(uri,entity,KakaoPayCancleVO.class);
				
				log.debug("cancleVO = {}",cancleVO );

				
				
	
				

	}

}
