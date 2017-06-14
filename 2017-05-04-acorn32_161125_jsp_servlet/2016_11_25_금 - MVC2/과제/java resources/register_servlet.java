package doit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register_servlet")
public class register_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public register_servlet() { super(); }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// entry.html에서 
		// name= 으로 지정한 것들이 getParameter의 매개변수로 들어간다.
		// getParameter는 모두 String으로 받는다. (다른 기본형은 불가능)
		String name123 = request.getParameter("name");
		String kor123 = request.getParameter("kor");
		String eng123 = request.getParameter("eng");
		String math123 = request.getParameter("math");
		
		// MemberDTO(model)에서 변수와 setter, getter를 먼저 작성 
		scoreDTO dto = new scoreDTO();
		dto.setName(name123);
		dto.setKor(kor123);
		dto.setEng(eng123);
		dto.setMath(math123);
		
		scoreDAO dao = new scoreDAO();
		
		boolean bool = dao.inputscore(dto);
		
		if(bool){
			response.sendRedirect("./Success.html");
		}
		
	}

}
