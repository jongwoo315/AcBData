// controller
package test;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.*;
//import org.apache.catalina.servlet4preview.RequestDispatcher;
import javax.servlet.RequestDispatcher;

@WebServlet("/servlet_display")
public class servlet_display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servlet_display() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		scoreDAO dao = new scoreDAO();
		ArrayList<scoreDTO> vec = new ArrayList<scoreDTO>();
		
		vec = dao.selectscore();	// selectMember()가 하는 일 -> ArrayList vec에 DTO변수의 값들을 입력한다.
		request.setAttribute("data1", vec);		// request는 사용자가 요청한 내용 // DAO에서 DB의 값들의 출력을 요청했다.
		// 여기서 바로 실행을 한 다음에 바로 view 페이지로 넘겨준다.
		
		ServletContext context = this.getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/jsp/result.jsp");
		// RequestDispatcher, 사용자의 요구를 발송(방출)
		dispatcher.forward(request, response);	// response는 사용자에게로 돌려보낼 놈
	}
}
