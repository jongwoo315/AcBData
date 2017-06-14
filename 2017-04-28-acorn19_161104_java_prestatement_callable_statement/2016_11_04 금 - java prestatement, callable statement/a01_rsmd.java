package a1104_fri;
import java.sql.*;

public class a01_rsmd {
	public static void main(String[] args) {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:acorn","SCOTT","TIGER");
			PreparedStatement ps = con.prepareStatement("select * from emp");
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			System.out.println("total columns: "+rsmd.getColumnCount());
			System.out.println("column nmae of 1st column: "+rsmd.getColumnName(1));
			System.out.println("column type name of 1st column: "+rsmd.getColumnTypeName(1));
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
