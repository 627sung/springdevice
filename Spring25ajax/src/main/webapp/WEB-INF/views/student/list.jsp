<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- axios 추가  -->    
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.19.2/axios.js" integrity="sha512-VGxuOMLdTe8EmBucQ5vYNoYDTGijqUsStF6eM7P3vA/cM1pqOwSBv/uxw94PhhJJn795NlOeKBkECQZ1gIzp6A==" crossorigin="anonymous"></script>
    
<script>
   function loadlist() {
	//목표 axios를 사용하여 RestController에 신호를 보내 목록을 불러온다
 	var div = document.querySelector(".list-wrap");

	axios({
  	url:"${pageContext.request.contextPath}/test/test7",
  	method:"get"
  	})
  	.then(function(response){
  	  	console.log(response.data);
  	  	 
  	  for(var i=0; i<response.data.length; i++){	
  	  	//h3 태그를 만들어서 정보를 설정하고 div에추가 
  	  	var h3 = document.createElement("div");
  	  	var name = response.data[i].name;
  	  	var score = response.data[i].score;

  	  	h3.textContent = name+":"+score;
  	  	div.appendChild(h3);
  	  }
  	  	});
  }

</script> 
    
    
<h1>학생목록 </h1>



<!-- 몰롯을 불러오기 위한 버튼 (트리거) -->
<button onclick="loadlist()">불러오기</button>


<!--  목록이 출력이될 자리 -->
<div class="list-wrap"></div>