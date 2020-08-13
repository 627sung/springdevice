package com.kh.spring26.service;

import java.net.URISyntaxException;

import com.kh.spring26.pay.KakaoPayCancleVO;
import com.kh.spring26.pay.KakaoPayFinishVO;
import com.kh.spring26.pay.KakaoPayHistoryVO;
import com.kh.spring26.pay.KakaoPayResultVo;
import com.kh.spring26.pay.KakaoPayStartVO;

public interface KakaopayService {
//결제요청 메소드
	KakaoPayResultVo prepare(KakaoPayStartVO startVO) throws URISyntaxException;

	// 결제승인 메소드
	KakaoPayFinishVO approve(String partner_order_id, String partner_user_id, String pg_token, String tid) throws URISyntaxException;

	//결제 조회메소드
	KakaoPayHistoryVO history(String tid) throws URISyntaxException;

	KakaoPayCancleVO cancle(String tid, int cancle_amount) throws URISyntaxException;
	
}
