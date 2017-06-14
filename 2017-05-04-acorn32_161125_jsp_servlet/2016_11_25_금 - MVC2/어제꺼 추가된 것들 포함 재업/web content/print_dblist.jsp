<!-- view -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="mysqltest.*"%>
<%@ page import="java.lang.*, java.util.*, java.sql.*, javax.sql.*, javax.naming.*, mysqltest.*, java.io.UnsupportedEncodingException, java.text.SimpleDateFormat" %>

<%
    ArrayList<MemberDTO> vec = new ArrayList<MemberDTO>();
    vec = (ArrayList<MemberDTO>)request.getAttribute("data1");
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
            MemberDTO dto = (MemberDTO) iterator.next();
            %>
        <tr>
            <td><%=dto.getNum() %></td>
            <td><%=dto.getName() %></td>
            <td><%=dto.getTel() %></td>
            <td><%=dto.getAddr() %></td>
        </tr>
        <% } %>   
    </table>
    <!-- http://stackoverflow.com/questions/9024167/retrieving-data-from-a-mysql-database-and-displaying-it-in-html-using-java -->
	<%-- <table>
		<c:forEach items="${vec}" var="abcd">
		<tr>
		       <td>${abcd.num}</td>
		       <td>${abcd.name}</td>
		       <td>${abcd.tel}</td>
		       <td>${abcd.addr}</td>
		</tr>
		</c:forEach>
	</table> --%>

</body>
</html>