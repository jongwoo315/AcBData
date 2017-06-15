package homework3_1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

class init{

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
	
} // class init

class action{
	
	static void input() {
		String query = "insert into sungjuk2 values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			//init.getconn();
			PreparedStatement pstmt = init.getconn().prepareStatement(query);
			int schoolno = Integer.parseInt(JOptionPane.showInputDialog("학교번호 입력"));
			if(schoolno != 10 && schoolno !=20) {
				System.out.println("학교번호는 10 혹은 20만 입력될 수 있습니다. 다시 입력하세요.");
				input();
			}
			pstmt.setInt(1, schoolno);
			int no = Integer.parseInt(JOptionPane.showInputDialog("학생번호 입력"));
			pstmt.setInt(2, no);
			String name = JOptionPane.showInputDialog("이름 입력");
			pstmt.setString(3, name);
			String gender = JOptionPane.showInputDialog("성별 입력");
			if(gender.matches("m|f")) {
				pstmt.setString(4, gender);
			}
			else {
				System.out.println("성별은 m 혹은 f만 입력가능합니다. 처음부터 다시 입력하세요.");
				input();								
			}
			int kor = Integer.parseInt(JOptionPane.showInputDialog("국어점수 입력"));
			pstmt.setInt(5, kor);
			int eng = Integer.parseInt(JOptionPane.showInputDialog("영어점수 입력"));
			pstmt.setInt(6, eng);
			int math = Integer.parseInt(JOptionPane.showInputDialog("수학점수 입력"));
			pstmt.setInt(7, math);
			int total = kor + eng + math;
			pstmt.setInt(8, total);
			float avr = (int)(total / 3f * 100) / 100f;
			pstmt.setFloat(9, avr);
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println(name+"학생의 정보 입력 성공");
			report3.menu();
		}catch(SQLException ee) {
			System.out.println(ee.toString());
		}
	} // method input()
	
	static void display() {
		String query = "select * from sungjuk2";	
		try {
			//init.getconn();			
			Statement stmt = init.getconn().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" : "+rs.getInt(2)+" : "+rs.getString(3)+" : "+rs.getString(4)+" : "+rs.getInt(5)+" : "+rs.getInt(6)+" : "+rs.getInt(7)+" : "+rs.getInt(8)+" : "+rs.getFloat(9));
			}
			System.out.println();
			rs.close();
			stmt.close();
			//init.getconn().close();	//DB와 연결을 아예 끊어버리겠다는 명령어 따라서. 이걸 쓰면 다음 명령어를 쓸 수 가 없다.
			report3.menu();
		}catch(SQLException ee){
			System.out.println("error = "+ee.toString());
		}
	} // method display()
	
	static void delete() {		
		String query = "DELETE FROM sungjuk2 WHERE name=?";
		String name = JOptionPane.showInputDialog("삭제할 레코드의 이름을 입력하세요.");
		
		try {
			//init.getconn();
			PreparedStatement pstmt = init.getconn().prepareStatement(query);			
			pstmt.setString(1,name);
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println(name+"학생의 정보 삭제 성공");			
			//init.getconn().close();	//이 명령어가 없으면 오류가 발생한다.
			report3.menu();
		}catch(SQLException ee) {
			System.out.println(ee.toString());
		}
	} // method delete()
	
	static void modify() {
		
		String edit_schoolno = "update sungjuk2 set schoolno=? where name=?";
		String edit_no = "update sungjuk2 set no=? where name=?";
		String edit_gender = "update sungjuk2 set gender=? where name=?";
		String edit_kor = "update sungjuk2 set kor=? where name=?";
		String edit_eng = "update sungjuk2 set eng=? where name=?";
		String edit_math = "update sungjuk2 set math=? where name=?";

		try {
			init.getconn();
			String name = JOptionPane.showInputDialog("수정할 학생의 이름 입력");
			String infotochange = JOptionPane.showInputDialog("수정할 정보의 종류 입력 (아래의 정보 중 수정하고 싶은 정보를 입력하세요)\n 학교번호 / 학생번호 / 성 / 국어점수 / 영어점수 / 수학점수");
			if(infotochange.equals("학교번호")) {
				PreparedStatement pstmt = init.getconn().prepareStatement(edit_schoolno);
				int schoolno = Integer.parseInt(JOptionPane.showInputDialog("새로운 학교 번호 입력"));
				pstmt.setInt(1,schoolno);
				pstmt.setString(2, name);
				pstmt.executeUpdate();
				pstmt.close();
				System.out.println(name+"학생의 새로운 학교 번호 입력 완료" );
			}
			else if(infotochange.equals("학생번호")){
				PreparedStatement pstmt = init.getconn().prepareStatement(edit_no);
				int no = Integer.parseInt(JOptionPane.showInputDialog("새로운 학생 번호 입력"));
				pstmt.setInt(1, no);
				pstmt.setString(2,name);
				pstmt.executeUpdate();
				pstmt.close();
				System.out.println(name+"학생의 새로운 학생 번호  입력 완료" );
			}
			else if(infotochange.equals("성")){
				PreparedStatement pstmt = init.getconn().prepareStatement(edit_gender);
				String gender = JOptionPane.showInputDialog("새로운 성 입력");
				pstmt.setString(1, gender);
				pstmt.setString(2,name);
				pstmt.executeUpdate();
				pstmt.close();
				System.out.println(name+"학생의 새로운 성 입력 완료" );
			}
			else if(infotochange.equals("국어점수")){
				PreparedStatement pstmt = init.getconn().prepareStatement(edit_kor);
				int kor = Integer.parseInt(JOptionPane.showInputDialog("새로운 국어점수 입력"));
				pstmt.setInt(1, kor);
				pstmt.setString(2,name);
				pstmt.executeUpdate();
				pstmt.close();
				System.out.println(name+"학생의 새로운 국어 점수 입력 완료" );
			}
			else if(infotochange.equals("영어점수")){
				PreparedStatement pstmt = init.getconn().prepareStatement(edit_eng);
				int eng = Integer.parseInt(JOptionPane.showInputDialog("새로운 영어점수 입력"));
				pstmt.setInt(1, eng);
				pstmt.setString(2,name);
				pstmt.executeUpdate();
				pstmt.close();
				System.out.println(name+"학생의 새로운 영어 점수 입력 완료" );
			}
			else if(infotochange.equals("수학점수")){
				PreparedStatement pstmt = init.getconn().prepareStatement(edit_math);
				int math = Integer.parseInt(JOptionPane.showInputDialog("새로운 수학점수 입력"));
				pstmt.setInt(1, math);
				pstmt.setString(2,name);
				pstmt.executeUpdate();
				pstmt.close();
				System.out.println(name+"학생의 새로운 수학 점수 입력 완료" );
			}
			report3.menu();	//이렇게만 적어놓으면 오류가 발생한다.
		}catch(SQLException ee) {
			System.out.println(ee.toString());
		}
	} //method modift()

} //class action

public class report3 {

	static void menu() {
		try{
			init.getconn();
		}catch(SQLException e) {
			System.out.println(e.toString());
		}

		String menu = JOptionPane.showInputDialog("메뉴 선택\n숫자를 입력하세요\n 1(입력) 2(출력) 3(삭제) 4(수정) 5(종료)");
		if(menu != null) {
				if(menu.equals("1")) { action.input(); }
				else if(menu.equals("2")) { action.display(); }
				else if(menu.equals("3")) { action.delete(); }
				else if(menu.equals("4")) { action.modify(); }
				else if(menu.equals("5")) {
					try {
						init.getconn().close();						
						System.out.println("종료");
						System.exit(0);
					}catch(SQLException ee) {
						System.out.println("닫기 실패");
					}
				}
				else menu();
		}
		else if(menu == null) { menu(); }
	} // menu()

	public static void main(String[] args) {	
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException e) {
			System.exit(0);
		}
		
		boolean flag = true;
		while(flag) {
			report3.menu();
			if(!flag) break;
		}
	} // main method
	
} //main class
