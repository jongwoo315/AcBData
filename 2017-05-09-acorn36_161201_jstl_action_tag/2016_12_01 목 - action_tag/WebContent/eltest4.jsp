<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>

<body>
    <h4>변수 사용</h4>
    
    name 변수의 값: ${name}<br>
    
    <%String name="김정현"; %>
    name 변수의 값: ${name}<br>
    
    <%pageContext.setAttribute("name", "JAVA"); %>    
    name 변수의 값: ${name}<br>
    
    pageScope.name 변수의 값: ${pageScope.name}<br>
    
    <hr>
    
    number 변수의 값: ${number }<br>
    
    <%pageContext.setAttribute("number", new Integer(100)); %>
    number 변수의 값: ${number }<br>
    
    pageScope.number 변수의 값 : ${pageScope.number }<br>
</body>
</html>