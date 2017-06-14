<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="test.*"%>
<%request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="regBean" class="test.RegisterBean"/> <!-- jsp action 태그라고 함 -->
<jsp:setProperty property="*" name="regBean"/> <!--  -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- <% 
    /*RegisterBean regBean = new RegisterBean();
    regBean.setMem_id("mem_id");
    regBean.setMem_id("mem_name");
    regBean.setMem_id("mem_passwd");
    regBean.setMem_id("mem_email");
    regBean.setMem_id("mem_phone");*/ //없어도 됨
    %> -->


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>

<body>
    <jsp:getProperty name="regBean" property="mem_id"/><p>
    <jsp:getProperty name="regBean" property="mem_passwd"/><p>
    <jsp:getProperty name="regBean" property="mem_name"/><p>
    <jsp:getProperty name="regBean" property="mem_email"/><p>
    <jsp:getProperty name="regBean" property="mem_phone"/><p>
 
    <!-- 아이디 <%=regBean.getMem_id() %><p>
    비번 <%=regBean.getMem_passwd() %><p>
    이름 <%=regBean.getMem_name() %><p>
    이멜 <%=regBean.getMem_email() %><p>
    전번 <%=regBean.getMem_phone() %><p>-->

    
</body>
</html>