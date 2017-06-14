<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    session.setAttribute("id", id);
    session.setAttribute("name", name);
    
    session.setAttribute("today", "건강한 마음으로 변화되는 날!");
    session.setAttribute("tomorrow", "변화된 내가 기대되는 날!");
    
    session.setMaxInactiveInterval(30);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>

<body>
    <a href="02_session02.jsp">session02.jsp</a>
</body>
</html>