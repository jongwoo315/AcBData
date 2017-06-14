package test;

import javax.sql.*;
import javax.naming.*;
import java.sql.*;


public class VisitorBean {
	private String name, content;
	private Connection conn;
	
	public VisitorBean(){
		try{
			Context context = new InitialContext();
			DataSource source = (DataSource)context.lookup("java:comp/env/jdbc/myconn");
			conn = source.getConnection();
		}catch(Exception e){	
		}
	}

	public void setName(String name) {this.name = name;}
	public void setContent(String content) {this.content = content;}
	
	public String getResult(){
		try{
			PreparedStatement pstmt = conn.prepareStatement("insert into abc values(?, ?, ?)");
			pstmt.setString(1, name);
			pstmt.setString(2, content);
			pstmt.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
			conn.close();
			return "<h4>"+name+"님의 글이 완료되었습니다.!! (BEAN 방식)</h4>";
		}catch(SQLException e){
			System.out.println("DB 연동 오류 발생:"+e);
			return "<h4>시스템 장애로 처리가 불가능합니다.</h4>";
		}
	}
}
