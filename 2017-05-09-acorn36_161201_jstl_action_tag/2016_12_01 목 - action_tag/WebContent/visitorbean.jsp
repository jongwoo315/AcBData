<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>방명록</title>
</head>

<body>
    <h4>JavaBean을 활용하는 방명록 JSP</h4>
    <hr>
    <%-- DB에 접속하여 방명록 등록 --%>
    <% request.setCharacterEncoding("UTF-8"); %>
    <jsp:useBean id="db" scope="request" class="test.VisitorBean"/>
    <jsp:setProperty name="db" property="name"/>
    <jsp:setProperty name="db" property="content"/>
    <%=db.getResult()%>
    

    <%-- <jsp:setProperty name="db" property="name" param="name"/> 
                    param은 html에서 가져오는 값
                    html과 bean(.java)에 사용하는 변수가 같으면 param생략가능
     --%>
    
    <%-- <jsp:setProperty name="db" property="content" param="content"/> param은 html에서 가져오는 값 --%>
</body>
</html>