<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	//웹소켓 접속 함수
	var socket;
	function connect(){
		var uri = "ws://localhost:8080/spring24/member";
		socket = new WebSocket(uri);
		
		//연결이 되었는지 안되었는지 확인할 수 있도록 예약 작업(콜백)을 설정
		socket.onopen = function(){
			console.log("서버와 연결되었습니다");
		};
		socket.onclose = function(){
			console.log("서버와 연결이 종료되었습니다");
		};
		socket.onerror = function(e){
			console.log("서버 연결 과정에서 오류가 발생했습니다");
		};
		socket.onmessage = function(e){
// 			console.log(arguments);
// 			console.log("메세지가 도착했습니다");
 			console.log(e);
			var div = document.createElement("div");
			//e.data는 Json String 이므로 객체로 바꾸어 필요한 정보를 추출 
			var obj = JSON.parse(e.data);
			div.textContent ="["+obj.id+"]"+obj.payload;
			
			
			document.querySelector(".message-wrap").appendChild(div);
		};
	}
	//웹소켓 종료 함수
	function disconnect(){
		socket.close();
	}
	//메세지 전송 함수 : 입력된 글자를 불러와서 서버에 전송
	function send(){
		var text = document.querySelector("#chat-input").value;
		if(!text){
			return;
		}
		
		socket.send(text);
		document.querySelector("#chat-input").value = "";//창 지우기
	}
</script>

<h1>Member Login Example</h1>

<h2>로그인 여부 : ${userinfo != null}</h2>

<button onclick="connect();">접속</button>
<button onclick="disconnect();">종료</button>

<hr>
<input type="text" id="chat-input">
<button onclick="send();">전송</button>

<!-- 수신된 메세지가 출력될 영역 -->
<div class="message-wrap"></div>








