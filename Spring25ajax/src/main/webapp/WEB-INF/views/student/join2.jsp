<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- axios 추가  -->    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.19.2/axios.js" integrity="sha512-VGxuOMLdTe8EmBucQ5vYNoYDTGijqUsStF6eM7P3vA/cM1pqOwSBv/uxw94PhhJJn795NlOeKBkECQZ1gIzp6A==" crossorigin="anonymous"></script>
    
  <script>
  function check2(){
	  var input = document.querySelector("input[name=name]");
	  var span = document.querySelector("input[name=name]+span");
	  console.log(input)
	  console.log(span)

	  var name = input.value;
	  if(!name){
		  return;
	  }
	  
	  //axios 사용  RestController 을 통해 얻은 값을 불러온다 .
	  axios({
		  url:"${pageContext.request.contextPath}/test/test8?name="+name,
		 method:"get"  
	  })
	  .then(function(resp){
		  if(!resp.data){ //결과가 없다면 
			  span.textContent = "사용이가능합니다.";
		  }else{
			  span.textContent="누가 이미 사용중입니다.";
		  }	  
	  });
	  
	  
	  
  }
  
  </script>  
    

    



<h1>join2입니다다아다아아다다</h1>
이름<input type ="text" name = "name" onblur="check2()" ></input><span></span>


