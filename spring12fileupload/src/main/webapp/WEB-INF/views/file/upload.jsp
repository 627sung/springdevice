<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>파일업로드~</h1>

<!-- 파일 올리기 폼  -->
<form action="upload" method="post" enctype="multipart/form-data">

	<input type="text" name="uploader">
	<br><br>
	<input type="file" name="f" multiple accept=".jpg, .png, .gif">
	<br><br>
	<input type="submit" value="업로드">

</form>
