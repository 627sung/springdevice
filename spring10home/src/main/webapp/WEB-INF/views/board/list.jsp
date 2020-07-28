<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h1>보드리스트</h1>



<!-- 검색창 -->
<form action = "union" method ="post">
<select name ="type">
<option value="board_title" >제목</option>
<option value="board_writer">작성자</option>

</select>
<input type="text" name="keyword" placeholder="검색어" value ="${param.keyword}" } >
<input type ="submit" value="검색">

</form>


<table border="1">
	<tbody>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		
		<c:forEach var="boardDto" items="${list}">

			<tr>
				<th>${boardDto.board_no} </th>
				<th>${boardDto.board_title}</th>
				<th>${boardDto.board_writer}</th>
				<th>
				<fmt:parseDate value="${boardDto.board_date}" var="time" pattern="yyyy-mm-dd HH:mm:ss"/>
				<fmt:formatDate value="${time}" pattern="yyyy-mm-dd"/>
				</th>
				<th>${boardDto.board_read}</th>
			</tr>
		</c:forEach>

	</tbody>

</table>





