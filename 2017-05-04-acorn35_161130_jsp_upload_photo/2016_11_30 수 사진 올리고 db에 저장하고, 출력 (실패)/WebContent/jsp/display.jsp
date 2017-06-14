<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="test.*"%>
    
<%@ page import="java.lang.*, java.util.*, java.sql.*, javax.sql.*, javax.naming.*, test.*, 
    java.io.UnsupportedEncodingException, java.text.SimpleDateFormat" %>


<%
    ArrayList<DTO> vec = new ArrayList<DTO>();
    vec = (ArrayList<DTO>)request.getAttribute("aaa");
    %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <table>
        <% 
            Iterator iterator = vec.iterator();
            while(iterator.hasNext()){
            DTO dto = (DTO) iterator.next();
        %>
        <tr>
            <td><%=dto.getName() %></td>
            <td><%=dto.getId() %></td>
            <td><%=dto.getPw() %></td>
            <td><%=dto.getFilename() %></td>
            <td><%=dto.getUrl() %></td>
            
        <%-- <img src="<%=request.getParameter("dto.getUrl()"")%>"> --%>
        <%}%>

    </table>
</body>
</html>