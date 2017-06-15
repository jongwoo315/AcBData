package yeul_heul_round27;

public class p932 {
	public static void main(String[] args) {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("드라이버 정상설치");
		}catch(ClassNotFoundException ee){
			System.out.println("드라이버 없당~");
		}
	}
}
