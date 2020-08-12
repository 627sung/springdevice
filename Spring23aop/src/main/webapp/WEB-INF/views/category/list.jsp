<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:forEach var = "categoryDto" items ="${list}">
<h5>

${categoryDto.category_no},
${categoryDto.category_name}

</h5>



</c:forEach>