<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>결과창</title>
    <style>
        h4{
            text-align: center;
        }
    </style>
    
</head>

<body>
    <h4>점수와 학점</h4>
    <hr>
    <%request.setCharacterEncoding("UTF-8"); %>
    
    <!-- 서버로 보내기 -->
    <jsp:useBean id="db1" scope="request" class="test1.convert_score_to_grade"/>
        <jsp:setProperty property="name" name="db1"/>
        <jsp:setProperty property="kor" name="db1"/>
        <jsp:setProperty property="eng" name="db1"/>
        <jsp:setProperty property="math" name="db1"/>
    
    <!-- 서버에서 가져오기 -->
    <%=db1.getResult()%>   
</body>
</html>