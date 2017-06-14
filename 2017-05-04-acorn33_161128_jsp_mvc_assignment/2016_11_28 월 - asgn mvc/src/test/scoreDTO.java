package test;
import java.io.Serializable;

public class scoreDTO implements Serializable{
	private int num;
	private String name;
	private String newname;

	private int kor;
	private int eng;
	private int math;
	private int tot;
	private float avg;
	
	public void setNum(int a) {this.num = a;}
	public int getNum() {return num;}
	
	public void setName(String b) {this.name = b;}
	public String getName() {return name;}
	
	public void setNewname(String aa) {this.newname = aa;}
	public String getNewname() {return newname;}
	
	public void setKor(int c) {this.kor = c;}
	public int getKor() {return kor;}
	
	public void setEng(int d) {this.eng = d;}
	public int getEng() {return eng;}
	
	public void setMath(int d) {this.math = d;}
	public int getMath() {return math;}
	
	public void setTot(int e) {this.tot = e;}
	public int getTot() {
		tot = kor + eng + math;
		return tot;
	}
	
	public void setAvg(float avg) {this.avg = avg;}
	public float getAvg() {
		avg = (float)((int)(tot / 3f * 100) / 100f);
		return avg;
	}

}