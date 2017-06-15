package homework2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

class action{
/*	
	static void delete() {
		//init();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
						
		try {
			conn = DriverManager.getConnection(url, id, pass);
			System.out.println("연결되었습니다.");
		}catch(SQLException ee) {
			System.out.println("연결 객체 생성 실패!");
		}
		
		
		
		String query = "DELETE FROM sungjuk2 WHERE name=?";
		String name = JOptionPane.showInputDialog("삭제할 레코드의 이름을 입력하세요.");
		try {
			pstmt = conn.prepareStatement(query);			
		}catch(SQLException ee) {
			System.out.println(ee.toString());
		}
		try {
			pstmt.setString(1,name);
			pstmt.executeUpdate();
			System.out.println("!!!");
			report1.menu();
			System.out.println("실행성공");			
		}catch(SQLException ee) {
			System.out.println("query 실행 클래스 생성 에러");
		}
	}*/
	
	static void modify() {
		//init();
		String query1 = "update sungjuk2 set schoolno='%d' where name='%s'";
		String query2 = "update sungjuk2 set no='%d' where name='%s'";
		String query3 = "update sungjuk2 set gender='%s' where name='%s'";
		String query4 = "update sungjuk2 set kor='%d' where name='%s'";
		String query5 = "update sungjuk2 set eng='%d' where name='%s'";
		String query6 = "update sungjuk2 set math='%d' where name='%s'";
		String query7 = "update sungjuk2 set total='%d' where name='%s'";
		String query8 = "update sungjuk2 set avr='%d' where name='%s'";
		// 특정 행에 속하는 특정 컬럼의 값을 지울 수 있도록
	}

	static void test() {
		/*try {
			//conn = DriverManager.getConnection(url, id, pass);
			report1.getconn1();
			System.out.println("연결되었습니다.");
		}catch(SQLException ee) {
			System.out.println("연결 객체 생성 실패!");
		}*/
		Connection ca = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from sungjuk2";	//쿼리 작성		
		try {
			//conn = DriverManager.getConnection(url, id, pass);	// 서버 연결
			//Statement stmt = conn.createStatement();	// 쿼리를 보낼 수 있도록 도와주는 객체 생성

			ca = report2.getconn();
			
			stmt = ca.createStatement();	// 쿼리를 보낼 수 있도록 도와주는 객체 생성
			rs = stmt.executeQuery(query);	// 쿼리 날리기 
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" : "+rs.getInt(2));
			}
			rs.close();
			stmt.close();
			report2.getconn().close();
		}catch(SQLException ee){
			System.out.println("error = "+ee.toString());
		}
	}
	
}
/////////////////////////////////////////// main class start
public class report2 {
	String input_name = "";
	static String url = "jdbc:mysql://localhost:3306/TESTDB?autoReconnect=true&useSSL=false";
	static String id = "root";
	static String pass = "123";
	static Connection conn = null;

	public static void main(String[] args) {	
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");	// 드라이버 확인
		}catch(ClassNotFoundException e) {
			System.exit(0);
		}
		
		action.test();
		/*while(true) {
			report1.menu();
			if(new report1().input_name == null) break;
		}*/
	}
	
	static Connection getconn(String url, String id, String pass) throws SQLException {
		conn = DriverManager.getConnection(url, id, pass);
		return conn;
	}

	static Connection getconn() throws SQLException{
		return conn;	
	}	//nullpointer가 났던 것 
	
/*	static Connection getconn() throws SQLException{
		if (conn != null) return conn;
		return getconn(url, id, pass);	// return conn을 하게 되면 다른 클래스에서 getconn()을 사용하면 getnull이 나오게 된다.
 										//http://stackoverflow.com/questions/21813084/exception-in-thread-main-java-lang-nullpointerexception-while-fetching-value-fro
	}*/	//고쳐서 정상 처리되는 
	


	static void menu() {
		String menu = JOptionPane.showInputDialog("메뉴 선택\n숫자를 입력하세요\n1(입력) 2(출력) 3(삭제) 4(수정) 5(종료)");
		if(menu != null) {
				//if(menu.equals("1")) { input(); }
				//else if(menu.equals("2")) { display(); }
				//if(menu.equals("3")) { action.delete(); }
				if(menu.equals("4")) { action.modify(); }
				else if(menu.equals("5")) {
					System.out.println("종료");
					System.exit(0);
				}
				else menu();
		}
		else if(menu == null) { menu(); }
	}

}	//main class

