<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

메뉴리스트

<c:forEach var="menudto" items="${getlist}" >
${menudto.name},${menudto.price}
</c:forEach>
