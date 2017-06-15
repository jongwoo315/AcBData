package homework1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

class action{
	static String url = "jdbc:mysql://localhost:3306/TESTDB?autoReconnect=true&useSSL=false";
	static String id = "root";
	static String pass = "123";
/*	static {		
				try {
			report1.getconn(report1.geturl(), report1.getid(), report1.getpass());		
		}catch(SQLException ee) {
			System.out.println(ee.toString());
		}
	}*/
	
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
	}
	
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
}

public class report1 {
	String input_name = "";
	static String url = "jdbc:mysql://localhost:3306/TESTDB?autoReconnect=true&useSSL=false";
	static String id = "root";
	static String pass = "123";
	
	static Connection conn = null;

	static {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");	// 드라이버 확인
		}catch(ClassNotFoundException e) {
			System.exit(0);
		}		
	}
	
	public static Connection getconn(String url, String id, String pass) throws SQLException {
		conn = DriverManager.getConnection(url, id, pass);
		return conn;
	}

	public static String geturl() {
		return url;
	}
	
	public static String getid() {
		return id;
	}
	
	public static String getpass() {
		return pass;
	}
	
	static void menu() {
		String menu = JOptionPane.showInputDialog("메뉴 선택\n숫자를 입력하세요\n1(입력) 2(출력) 3(삭제) 4(수정) 5(종료)");
		if(menu != null) {
				//if(menu.equals("1")) { input(); }
				//else if(menu.equals("2")) { display(); }
				if(menu.equals("3")) { action.delete(); }
				else if(menu.equals("4")) { action.modify(); }
				else if(menu.equals("5")) {
					System.out.println("종료");
					System.exit(0);
				}
				else menu();
		}
		else if(menu == null) { menu(); }
	}

	public static void main(String[] args) {	
		while(true) {
			report1.menu();
			if(new report1().input_name == null) break;
		}
	}

/*	boolean flag = false;
	void input(){
		while(!flag) {
			try {
				input_name = JOptionPane.showInputDialog("이름 입력을 입력하세요.");
				if(input_name == null) {
					System.out.println("이름을 입력하지 않았습니다. 정보를 처음부터 다시 입력하세요.");
					input();
				}
				ban_input = Integer.parseInt(JOptionPane.showInputDialog("반 입력을 입력하세요."));
				kor_input = Integer.parseInt(JOptionPane.showInputDialog("국어점수를 입력하세요."));
				eng_input = Integer.parseInt(JOptionPane.showInputDialog("영어점수를 입력하세요."));
				math_input = Integer.parseInt(JOptionPane.showInputDialog("수학점수를 입력하세요."));
				arr_student.add(new student(input_name, ban_input, kor_input, eng_input, math_input));
				menu();
			} catch(NumberFormatException e) {
				System.out.println("숫자가 아닙니다. 정보를 처음부터 다시 입력하세요.");
			}
		}
	}*/
}

