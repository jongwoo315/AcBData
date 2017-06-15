package abc;

//import java.util.Comparable;	//오류 발생
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import javax.swing.JOptionPane;

class student implements Comparator<student>, Comparable<student>{
	String name;
	int ban, no, kor, mat, eng, total;
	student(){}
	student(String a, int b, int c, int d, int e, int f, int g){
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
	
	public int compareTo(student std1) { return name.compareTo(std1.name); }
	public int compare(student std1, student std2) { return std1.total - std2.total; }	
}

public class a03_score_1 {
	public static void main(String[] args) {
		//처음에 student의 정보를 넣기 위해 ArrayList를 사용한다
		ArrayList<student> arl = new ArrayList<student>();
		//추가를 한다
		//arl.add(student); 매개변수에 클래스를 넣으려면..
		//ArrayList를 클래스로 받아야 한다 <>가 클래스가 필요(없어도 상관없으나 좋은 코딩이 아님)
		arl.add(new student("zzz1",1,1,100,80,71,54));
		arl.add(new student("aaa2",1,1,99,80,71,54));
		arl.add(new student("ooo3",1,1,98,80,71,54));
		arl.add(new student("mmm4",1,97,23,80,71,54));
		arl.add(new student("ddd5",1,1,96,80,71,54));
		//추가를 했으면 출력 -> Iterator가 필요
/*		Iterator it = arl.iterator();	
		while(it.hasNext()){		// <- 이걸 지나면서 리스트의 끝까지 갔으므로 다시 처음으로 불러야함
			Object obj = it.next();
			System.out.println(obj);
		}*/
	/*	System.out.println();
		//System.out.println(arl);
		student prac1 = new student();	//student class에서 빈 생성자가 없으면 이런식으로 초기화 불가
		prac1.disp();		//이걸 실행해도 null값만 나옴	//s
		System.out.println();*/
		
		//정렬
		Collections.sort(arl);
		//정렬하고 출력은? compareTo로?
		//compareTo(std1) // 객체선언+객체초기화를 하지 않았으므로 사용불가
		//객체초기화를 사용하지 않는 방법은 반복문 내에서 객체선언을 하는 것
/*		for(student st : arl) { 
			System.out.println(st.toString());
			System.out.println(st.getkor());
			int a = st.getkor();
			System.out.println(a);
		}
		System.out.println();*/
		//추가 //add메서드?
		//
/*		String input1 = JOptionPane.showInputDialog("추가할 내용 입력");
		int input2 = Integer.parseInt(JOptionPane.showInputDialog("추가할 내용 입력"));
		int  input3 = Integer.parseInt(JOptionPane.showInputDialog("추가할 내용 입력"));
		int input4 = Integer.parseInt(JOptionPane.showInputDialog("추가할 내용 입력"));
		int input5 = Integer.parseInt(JOptionPane.showInputDialog("추가할 내용 입력"));
		int input6 = Integer.parseInt(JOptionPane.showInputDialog("추가할 내용 입력"));
		int input7 = Integer.parseInt(JOptionPane.showInputDialog("추가할 내용 입력"));
		arl.add(new student(input1,input2,input3,input4,input5,input6,input7));	//student에 매개변수가 하나인 생성자를 만든다?
		//만약 student의 생성자 중에서 매개변수가 하나인 것이 있으면 arl.add(new student(input1)); 가능 
		*/
		ListIterator<student> lit = arl.listIterator();
		Object obj = null;
		while(lit.hasNext()) {
			obj = lit.next();
			System.out.println(obj);
		}
		System.out.println("dddddddddddddddddddddddddddddd");
		//삭제
		lit = arl.listIterator();
		//String input8 = JOptionPane.showInputDialog("삭제할 정보(이름)입력");
		//확인 메세지 출력하기
		student ss = new student();
/*		for(student ss : arl) {	// arl가 student의 멤버정보(5명분의 정보)를 순차적으로 읽어라
			 //arl.get(ss.getkor());	// get메서드는 int형으로 전환불가 // student 클래스에 변수를 리턴받는 메서드를 따로 생성할 것
						if(input8.equals(arl)) //arl에 입력된 정보를 하나씩 읽는 것 가능? 
				arl.remove(new Student());
			if(ss.getname().equals("aaa2")) {
				lit.remove();
				//arl.remove(ss);	//student 클래스의 객체를 지우면 안된다. 
				//arl.remove(lit);
			}
		}*/
		
/*		while(lit.hasNext()) {
			obj = lit.next();
			if(obj.equals(ss.getname())) lit.remove(); 
		}*///안되는 거	지워지지 않음
		
		lit = arl.listIterator();
		while(lit.hasNext()) {
			obj = lit.next();
			System.out.println(obj);
		}
	}
}
//정렬, 삽입, 삭제, 편집
//메인에서 해보고, 클래스를 추가해서 해볼 것

/*	class action{
 * 		
 * 		삽입
 * 		삭제
 * 		편집
 * 		정렬
 * }
 *  
 */

