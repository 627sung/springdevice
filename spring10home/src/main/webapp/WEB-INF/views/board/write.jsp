<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>글쓰기</h1>

<form action="write" method="post">
	말머리 : <input type="text" name="board_head"><br><br>
	제목 : <input type="text" name="board_title"><br><br>
	내용 : <input type="text" name="board_content"><br><br>
	<input type="submit" value="등록">
</form>