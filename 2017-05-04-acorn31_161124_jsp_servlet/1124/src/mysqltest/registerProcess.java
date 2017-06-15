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
		String addr = request.getParameter("addr");		// html에서 입력한 값을 가져오는 과정
		
		MemberDTO dto = new MemberDTO();
		dto.setName(name);
		dto.setTel(tel);
		dto.setAddr(addr);		// 가져온 값을 DTO변수 값들에 저장하는 과정(set)
		
		MemberDAO dao = new MemberDAO();
		// 성공여부 확인
		boolean bool = dao.registerMember(dto); // registerMember메서드가 하는 일 -> registerProcess.java에서 set으로 저장한 값들을 get으로 가져온 후,  DB query에 저장한다.
		
		// 출력하기
		//ArrayList<MemberDTO> bool2 = dao.selectMember();
		//System.out.println(bool2);
		//dao.selectMember();
		if(bool){
			response.sendRedirect("./Success.html"); // response는 사용자에게로 돌려보낼 놈 
		}
	}

}
