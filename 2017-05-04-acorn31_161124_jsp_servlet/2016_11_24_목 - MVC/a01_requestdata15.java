package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

/* http://localhost:8080/1124_thu/a01_requestdata15로 호출 (eclipse안이라서 가능한 것) */
@WebServlet("/a01_requestdata15")
public class a01_requestdata15 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public a01_requestdata15() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html; charset=euc-kr");
		
		String data1 = new String("java!");
		Vector<String> data2 = new Vector<String>();
		
		data2.add("c");
		data2.add("c++");
		
		request.setAttribute("data1", data1);
		request.setAttribute("data2", data2);
		
		ServletContext context = this.getServletContext(); 		// get은 application 역할을 한다.
		RequestDispatcher dispatcher = context.getRequestDispatcher("/a02_requestdata_ppp?data3=string&data4=ok");		// 넘아갈 주소
		//RequestDispatcher dispatcher = context.getRequestDispatcher("/test?data3=string&data4=ok");		// 넘아갈 주소
		dispatcher.forward(request, response);
	}

}
