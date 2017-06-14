<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%request.setCharacterEncoding("UTF-8"); %>
	
	<c:set var="dd" value="<%=new java.util.Date() %>" />
	<c:catch var="ex">
		<sql:update sql="update mydata set sal=? where name=?" dataSource="jdbc/myconn">
			<sql:param value="${param.sal }" />
			<sql:param value="${param.name }" />
		</sql:update>
	</c:catch>
	
	<c:if test="${!empty ex }">
		<h4>시스템 장애로 처리가 불가능합니다.</h4><br>
		${ex }
	</c:if>
	<c:if test="${empty ex }">
		<h4>회원 정보 수정이 완료되었습니다.</h4>
	</c:if>
		
			
	
	
	
</body>
</html>