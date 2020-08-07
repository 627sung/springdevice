<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
-계획 : pop이라는 쿠키가 있는지 검사 
-쿠키가 없는 경우에만 광고(새창)을 출력
window.open코드  
 -->

<c:if test = "${empty cookie.pop}">
  <script>
  window.open("http://www.naver.com","naver","width=100", "height=100");
  </script>
</c:if>







  