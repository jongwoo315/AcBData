package abc;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import javax.swing.JOptionPane;
/*	class action{
* 		삽입
* 		삭제
* 		편집
* 		정렬
* }
*/
class student1 implements Comparator<student1>, Comparable<student1>{
	String name;
	int ban, no, kor, mat, eng, total;
	student1(){}
	student1(String a, int b, int c, int d, int e, int f, int g){
		this.name = a;
		this.ban = b;
		this.no= c;
		this.kor = d; this.mat = e; this.eng = f;
		total = kor + mat + eng;
	}
	
	public String getname() {
		return name;
	}
	public String toString() {
		return name + "\t" + ban + "\t" + no + "\t" + kor + "\t" +
				mat + "\t" + eng + "\t" + total + "\t";
	}
	
	public void disp() {
		System.out.println(toString());
	}
	
	public int compareTo(student1 std1) { return name.compareTo(std1.name); }
	public int compare(student1 std1, student1 std2) { return std1.total - std2.total; }	
}

public class a03_score_1_1 {
	public static void main(String[] args) {
		ArrayList<student1> arl = new ArrayList<student1>();
		arl.add(new student1("zzz1",1,16,100,80,71,54));
		arl.add(new student1("aaa2",2,14,99,80,71,54));
		arl.add(new student1("ooo3",3,12,98,80,71,54));
		arl.add(new student1("mm4",4,97,23,80,71,54));
		arl.add(new student1("ddd5",5,11,96,80,71,54));
//#################################################
		//정렬
		Collections.sort(arl);
		//정렬하고 출력은? compareTo로?
		//compareTo(std1) // 객체선언+객체초기화를 하지 않았으므로 사용불가
		//객체초기화를 사용하지 않는 방법은 반복문 내에서 객체선언을 하는 것
		System.out.println("정렬");
		for(student1 st : arl) { 
			//System.out.println(st.toString());
			//System.out.println(st.getname());		//바로출력
			String name_var = st.getname();
			System.out.println(name_var);			//각 행의 이름을 변수지정하여 출력
		}
		System.out.println();
//#################################################
		//추가
/*		String input1 = JOptionPane.showInputDialog("추가할 내용 입력");
		int input2 = Integer.parseInt(JOptionPane.showInputDialog("추가할 내용 입력"));
		int  input3 = Integer.parseInt(JOptionPane.showInputDialog("추가할 내용 입력"));
		int input4 = Integer.parseInt(JOptionPane.showInputDialog("추가할 내용 입력"));
		int input5 = Integer.parseInt(JOptionPane.showInputDialog("추가할 내용 입력"));
		int input6 = Integer.parseInt(JOptionPane.showInputDialog("추가할 내용 입력"));
		int input7 = Integer.parseInt(JOptionPane.showInputDialog("추가할 내용 입력"));
		arl.add(new student1(input1,input2,input3,input4,input5,input6,input7)); */		
		System.out.println("\n추가");
		Object obj = null;
		arl.add(new student1("dd",8,23,76,45,43,23));
		ListIterator<student1> lit = arl.listIterator();
		while(lit.hasNext()) {
			obj = lit.next();
			System.out.println(obj);
		}
//##################################################		
		//삭제
		//String input8 = JOptionPane.showInputDialog("삭제할 정보(이름)입력");		
		System.out.println("\n삭제");
		System.out.println(arl);
		
		arl.remove(0);
		System.out.println(arl);
		
		arl.remove(1);
		System.out.println(arl);
		
		
	}//class
}//main

