package yeul_heul_round27; import java.sql.*;

public class p934 {
	public static void main(String[] args) {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");	// 드라이버 확인
		}catch(ClassNotFoundException e) {
			System.exit(0);
		}
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/acorn?autoReconnect=true&useSSL=false";
		String id = "root";
		String pass = "123";
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from my_data";	//쿼리 작성		
		try {
			conn = DriverManager.getConnection(url, id, pass);	// 서버 연결
			stmt = conn.createStatement();	// 쿼리를 보낼 수 있도록 도와주는 객체 생성
			rs = stmt.executeQuery(query);	// 쿼리 날리기 
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" : "+rs.getString(2));
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException ee){
			System.out.println("error = "+ee.toString());
		}
	}
}
