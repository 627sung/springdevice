<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<h1>게시판 목록</h1>

<table border="1">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="boardDto" items="${list}">
		<tr>
			<td>${boardDto.board_no}</td>
			<td>${boardDto.board_title}</td>
			<td>${boardDto.board_writer}</td>
			<td>
				<fmt:parseDate value="${boardDto.board_date}" 
							var="time" pattern="yyyy-MM-dd HH:mm:ss"/>
				<fmt:formatDate value="${time}" pattern="yyyy-MM-dd"/>
			</td>
			<td>${boardDto.board_read}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<!-- 검색창 -->
<form action="union" method="post">
	
	<select name="type">
		<option value="board_title" ${param.type == 'board_title' ? 'selected':''}>제목</option>
		<option value="board_writer" ${param.type == 'board_writer' ? 'selected':''}>작성자</option>
	</select>
	
	<input type="text" name="keyword" placeholder="검색어" value="${param.keyword}">
	
	<input type="submit" value="검색">
	
</form>







