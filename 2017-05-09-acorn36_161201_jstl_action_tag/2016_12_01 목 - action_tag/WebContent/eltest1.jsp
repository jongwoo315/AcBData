<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>

<body>
    <h4>EL의 다양한 연산식 출력</h4>
    <hr>
    <%="${200+100}:" %> ${200+100} <br>
    <%="${200-100}:" %> ${200-100} <br>
    <%="${200/100}:" %> ${200/100} <br>
    <%="${200>100}:" %> ${200>100} <br>
    <%="${200==100}:" %> ${200==100} <br>
    
    <%="{10>2 && 'a'<'b'}:" %> ${10>2 && 'a' < 'b'} <br>
    
</body>
</html>