<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Board Write!</title>
	<script language='javascript'>
		function move_list() {
			location.href='Round23_Page_BBS_List.jsp';
		}
	</script>
</head>

<body>
	<center>
		<h2>게시판 글쓰기</h2>
		<form method='post' action='Round23_Page_BBS_Write_Process.jsp'>
		<table border='1' width='500'>
			<tr>
				<th width='150'>
					글제목
				</th>
				<td>
					<!-- 
						여기의 객체 이름은 반드시 BoardDTO 속의 속성 이름과 동일해야 한다.
						첫글자를 소문자로 처리해 주어야 DTO에서 setter와 getter를
						생성할 때 합성어의 첫글자에 대한 대문자 변환이 무리없이 이루어진다.ㄴ
					-->
					<input type='text' name='content_title' size='40'/>
				</td>
			</tr>
			<tr>
				<th width='150'>
					작성자
				</th>
				<td>
					<input type='text' name='content_writer' size='40'/>
				</td>
			</tr>
			<tr>
				<td colspan='2'>
					<textarea name='content_contents' cols='60' rows='8'></textarea>
				</td>
				
			</tr>
		</table>
		<table border='0' width='500'>
			<tr>
				<td align='left'>
					<input type='button' value='리스트로' onClick='move_list()'/>&nbsp;
				</td>
				<td align='right'>
					<input type='submit' value='글쓰기'/>
					<input type='reset' value='초기화'/>
				</td>
			</tr>
		</table>
		</form>
	</center>
</body>
</html>