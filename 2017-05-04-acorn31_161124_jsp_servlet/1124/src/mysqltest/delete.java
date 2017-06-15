package mysqltest;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public delete() { super(); }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		
		MemberDTO dto = new MemberDTO();
		dto.setName(name);
		
		MemberDAO dao = new MemberDAO();
		// 성공여부 확인
		boolean bool = dao.deletemem(dto);
		
		// 출력하기
		//ArrayList<MemberDTO> bool2 = dao.selectMember();
		//System.out.println(bool2);
		//dao.selectMember();
		if(bool){
			//response.sendRedirect("/jsp/print_dblist.jsp");
			response.sendRedirect("./Success.html");	// response는 사용자에게로 돌려보낼 놈
		}
	}

}
