<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- axios 추가  -->    
 <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.19.2/axios.js" integrity="sha512-VGxuOMLdTe8EmBucQ5vYNoYDTGijqUsStF6eM7P3vA/cM1pqOwSBv/uxw94PhhJJn795NlOeKBkECQZ1gIzp6A==" crossorigin="anonymous"></script>
  
  <script>
  function checkName() {
	//할일  : 이름이 DB에 있나 없나 확인하여 입력창 뒤에 있는 span에 출력 	
	//입력창 ,span 불러온다 .
	var input = document.querySelector("input[name=name]");
  	var span = document.querySelector("input[name=name]+span");
  	
  	var name= input.value;
  	if(!name){
  		return;
  	}
  	
  	
  	//axios를 이용하여 비동기 통신을 보낸다. 
  	//axios ({옵션}).then(성공코드).catch(오류코드);
  	axios({
  		//url:http:localhost:8080/spring25/test/test8?name="+name
  	url:"${pageContext.request.contextPath}/test/test8?name="+name,
  	method:"get"
  	})
  	.then(function(response){
  	  	if(!response.data){//결과없음
  	  		span.textContent = "사용 가능한 이름입니다";  
  	  	}
  	  	else{
  	  		span.textContent = "사용하지마세요";
  	  	  }
  	  	  
  	  	});
  }
  	
  	

  </script>  
    
    
<h1>스튜던트 조인 </h1>



이름 : <input type="text" name = "name" onblur="checkName()"><span></span>