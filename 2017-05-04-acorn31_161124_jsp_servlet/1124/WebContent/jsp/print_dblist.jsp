<!-- view -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="mysqltest.*"
    %>    
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
      	<tr>
      		<td>번호</td>
      		<td>이름</td>
      		<td>전번</td>
      		<td>주소</td>
      	</tr>
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
    <br>
    
    <form method="post" action="delete">
    	<input type="text" name="name" placeholder="삭제할 레코드의 이름 입력">
    	<button type="submit">삭제실행</button>
    </form>
    
    <br>
    <form method="post" action="edit">
		<input type="text" name="name" placeholder="변경할 이름입력">
		<input type="text" name="kor" placeholder="변경할 국어점수 입력">
		<input type="text" name="eng" placeholder="변경할 영어점수 입력">
		<input type="text" name="math" placeholder="변경할 수학점수 입력">
		<button type="submit">변경실행</button>
    </form>
    
<!--     <br>
    <a rel="stylesheet" href="signup_form.html" type="text/css">첫 화면으로 </a><br/>
 -->
     
<!--    	<br>
   	<form action="signup_form.html">
   		<input type="submit" value="첫화면으로">
   	</form>
    
    <br>
    <input type="button" value="버튼"  onclick="location.href='signup_form.html'">
 -->    
    <br>
    <button onclick="location.href='signup_form.html' ">back to first page</button>
    
    
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