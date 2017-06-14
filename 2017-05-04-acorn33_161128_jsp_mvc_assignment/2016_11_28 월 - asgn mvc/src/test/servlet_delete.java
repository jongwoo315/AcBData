package test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet_delete")
public class servlet_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servlet_delete() { super(); }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		
		scoreDTO dto = new scoreDTO();
		dto.setName(name);
		
		scoreDAO dao = new scoreDAO();
		boolean bool = dao.deletemem(dto);
		
		if(bool){
			response.sendRedirect("./Success.html");	// response는 사용자에게로 돌려보낼 놈
		}
	}
}