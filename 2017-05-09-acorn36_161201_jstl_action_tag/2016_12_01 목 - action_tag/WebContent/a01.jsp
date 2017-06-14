<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>과제 2</title>
</head>
<body>
	<h4>Product 객체에 저장된 회원 정보</h4>
	<jsp:useBean id="product" scope="session" class="test.Product" />
	선택된 상품 정보는 다음과 같습니다. <br>
	<hr>
	선택된 사과의 개수 : <jsp:getProperty name="product" property="apple" /><br>
	선택된 바나나의 개수 : <jsp:getProperty name="product" property="banana" /><br>
	선택된 한라봉의 개수 : <jsp:getProperty name="product" property="halabong" /><br>
	<hr>
</body>
</html>
