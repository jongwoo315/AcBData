<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="test.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	//�Ѿ���� �����Ϳ� ���� �ѱ� ó���� �Ѵ�.
	request.setCharacterEncoding("euc-kr");
%>
<!-- 
	�۾��⿡�� �Ѿ�� �����͸� useBean�� setProperty�� �̿��Ͽ� ȹ���Ѵ�.
	setProperty���� property ���� "*"�� �����ϸ�
	�Ӽ��� �̸��� ������ ��ü�� �ڵ����� ���� �����ȴ�.
-->
<jsp:useBean id="board" class="test.BoardDTO" scope="request">
	<jsp:setProperty name="board" property="*"/>
</jsp:useBean>

<%
	//DB�� ������ ���� DAO Ŭ���� ��ü�� �����Ѵ�.
	BoardDAO dao = new BoardDAO();
	//resigerMember�޼��忡 useBean���� ������ DTO��ü�� board�� �Ű������� �����Ͽ� �����Ѵ�.
	int result = dao.registerMember((test.BoardDTO)request.getAttribute("board"));
	
	//������ �Ϸ�Ǹ� session ������ list ��� �̸����� DB�� ��� Row�� ȹ���Ͽ� ArrayList�� �����Ѵ�.
	session.setAttribute("list", dao.getBoardList());
%>

<script language='javascript'>
<!--
	//registerMember �޼��� �۾� �� ���ϵǴ� ����� -1�̸� �����̹Ƿ�
	//���� �޽����� ǥ���ϰ� �� �̿��� ���� ���ϵǸ� List �������� �̵��Ѵ�.
	if(<%= result %> == -1) {
		alert('���忡 �����߽��ϴ�.');
		history.go(-1);
	}
	else {
		alert('���������� ����Ǿ����ϴ�.');
		location.href='Round23_Page_BBS_List.jsp';
	}
//-->
</script>