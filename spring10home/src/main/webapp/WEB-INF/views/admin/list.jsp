<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<h1>회원 목록</h1>

<table border="1">
	<thead>
		<tr>
			<th>아이디</th>
			<th>닉네임</th>
			<th>권한</th>
		</tr>
	</thead>
	<tbody>
	
		<c:forEach var="memberDto" items="${list}">
		<tr>
			<td>${memberDto.member_id}</td>
			<td>${memberDto.member_nick}</td>
			<td>${memberDto.member_auth}</td>
		</tr>
		</c:forEach>
		
	</tbody>
</table>