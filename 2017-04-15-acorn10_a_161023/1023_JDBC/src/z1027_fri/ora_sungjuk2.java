/*package ora2;

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.lang.Class;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
*//**출력, 입력 
 * 삭제, 수정은 입력에서 쓰는 방식으로 하면 됨 *//*
class InsertTest{
	static void add(){
		Scanner sc = new Scanner(System.in);
		System.out.print("학교번호(10,20) : ");
		int school = sc.nextInt();
		System.out.print("번호 : ");
		int no = sc.nextInt();
		System.out.println("이름 :");
		String name = sc.next();
		System.out.print("성별(m,f) : ");
		String gender = sc.next();
		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
		System.out.print("영어점수 : ");
		int eng = sc.nextInt();
		System.out.print("수학점수 : ");
		int math = sc.nextInt();
		int total = kor + eng + math;
		double avr = total / 3d;
		///////////////////////////////////
		Connection con = null;
		int result = 0;
// 접속 과정 시작				
//접속 과정 끝
		String sql = "insert into sungjuk2(schoolno, no, name, gender, kor, eng, math, total, avr) values("+school+","+no+","+"'"+name+"'"+","+"'"+gender+"'"+","+kor+","+eng+","+math+","+total+","+avr+")";
		System.out.println(sql);
		Statement st = null;	//입력된 값을 DB에 update시키는 것
//업로드 시키는 과정
		try{
			st = con.createStatement();
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		try{
			result = st.executeUpdate(sql);
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		if(result > 0){
			System.out.println("등록 성공");
		} else{
			System.out.println("등록 실패");
		}
		
	}//메서드	
}//insertest 끝

/// 업로드 시키는 과정 끝
		try{
			st.close();
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
// 접속 종료
	
////////////////////////////////////////////////////////////////////////////////////////////////////
class printdata{
	static void choolruk(){
		String url = "jdbc:oracle:thin:@localhost:1521:acorn";
		String user = "SCOTT";
		String pass = "TIGER";
		
		Connection conn =null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from sungjuk2"; //emp뒤에 ;이 있으면 오류가 발생한다
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		try{
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("학교 : 번호 : 이름 : 성별 : 국어점수 : 영어점수 : 수학점수: 총점 : 평균");
			while(rs.next()){
				int school = rs.getInt(1);
				int no = rs.getInt(2);
				String name = rs.getString(3);
				String gender = rs.getString(4);
				int kor = rs.getInt(5);
				int eng = rs.getInt(6);
				int math = rs.getInt(7);
				int total = kor + eng + math;
				total = rs.getInt(8);			
				double avr = total / 3;
				avr = rs.getDouble(9);
				System.out.println(school+"  : "+no+"  : "+name+" : "+gender+"   :   "+kor+"   :   "+eng+"   :   "+math+"   : "+total+" : "+avr);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			try{
				rs.close();
				stmt.close();
				conn.close();
			} catch(SQLException e){
				
			}
		}
	}
} // printdata 메뉴 끝

class delete{
	static void eliminate(){
		
	}
 //delete 메뉴 끝


 // modify 메뉴 끝


class init_and_menu{
	
	void menu(){
		String menu = JOptionPane.showInputDialog("메뉴 선택\n숫자를 입력하세요\n1(입력) 2(출력) 3(삭제) 4(수정) 5(종료)");
		if(menu != null) {
				if(menu.equals("1")) { InsertTest.add(); }
				else if(menu.equals("2")) { printdata.choolruk(); }
				else if(menu.equals("3")) { delete.eliminate(); }
				//else if(menu.equals("4")) { modify.edit(); }
				else if(menu.equals("5")) {
					System.out.println("종료");
					System.exit(0);
				}
				else menu();
		}
		else if(menu == null) { menu(); }
	}
	
	public void init(){

		String user = "SCOTT";
		String password = "TIGER";
		String url = "jdbc:oracle:thin:@localhost:1521:acorn";
		String driver = "oracle:jdbc:driver.OracleDriver";
		Connection con = null;	// !!!!!!!
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 이상무");
		} catch(ClassNotFoundException e){
			  System.out.println("드라이버 문제");
			  e.printStackTrace();
		}

		try{
			con = DriverManager.getConnection(url, user, password);
			System.out.println("접속성공");
		}catch (SQLException e){
		  System.out.println("접속문제");
		  e.printStackTrace();
		}
	}

} //class init_and menu 끝

public class ora_sungjuk2 {
	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		it.add();
		printdata pd = new printdata();
		pd.choolruk();
		
		//InsertTest it = new InsertTest();
		init_and_menu iam = new init_and_menu();
		iam.init();
		iam.menu();
		*//**
		 * (접속 + 메뉴) - 입력, 수정, 출력, 삭제, 종료
		 * 접속은 자동, 메뉴가 뜨도록
		 * 종료 클래스를 따로 만들어 메뉴의 종료 메서드에 연결되도록		 
		 *//*
	}
}

//A클래스의 a메서드를 B클래스의 b메서드에서 사용하고 싶으면, a메서드를 static void a() 로 선언하면 된다. */