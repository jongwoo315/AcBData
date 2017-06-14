<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="test.*"%>  <!--  import부분은 test패키지의 java파일의 내용을 가져오겠다는 의미 -->
<% request.setCharacterEncoding("UTF-8"); %>

<%
    //test.AddressBean addr = new AddressBean();
    AddressBean addr = new AddressBean();
    addr.setName("김종호 테스트");
    addr.setId("iadslba");
    addr.setAddress("충북 충주시");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
        이름: <%=addr.getName() %></br>
        아이디: <%=addr.getId() %></br>
        주소: <%=addr.getAddress() %></br>	
	</body>
</html>