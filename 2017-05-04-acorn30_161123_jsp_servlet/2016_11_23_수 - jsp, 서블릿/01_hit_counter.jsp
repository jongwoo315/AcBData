<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "java.util.*, java.io.*" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>application object in jsp</title>
</head>

<body>
    <%
    Integer hitsCount =
    	(Integer)application.getAttribute("hitCounter");
    if(hitsCount == null || hitsCount == 0){
    	/*first visit*/
    	out.println("welcome to my website!");
    	hitsCount = 1;
    }
    else{
    	/*return visit*/
    	out.println("welcome back to my website!");
    	hitsCount += 1;
    }
    application.setAttribute("hitCounter", hitsCount);
    %>
    
    <center>
        <p>Total number of visits: <%= hitsCount %></p>
    </center>
</body>
</html>