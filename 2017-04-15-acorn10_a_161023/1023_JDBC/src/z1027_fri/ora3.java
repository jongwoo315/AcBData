package z1027_fri;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.lang.Class;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

class insertTest{
	static void add(){
		String user = "SCOTT";
		String password = "TIGER";
		String url = "jdbc:oracle:thin:@localhost:1521:acorn";
		Connection con = null;
		try{
			con = DriverManager.getConnection(url, user, password);
		}catch (SQLException e){ e.printStackTrace(); }
		
		
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
////////////////////////////////////////// ���Ӱ��� ////////////////////////////////
		int result = 0;
		String sql = "insert into sungjuk2(schoolno, no, name, gender, kor, eng, math, total, avr) values("+school+","+no+","+"'"+name+"'"+","+"'"+gender+"'"+","+kor+","+eng+","+math+","+total+","+avr+")";
		System.out.println(sql);
		Statement st = null;
		try{
			st = con.createStatement();
			result = st.executeUpdate(sql);
		} catch(SQLException e){ e.printStackTrace(); }
			
		if(result > 0){ System.out.println("��� ����"); } 
		else{ System.out.println("��� ����"); }
		init_and_menu.menu();
	}
}

class printdata {	
	 static void print(){

		String user = "SCOTT";
		String password = "TIGER";
		String url = "jdbc:oracle:thin:@localhost:1521:acorn";
		Connection con = null;
		try{
			con = DriverManager.getConnection(url, user, password);
		}catch (SQLException e){ e.printStackTrace(); }		

/*		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}*/ //��� �Ǳ� ��
		
		ResultSet rs = null;
		String query = "select * from sungjuk2"; //emp�ڿ� ;�� ������ ������ �߻��Ѵ�
		Statement stmt = null;
		try{
			stmt = con.createStatement();			
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
				con.close();
			} catch(SQLException e){}
		
		  init_and_menu.menu();
		  }	
	}
}

class delete{
	static void eliminate(){
		String user = "SCOTT";
		String password = "TIGER";
		String url = "jdbc:oracle:thin:@localhost:1521:acorn";
		Connection con = null;
		try{
			con = DriverManager.getConnection(url, user, password);
		}catch (SQLException e){ e.printStackTrace(); }		
		
		//��ü �� ����
	}
}

class modify{
	static void edit(){
		//Ư�� ���� Ư�� ������ ����
	}
}

class init_and_menu{
	public void init(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �̻�");
		} catch(ClassNotFoundException e){
			  System.out.println("����̹� ����");
			  e.printStackTrace();
		}
	}
	
	static void menu(){
		String menu = JOptionPane.showInputDialog("�޴� ����\n���ڸ� �Է��ϼ���\n1(�Է�) 2(���) 3(����) 4(����) 5(����)");
		Statement stmt = null;
		if(menu != null) {
				if(menu.equals("1")) { insertTest.add(); }
				else if(menu.equals("2")) { printdata.print(); }
				else if(menu.equals("3")) { delete.eliminate(); }
				else if(menu.equals("4")) { modify.edit(); }
				else if(menu.equals("5")) {
					System.out.println("����");
					System.exit(0);
				}
				else menu();
		}
		else if(menu == null) { menu(); }
	}
}

public class ora3 {
	public static void main(String[] args) {
		init_and_menu iam = new init_and_menu();
		iam.init();
		iam.menu();
	}
}
/**
 * (���� + �޴�) - �Է�, ����, ���, ����, ����
 * ������ �ڵ�, �޴��� �ߵ���
 * ���� Ŭ������ ���� ����� �޴��� ���� �޼��忡 ����ǵ���
 * 
 * �޴�	 
 */