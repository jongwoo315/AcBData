<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/mydats/insert">
	<table>
	<tr>
		<td>commentNo</td>
		<td><input name="commentNo"/></td>
	</tr>
	<tr>
		<td>userId</td>
		<td><input name="userId"/></td>
	</tr>
	<tr>
		<td>commentContent</td>
		<td><input name="commentContent"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="submit"/>
		</td>
	</tr>
	</table>
	
</form>
	<form method="post" action="/mydats/select">
		<table>
			<tr>
				<td>commentNo.null이면 모두출력</td>
				<td><input type="text" name="commentNo"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="테이블출력" /></td>
			</tr>
		</table>
	</form>
		<form method="post" action="/mydats/delete">
		<table>
			<tr>
				<td>commentNo삭제</td>
				<td><input type="text" name="commentNo"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="테이블출력" /></td>
			</tr>
		</table>
	</form>

</body>
</html>