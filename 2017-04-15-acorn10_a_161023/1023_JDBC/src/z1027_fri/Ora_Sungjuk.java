package z1027_fri;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**���, �Է� 
 * ����, ������ �Է¿��� ���� ������� �ϸ� �� */
class InsertTest{
	Scanner sc;
	public InsertTest(){
		sc = new Scanner(System.in);
	}
	
	public void add(){

		System.out.print("�б���ȣ(10,20) : ");
		int school = sc.nextInt();
		
		System.out.print("��ȣ : ");
		int no = sc.nextInt();

		System.out.println("�̸� :");
		String name = sc.next();
		
		System.out.print("����(M,F) : ");
		String gender = sc.next();

		System.out.print("�������� : ");
		int kor = sc.nextInt();
		
		System.out.print("�������� : ");
		int eng = sc.nextInt();

		System.out.print("�������� : ");
		int math = sc.nextInt();
		int total = kor + eng + math;
		double avr = total / 3;
		
		String user = "SCOTT";
		String password = "TIGER";
		String url = "jdbc:oracle:thin:@localhost:1521:acorn";
		String driver = "oracle:jdbc:driver.OracleDriver";
		Connection con = null;
		Statement st = null;
		int result = 0;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e){
			System.out.println("����̹� ����");
			e.printStackTrace();
		}
		
		try{
			con = DriverManager.getConnection(url, user, password);
		}catch (SQLException e){
			System.out.println("���ӹ���");
			e.printStackTrace();
		}
		//String sql = "insert into sungjuk2(schoolno, no, name, gender, kor, eng, math, total, avr) values("+school+","+no+", '"+name+"', '"+gender+"',"+kor+","+eng+","+math+","+total+","+avr+")";
		String sql = "insert into sungjuk2(schoolno, no, name, gender, kor, eng, math, total, avr) values("+school+","+no+","+"'"+name+"'"+","+"'"+gender+"'"+","+kor+","+eng+","+math+","+total+","+avr+")";
		//�����ذ�: �ܷ�Ű�� ����� �� ���̺��� �ִ�(sql���� ���̺� ������ ������ ������.). �ٵ� �ڹٷ� ���� ��ɾ �������ϸ� ������
		//�߻��Ѵ�.
		//����: �ܷ�Ű�� ����� ���̺��� null���� ������ �ֱ� �����̴�. �ܷ�Ű�� ����� ���̺�(���⿡���� school_table2)��
		//(SQL���� �����ϴ� ��) ���� �Է��ϰ� ���� ��ɾ �ٽ� �Է��ϸ� �ȴ�.
		
		System.out.println(sql);
		
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
		
		try{
			st.close();
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	} // method add
} // class add



public class Ora_Sungjuk {
	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		it.add();
	}
}