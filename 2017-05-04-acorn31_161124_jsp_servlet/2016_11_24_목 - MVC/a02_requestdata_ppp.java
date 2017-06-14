package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;



@WebServlet("/a02_requestdata_ppp")
public class a02_requestdata_ppp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public a02_requestdata_ppp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String data1 = (String)request.getAttribute("data1");
		Vector data2 = (Vector)request.getAttribute("data2");
		
		String data3 = request.getParameter("data3");
		String data4 = request.getParameter("data4");
		
		response.setContentType("text/html; charset=euc-kr");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("data1= "+data1+"<br/>");
		out.println("data2= ");
		for(int i = 0; i < data2.size(); ++i){
			out.println(data2.get(i)+"&nbsp;&nbsp;");
		}
		out.println("<br/>");
		out.println("data3= "+data3+"<br/>");
		out.println("data4= "+data4+"<br/>");
		
		out.println("</body>");
		out.println("</html>");
		
	}

}
