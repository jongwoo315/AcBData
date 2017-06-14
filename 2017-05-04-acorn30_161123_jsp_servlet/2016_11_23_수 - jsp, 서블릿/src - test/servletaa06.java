package test;
import java.io.PrintWriter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class servletaa06
 * http://localhost:8080/acorn_jsp/servletaa06 로 호출할 것
 */
@WebServlet("/servletaa06")
public class servletaa06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletaa06() {
        super();
        message = "Hello world";
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<h2>"+message+"</h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
