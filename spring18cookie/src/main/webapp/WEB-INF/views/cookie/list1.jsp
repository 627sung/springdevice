<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%-- -- EL을 이용한 쿠키접근 
      ${cookie.쿠키명}
    --%>  
    
<h1>쿠키리스트 확인~ </h1>

<div>
쿠키가 있읍니까? : ${cookie.test != null}
 쿠키가 있읍니까? : ${not empty cookie.test}
</div>

<div>
쿠키:  ${cookie.test}
</div>

<div>
쿠키 값:   ${cookie.test.value}
</div>