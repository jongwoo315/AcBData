<!-- view -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
   	pageEncoding="UTF-8" import="test.*"
    %>    
<%@ page import="test.*, java.lang.*, java.util.*, java.sql.*, javax.sql.*, javax.naming.*, 
					java.io.UnsupportedEncodingException, java.text.SimpleDateFormat" %>

<%
    ArrayList<scoreDTO> vec = new ArrayList<scoreDTO>();
    vec = (ArrayList<scoreDTO>)request.getAttribute("data1");
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>성적표 결과 창</title>
</head>

<body>
    <table>
      	<tr>
      		<td>번호</td>
      		<td>이름</td>
      		<td>국어</td>
      		<td>영어</td>
      		<td>수학</td>
      		<td>총점</td>
      		<td>평균</td>
      	</tr>
      <%
        Iterator iterator = vec.iterator();
        while(iterator.hasNext()){
            scoreDTO dto = (scoreDTO) iterator.next();
      %>
        <tr>
            <td><%=dto.getNum() %></td>
            <td><%=dto.getName() %></td>
            <td><%=dto.getKor() %></td>
            <td><%=dto.getEng() %></td>
            <td><%=dto.getMath() %></td>
            <td><%=dto.getTot() %></td>
            <td><%=dto.getAvg() %></td>
        </tr>
        <% } %>   
    </table>
    <br>
    
    <form method="post" action="servlet_delete">
    	<input type="text" name="name" placeholder="삭제할 레코드의 이름 입력">
    	<button type="submit">삭제실행</button>
    </form>
    
    <br>
    <form method="post" action="servlet_edit1">
		<input type="text" name="name" placeholder="기존 이름입력">
    	<input type="text" name="newname" placeholder="새로운 이름 입력">
		<button type="submit">이름변경</button>
    </form>
    <form method="post" action="servlet_edit2">
		<input type="text" name="name" placeholder="이름입력">
		<input type="text" name="kor" placeholder="새로운 국어점수 입력">
		<button type="submit">국어점수변경</button>
    </form>
    <form method="post" action="servlet_edit3">
		<input type="text" name="name" placeholder="이름입력">
 		<input type="text" name="eng" placeholder="새로운 영어점수 입력">
		<button type="submit">영어점수변경</button>
    </form>
    <form method="post" action="servlet_edit4">
		<input type="text" name="name" placeholder="이름입력">
		<input type="text" name="math" placeholder="새로운 수학점수 입력">
		<button type="submit">수학점수변경</button>
    </form>
    
    <br>
    <button onclick="location.href='input_page.html' ">back to first page</button>
    
</body>
</html>