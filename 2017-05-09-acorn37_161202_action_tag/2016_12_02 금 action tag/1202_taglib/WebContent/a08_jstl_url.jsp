<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> --%>
<%@ page contentType="text/html; charset=euc-kr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
    <title>Insert title here</title>
</head>

<body>

    <fmt:requestEncoding value="UTF-8"/>
    <%-- <fmt:responseEncoding value="UTF-8"/> --%>

    <c:url var="url1" value="../shopping.do"/>
    <c:url var="url2" value="/shopping.do">
        <c:param name="Add" value="isdn-001"/>
    </c:url>
    <c:url var="url3" value="http://localhost:8080/jstl/setTag.jsp"/>
    
    <ul>
        <li>URL1 = <a href=${url1 }>URL1</a>
        <li>URL2 = <a href=${url2 }>URL2</a>
        <li>URL3 = <a href=${url3 }>URL3</a>
    </ul>
    
    <c:import url="http://naver.com" var="urlEx"/>
    ${urlEx}
    
<%--     <c:redirect url="test.jsp">
        <c:param name="message" value="Have a nice day!!"/>
    </c:redirect> --%>
</body>
</html>