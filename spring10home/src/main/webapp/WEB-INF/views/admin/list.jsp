<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

멤바 리스트 

<c:forEach var ="member" items ="${memberlist}">
<h3>${member.member_id},${member.member_nick} </h3>
</c:forEach>
