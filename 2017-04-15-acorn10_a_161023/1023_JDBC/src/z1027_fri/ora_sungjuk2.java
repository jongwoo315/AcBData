/*package ora2;

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.lang.Class;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
*//**���, �Է� 
 * ����, ������ �Է¿��� ���� ������� �ϸ� �� *//*
class InsertTest{
	static void add(){
		Scanner sc = new Scanner(System.in);
		System.out.print("�б���ȣ(10,20) : ");
		int school = sc.nextInt();
		System.out.print("��ȣ : ");
		int no = sc.nextInt();
		System.out.println("�̸� :");
		String name = sc.next();
		System.out.print("����(m,f) : ");
		String gender = sc.next();
		System.out.print("�������� : ");
		int kor = sc.nextInt();
		System.out.print("�������� : ");
		int eng = sc.nextInt();
		System.out.print("�������� : ");
		int math = sc.nextInt();
		int total = kor + eng + math;
		double avr = total / 3d;
		///////////////////////////////////
		Connection con = null;
		int result = 0;
// ���� ���� ����				
//���� ���� ��
		String sql = "insert into sungjuk2(schoolno, no, name, gender, kor, eng, math, total, avr) values("+school+","+no+","+"'"+name+"'"+","+"'"+gender+"'"+","+kor+","+eng+","+math+","+total+","+avr+")";
		System.out.println(sql);
		Statement st = null;	//�Էµ� ���� DB�� update��Ű�� ��
//���ε� ��Ű�� ����
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
			System.out.println("��� ����");
		} else{
			System.out.println("��� ����");
		}
		
	}//�޼���	
}//insertest ��

/// ���ε� ��Ű�� ���� ��
		try{
			st.close();
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
// ���� ����
	
////////////////////////////////////////////////////////////////////////////////////////////////////
class printdata{
	static void choolruk(){
		String url = "jdbc:oracle:thin:@localhost:1521:acorn";
		String user = "SCOTT";
		String pass = "TIGER";
		
		Connection conn =null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from sungjuk2"; //emp�ڿ� ;�� ������ ������ �߻��Ѵ�
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		try{
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("�б� : ��ȣ : �̸� : ���� : �������� : �������� : ��������: ���� : ���");
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
} // printdata �޴� ��

class delete{
	static void eliminate(){
		
	}
 //delete �޴� ��


 // modify �޴� ��


class init_and_menu{
	
	void menu(){
		String menu = JOptionPane.showInputDialog("�޴� ����\n���ڸ� �Է��ϼ���\n1(�Է�) 2(���) 3(����) 4(����) 5(����)");
		if(menu != null) {
				if(menu.equals("1")) { InsertTest.add(); }
				else if(menu.equals("2")) { printdata.choolruk(); }
				else if(menu.equals("3")) { delete.eliminate(); }
				//else if(menu.equals("4")) { modify.edit(); }
				else if(menu.equals("5")) {
					System.out.println("����");
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
			System.out.println("����̹� �̻�");
		} catch(ClassNotFoundException e){
			  System.out.println("����̹� ����");
			  e.printStackTrace();
		}

		try{
			con = DriverManager.getConnection(url, user, password);
			System.out.println("���Ӽ���");
		}catch (SQLException e){
		  System.out.println("���ӹ���");
		  e.printStackTrace();
		}
	}

} //class init_and menu ��

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
		 * (���� + �޴�) - �Է�, ����, ���, ����, ����
		 * ������ �ڵ�, �޴��� �ߵ���
		 * ���� Ŭ������ ���� ����� �޴��� ���� �޼��忡 ����ǵ���		 
		 *//*
	}
}

//AŬ������ a�޼��带 BŬ������ b�޼��忡�� ����ϰ� ������, a�޼��带 static void a() �� �����ϸ� �ȴ�. */