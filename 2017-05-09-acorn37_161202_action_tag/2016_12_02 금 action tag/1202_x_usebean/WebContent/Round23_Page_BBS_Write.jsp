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
		<h2>�Խ��� �۾���</h2>
		<form method='post' action='Round23_Page_BBS_Write_Process.jsp'>
		<table border='1' width='500'>
			<tr>
				<th width='150'>
					������
				</th>
				<td>
					<!-- 
						������ ��ü �̸��� �ݵ�� BoardDTO ���� �Ӽ� �̸��� �����ؾ� �Ѵ�.
						ù���ڸ� �ҹ��ڷ� ó���� �־�� DTO���� setter�� getter��
						������ �� �ռ����� ù���ڿ� ���� �빮�� ��ȯ�� �������� �̷������.��
					-->
					<input type='text' name='content_title' size='40'/>
				</td>
			</tr>
			<tr>
				<th width='150'>
					�ۼ���
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
					<input type='button' value='����Ʈ��' onClick='move_list()'/>&nbsp;
				</td>
				<td align='right'>
					<input type='submit' value='�۾���'/>
					<input type='reset' value='�ʱ�ȭ'/>
				</td>
			</tr>
		</table>
		</form>
	</center>
</body>
</html>