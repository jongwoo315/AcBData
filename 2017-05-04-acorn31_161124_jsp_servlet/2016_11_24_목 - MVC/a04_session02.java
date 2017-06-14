package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.util.*;//Calendar 클래스 사용을 위해...
import java.text.*;//SimpleDateFormat 클래스 사용을 위해...

@WebServlet("/a04_session02")
public class a04_session02 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	//forward에 의한 이동이므로 Get방식 메서드 호출
		
		String data1 = (String)request.getAttribute("data1");
		//request scope에 data1이라는 이름으로 설정된 데이터 추출
		
		HttpSession session = request.getSession();
		//request 객체로 부터 session 객체 획득
			String data2 = (String)session.getAttribute("data2");
			//session scope에 data2라는 이름으로 설정된 데이터 추출
			Calendar data3 = (Calendar)session.getAttribute("data3");
			//session scope에 data3이라는 이름으로 설정된 데이터 추출
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//날짜 출력을 위한 format 클래스 객체 생성
		String data4 = format.format(data3.getTime());
		//날짜 출력을 위한 format 변환
		
		response.setContentType("text/html;charset=euc-kr");		
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		out.println("data1 = " + data1 + "<br/>");
		out.println("data2 = " + data2 + "<br/>");
		out.println("data3 = " + data4 + "<br/><br/>");
		//각 데이터 출력
		
		out.println("<a href='a05_session03'>다음페이지로</a>");
		//다음 페이지로 이동하여 request scope의 데이터는 더 이상 존재하지 않는다는 것을 확인
		//session scope의 데이터는 웹 페이지가 사라질 때 까지 존재...
		
		out.println("</body></html>");
	}
}
