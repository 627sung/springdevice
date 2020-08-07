<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>로그인 예제</h1>

<!-- 
	계획 : 
	- saveId라는 쿠키가 있다면 아이디를 저장한 것으로 간주
	- 저장된 value를 불러와서 아이디 입력창에 설정
	- 아이디 저장하기 체크박스에 체크 수행
 -->
<form>

	<c:choose>
		<c:when test="${not empty cookie.saveId}">
			<input type="text" name="id" value="${cookie.saveId.value}">
			<br>
			<input type="checkbox" name="saveId" checked>
		</c:when>
		<c:otherwise>
			<input type="text" name="id">
			<br>
			<input type="checkbox" name="saveId">
		</c:otherwise>
	</c:choose>

</form>