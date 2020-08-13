<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>결제페이지</h1>


<form action = "prepare" method="post">
<input type="text" name="item_name" placeholder="상품명" required>
<input type="text" name="quantity" placeholder="수량" required>
<input type="text" name="total_amount" placeholder="총금액" required>
<input type="submit" name="결제하기" >


</form>