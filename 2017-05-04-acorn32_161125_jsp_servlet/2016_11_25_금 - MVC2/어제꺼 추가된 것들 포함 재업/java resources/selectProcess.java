// controller

package mysqltest;

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

@WebServlet("/selectProcess")
public class selectProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public selectProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> vec = new ArrayList<MemberDTO>();
		vec = dao.selectMember();
		request.setAttribute("data1", vec);
		//request.setAttribute(arg0, arg1);
		// 여기서 바로 실행을 한 다음ㅇ에 바로 view 페이지로 넘겨준다.
		
		ServletContext context = this.getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/jsp/aaa.jsp");
		dispatcher.forward(request, response);
	}
}
