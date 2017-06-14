<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script language="javascript">
<!--
	function move_list() {
		location.href = "Round23_Page_IncludeMain.jsp?contents_page=main.jsp";
	}
//-->
</script>

<center>
	<h3>게시판 리스트</h3>	
	<font size='2'>
	<table width="480" border="1">
		<tr>
			<th width="50">번호</th>
			<th width="250">제목</th>
			<th width="80">작성자</th>
			<th width="100">작성일</th>
		</tr>
		<%
			for(int i = 0; i < 5; ++i) {
				out.println("<tr>");
				out.println("<td align='center'>" + (i + 1) + "</td>");
				out.println("<td align='left'><a href='#'>안녕하세요! #" + (i + 1) + "</a></td>");
				out.println("<td align='center'>김승현</td>");
				out.println("<td align='center'>2010-02-01</td>");
				out.println("</tr>");
			}
		%>
	</table>
	<table width="480" border="0">
		<tr>
			<td align="center">				
					<a href='#'>&lt;&lt;</a>&nbsp;
					<a href='#'>&lt;</a>&nbsp;
					<a href='#'>1</a>&nbsp;
					<a href='#'>&gt;</a>&nbsp;
					<a href='#'>&gt;&gt;</a>&nbsp;				
			</td>
		</tr>
	</table>
	</font>
	<table width="480" border="0">
		<tr>
			<td align="left">
				<input type="button" value="리스트" onClick="move_list()"/>
			</td>
			<td align="right">
				<input type="button" value="글쓰기"/>
			</td>
		</tr>
	</table>
</center>