package com.kh.spring26.controller;

import java.net.URISyntaxException;
import java.nio.channels.SeekableByteChannel;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring26.pay.KakaoPayCancleVO;
import com.kh.spring26.pay.KakaoPayFinishVO;
import com.kh.spring26.pay.KakaoPayHistoryVO;
import com.kh.spring26.pay.KakaoPayResultVo;
import com.kh.spring26.pay.KakaoPayStartVO;
import com.kh.spring26.service.KakaopayService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/pay")
public class KakaoPayController {

	@Autowired
	private KakaopayService kakaopayService;

	@GetMapping("/prepare")
	public String prepare() {
		return "pay/prepare";
	}

	@PostMapping("/prepare")
	public String prepare(@ModelAttribute KakaoPayStartVO startVO, HttpSession session) throws URISyntaxException {
		// 모자른정보 두개채우기
		startVO.setPartner_order_id(UUID.randomUUID().toString());
		startVO.setPartner_user_id("bdasdew");

		// 결제요청
		KakaoPayResultVo resultVo = kakaopayService.prepare(startVO);

		// 결제 승인 페이지에서 사용할 수 있도록 session에 3개의 데이터를 추가
		// partner_order_id,partner_user_id,tid"
		session.setAttribute("partner_order_id", startVO.getPartner_order_id());
		session.setAttribute("partner_user_id", startVO.getPartner_user_id());
		session.setAttribute("tid", resultVo.getTid());

		// qr코드반환
		return "redirect:" + resultVo.getNext_redirect_pc_url();
	}

	// 결제성공시 처리
	// 승인 요청을 보내기 위해 필요한 정보를 취합
	// 세션 partner_order_id,partner_user_id,tid
	// 파라미터 :pg_token
	// 고유값 : CID
	@GetMapping("/success")
	public String success(@RequestParam String pg_token, HttpSession session) throws URISyntaxException {

		String partner_order_id = (String) session.getAttribute("partner_order_id");
		String partner_user_id = (String) session.getAttribute("partner_user_id");
		String tid = (String) session.getAttribute("tid");

		log.info("pg_token={}", pg_token);
		log.info("partner_order_id={}", partner_order_id);
		log.info("partner_user_id={}", partner_user_id);
		log.info("tid={}", tid);

		KakaoPayFinishVO finishVO = kakaopayService.approve(partner_order_id, partner_user_id, pg_token, tid);

		// 필요하다면 데이터베이스 처리 등을 수행 (결제 최종 완료 시점)
		log.info("finishVO={}", finishVO);

		// 결제취소에 사용할 필요한 정보(결제 결과)를 세션에 넣어라  에 넣을거다
		session.setAttribute("finishVO", finishVO);

		return "redirect:result_succes";
	}

	// 성공페이지
	@GetMapping("/result_succes")
	public String result_succes() {
		return "pay/result_succes";
	}

	// 취소페이지

	@GetMapping("/cancle")
	public String cancle() {
		// 할거하고
		return "redirect:result_cancle";
	}

	@GetMapping("/result_cancle")
	public String result_cancle() {
		return "pay/result_cancle";
	}

	// 실패페이지
	@GetMapping("/fail")
	public String fail() {
		// 할거하고
		return "redirect:result_fail";
	}

	@GetMapping("/result_fail")
	public String result_fail() {
		return "pay/result_fail";
	}

	// Q:카카오페이지 주문 조회 페이지를 구현
	// tid를 파라미터로 받아 해당하는 tid의 주문정보를 조회하여 화면에 출력

	@GetMapping("/history")
	public String history(@RequestParam String tid, Model model) throws URISyntaxException {
		KakaoPayHistoryVO historyVO = kakaopayService.history(tid);
		model.addAttribute("historyVO", historyVO);
		return "pay/history";
	}

	// 결제번호 결제금액을 받아 결제취소한다.
	@GetMapping("/delete")
	public String delete(HttpSession session) throws URISyntaxException {
		KakaoPayFinishVO finishVO = (KakaoPayFinishVO) session.getAttribute("finishVO");
		String tid = finishVO.getTid();
		int cancle_amount = finishVO.getAmount().getTotal();
	
		
		  KakaoPayCancleVO cancelVO = kakaopayService.cancle(tid, cancle_amount);
		  session.removeAttribute("finishVO"); return "redirect:delete_finish";
		 
	}
	
	@GetMapping("/delete_finish")
	public String delete_finish() {
		return "pay/delete_finish";
		
		
	}

}
