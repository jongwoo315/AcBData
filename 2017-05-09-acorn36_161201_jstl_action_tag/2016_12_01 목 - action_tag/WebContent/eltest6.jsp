<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h4>el에서의 헤더정보 추출과  scope 객체에 등록된 객체 추출</h4>
    <font color=blue>쿠키 정보:</font> ${cookie.JSESSIONID.value }<br>
    <font color=blue>USER-AGENT 정보:</font> ${header["user-agent"]}<br>
    <font color=blue>USER-AGENT 정보:</font> ${header.user-agent }<br>
    <font color=blue>ACCEPT 헤더 정보:</font> ${header.accept }<br>
    <hr>
    객체 등록<br>
    <hr>
    
    <%
        pageContext.setAttribute("account_grade", "PageContext 객체문자열");
        request.setAttribute("account_grade", "HttpServletRequest 객체 문자열");
        session.setAttribute("account_grade", "HttpSession 객체 문자열");
        application.setAttribute("account_grade", "ServletContext 객체에 문자열");
        %>
        
    pageScope객체에서 추출: ${pageScope.account_grade}<br>
    requestScope객체에서 추출: ${requestScope.account_grade}<br>
    sessionScope객체에서 추출: ${sessionScope.account_grade}<br>
    applicationScope객체에서 추출: ${applicationScope.account_grade}<br>
    <br><br>
    ${account_grade } 
    
</body>
</html>
