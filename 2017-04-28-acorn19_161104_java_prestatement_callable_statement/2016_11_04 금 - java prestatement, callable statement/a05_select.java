package a1104_fri;
import java.sql.*;

public class a05_select {
	public static void main(String[] args) {
		try{			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:acorn","SCOTT","TIGER");
			PreparedStatement psmt = con.prepareStatement("select * from emp where empno =?");
			psmt.setInt(1,7788);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
		try{			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:acorn","SCOTT","TIGER");
			PreparedStatement psmt = con.prepareStatement("update emp set ename=? where empno=?");
			psmt.setString(1,"°Ç°­");
			psmt.setInt(2, 101);
			int i = psmt.executeUpdate();
			System.out.println(i+"records updated");
		}catch(Exception e){
			System.out.println(e);
		}
		
		try{			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:acorn","SCOTT","TIGER");
			PreparedStatement psmt = con.prepareStatement("delete from emp where empno=?");
			psmt.setInt(1,101);
			
			int i = psmt.executeUpdate();
			System.out.println(i+"records deleted");
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
}
