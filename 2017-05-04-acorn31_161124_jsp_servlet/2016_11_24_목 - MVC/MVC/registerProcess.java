package mysqltest;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerProcess")
public class registerProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public registerProcess() { super(); }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		MemberDTO dto = new MemberDTO();
		dto.setName(name);
		dto.setTel(tel);
		dto.setAddr(addr);
		
		MemberDAO dao = new MemberDAO();

		// 성공여부 확인
		boolean bool = dao.registerMember(dto);
		
		// 출력하기
		//ArrayList<MemberDTO> bool2 = dao.selectMember();
		//System.out.println(bool2);
		//dao.selectMember();
		
		
		
		if(bool){
			response.sendRedirect("./Success.html");
		}
	}

}
