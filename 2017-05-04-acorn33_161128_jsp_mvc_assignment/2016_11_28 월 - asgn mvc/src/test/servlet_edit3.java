package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet_edit3")
public class servlet_edit3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servlet_edit3() {super();}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name123 = request.getParameter("name");
		int eng123 = Integer.parseInt(request.getParameter("eng"));		// html에서 입력한 값을 가져오는 과정
		
		scoreDTO dto = new scoreDTO();
		dto.setName(name123);
		dto.setEng(eng123);		// 가져온 값을 DTO변수 값들에 저장하는 과정(set)
		
		scoreDAO dao = new scoreDAO();
		boolean bool = dao.editscore3(dto); // registerMember메서드가 하는 일 -> registerProcess.java에서 set으로 저장한 값들을 get으로 가져온 후,  DB query에 저장한다.
		
		if(bool){
			response.sendRedirect("./Success.html");
		}
	}
}

