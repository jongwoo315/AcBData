package a1104_fri;
import java.sql.*;

public class a03_aaa {
	
	public static void main(String[] args) {
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:acorn","SCOTT","TIGER");
			
			PreparedStatement stmt = con.prepareStatement("insert into Emp(empno, ename) values(?,?)");
			stmt.setInt(1, 101);
			stmt.setString(2, "ÀÚ¹Ù");
			int  i = stmt.executeUpdate();
			System.out.println(i+"records inserted");
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
		
	}//main method
}// main  class
