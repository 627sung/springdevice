<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- axios 추가  -->    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.19.2/axios.js" integrity="sha512-VGxuOMLdTe8EmBucQ5vYNoYDTGijqUsStF6eM7P3vA/cM1pqOwSBv/uxw94PhhJJn795NlOeKBkECQZ1gIzp6A==" crossorigin="anonymous"></script>
    
 <script>
 function getlist(){
	 var diva = document.querySelector(".list-seat");
	 
	 axios({
		 url:"${pageContext.request.contextPath}/test/test7",
		 method:"get"
	 })
	 .then(function(resp){
		 console.log(resp.data);
		 diva.innerHTML = "";
		 
		 for(var i=0; i<resp.data.length; i++){
			 
			 var h1 = document.createElement("h1");
			 var name=resp.data[i].name;
			 var score=resp.data[i].score;
			 h1.textContent = name+":"+score;
			 diva.append(h1);
		 }		
		
		 

	 });
	 
 }
 </script>   
    
    
    
    
    
    
    
    
<h1>학생의 목록</h1>

<!-- 목록불러오기 (버튼)-->
<button onclick="getlist()">불러오기!</button>

<!-- 목록 불러온거 들어가는 자리  -->
<div class="list-seat"></div>