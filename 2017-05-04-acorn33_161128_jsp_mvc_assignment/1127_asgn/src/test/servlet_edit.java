package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet_edit")
public class servlet_edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servlet_edit() {super();}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name123 = request.getParameter("name");
		String newname123 = request.getParameter("newname");
		int kor123 = Integer.parseInt(request.getParameter("kor"));
		int eng123 = Integer.parseInt(request.getParameter("eng"));		// html에서 입력한 값을 가져오는 과정
		int math123 = Integer.parseInt(request.getParameter("math"));
		
		scoreDTO dto = new scoreDTO();
		dto.setName(name123);
		dto.setNewname(newname123);
		dto.setKor(kor123);
		dto.setEng(eng123);		// 가져온 값을 DTO변수 값들에 저장하는 과정(set)
		dto.setMath(math123);
		
		scoreDAO dao = new scoreDAO();
		scoreDAO dao2 = new scoreDAO();
		scoreDAO dao3 = new scoreDAO();
		scoreDAO dao4 = new scoreDAO();
		
		// 성공여부 확인
		boolean bool1 = dao.editscore1(dto); // registerMember메서드가 하는 일 -> registerProcess.java에서 set으로 저장한 값들을 get으로 가져온 후,  DB query에 저장한다.
		boolean bool2 = dao2.editscore2(dto);
		boolean bool3 = dao3.editscore3(dto);
		boolean bool4 = dao4.editscore4(dto);
		
		if(bool1){
			response.sendRedirect("./Success.html");
		}
	}
}

