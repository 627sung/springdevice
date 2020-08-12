<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- axios 추가  -->

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.19.2/axios.js"
	integrity="sha512-VGxuOMLdTe8EmBucQ5vYNoYDTGijqUsStF6eM7P3vA/cM1pqOwSBv/uxw94PhhJJn795NlOeKBkECQZ1gIzp6A=="
	crossorigin="anonymous"></script>

<script>
	function searchScore() {
		var div = document.querySelector(".list-wrap");	
		var start = document.querySelector(".start").value;
		var finish = document.querySelector(".finish").value;
		
	    div.innerHTML = ""; //초기화코드
	    div.textContent = ""; //초기화코드
		
		axios({
			url:"${pageContext.request.contextPath}/test/test9?start="+start+"&finish="+finish,
			method :"get"
			
		}).then(function(response){
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





<h1>학생 점수 구간 검색</h1>
<!--  점수시작 지점 끝지점이 필요하다  -->


<input type="number" class="start">
부터
<input type="number" class="finish">
사이의 학생
<button onclick="searchScore();">조회</button>


<div class="list-wrap"></div>

