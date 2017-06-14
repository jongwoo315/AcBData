<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%
	/*
		CENTER 영역에 나타나는 페이지를 매개변수를 이용하여 Control 한다.
		처음 contents_page 라는 속성이 없을 때에는 main.jsp를 표시하고,
		contents_page 라는 속성이 존재하게 되면 그 값을 페이지명으로 호출한다.
	*/
	String contents_page = request.getParameter("contents_page");
	if(contents_page == null || contents_page.trim().length() == 0) {
		contents_page = "./template/main.jsp";
	}
	else {
		contents_page = "./template/" + contents_page;
	}
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Page!</title>
</head>
<body>
	<table border="1" width="800">
		<tr>
			<td colspan="2" align="center" valign="middle">
				<!-- 
				지시어 원소를 이용하여 top.jsp를 포함시킨다.
				이렇게 포함된 페이지는 서블릿으로 변환될때 코드 자체가 포함된다. 
				-->
				<%@ include file="./template/top.jsp" %>
			</td>
		</tr>
		<tr height="300">
			<td align="center" valign="top" width="250">
				<!-- 
				액션 원소를 이용하여 jsp 페이지를 포함시킨다.
				이 때에는 소스 코드를 포함하여 컴파일 되는 것이 아니라
				단지 호출에 의해 결과 페이지만 표시할 뿐이다.
				또한 flush 값에 의해 이 코드 이전까지의 내용을 
				화면으로 전송할지 여부를 결정한다.
				현재는 화면이 전부 모일때 까지 전송하지 않고 기다린다.
				-->
				<jsp:include page="./template/left.jsp" flush="false" />
			</td>
			<td valign="top" width="550">
				<!-- 
				매개변수의 값에 따라 포함될 페이지를 동적으로 결정한다.
				호출된 결과가 담기게 된다.
				-->			
				<jsp:include page="<%= contents_page %>" flush="false" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center" valign="middle">
				<%@ include file="./template/bottom.jsp" %>
			</td>
		</tr>
	</table>
</body>
</html>