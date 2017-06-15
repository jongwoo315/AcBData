package mysqltest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;

public class MemberDAO {
	
	private Connection conn;
	
	public MemberDAO() throws ServletException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("org.gjt.mm.mysql.Driver");	
		}catch(ClassNotFoundException ex){
			throw new ServletException("드라이버 오류!, 드라이버를 찾지 못함");
		}
		
		String url = "jdbc:mysql://localhost:3306/acorn?autoReconnect=true&useSSL=false";
		String id = "root";
		String pw = "123";
		try{
			conn = DriverManager.getConnection(url, id, pw);
		}catch(SQLException ex){
			throw new ServletException("접속 오류!");
		}
	}
	
	public boolean registerMember(MemberDTO dto) throws ServletException{
		String query = "insert into addresstable values (NULL, ?, ?, ?)";
		try{
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTel());
			pstmt.setString(3, dto.getAddr());		// registerProcess.java에서 set으로 저장한 값들을 DB query에 저장한다.
			pstmt.executeUpdate();
			pstmt.close();
			
		}catch(SQLException ex){
			throw new ServletException("등록 실패!");
		}finally{
			this.close();
		}
		return true;
	}
	
	public ArrayList<MemberDTO> selectMember() throws ServletException{
		ArrayList<MemberDTO> vec = new ArrayList<MemberDTO>();
		String query = "select * from addresstable";
		try{
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);	// ResultSet 객체에 쿼리의 내용이 담겨져 있다.
			while(rs.next()){
				
				MemberDTO mt = new MemberDTO();
				
				mt.setNum(rs.getInt("num"));		// DB의 변수명과 정확히 일치해야 한다.
				mt.setName(rs.getString("name"));
				mt.setTel(rs.getString("tel"));
				mt.setAddr(rs.getString("addr"));	// ResultSet의 인스턴스 rs에서 가져온 값들을  DTO변수들의 값으로 설정한다.
				vec.add(mt);	// ArrayList vec에 DTO변수의 값들을 입력한다.
			}
			rs.close();
			pstmt.close();
		}catch(SQLException ex){
			throw new ServletException("등록 실패!");
		}finally{
			this.close();
		}
		return vec;
	}

	public boolean deletemem(MemberDTO dto) throws ServletException{
		String query = "DELETE FROM addresstable WHERE name=?";
		try{
			PreparedStatement pstmt = conn.prepareStatement(query);
			//MemberDTO aaa = new MemberDTO();
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
	
	private void close(){
		try{
			if(conn != null && !conn.isClosed()) conn.close();
		}catch(SQLException ex) { conn = null; }
	}
}