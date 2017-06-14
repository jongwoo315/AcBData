package a1104_fri;
import java.sql.*;

public class a06_funcsum {
	public static void main(String[] args) {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:acorn","SCOTT","TIGER");
			CallableStatement stmt = con.prepareCall("{?= call sum4(?,?)}"); //����Ŭ���� function�� ���� �����ؾ� �Ѵ�
			
			stmt.setInt(2, 10);
			stmt.setInt(3, 43);
			stmt.registerOutParameter(1, Types.INTEGER);
			stmt.execute();
			System.out.println(stmt.getInt(1));
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
}
