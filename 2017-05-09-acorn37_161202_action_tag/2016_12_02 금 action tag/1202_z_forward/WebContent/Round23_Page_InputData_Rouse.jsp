<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	//전송된 데이터를 획득한다.
	String input_data = request.getParameter("data");
	
	boolean check = false;
	
	//전송된 데이터의 공백여부를 확인한다.
	if(input_data != null && input_data.trim().length() != 0) {
		try {
			// 숫자로 변환 시 오류가 발생하는 지 체크한다.
			Integer.parseInt(input_data);
			// 숫자 변환 시 오류가 없다면 check의 값을 true로 설정한다.
			check = true;
		} catch (NumberFormatException nfe) { }
	}
	
	// check의 값이 false이면 Error 페이지로 이동한다.
	if(!check) {
		response.sendRedirect("Round23_Page_InputData_Error.jsp");
		return;
	}
	
%>

<!-- 
	check의 값이 true 이면 출력 페이지로 forward 한다.
	forward가 되면 이 페이지로 전달된 "data"는 그대로 다음 페이지로 전송된다.
-->
<jsp:forward page="Round23_Page_InputData_View.jsp" />