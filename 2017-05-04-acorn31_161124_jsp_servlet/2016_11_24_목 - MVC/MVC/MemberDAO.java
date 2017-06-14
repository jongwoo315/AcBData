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
			throw new ServletException("접속 오류!");
		}
	}
	
	public boolean registerMember(MemberDTO dto) throws ServletException{
		String query = "insert into addresstable values (NULL, ?, ?, ?)";
		try{
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTel());
			pstmt.setString(3, dto.getAddr());
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
			ResultSet rs = pstmt.executeQuery(query);
			while(rs.next()){
				MemberDTO mt = new MemberDTO();
				mt.setNum(rs.getInt("id"));
				mt.setName(rs.getString("name"));
				mt.setTel(rs.getString("Tel"));
				mt.setAddr(rs.getString("Address"));
				vec.add(mt);
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
	
	private void close(){
		try{
			if(conn != null && !conn.isClosed()) conn.close();
		}catch(SQLException ex) { conn = null; }
	}
	
}
