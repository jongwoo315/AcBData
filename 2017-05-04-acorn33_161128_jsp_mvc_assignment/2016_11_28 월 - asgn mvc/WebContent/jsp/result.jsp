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
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
	<style>
	   th, td {
		    padding: 15px;
		    text-align: left;
		    border-bottom: 1px solid #ddd;
	        background-color: #4CAF50;
            color: white;
	   }
	   
	   hr {
		  border: 0;
		  border-top: 1px solid #8c8c8c;
		  border-bottom: 1px solid #fff;
	   }
	</style>
	
</head>

<body class="container">
    <br><br>
    <h3>결과 화면</h3>
    <div class="row">
         <div class="span12">
             <div class="well">
                <div style="height:300px;overflow:auto;">
				    <table>
				        <thead>
					      	<tr>
					      		<td>번호</td>
					      		<td>이름</td>
					      		<td>국어</td>
					      		<td>영어</td>
					      		<td>수학</td>
					      		<td>총점</td>
					      		<td>평균</td>
					      	</tr>
					    </thead>
				      <%
				        Iterator iterator = vec.iterator();
				        while(iterator.hasNext()){
				            scoreDTO dto = (scoreDTO) iterator.next();
				      %>
				      <tbody>
				        <tr>
				            <td><%=dto.getNum() %></td>
				            <td><%=dto.getName() %></td>
				            <td><%=dto.getKor() %></td>
				            <td><%=dto.getEng() %></td>
				            <td><%=dto.getMath() %></td>
				            <td><%=dto.getTot() %></td>
				            <td><%=dto.getAvg() %></td>
				        </tr>
				      </tbody>
				        <% } %>   
				    </table>
				</div>
			    <br>
			    
			    <form method="post" action="servlet_delete">
			    	<input type="text" name="name" placeholder="삭제할 레코드의 이름 입력">
			    	<button type="submit" class="btn btn-primary">삭제실행</button>
			    </form>
			    
			    <hr>
			    <br>
			    <form method="post" action="servlet_edit1">
					<input type="text" name="name" placeholder="기존 이름입력">
			    	<input type="text" name="newname" placeholder="새로운 이름 입력">
					<button type="submit" class="btn btn-primary">이름변경</button>
			    </form>
			    <br>
			    <form method="post" action="servlet_edit2">
					<input type="text" name="name" placeholder="이름입력">
					<input type="text" name="kor" placeholder="새로운 국어점수 입력">
					<button type="submit" class="btn btn-primary">국어점수변경</button>
			    </form>
			    <br>
			    <form method="post" action="servlet_edit3">
					<input type="text" name="name" placeholder="이름입력">
			 		<input type="text" name="eng" placeholder="새로운 영어점수 입력">
					<button type="submit" class="btn btn-primary">영어점수변경</button>
			    </form>
			    <br>
			    <form method="post" action="servlet_edit4">
					<input type="text" name="name" placeholder="이름입력">
					<input type="text" name="math" placeholder="새로운 수학점수 입력">
					<button type="submit" class="btn btn-primary">수학점수변경</button>
			    </form>
			    
			    <br>
			    <button onclick="location.href='input_page.html' " class="btn btn-primary">첫화면으로</button>
	        </div>
		  </div>
	   </div>
    
</body>
</html>