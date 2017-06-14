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
	
		  <!-- select * from emp --> <!-- sql:query 태그 안에 주석처리된 것도 넣지 말 것 -->
	<c:catch var="ex">
		<sql:query var="result" dataSource="jdbc/myconn">
		  select * from my_data
		</sql:query>
	</c:catch>
	
	<c:set var="i" value="0"/>
	
	<p>
	<table border="2">
		<td>번호</td>
		<td>이름</td>
		<td>직무</td>
		<c:forEach var="row" items="${result.rows }">
			<tr>
				<%-- <td><c:out value="${i + 1 }" /></td> --%>
				<%-- <td><c:out value="${row.ename }" /></td>
				<td><c:out value="${row.job }" /></td> --%>
				<td><c:out value="${row.num }" /></td>
				<td><c:out value="${row.name }" /></td>
                <td><c:out value="${row.age }" /></td>
			</tr>
		</c:forEach>
	</table>
	
	<c:if test="${ex != null }">
		예외가 발생했습니다. : ${ex }
	</c:if>
	
	
</body>
</html>