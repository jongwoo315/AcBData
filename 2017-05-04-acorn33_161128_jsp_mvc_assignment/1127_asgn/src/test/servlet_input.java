package test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

@WebServlet("/servlet_input")
public class servlet_input extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public servlet_input() { super(); }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name123 = request.getParameter("name");
		int kor123 = Integer.parseInt(request.getParameter("kor"));
		int eng123 = Integer.parseInt(request.getParameter("eng"));		// html에서 입력한 값을 가져오는 과정
		int math123 = Integer.parseInt(request.getParameter("math"));
		
		scoreDTO dto = new scoreDTO();
		dto.setName(name123);
		dto.setKor(kor123);
		dto.setEng(eng123);		// 가져온 값을 DTO변수 값들에 저장하는 과정(set)
		dto.setMath(math123);
		
		scoreDAO dao = new scoreDAO();
		// 성공여부 확인
		boolean bool = dao.inputscore(dto); // registerMember메서드가 하는 일 -> registerProcess.java에서 set으로 저장한 값들을 get으로 가져온 후,  DB query에 저장한다.
		
		if(bool){
			response.sendRedirect("./Success.html"); // response는 사용자에게로 돌려보낼 놈 
//			request.setCharacterEncoding("UTF-8");
//			ServletContext context = this.getServletContext();
//			RequestDispatcher dispatcher = context.getRequestDispatcher("/jsp/result.jsp");
//			// RequestDispatcher, 사용자의 요구를 발송(방출)
//			dispatcher.forward(request, response);	// response는 사용자에게로 돌려보낼 놈
		}
	}

}
