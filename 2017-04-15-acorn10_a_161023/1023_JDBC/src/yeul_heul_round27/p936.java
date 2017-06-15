package yeul_heul_round27;
import java.sql.*;

public class p936 {
	public static void main(String[] args) {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("드라이버 있음");
		}catch(ClassNotFoundException ee) {
			System.out.println(ee.toString());
		}
		
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/TESTDB?autoReconnect=true&useSSL=false";
		String user = "root";
		String pass = "123";
		try {
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("연결되었습니다.");
		}catch(SQLException ee) {
			System.out.println("연결 객체 생성 실패!");
		}
		
		String query = "select * from sungjuk2;";
		Statement stmt = null;
		
		String pquery = "insert into sungjuk2 values (?, ?, null, null, null, null, null, null, null)";
		PreparedStatement pstmt = null;
		
		try {
			stmt = conn.createStatement();
			//pstmt = conn.prepareStatement(pquery);
			//pstmt.setInt(1, 10);
			//pstmt.executeUpdate();
			System.out.println("실행성공");
			
		}catch(SQLException ee) {
			System.out.println("query 실행 클래스 생성 에러");
		}
		
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				int num = rs.getInt(1);
				int name = rs.getInt(2);
				System.out.println(num+" : "+name);
			}
/*			rs = pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt(1);
				String name = rs.getString(2);
				System.out.println(num+" : "+name);
			}
*/			
		}catch(SQLException ee) {
			System.out.println("실행결과 획득 실패");
		}
		
		try {
			rs.close();
			pstmt.close();
			stmt.close();
			if(conn != null) {
				if(!conn.isClosed()) {
					conn.close();					
				}
				conn = null;
			}
		}catch(SQLException ee) {
			System.out.println("닫기 실패");
		}
	}
}
