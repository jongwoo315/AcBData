<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	java.util.HashMap mapData = new java.util.HashMap();
	mapData.put("name", "왕성현");
	mapData.put("today", new java.util.Date());
%>

<c:set var="intArray" value="<%= new int[] {1, 2, 3, 4, 5} %>" />
<c:set var="map" value="<%= mapData %>" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>

<body>

	<h3>1부터 100까지 홀수의 합 출력</h3>
	<c:set var="sum" value="10" />
	<c:forEach var="i" begin="1" end="100" step="2" >
	   <c:set var="sum" value="${sum + i }" />
	</c:forEach>
	결과 = ${sum }
	
	<hr>
	<h3>구구단 / 4단</h3>
	<ul>
		<c:forEach var="i" begin="1" end="9">
		  <li>4 * ${i} = ${4 * i}</li>
		</c:forEach>
	</ul>
	
	<hr>
	<h3>int형 배열</h3>
	<c:forEach var="i" items="${intArray}" begin="2" end="4">
		[${i }]
	</c:forEach>
	
	<hr>
	<h3>Map</h3>
	<c:forEach var="i" items="${map }">
		${i.key } = ${i.value }<br>
	</c:forEach>
	
</body>
</html>