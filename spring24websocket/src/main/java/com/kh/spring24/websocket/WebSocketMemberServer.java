package com.kh.spring24.websocket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring24.vo.MessageVO;

import lombok.extern.slf4j.Slf4j;

/**
 * 이 서버는 로그인된 사용자만 메시지를 보낼 수 있다.
 */
@Slf4j
public class WebSocketMemberServer extends TextWebSocketHandler {

	/**
	 * 사용자 관리 저장소
	 */
	private Set<WebSocketSession> users = new CopyOnWriteArraySet<>();

	/**
	 * 접속 메소드
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.add(session);
		log.info("접속 : {}", session);
		log.info("attribute : {}", session.getAttributes());

		// 만약에 로그인한 사용자가 접속한다면 하단에 아이디 정보가 출력된다
		// 로그인하지 않았다면 아이디는 null로 표시된다.
		log.info("아이디 : {}", session.getAttributes().get("userinfo"));
	}

	/**
	 * 종료 메소드
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		users.remove(session);
	}

	/**
	 * 중계 메소드
	 * "id : 은성 / 내용 : 안녕"
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String id = (String) session.getAttributes().get("userinfo");
		if (id != null) {
			MessageVO vo = MessageVO.builder().id(id).payload(message.getPayload()).build();
			
			ObjectMapper mapper = new ObjectMapper();
			String result = mapper.writeValueAsString(vo);

			for (WebSocketSession ws : users) {
				// 전송을 위한 신규 메시지 생성
				TextMessage newMessage = new TextMessage(result);
				
				// 전체에게 전송
				ws.sendMessage(newMessage);
				
			}
		}


	}
}
