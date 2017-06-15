package mysqltest;
import java.io.Serializable;

public class MemberDTO implements Serializable{
	private int num;
	private String name;
	private String tel;
	private String addr;
	
	public void setNum(int num) {this.num = num;}
	public int getNum() {return num;}
	
	public void setName(String name) {this.name = name;}
	public String getName() {return name;}
	
	public void setTel(String tel) {this.tel = tel;}
	public String getTel() {return tel;}
	
	public void setAddr(String addr) {this.addr = addr;}
	public String getAddr() {return addr;}
}
