<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.io.*, javax.servlet.*, java.util.*, ldg.mybatis.service.*, ldg.mybatis.model.*,
                        org.springframework.context.*, org.springframework.context.support.*"
        contentType="text/html; charset=utf8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        

<html>
	<head>
		<title>선택된 코멘트들!</title>
	</head>
	<body>
		<%
		    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:config/spring/context-mapper.xml");		    
		    Long commentNo12 = Long.parseLong(request.getParameter("commentNo"));
		   	
		    /* Comment ccc = new Comment();
		    ccc.setCommentNo(commentNo12);
		    Long print_comment = ccc.getCommentNo(); */		    
		    CommentService commentService = (CommentService)applicationContext.getBean("commentService");	// CommentService로 넘어가면서 소문자 commentService로 변함
		    List<Comment> result123 = commentService.selectComment(commentNo12); /* 좌항은 CommentMapperRepository.java에 있는 내용 /// commentService */
		    //request.setAttribute("menu", result123);
		    //Iterator<Comment> abc = result123.iterator();
		%>
		
		<c:forEach items="<%=result123%>" var="element"> 
		  <tr>
		    <td>${element.getCommentNo()}</td>
		    <td>${element.getUserId()}</td>
		    <td>${element.getRegDate()}</td>
		    <td>${element.getCommentContent()}</td>
		  </tr>
		  <br>
		</c:forEach>
		
	</body>
</html>