<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>게시글 작성</h1>

<form action="write" method="post">
	말머리 :
	<select name="head">
		<option value="">선택하세요</option>
		<option>정보</option>
		<option>유머</option>
		<option>공지</option>
	</select>
	<br><br>
	제목 : <input type="text" name="title">
	<br><br>
	내용 : <br>
	<textarea name="content" rows="5" cols="60"></textarea>
	<br><br>
	<input type="submit" value="등록">
</form>