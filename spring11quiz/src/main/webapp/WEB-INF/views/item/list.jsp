<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>상품리스트및조회</h1>
<a href="list?col=price&order=desc">최고가부터</a>
<a href="list?col=price&order=asc">최저가부터</a>
<a href="list?col=name&order=desc">이름순</a>
<a href="list?col=when&order=desc">최신 등록순</a>




<table border="1">
	<thead>
		<tr>
			<th>상품번호</th>
			<th>상품명</th>
			<th>판매가</th>
			<th>분류</th>
			<th>등록일</th>
			<th>관리메뉴</th>
		</tr>

	</thead>
     <tbody>
	<c:forEach var="getlist" items="${list}">

<tr>
			<td>${getlist.no}</td>
			<td>${getlist.name}</td>
			<td>${getlist.price}</td>
			<td>${getlist.type}</td>
			<td>${getlist.when}</td>
	  		<td>
				<a href="detail?no=${getlist.no}">상세</a> | 수정 | 삭제
<%-- 				<a href="detail?no=${itemDto.no}">상세</a>  --%>
				<a href="detail/${getlist.no}">상세</a>
				| 
					<a href="edit/${getlist.no}">수정</a> 
				|
				<a href="delete/${getlist.no}">삭제</a> | 삭제
			</td>
		</tr>



	</c:forEach>
	</tbody> 	
</table>
