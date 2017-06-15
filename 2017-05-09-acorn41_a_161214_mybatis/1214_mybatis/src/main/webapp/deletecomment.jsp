<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.io.*, javax.servlet.*, java.util.*, ldg.mybatis.service.*, ldg.mybatis.model.*,
                        org.springframework.context.*, org.springframework.context.support.*"
        contentType="text/html; charset=utf8" pageEncoding="UTF-8" %>
                 
<%
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:config/spring/context-mapper.xml");
    
    Long commentNo12 = Long.parseLong(request.getParameter("commentNo"));
    
    
    CommentService commentService = (CommentService)applicationContext.getBean("commentService");
    Integer result = commentService.deleteComment(commentNo12);

    %>                 
    
<%= result %>
    
<html>

	<head>
		<title>삭제 성공!</title>
	</head>

	<body>
	    
	</body>

</html>