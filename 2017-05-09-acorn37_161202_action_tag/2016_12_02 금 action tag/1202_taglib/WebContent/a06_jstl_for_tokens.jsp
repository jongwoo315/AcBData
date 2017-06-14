<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
	
	<c:set var="it" value="0" />
	콤마와 점을 구분자로 활용 : <br>
	<c:forTokens var="token" items="빨강색!주황색@노랑색#초록색$파랑색%남색^보라색" delims=",.!@#$%^&*()">
		분해된 요소 ${it=it+1 } 번째 ${token } <br>
	</c:forTokens>
</body>
</html>