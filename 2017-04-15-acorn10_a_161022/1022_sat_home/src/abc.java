public class abc {
    public static void main(String[] args) {
        try {
            //Class.forName("org.gjt.mm.mysql.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("드라이버 정상설치");
        }catch(ClassNotFoundException ee){
            System.out.println("드라이버 없당~");
        }
    }
}