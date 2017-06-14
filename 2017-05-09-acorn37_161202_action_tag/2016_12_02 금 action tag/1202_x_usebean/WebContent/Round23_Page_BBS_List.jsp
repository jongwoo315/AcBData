<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<% 
	/* 
	���⼭ ȹ���ϴ� ArrayList�� Write_Process.jsp���� ���� �� 
	session ������ ����Ǵ� �������̴�.
	���� �� ������ �������� �����͸� ȹ���ؾ� ������ 
	������ ���ǻ� �۾��� ���Ŀ� ȹ���ϴ� ������ ó���Ѵ�.
	���� �ݵ�� �۾��⸦ �ѹ� �ؾ����� ����Ʈ�� ���̰� �� ���̴�.
	*/
	ArrayList<test.BoardDTO> list = (ArrayList<test.BoardDTO>)session.getAttribute("list"); 
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Board List!</title>
	<script language='javascript'>
		/*�� �Լ��� �۾��� ��ư�� ������ �� �۾��� �������� �̵��ϱ� ���� �Լ��̴�.*/
		function move_write() {
			location.href='Round23_Page_BBS_Write.jsp';
		}
	</script>
</head>

<body>
	<center>
		<h2>�Խ���</h2>
		<table border='0' width='500'>
			<tr>
				<td align='right'>
					<input type='button' value='�۾���' onClick='move_write()'/>
				</td>
			</tr>
		</table>
		<table border='1' width='500'>
			<tr height='25'>
				<th width='60'>��ȣ</th>
				<th width='200'>����</th>
				<th width='90'>�ۼ���</th>
				<th width='500'>����</th>
				<th width='100'>�ۼ���</th>
			</tr>
			<!-- 
				��ܿ��� ȹ���� list ��ü�� size()�� �����Ͽ�
				�����Ͱ� ���ٸ� ������ ������ ����ϰ�,
				�����Ͱ� ������ �ش� ����ŭ �ݺ��ϸ鼭 �����͸� ����Ѵ�.
			-->
			<% if(list == null || list.size() == 0) { %>
			<tr>
				<td colspan='4' align='center'>��ϵ� ���� �����ϴ�.</td>
			</tr>
			<% 
				}  else {
					for(int i = 0; i < list.size(); ++i) {
						//����� �����ʹ� BoardDTO Ÿ���̱� ������ 
						//�ش� Ŭ������ �̸����� ȹ���Ѵ�.
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