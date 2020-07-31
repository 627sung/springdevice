<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>갤러리 이미지 등록</h1>

<form action="add" method="post" enctype="multipart/form-data">
	<input type="text" name="title" placeholder="제목"><br><br>
	<input type="text" name="explain" placeholder="설명"><br><br>
	<input type="file" name="file" accept=".jpg,.png,.gif"><br><br>
	<input type="submit" value="등록">
</form>