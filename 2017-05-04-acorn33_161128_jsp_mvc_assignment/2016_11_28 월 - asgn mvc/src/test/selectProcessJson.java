// controller

package test;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

@WebServlet("/selectProcessJson")
public class selectProcessJson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public selectProcessJson() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		scoreDAO dao = new scoreDAO();
		ArrayList<scoreDTO> vec = new ArrayList<scoreDTO>();
		
		vec = dao.selectscore();
		String json = new Gson().toJson(vec);
		
		request.setAttribute("data1", json);	// 사용자가 요청
		// 여기서 바로 실행을 한 다음ㅇ에 바로 view 페이지로 넘겨준다.
		response.setContentType("application/json; charset=UTF-8");	// 사용자에게 돌려줌
		response.getWriter().write(json);
		//response.sendRedirect("./export_as_json_format.html");
	}

	
}
