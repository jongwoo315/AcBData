<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		<%
		   // Create cookies for first and last names.      
		   Cookie firstName123 = new Cookie("first_name44", request.getParameter("first_name44"));
		   Cookie phonenum123= new Cookie("phonenum44",  request.getParameter("phonenum44"));
		
		   // Set expiry date after 24 Hrs for both the cookies.
		   firstName123.setMaxAge(60*60*24); 
		   phonenum123.setMaxAge(60*60*24); 
		
		   // Add both the cookies in the response header.
		   response.addCookie( firstName123 );
		   response.addCookie( phonenum123 );
		%>
		
		<center>
		   <h1>쿠키 설정 후 전송</h1>
		</center>
		
		<ul>
	
			<li>
			  <p>
			      <b>이름:</b>
				  <%= request.getParameter("first_name44")%>
				</p>
			</li>
			
			<li>
			  <p>
			      <b>전번:</b>
			      <%= request.getParameter("phonenum44")%>
			  </p>
			</li>
			
		</ul>
	
	</body>

</html>

