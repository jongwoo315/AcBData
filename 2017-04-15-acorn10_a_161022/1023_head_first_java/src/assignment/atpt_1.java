package assignment;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

/**
 * 학생의 이름, 반, 번호, 국어점수, 영어점수, 수학점수 입력받기 + 합계점수까지
 * 추가 / 정렬 / 출력 / 삭제 / 수정 기능 추가
 **/
class student{
	String name;
	int ban;
	int kor_score;
	int eng_score;
	int math_score;
	int total;	//합계는 생성자에 들어가지 않는다. 매개변수로 넣는 것이 아니라 계산되어야할 
	student(String a, int b, int c, int d, int e) {
		name = a;
		ban = b;
		kor_score = c;
		eng_score = d;
		math_score = e;
		total = c + d + e;
	}
/*	student(){
		//name = aa;
	}*/	
	public String getname() { return name; }
	
	public void setname(String a) { name = a; }
	public void setban(int a) { ban = a; }
	public void setkor(int a) { kor_score = a; }
	public void seteng(int a) { eng_score = a; }
	public void setmath(int a) { math_score = a; }
	
	public String toString() {
		return name+" "+ban+" "+kor_score+" "+eng_score+" "+math_score+" "+total;
	}
}

class action{
	public void rearrange() {}
	public void display() {}
	public void delete() {}
	public void modify() {}
}

public class atpt_1 {
	ArrayList<student> arr_student = new ArrayList<student>();
	String input_name = "";
	int ban_input = 0; int kor_input = 0; int eng_input = 0; int math_input = 0;
	
	public static void main(String[] args) {
		atpt_1 atpt = new atpt_1();
		
		while(true) {
			atpt.menu();
			//atpt.input();
			//new atpt_1().input();	//이렇게 선언을 하면 input메서드 내에 있는 arraylist가 매번 초기화되어 값이 누적되지 않는다 
			//if(atpt.getname() == null) break;
			if(new atpt_1().input_name == null) break;
			//System.out.println(arr_student);
			//arr_student.add(new student(input_name, ban_input, kor_input, eng_input, math_input));
		}
	}
	
	void menu() {
		String menu = JOptionPane.showInputDialog("메뉴 선택\n숫자를 입력하세요\n1(입력) 2(출력) 3(정렬된 출력) 4(삭제) 5(탐색) 6(수정) 7(종료)");
		if(menu != null) {
			if(menu.equals("1")) { input(); }
			else if(menu.equals("2")) { display(); }	//출력 
			else if(menu.equals("3")) { rearrange_display(); }	//정렬 
			else if(menu.equals("4")) { deleteb(); }	//삭제 
			else if(menu.equals("5")) { search(); }		//검색 
			else if(menu.equals("6")) { modify(); } 	//수정
			else if(menu.equals("7")) {
				System.out.println("종료");
				System.exit(0);				
			}
		}
		else if(menu == null) {
			menu();
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////
	
	void input(){
		//System.out.println(arr_student);
		input_name = JOptionPane.showInputDialog("이름 입력");
		ban_input = Integer.parseInt(JOptionPane.showInputDialog("반 입력"));
		kor_input = Integer.parseInt(JOptionPane.showInputDialog("국어점수 입력"));
		eng_input = Integer.parseInt(JOptionPane.showInputDialog("영어점수 입력"));
		math_input = Integer.parseInt(JOptionPane.showInputDialog("마지막, 수학점수"));
		arr_student.add(new student(input_name, ban_input, kor_input, eng_input, math_input));
		//display();
		//rearrange_display();
		menu();
	}	
	//public String getname() { return input_name; }
	//메인메서드의 while문 탈출을 위해 필요했으나 input_name을 static으로 선언하여 필요 없어
//////////////////////////////////////////////////////////////////////////////////////////	
	
	void display() { 
		System.out.println("최초 입력값: "+arr_student);
		menu();
	} 
///////////////////////////////////////////////////////////////////////////////////////////
	
	class rearrange implements Comparator<student>{
		public int compare(student one, student two) {
			return one.name.compareTo(two.name);
		}
	}
	void rearrange_display(){		
		//rearrange re = new rearrange();
		Collections.sort(arr_student, new rearrange());
		System.out.println("정렬: "+arr_student);
		menu();
	}
//////////////////////////////////////////////////////////////////////////////////////////
	//ListIterator<student> listit = new ListIterator<student>();
	//ListIterator<student> listit = arr_student.listIterator();
	//Object obj = new Object();
	//void delete() {
/*		System.out.println("1");
		//while(listit.hasNext()) {
			System.out.println("2");
			if(obj.equals("aaa")) listit.remove();
			System.out.println("3");
			//obj = listit.next();
		//}
		System.out.println("4");*/
		//String input = JOptionPane.showInputDialog("삭제할 이름 입력");
		//arr_student.remove("aaa");
		//arr_student.remove(new student(input));
/*		display();
		menu();
	}
*/	
	
	void deleteb() {
		String input = JOptionPane.showInputDialog("삭제할 이름 입력");  
/*		for (ListIterator<student> listit = arr_student.listIterator(); listit.hasNext(); ) {
			  student temp = listit.next();
			  if (temp.getname().equals(input)) {	//new student().getname().equals(input) 에러발생 
				  listit.remove();
			  }
		}*/
		ListIterator<student> listit = arr_student.listIterator();	//삭제, 검색, 변경 메서드에 가각 들어있어야 한다. 안그러면 리스트가 끝까지 이동 후 다시 앞으로 오지 않는다.
		
		while(listit.hasNext()) {
			student temp = listit.next();	//listiterator 클래스의 listit이 가리키는 값을 student에 저장 
			if (temp.getname().equals(input)) {	//new student().getname().equals(input) 에러발생 
				  listit.remove();
			  }
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////
	
	void search() {
		String input = JOptionPane.showInputDialog("검색할 이름 입력");
		ListIterator<student> listit = arr_student.listIterator();
		while(listit.hasNext()) {
			student temp = listit.next();
			if(temp.getname().equals(input)) {
				System.out.println(temp);
			}
		}
	}
	
	void modify() {
		String input = JOptionPane.showInputDialog("수정할 이름 입력");
		ListIterator<student> listit = arr_student.listIterator();
		
		while(listit.hasNext()) {
			student temp = listit.next();
			
			if(temp.getname().equals(input)) {
				//arr_student.set(, temp);
				//edit.getname();
				//arr_student.get(new student(input_name, ban_input, kor_input, eng_input, math_input));
				System.out.println("값을 다시 입력하세요.");
/*				input_name = JOptionPane.showInputDialog("이름 입력(변경을 원하지 않으면 enter66");
				if(input_name == null) input_name = input;*/
				input_name = input;
				ban_input = Integer.parseInt(JOptionPane.showInputDialog("반 입력"));
				kor_input = Integer.parseInt(JOptionPane.showInputDialog("국어점수 입력"));
				eng_input = Integer.parseInt(JOptionPane.showInputDialog("영어점수 입력"));
				math_input = Integer.parseInt(JOptionPane.showInputDialog("마지막, 수학점수"));
				//arr_student.add(new student(input_name, ban_input, kor_input, eng_input, math_input));
				temp.setname(input_name);
				temp.setban(ban_input);
				temp.setkor(kor_input);
				temp.seteng(eng_input);
				temp.setmath(math_input);
				
				listit.set(temp);
				//arr_student = (ArrayList) arr_student.clone();
				//display();
				//rearrange_display();
				//break;
			}
		}
		menu();
	}

}//class
