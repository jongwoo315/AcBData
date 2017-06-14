package test1;

import javax.sql.*;
import org.apache.tomcat.jdbc.pool.DataSource;

import javax.naming.*;
import java.sql.*;

public class convert_score_to_grade {
	private String name;
	private String kor, eng, math;
	private Connection conn;
	PreparedStatement pstmt;
	
	public convert_score_to_grade(){
		try{
			Context context = new InitialContext();
			DataSource source = (DataSource)context.lookup("java:comp/env/jdbc/mycone");
			conn = source.getConnection();
			System.out.println("연결완료");
		}catch(Exception e){
			
		}
	}
	
	public void setName(String name) {this.name = name;}
	public void setKor(String kor) {this.kor = kor;}
	public void setEng(String eng) {this.eng = eng;}
	public void setMath(String math) {this.math = math;}
	
	public String kor_grade(String a){
		String c = "";
		int ab = Integer.parseInt(a);
		if (ab>= 90)  c="A";
		else if (ab>=80) c="B";
		else if (ab>=70) c="C";
		else if (ab>=60) c="D";
		else c="F";
		
		return c;
	}

	public String getResult(){
		try{
			pstmt = conn.prepareStatement("insert into score values(?, ?, ?, ?)");
			pstmt.setString(1, name);
			pstmt.setString(2, kor);
			pstmt.setString(3, eng);
			pstmt.setString(4, math);
			//pstmt.executeUpdate();
			conn.close();
			return name+" "+kor+" "+kor_grade(kor);			
		}catch (SQLException e){
			System.out.println("DB연동 오류 발생: "+e);
			return "<h4>처리 불가능</h4>";
		}
	}
	
}