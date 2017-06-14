package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import test.BoardDTO;

import javax.naming.*;
import java.sql.*;
import javax.sql.*;
public class BoardDAO {
	private Connection conn;
	
	/**
	 * DB와의 접속을 위해 Connection 객체를 생성하는 생성자 메서드이다.
	 */
	public BoardDAO() {
				
		/*try {
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException ex) {}
		String url = "jdbc:mysql://localhost:3306/web_java";
		try {
			conn = DriverManager.getConnection(url, "root", "12345678");
		}catch(SQLException ex) {
			System.err.println("Create Error = " + ex.getMessage());
			ex.printStackTrace();
		}*/
		
		try{
			Context context = new InitialContext();
			DataSource source = (DataSource)context.lookup("java:comp/env/jdbc/myconn");
			conn = source.getConnection();
			System.out.println("연결완료");
		}catch(Exception e){

		}
	}
	
	/**
	 * useBean으로 생성된 객체가 매개변수로 전달되면 그 값들을 이용하여 
	 * DB에 저장하는 작업을 진행하는 메서드이다.
	 * 
	 * @param dto
	 * @return result
	 */
	public int registerMember(BoardDTO dto) {
		int result = 0;
		try {
			
			/*String query = "INSERT INTO BBS_CONTENT_TB VALUES (null, ?, ?, ?, now())";
			PreparedStatement pstmt = conn.prepareStatement(query);*/
			
			PreparedStatement pstmt = conn.prepareStatement("insert into bbs values(null, ?, ?, ?, now())");
			pstmt.setString(1, dto.getContent_title());
			pstmt.setString(2, dto.getContent_writer());
			pstmt.setString(3, dto.getContent_contents());
			result = pstmt.executeUpdate();
			pstmt.close();
		}catch(SQLException ex) {
			System.err.println("Register Error = " + ex.getMessage());
			ex.printStackTrace();
			return -1;
		}
		return result;
	}
	
	/**
	 * List 페이지에서 출력될 데이터를 이 메서드를 이용하여 획득한다.
	 * 결과값을 ArrayList의 Type이고 페이징 처리 없이 전체 값을 획득한다.
	 * 
	 * @return list
	 */
	public ArrayList<BoardDTO> getBoardList() {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			String query = "SELECT * FROM bbs";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setContent_num(rs.getInt(1));//content_num값 획득
				dto.setContent_title(rs.getString(2));//content_title값 획득
				dto.setContent_writer(rs.getString(3));//content_writer값 획득
				dto.setContent_contents(rs.getString(4));//content_contents값 획득
				dto.setContent_regdate(rs.getTimestamp(5));//content_regdate값 획득
				list.add(dto);
			}
			rs.close();
			stmt.close();
		}catch(SQLException ex) {
			System.err.println("getList Error = " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		return list;
	}
}
