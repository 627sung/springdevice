<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<h1>아이템목록</h1>

<table border="1">
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>가격</th>
			<th>타입</th>
			<th>등록일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${list}">
			<tr>
				<th>${item.no}</th>
				<th>${item.name}</th>
				<th>${item.price}</th>
				<th>${item.type}</th>
				<th>${item.when}</th>
			</tr>
		</c:forEach>

		
	</tbody>
</table>













