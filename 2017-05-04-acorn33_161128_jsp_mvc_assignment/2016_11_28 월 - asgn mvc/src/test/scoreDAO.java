package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import java.sql.Statement;

public class scoreDAO {
	
	private Connection conn;

	public scoreDAO() throws ServletException{
		try{
			//Class.forName("com.mysql.jdbc.Driver");		// 이걸로 접속함
			//Class.forName("org.gjt.mm.mysql.Driver");
			Class.forName("org.mariadb.jdbc.Driver");
		}catch(ClassNotFoundException ex){
			throw new ServletException("드라이버 오류!, 드라이버를 찾지 못함");
		}
		
		/*String url = "jdbc:mysql://localhost:3306/acorn?autoReconnect=true&useSSL=false";*/
		String url = "jdbc:mariadb://localhost:3306/acorn";
		String id = "root";
		String pw = "123";
		try{
			conn = DriverManager.getConnection(url, id, pw);
		}catch(SQLException ex){
			throw new ServletException("접속 오류!");
		}
	}
	
	public boolean inputscore(scoreDTO dto) throws ServletException{
		String query = "insert into scoretable2 values (NULL, ?, ?, ?, ?, ?, ?)";
		try{
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getKor());
			pstmt.setInt(3, dto.getEng());		// registerProcess.java에서 set으로 저장한 값들을 DB query에 저장한다.
			pstmt.setInt(4, dto.getMath());
			pstmt.setInt(5, dto.getTot());
			pstmt.setFloat(6, dto.getAvg());	// dto에서 get으로 선언된 값들을 db에 넣는다.
			pstmt.executeUpdate();
			pstmt.close();
			
		}catch(SQLException ex){
			throw new ServletException("등록 실패!");
		}finally{
			this.close();
		}
		return true;
	}
	
	public ArrayList<scoreDTO> selectscore() throws ServletException{
		ArrayList<scoreDTO> vec = new ArrayList<scoreDTO>();
		String query = "select * from scoretable2";
		try{
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);	// ResultSet 객체에 쿼리의 내용이 담겨져 있다.
			//Statement stmt = conn.createStatement();
			//ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){		
				scoreDTO mt = new scoreDTO();
				
				mt.setNum(rs.getInt("num"));		// DB의 변수명과 정확히 일치해야 한다.
				mt.setName(rs.getString("name"));
				mt.setKor(rs.getInt("kor"));
				mt.setEng(rs.getInt("eng"));	// ResultSet의 인스턴스 rs에서 가져온 값들을  DTO변수들의 값으로 설정한다.
				mt.setMath(rs.getInt("math"));
				mt.setTot(rs.getInt("tot"));
				mt.setAvg(rs.getFloat("avge"));
				vec.add(mt);	// ArrayList vec에 DTO변수의 값들을 입력한다.
			}
			rs.close();
			pstmt.close();
			//stmt.close();
		}catch(SQLException ex){
			throw new ServletException("등록 실패!");
		}finally{
			this.close();
		}
		return vec;
	}

	public boolean deletemem(scoreDTO dto) throws ServletException{
		String query = "DELETE FROM scoretable2 WHERE name=?";
		try{
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,dto.getName());
			pstmt.executeUpdate();
			pstmt.close();
			
		}catch(SQLException ex){
			throw new ServletException("delete 삭제 실패!");
		}finally{
			this.close();
		}
		return true;
	}
	
	public boolean editscore1(scoreDTO dto) throws ServletException{			
		try{				
			String edit_name = "update scoretable2 set name=? where name=?";
			try(PreparedStatement pstmt1 = conn.prepareStatement(edit_name)) {
				pstmt1.setString(1, dto.getNewname());
				pstmt1.setString(2, dto.getName());
				pstmt1.executeUpdate();
				pstmt1.close();
			}
		}catch(SQLException ex){
			throw new ServletException("등록 실패!");
		}finally{
			this.close();
		}
		return true;
	}
	
	public boolean editscore2(scoreDTO dto) throws ServletException{			
		try{				
			String edit_kor = "update scoretable2 set kor=? where name=?";
			try(PreparedStatement pstmt2 = conn.prepareStatement(edit_kor)){
				pstmt2.setInt(1, dto.getKor());
				pstmt2.setString(2, dto.getName());
				pstmt2.executeUpdate();
				pstmt2.close();				
			}
		}catch(SQLException ex){
			throw new ServletException("등록 실패!");
		}finally{
			this.close();
		}
		return true;
	}
	
	public boolean editscore3(scoreDTO dto) throws ServletException{			
		String edit_eng = "update scoretable2 set eng=? where name=?";
		try{				
			PreparedStatement pstmt3 = conn.prepareStatement(edit_eng);
			pstmt3.setInt(1, dto.getEng());
			pstmt3.setString(2, dto.getName());
			pstmt3.executeUpdate();
			pstmt3.close();				
		}catch(SQLException ex){
			throw new ServletException("등록 실패!, dasfsdaf");
		}finally{
			this.close();
		}
		return true;
	}

	public boolean editscore4(scoreDTO dto) throws ServletException{			
		try{				
			String edit_math = "update scoretable2 set math=? where name=?";
			try(PreparedStatement pstmt4 = conn.prepareStatement(edit_math)){
				pstmt4.setInt(1, dto.getMath());
				pstmt4.setString(2, dto.getName());
				pstmt4.executeUpdate();
				pstmt4.close();
			}
		}catch(SQLException ex){
			throw new ServletException("등록 실패!");
		}finally{
			this.close();
		}
		return true;
	}

	
	private void close(){
		try{
			if(conn != null && !conn.isClosed()) conn.close();
		}catch(SQLException ex) { conn = null; }
	}
}