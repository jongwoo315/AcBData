package test;
// 08_post_regi.html
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;

@WebServlet("/s_05_asgn")
public class s_05_asgn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public s_05_asgn() {
        super();

    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		Enumeration names = request.getParameterNames();	// html에 name으로 선언한 것들을 모두 받아온다
		
		while(names.hasMoreElements()){
			String name = (String)names.nextElement();
			String value = request.getParameter(name);
			out.println(name+" : "+value);
		}
		
	}

}
