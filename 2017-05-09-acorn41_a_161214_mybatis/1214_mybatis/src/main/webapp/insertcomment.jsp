<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.io.*, javax.servlet.*, java.util.*, 
						ldg.mybatis.service.*, ldg.mybatis.model.*,
                        org.springframework.context.*, org.springframework.context.support.*"
        contentType="text/html; charset=utf8" pageEncoding="UTF-8" %>
                 
<%
    ApplicationContext applicationContext = 
    			new ClassPathXmlApplicationContext("classpath*:config/spring/context-mapper.xml");
	/* 스프링은 각 객체를 컨테이너에 저장한다. 컨테이너에서 빈을 가져오기 위해서는 ApplicationContext 타입의 객체를 생성해야 한다.
		이 객체를 생성할 때 Bean 설정이 들어있는 XML파일을 파라미터로 설정하다. */ 

    Long commentNo = Long.parseLong(request.getParameter("commentNo"));
    String userId = request.getParameter("userId");
    String commentContent = request.getParameter("commentContent");
    Comment comment = new Comment(commentNo, userId, Calendar.getInstance().getTime(), commentContent);
    
    CommentService commentService = (CommentService)applicationContext.getBean("commentService");
     	/* 앞서 생성한 ApplicationContext 객체에서 commentService Bean을 가져온다. 
     	CommentService 객체는 마이바티스를 사용해서 각종 데이터베이스 연동을 하는 서비스 객체다. */

    Integer result = commentService.insertComment(comment);
    %>                 
    
<%= result %>
    
<html>

	<head>
		<title>입력성공!</title>
	</head>

	<body>
	    
	</body>

</html>