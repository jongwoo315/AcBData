package test;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import sun.rmi.server.Dispatcher;
import javax.servlet.RequestDispatcher;
import java.util.ArrayList;

@WebServlet("/servlet_display")
public class servlet_display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servlet_display() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 자료를 가져오는 것
		request.setCharacterEncoding("UTF-8");		// request = 사용자가 요청한다!
		
		DAO dao = new DAO();
		//DTO dto = new DTO();
		ArrayList<DTO> vec = new ArrayList<DTO>();
		vec = dao.select();
		request.setAttribute("aaa", vec);
		
		ServletContext context = this.getServletContext();		// ServletContext = get configuration info from .xml
		RequestDispatcher dispatch = context.getRequestDispatcher("/jsp/display.jsp");	
		dispatch.forward(request, response); 		// response = 서버가 응답한다!
	}

}
