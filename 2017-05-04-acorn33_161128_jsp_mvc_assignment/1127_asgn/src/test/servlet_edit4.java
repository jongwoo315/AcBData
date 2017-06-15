package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet_edit4")
public class servlet_edit4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servlet_edit4() {super();}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name123 = request.getParameter("name");
		int math123 = Integer.parseInt(request.getParameter("math"));
		
		scoreDTO dto = new scoreDTO();
		dto.setName(name123);
		dto.setMath(math123);
		
		scoreDAO dao = new scoreDAO();
		
		boolean bool = dao.editscore4(dto); // registerMember메서드가 하는 일 -> registerProcess.java에서 set으로 저장한 값들을 get으로 가져온 후,  DB query에 저장한다.
		
		if(bool){
			response.sendRedirect("./Success.html");
		}
	}
}

