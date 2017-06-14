<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%
	//forward에 의해 전송된 "data"를 획득한다.
	String data = request.getParameter("data");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Result View!</title>
</head>
<body>
	<center>
		<!-- data 의 값을 출력한다. -->
		결과 Data : <%= data %>
	</center>
</body>
</html>