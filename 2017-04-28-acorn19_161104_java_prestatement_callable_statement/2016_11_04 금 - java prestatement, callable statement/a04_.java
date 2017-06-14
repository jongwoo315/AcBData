package a1104_fri;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class a04_ {
	public static void main(String[] args) {
		try{
			Connection con = null;
			StringBuffer sql = new StringBuffer("insert into emp(empno, ename) values(?,?)");
			PreparedStatement psmt = con.prepareStatement(sql.toString());
			psmt.setInt(1, 901);
			psmt.setString(2, "회견");
			psmt.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		try{
			Connection con = null;
			StringBuffer sql = new StringBuffer("insert into emp(empno, ename) values(?,?)");
			PreparedStatement psmt = con.prepareStatement(sql.toString());
			Integer[] a_empno = new Integer[] {111,112,113,114,115};
			String[] a_ename = new String[]{"새마을", "잘살기", "성공", "노력", "밤샘"};
				for(int i = 0; i < 5; i++){
					psmt.setInt(1, a_empno[i]);
					psmt.setString(2, a_ename[i]);
					psmt.executeUpdate();
					psmt.clearParameters();
				}			
		}catch(Exception e){
			System.out.println(e);
		}
		
		try{			
			Connection con = null;
			StringBuffer sql = new StringBuffer("insert into emp(empno, ename) values(?,?)");
			PreparedStatement psmt = con.prepareStatement(sql.toString());
			Integer[] a_empno = new Integer[] {111,112,113,114,115};
			String[] a_ename = new String[]{"새마을", "잘살기", "성공", "노력", "밤샘"};
			for(int i = 0; i < 5; i++){
				psmt.setInt(1, a_empno[i]);
				psmt.setString(2, a_ename[i]);
				psmt.addBatch();
				psmt.clearParameters();
			}
			psmt.executeBatch();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
