<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="test.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	//넘어오는 데이터에 대한 한글 처리를 한다.
	request.setCharacterEncoding("euc-kr");
%>
<!-- 
	글쓰기에서 넘어온 데이터를 useBean과 setProperty를 이용하여 획득한다.
	setProperty에서 property 값을 "*"로 설정하면
	속성과 이름이 동일한 객체는 자동으로 값이 설정된다.
-->
<jsp:useBean id="board" class="test.BoardDTO" scope="request">
	<jsp:setProperty name="board" property="*"/>
</jsp:useBean>

<%
	//DB에 저장을 위한 DAO 클래스 객체를 생성한다.
	BoardDAO dao = new BoardDAO();
	//resigerMember메서드에 useBean으로 생성된 DTO객체인 board를 매개변수를 전달하여 저장한다.
	int result = dao.registerMember((test.BoardDTO)request.getAttribute("board"));
	
	//저장이 완료되면 session 영역에 list 라는 이름으로 DB의 모든 Row를 획득하여 ArrayList로 저장한다.
	session.setAttribute("list", dao.getBoardList());
%>

<script language='javascript'>
<!--
	//registerMember 메서드 작업 후 리턴되는 결과가 -1이면 에러이므로
	//에러 메시지를 표시하고 그 이외의 값이 리턴되면 List 페이지로 이동한다.
	if(<%= result %> == -1) {
		alert('저장에 실패했습니다.');
		history.go(-1);
	}
	else {
		alert('성공적으로 저장되었습니다.');
		location.href='Round23_Page_BBS_List.jsp';
	}
//-->
</script>