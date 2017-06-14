package model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletContext;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servletContextTest")
public class servletContextTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletContextTest() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String intro = "안녕하세요! 우리 서버에 오신것을 환영합니다.";
		
		ServletContext context = this.getServletContext();
		context.setAttribute("intro", intro);	//  출력하라는 이야기
		response.setContentType("text/htm; charset=utf-8");
		PrintWriter out = response.getWriter();
		//out.println("<html><body>");
		out.println(intro);
		out.println("ServletContext 데이터 통신 완료!");
		//out.println("</body></html>");
		
		// 교재 15라운드
	}

}


