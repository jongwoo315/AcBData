<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% //05/ Session2.jsp
      String xid = (String)session.getAttribute("id");
      String xname = (String)session.getAttribute("name");
      String xtoday = (String)session.getAttribute("today");
      String xtomorrow = (String)session.getAttribute("tomorrow");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	</head>

	<body>
        아이디 = <%=xid %><p>
        이름 = <%=xname %><p>
        오늘은 = <%=session.getAttribute("today") %><p>
        내일은 = <%=session.getAttribute("tomorrow") %><p>
        세션 아이디 = <%=session.getId() %><p>	
	</body>
</html>
