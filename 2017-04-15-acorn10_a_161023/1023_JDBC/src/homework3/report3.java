package homework3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

class action{
	
	static void input() {
		
	}
	
	static void display() {
		String query = "select * from sungjuk2";	//쿼리 작성		
		try {
			report3.getconn();			
			Statement stmt = report3.getconn().createStatement();	// 쿼리를 보낼 수 있도록 도와주는 객체 생성
			ResultSet rs = stmt.executeQuery(query);	// 쿼리 날리기 
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" : "+rs.getInt(2));
			}
			rs.close();
			stmt.close();
			report3.getconn().close();
		}catch(SQLException ee){
			System.out.println("error = "+ee.toString());
		}
	} // method display()
	
	static void delete() {		
		String query = "DELETE FROM sungjuk2 WHERE name=?";
		String name = JOptionPane.showInputDialog("삭제할 레코드의 이름을 입력하세요.");
		
		try {
			PreparedStatement pstmt = report3.getconn().prepareStatement(query);			
			pstmt.setString(1,name);
			pstmt.executeUpdate();
			System.out.println("삭제 성공");			
			report3.menu();
		}catch(SQLException ee) {
			System.out.println(ee.toString());
		}
	} // method delete()
	
	static void modify() {
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

	
} //class action
/////////////////////////////////////////// main class start
public class report3 {

	String input_name = "";
	private static String url = "jdbc:mysql://localhost:3306/TESTDB?autoReconnect=true&useSSL=false";
	private static String id = "root";
	private static String pass = "123";
	private static Connection conn = null;
	
	static Connection connect(String url, String id, String pass) throws SQLException {
		conn = DriverManager.getConnection(url, id, pass);
		return conn;
	}

	static Connection getconn() throws SQLException{
		if (conn != null) return conn;
		return connect(url, id, pass); 										
	}

	static void menu() {
		String menu = JOptionPane.showInputDialog("메뉴 선택\n숫자를 입력하세요\n 1(입력) 2(출력) 3(삭제) 4(수정) 5(종료)");
		if(menu != null) {
				if(menu.equals("1")) { action.input(); }
				else if(menu.equals("2")) { action.display(); }
				else if(menu.equals("3")) { action.delete(); }
				else if(menu.equals("4")) { action.modify(); }
				else if(menu.equals("5")) {
					System.out.println("종료");
					System.exit(0);
				}
				else menu();
		}
		else if(menu == null) { menu(); }
	} // menu()

	public static void main(String[] args) {	
		try {
			Class.forName("org.gjt.mm.mysql.Driver");	// 드라이버 확인
		}catch(ClassNotFoundException e) {
			System.exit(0);
		}
		
		action.display();
		/*while(true) {
			report3.menu();
			if(new report3().input_name == null) break;
		}*/
	} // main method
	
} //main class

