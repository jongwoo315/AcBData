<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<% 
	/* 
	여기서 획득하는 ArrayList는 Write_Process.jsp에서 저장 후 
	session 영역에 저장되는 데이터이다.
	실제 이 페이지 진입전에 데이터를 획득해야 하지만 
	지금은 편의상 글쓰기 이후에 획득하는 것으로 처리한다.
	따라서 반드시 글쓰기를 한번 해야지만 리스트가 보이게 될 것이다.
	*/
	ArrayList<test.BoardDTO> list = (ArrayList<test.BoardDTO>)session.getAttribute("list"); 
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Board List!</title>
	<script language='javascript'>
		/*이 함수는 글쓰기 버튼을 눌렀을 때 글쓰기 페이지로 이동하기 위한 함수이다.*/
		function move_write() {
			location.href='Round23_Page_BBS_Write.jsp';
		}
	</script>
</head>

<body>
	<center>
		<h2>게시판</h2>
		<table border='0' width='500'>
			<tr>
				<td align='right'>
					<input type='button' value='글쓰기' onClick='move_write()'/>
				</td>
			</tr>
		</table>
		<table border='1' width='500'>
			<tr height='25'>
				<th width='60'>번호</th>
				<th width='200'>제목</th>
				<th width='90'>작성자</th>
				<th width='500'>내용</th>
				<th width='100'>작성일</th>
			</tr>
			<!-- 
				상단에서 획득한 list 객체의 size()를 조사하여
				데이터가 없다면 데이터 없음을 출력하고,
				데이터가 있으면 해당 수만큼 반복하면서 데이터를 출력한다.
			-->
			<% if(list == null || list.size() == 0) { %>
			<tr>
				<td colspan='4' align='center'>등록된 글이 없습니다.</td>
			</tr>
			<% 
				}  else {
					for(int i = 0; i < list.size(); ++i) {
						//저장된 데이터는 BoardDTO 타입이기 때문에 
						//해당 클래스의 이름으로 획득한다.
						test.BoardDTO dto = (test.BoardDTO)list.get(i);
			%>
				<tr>
					<td align='center'><%= dto.getContent_num() %></td>					
					<td align='left'>
					   <a href=<%= dto.getContent_title() %>><%= dto.getContent_title() %></a>
					</td>
					<td align='center'><%= dto.getContent_writer() %></td>
					<td align='center'><%= dto.getContent_contents() %></td>
					<td align='center'><%= dto.getContent_regdate() %></td>
				</tr>
			<%
					}
				} 
			%>
		</table>
	</center>
</body>
</html>