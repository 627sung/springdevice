<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>회원가입</h1>

<form action="join" method="post">
	아이디 : <input type="text" name="member_id"><br><br>
	비밀번호 : <input type="text" name="member_pw"><br><br>
	닉네임 : <input type="text" name="member_nick"><br><br>
	우편번호 : <input type="text" name="post"><br><br>
	기본주소 : <input type="text" name="base_addr"><br><br>
	상세주소 : <input type="text" name="extra_addr"><br><br>
	생년월일 : <input type="text" name="member_birth"><br><br>
	전화번호 : <input type="text" name="member_phone"><br><br>
	자기소개 : <input type="text" name="member_intro"><br><br>
	<input type="submit" value="가입">
</form>