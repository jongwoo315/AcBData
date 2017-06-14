package test;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 06_get_method_servlet.html

/**
 * Servlet implementation class HelloForm1
 */
@WebServlet("/HelloForm1")
public class HelloForm1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /*** @see HttpServlet#HttpServlet() */
    public HelloForm1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/*** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		String title = "Using GET Method to Read Form Data";
		//String docType ="<!doctype html public \"-//w3c//dtd html 4.0" + "transitional//en\">\n";
		String docType ="<!doctype html public   \"-//w3c//dtd html 4.0 transitional//en\"   >\n";	// 역슬래쉬 뒤의 내용은 사용하기 위해서 있음
		out.println(docType+
				"<html>\n"+
					"<head><title>"+title+"</title></head>\n"+
				
					"<body bgcolor=\"#f0f0f0\">\n"+
						"<h1 align=\"center\">"+title+"</h1>\n"+
						"<ul>\n"+
							"<li><b>name</b>:"+request.getParameter("first_name")+"\n"+
							"<li><b>address</b>:"+request.getParameter("address")+"\n"+
						"</ul>\n"+
					"</body>"+
				"</html>"
		);
	}

	/*** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
