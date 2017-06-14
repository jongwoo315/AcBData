
<%@ page import="java.sql.*" contentType="text/html; charset=EUC-KR" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>

<body>
    <h4>jstl을 사용한 방명록</h4>
    <hr>
    <fmt:requestEncoding value="utf-8"/>
    <c:set var="dd" value="<%= new java.util.Date()%>"/>
    
    <c:catch var="ex">
        <sql:update sql="insert into visitor values(?, ?, ?)" dataSource="jdbc/myconn">
	        <sql:param value="${param.name}"/>
	        <sql:param value="${param.content}"/>
	        <sql:dateParam value="${dd}" type="date"/>
        </sql:update>
    </c:catch>
    
    <c:if test="${!empty ex}">
        시스템 장애로 처리가 불가능합니다.<br>
    </c:if>
    
    <c:if test="${empty ex}">
        <h4>${param.name}님의 글이 저장완료되었습니다.!! (JSTL방식)</h4>
    </c:if>
        
</body>
</html>