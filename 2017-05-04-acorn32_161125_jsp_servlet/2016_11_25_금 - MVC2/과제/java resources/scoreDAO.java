package doit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;

import java.sql.ResultSet;
import java.util.ArrayList;


public class scoreDAO {
	private Connection conn;
	
	public scoreDAO() throws ServletException{
		try{
			Class.forName("org.mariadb.jdbc.Driver");
		}catch(ClassNotFoundException ex){
			throw new ServletException("드라이버 오류!");
		}
		
		String url = "jdbc:mariadb://localhost:3306/acorn";
		String id = "root";
		String pw = "123";
		
		try{
			conn = DriverManager.getConnection(url, id, pw);
		}catch(SQLException ex){
			throw new ServletException("연결 오류!");
		}
	}
	
	public boolean inputscore(scoreDTO dto) throws ServletException{
		String query = "INSERT INTO score_card VALUES(NULL, ?, ?, ?, ?)";
		try{
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getKor());
			pstmt.setString(3, dto.getEng());
			pstmt.setString(4, dto.getMath());
		}catch(SQLException ex){
			throw new ServletException("입력 실패!");
		}finally{
			this.close();
		}
		
		return true;
	}
	
	private void close(){
		try{
			if(conn != null && !conn.isClosed()){
				conn.close();
			}
		}catch(SQLException ex){
			conn = null;
		}
	}
}
