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

@WebServlet("/servletContextTest2")
public class servletContextTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletContextTest2() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		String intro = (String)context.getAttribute("intro");			//이전에 작업했던 servletContextTest.java에서 선언된 intro를 가져오라는 의미
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("서버의 인사말 = "+ intro);
		out.println("</body></html>");
	}


}
