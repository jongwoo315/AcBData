package a1104_fri;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Date;
import oracle.jdbc.OracleTypes;

public class stored_procedure_callable_select {

	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:acorn";
	private static final String DB_USER = "SCOTT";
	private static final String DB_PASSWORD = "TIGER";

	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return dbConnection;
	}//getDBConnection 메서드

	private static void callStoredProcCURSORParameter() throws SQLException {

		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		String getempCursorSql = "{call getempCursor(?,?)}";

		try {
			dbConnection = getDBConnection();
			callableStatement = dbConnection.prepareCall(getempCursorSql);

			callableStatement.setInt(1, 20);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

			callableStatement.executeUpdate();

			rs = (ResultSet) callableStatement.getObject(2);

			while (rs.next()) {
				Integer EMPNO = rs.getInt("EMPNO");
				String ENAME = rs.getString("ENAME");
				String JOB = rs.getString("JOB");
				Integer MGR = rs.getInt("MGR");

				Date HIREDATE = rs.getDate("HIREDATE");
				Integer SAL = rs.getInt("SAL");
				Integer COMM = rs.getInt("COMM");
				Integer DEPTNO = rs.getInt("DEPTNO");

				System.out.println("empno : " + EMPNO);
				System.out.println("Ename : " + ENAME);
				System.out.println("JOB : " + JOB);
				System.out.println("NGR : " + MGR);
				System.out.println("Hiredate : " + HIREDATE);
				System.out.println("SAL : " + SAL);
				System.out.println("COMM : " + COMM);
				System.out.println("DEPTNO : " + DEPTNO);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (callableStatement != null) {
				callableStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}

	}//callStoredProcCURSORParameter 메서드

	public static void main(String[] args) {
		try {
			callStoredProcCURSORParameter();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}//main 메서드

}