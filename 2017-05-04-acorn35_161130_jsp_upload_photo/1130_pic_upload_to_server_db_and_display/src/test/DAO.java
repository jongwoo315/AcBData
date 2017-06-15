package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.sql.DataSource;

import java.util.ArrayList;

public class DAO {
	
	private Connection conn;
	
	public boolean register(DTO dto) throws ServletException{
		//response.setContentType("text/html; charset=utf-8");
		//PrintWriter out = response.getWriter();
		//out.println("<html><body><center><h3>");
		
		//Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into upload values(?, ?, ?, ?, ?)";
		
		try{
			Context context = new InitialContext();
			DataSource source = (DataSource)context.lookup("java:comp/env/jdbc/MySql"); // web.xml에서 리턴받기로 설정한 값
			conn = source.getConnection();
		}catch(Exception e){
			//out.println("접속오류!!!!!!");
			//out.println();
			throw new ServletException("접속 오류!");
			
		}
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPw());
			pstmt.setString(4, dto.getFilename());
			pstmt.setString(5, dto.getUrl());
			
			int res = pstmt.executeUpdate();
			//if(res > 0){out.println("저장성공");}
			pstmt.close();
			//conn.close();		// connection을 닫으면 안된다.		
		}catch(Exception e){
			//out.print("SQL Process Error: "+e.getMessage());
		}
		//out.println("</h3></center></body></html>");
		
		return true;
	}
	
	public ArrayList<DTO> select() throws ServletException{
		
		ArrayList<DTO> vec = new ArrayList<DTO>();
		
		//Connection conn = null;
		String query = "select * from upload";
		
		try{		// 접속이 매번 필요하다. 안 그러면 nullpointer 오류 발생
			Context context = new InitialContext();
			DataSource source = (DataSource)context.lookup("java:comp/env/jdbc/MySql"); // web.xml에서 리턴받기로 설정한 값
			conn = source.getConnection();
		}catch(Exception e){
			throw new ServletException("접속 오류!");
		}
		
		try{
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);
			while(rs.next()){		// db에서 가져오므로, dto에 저장을 해야한다. (db의 값을 빼서 dto에 올린다)
				DTO dto = new DTO();
				dto.setName(rs.getString("name"));	// db상에 저장된 컬럼명과 일치해야함
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setFilename(rs.getString("filename"));
				dto.setUrl(rs.getString("dir"));
				vec.add(dto);
			}
			rs.close();
			conn.close();
		}catch(SQLException e){
			throw new ServletException("쿼리 가져오기 실패!");
		}finally{
			this.close();
		}
		
		return vec;
	} // select() method
	
	public void close(){
		//Connection conn = null;
		try{
			if(conn != null && !conn.isClosed()) conn.close();
		}catch(SQLException e){
			conn = null;
		}
	}
}
