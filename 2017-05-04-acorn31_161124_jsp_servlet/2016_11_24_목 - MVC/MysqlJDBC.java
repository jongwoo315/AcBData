package mysqltest;
import java.sql.*;
import java.util.*;

public class MysqlJDBC {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		try {
			Class cls = Class.forName("com.maridb.jdbc.Driver");
			cls.newInstance();
		}catch(ClassNotFoundException e) {
		}catch (InstantiationException e) {
		}catch (IllegalAccessException e) {}
	//////////////////////////////////////////////////////////////////////////////////////////////////
		Connection conn = null;
		String query = "";

		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	//////////////////////////////////////////////////////////////////////////////////////////////////		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/acorn", "root", "123");
			query = "drop table my_data";
			stmt = conn.createStatement();
			stmt.execute(query);//기존에 my_data라는 테이블이 있으면 삭제한다.
			stmt.close();
		}catch(SQLException e) {}
	//////////////////////////////////////////////////////////////////////////////////////////////////
		try {
			query = "create table my_data(num int primary key auto_increment, name varchar(20) not null, age int)";
			stmt = conn.createStatement();
			stmt.execute(query);//my_data라는 테이블을 생성한다.
			//필드로는 자동증가 번호로 관리되는 num과 
			//이름을 저장할 name, 나이를 저장할 age로 구성된다.
			stmt.close();			
		}catch(SQLException e) {}
	//////////////////////////////////////////////////////////////////////////////////////////////////	
		up: while(true) {
			System.out.print("1.데이터추가 2.전체출력 3.종료 = ");
			int dist = in.nextInt();
			in.nextLine(); //엔터키 처리
			switch(dist) {
				////////////////////////////////////////////////////////////////////////
				case 1:		// 데이터 추가
					System.out.print("이름 = ");
					String name = in.nextLine();
					System.out.print("나이 = ");
					int age = in.nextInt();
					in.nextLine();
					query = "insert into my_data values (null, ?, ?)";
					try {
						pstmt = conn.prepareStatement(query);
						pstmt.setString(1, name);//첫번째 ? 자리에 이름을 설정한다.
						pstmt.setInt(2, age);//두번째 ? 자리에 나이를 설정한다. 
						int res_int = pstmt.executeUpdate();//Query를 수행한다.
						if(res_int > 0) //Query가 성공적으로 실행되면 insert 된 개수가 리턴된다.
							//여기에서는 1이 리턴 된다.
							System.out.println("정상적으로 추가 되었습니다.");
						else
							System.out.println("추가에 실패 했습니다.");
						pstmt.close();
					}catch(SQLException e) {
						System.out.println("ERROR = " + e);
					}
					break;
				//////////////////////////////////////////////////////////////////////////	
				case 2:
					System.out.println("전체 정보 출력!");
					query = "select * from my_data";
					try {
						stmt = conn.createStatement();
						rs = stmt.executeQuery(query);
						while(rs.next()) { //검색된 정보가 있는 동안 반복 수행한다.
							int num = rs.getInt("num"); //해당 RECORD의 번호 값을 가져온다.
							name = rs.getString("name"); //해당 RECORD의 이름 값을 가져온다.
							age = rs.getInt("age"); //해당 RECORD의 나이 값을 가져온다. 
							System.out.println(num + "번 : " + name + "(" + age + "세)");
						}
						rs.close();
						stmt.close();
					}catch(SQLException e) {
						System.out.println("ERROR = " + e);
					}
					break;
				//////////////////////////////////////////////////////////////////////////
				case 3:
					System.out.println("프로그램 종료!");
					break up;
				default: System.out.println("잘못 입력 하셨습니다.");
				} // switch문 종료
			System.out.println();
		} // while문 종료
		//////////////////////////////////////////////////////////////////////////
		
		try {
			if(conn != null && !conn.isClosed())
				//만약 conn 객체가 null이 아니고 닫혀있지 않다면 
				conn.close();//닫는다.
			conn = null;
		}catch(SQLException e) {}
		
	}
}
