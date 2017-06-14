package DBCP;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;


@WebServlet("/dhcplet")
public class dbcplet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public dbcplet() { super(); }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body><center><h3>");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into my_data values(null, ?, ?)";
		
		try{
			Context context = new InitialContext();
			DataSource source = (DataSource)context.lookup("java:comp/env/jdbc/myconn"); // web.xml에서 리턴받기로 설정한 값
			conn = source.getConnection();
		}catch(Exception e){
			out.println("접속오류!!!!!!");
			out.println();
		}
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, age);
			
			int res = pstmt.executeUpdate();
			if(res > 0){out.println("저장성공");}
			pstmt.close();
			conn.close();			
		}catch(Exception e){
			out.print("SQL Process Error: "+e.getMessage());
		}
		
		out.println("</h3></center></body></html>");
				
	}

}
