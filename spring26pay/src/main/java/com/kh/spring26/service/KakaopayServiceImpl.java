package com.kh.spring26.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring26.pay.KakaoPayCancleVO;
import com.kh.spring26.pay.KakaoPayFinishVO;
import com.kh.spring26.pay.KakaoPayHistoryVO;
import com.kh.spring26.pay.KakaoPayResultVo;
import com.kh.spring26.pay.KakaoPayStartVO;

@Service
public class KakaopayServiceImpl implements KakaopayService {

	public static final String CID = "TC0ONETIME";

	@Override
	public KakaoPayResultVo prepare(KakaoPayStartVO startVO) throws URISyntaxException {
		// 1.서버에서 서버로 요청을 보내기 위해 Spring에서는 RestTemplate을 제공
		RestTemplate template = new RestTemplate();

		// 2.h2 Header 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK e79020720cc1021b8ed74eba33df0289");
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		// 3.body 생성
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("cid", CID);
		body.add("partner_order_id", startVO.getPartner_order_id());
		body.add("partner_user_id", startVO.getPartner_user_id());
		body.add("item_name", startVO.getItem_name());
		body.add("quantity", String.valueOf(startVO.getQuantity()));
		body.add("total_amount", String.valueOf(startVO.getTotal_amount()));
		body.add("tax_free_amount", "0");
		// 주의 반드시 주소는 API에서 승인된 URL을 사용해야 한다.
		body.add("approval_url", "http://localhost:8080/spring26/pay/success");
		body.add("cancel_url", "http://localhost:8080/spring26/pay/cancel");
		body.add("fail_url", "http://localhost:8080/spring26/pay/fail");

		// 4.Header와 Body 를 합성

		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);

		// 5. URL주소를 정의
		URI uri = new URI("https://kapi.kakao.com/v1/payment/ready");

		// 6.준비 완료 template 이용하여 요청을 전송한다.

		// template.postForLocation(uri, entity);

		KakaoPayResultVo resultVo = template.postForObject(uri, entity, KakaoPayResultVo.class);

		return resultVo;
	}

	@Override
	public KakaoPayFinishVO approve(String partner_order_id, String partner_user_id, String pg_token, String tid)
			throws URISyntaxException {
		// 목표:카카오 승인 서버에 승인요청을 보낸다.
		// 준비물 : 5개
		// 결과물 많다=>KakaoPayFinishVO에 다 들어감

		// 1.서버에서 서버로 요청을 보내기 위해 Spring에서는 RestTemplate을 제공
		RestTemplate template = new RestTemplate();

		// 2.h2 Header 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK e79020720cc1021b8ed74eba33df0289");
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		// 3.body 생성
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", CID);
		body.add("partner_order_id", partner_order_id);
		body.add("partner_user_id", partner_user_id);
		body.add("tid", tid);
		body.add("pg_token", pg_token);

		// 4.Header와 Body 를 합성

		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);

		// 5. URL주소를 정의
		URI uri = new URI("https://kapi.kakao.com/v1/payment/approve");

		// 6.준비 완료 template 이용하여 요청을 전송한다.
		// 승인 요청 발송

		KakaoPayFinishVO finishVO = template.postForObject(uri, entity, KakaoPayFinishVO.class);

		return finishVO;
	}

	@Override
	
		public KakaoPayHistoryVO history(String tid) throws URISyntaxException {
			//1. 도구 생성
			RestTemplate template = new RestTemplate();

			//2. Header 생성
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "KakaoAK fe371652b5d7bbc8b899e03f8d684ea7");
			headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

			//3. Body 생성
			MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
			body.add("cid", CID);
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

			return historyVO;
	}

	@Override
	public KakaoPayCancleVO cancle(String tid, int cancle_amount) throws URISyntaxException {
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
				body.add("cancel_amount", String.valueOf(cancle_amount));
				body.add("cancel_tax_free_amount",String.valueOf(0)); 
				
				//4. Header와 Body를 합성
				HttpEntity<MultiValueMap<String, String>> entity = 
													new HttpEntity<>(body, headers);
				
				//5. 주소 정의
				URI uri = new URI("https://kapi.kakao.com/v1/payment/cancel");
				
				//6.전송
				KakaoPayCancleVO cancleVO=
						template.postForObject(uri,entity,KakaoPayCancleVO.class);
				
				return cancleVO;
				

		
		
	}

}
