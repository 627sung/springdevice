package com.kh.spring24.websocket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

/**
 *	접속한 사용자를 기억해두고 모두에 대한 처리를 수행하는 서버 
 */
@Slf4j
public class WebSocketGroupServer extends TextWebSocketHandler{
	
	/**
	 * 사용자를 기억하기 위한 저장소
	 * - 중복 불가
	 * - 동기화 지원
	 */
	private Set<WebSocketSession> users = new CopyOnWriteArraySet<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.add(session);
		log.info("사용자 접속! 현재 {} 명", users.size());
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		users.remove(session);
		log.info("사용자 종료! 현재 {} 명", users.size());
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//메시지를 모든 사용자에게 전송(사용자 수만큼 반복하여 전송)
		TextMessage newMessage = new TextMessage(message.getPayload());
		for(WebSocketSession ws : users) {
			ws.sendMessage(newMessage);
		}
	}
	
}



