package com.kh.spring24.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

/**
 *	웹소켓의 기본적인 이해를 돕기 위해 만든 서버
 *	- WebSocketServer를 만들기 위해서는 특정 클래스/인터페이스 상속이 필요 
 */
@Slf4j
//public class WebSocketBasicServer implements WebSocketHandler{
public class WebSocketBasicServer extends TextWebSocketHandler{
	
	/**
	 * 접속 시 실행되는 메소드
	 * - session : 사용자의 웹소켓 정보(HttpSession이 아님!)
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("접속");
		log.info("session : {}", session);
	}
	
	/**
	 * 메세지 수신 시 실행될 메소드
	 * - session : 사용자(전송한 사용자)의 웹소켓 정보(HttpSession이 아님!)
	 * - message : 사용자가 전송한 메세지 정보
	 * 		- payload : 실제 보낸 내용
	 * 		- byteCount : 보낸 메세지 크기(byte)
	 * 		- last : 메세지 종료 여부
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		log.info("수신");
		log.info("session : {}", session);
		log.info("message : {}", message);
	}
	
	/**
	 * 사용자 접속 종료시 실행되는 메소드
	 * - session : 사용자의 웹소켓 정보(HttpSession이 아님!)
	 * - status : 접속이 종료된 원인과 관련된 정보
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.info("종료");
		log.info("session : {}", session);
		log.info("status : {}", status);
	}
	
}




