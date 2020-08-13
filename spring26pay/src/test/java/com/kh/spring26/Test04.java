package com.kh.spring26;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring26.pay.KakaoPayHistoryVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test04 {
	
	@Test
	public void test() throws URISyntaxException {
		//목표 : 결제내역 조회
		// - 준비물 : tid, cid
		String tid = "T2794503871513030817";
		String cid = "TC0ONETIME";
		
		//1. 도구 생성
		RestTemplate template = new RestTemplate();
		
		//2. Header 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK fe371652b5d7bbc8b899e03f8d684ea7");
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		//3. Body 생성
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", cid);
		body.add("tid", tid);
		
		//4. Header와 Body를 합성
		HttpEntity<MultiValueMap<String, String>> entity = 
											new HttpEntity<>(body, headers);
		//5. 주소 정의
		URI uri = new URI("https://kapi.kakao.com/v1/payment/order");
		
		//6. 모든 준비가 완료되었으므로 template을 이용하여 요청을 전송
		//template.postForLocation(uri, entity);
		
		KakaoPayHistoryVO historyVO = 
			template.postForObject(uri, entity, KakaoPayHistoryVO.class);
		
		log.debug("historyVO = {}", historyVO);
	}
	
}







