package test;
// 07_post_method_servlet.html

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.Enumeration;

@WebServlet("/Post_test")
public class Post_test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Post_test() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		Enumeration names = request.getParameterNames();	// html에 name으로 선언한 것들을 모두 받아온다
		
		while(names.hasMoreElements()){
			String name11 = (String)names.nextElement();
			String value = request.getParameter(name11);
			out.println(name11+" : "+value);
		}
	}

}
