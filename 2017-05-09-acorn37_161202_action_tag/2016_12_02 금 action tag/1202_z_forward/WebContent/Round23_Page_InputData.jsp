<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Input For Forward!</title>
</head>
<body>
	<center>
		<form method="post" action="Round23_Page_InputData_Rouse.jsp">
			Input Data : <input type="text" name="data" value="${ param.data }"/>
			<input type="submit" value="전송" />
		</form>
	</center>
</body>
</html>