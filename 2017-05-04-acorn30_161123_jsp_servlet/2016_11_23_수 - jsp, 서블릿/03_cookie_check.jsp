<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
    <center>
        <h1>reading cookies</h1>
    </center>
    
    <%
        Cookie cookie = null;
        Cookie[] cookies = null;
        
        cookies = request.getCookies();
        if(cookies != null){
            out.println("<h2> Found Cookies Name and Value</h2>");
            for(int i = 0; i < cookies.length; i++){
            	cookie = cookies[i];
            	out.print("Name: "+cookie.getName()+", ");
            	out.print("Value: "+cookie.getValue()+"<br/>");
            }
        }
        else{
        	out.println("<h2>No cookies found</h2>");
        }      
     %>
     
    
</body>
</html>