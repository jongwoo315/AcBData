<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.io.*, javax.servlet.*, java.util.*, ldg.mybatis.service.*, ldg.mybatis.model.*,
                        org.springframework.context.*, org.springframework.context.support.*"
                 contentType="text/html; charset=utf8" %>
                 
<%
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context-mapper.xml");
    
    Long commentNo = Long.parseLong(request.getParameter("commentNo"));
    String userId = request.getParameter("userId");
    String commentContent = request.getParameter("commentContent");
    Comment comment = new Comment(commentNo, userId, Calendar.getInstance().getTime(), commentContent);
    CommentService commentService = (CommentService)applicationContext.getBean("commentService");
    Integer result = commentService.insertComment(comment);
    %>                 
    
<%= result %>
    
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>

<body>
    
</body>

</html>