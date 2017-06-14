<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%request.setCharacterEncoding("UTF-8"); %>
	
	<c:set var="now" value="<%=new java.util.Date() %>" />
	
	<fmt:formatDate value="${now }" type="date" dateStyle="full" /> <br>
	<fmt:formatDate value="${now }" type="date" dateStyle="short" /> <br>
	
	<hr>
	<fmt:formatDate value="${now }" type="time" /> <br>
	
	<hr>
	<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full" /> <br>
	
	<hr>
	<fmt:formatDate value="${now }" pattern="z a h:mm" /> <br>
	 
	<hr><hr><hr>
	<c:set var="price" value="10000" />
	<fmt:formatNumber value="${price }" type="number" var="numberType" />
	
	통화 : <fmt:formatNumber value="${price }" type="currency" currencySymbol="원" /> <br>
	통화 : <fmt:formatNumber value="${price }" type="currency" currencySymbol="$" /> <br>
	퍼센트 : <fmt:formatNumber value="${price }" type="percent" groupingUsed="true" /> <br>
	숫자 : ${numberType }
</body>
</html>