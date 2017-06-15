package z1027_fri;
//메인 클래스명: asgn
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

class student{
	String name;
	int ban;
	int kor_score;
	int eng_score;
	int math_score;
	int total;
	student(String a, int b, int c, int d, int e) {
		name = a;
		ban = b;
		kor_score = c;
		eng_score = d;
		math_score = e;
		total = c + d + e;
	}
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

public class asgn {
	ArrayList<student> arr_student = new ArrayList<student>();
	String input_name = "";
	int ban_input = 0; int kor_input = 0; int eng_input = 0; int math_input = 0;

	public static void main(String[] args) {
		asgn atpt = new asgn();
		while(true) {
			atpt.menu();
			if(new asgn().input_name == null) break;
		}
	}

	void menu() {
		String menu = JOptionPane.showInputDialog("메뉴 선택\n숫자를 입력하세요\n1(입력) 2(출력) 3(정렬된 출력) 4(삭제) 5(탐색) 6(수정) 7(종료)");
		if(menu != null) {
				if(menu.equals("1")) { input(); }
				else if(menu.equals("2")) { display(); }
				else if(menu.equals("3")) { rearrange(); }
				else if(menu.equals("4")) { delete(); }
				else if(menu.equals("5")) { search(); }
				else if(menu.equals("6")) { modify(); }
				else if(menu.equals("7")) {
					System.out.println("종료");
					System.exit(0);
				}
				else menu();
		}
		else if(menu == null) { menu(); }
	}

	boolean flag = false;
	void input(){
		while(!flag) {
			try {
				input_name = JOptionPane.showInputDialog("이름 입력을 입력하세요.");
				if(input_name == null) {
					System.out.println("이름을 입력하지 않았습니다. 정보를 처음부터 다시 입력하세요.");
					input();
				}
				ban_input = Integer.parseInt(JOptionPane.showInputDialog("반 입력을 입력하세요."));
				kor_input = Integer.parseInt(JOptionPane.showInputDialog("국어점수를 입력하세요."));
				eng_input = Integer.parseInt(JOptionPane.showInputDialog("영어점수를 입력하세요."));
				math_input = Integer.parseInt(JOptionPane.showInputDialog("수학점수를 입력하세요."));
				arr_student.add(new student(input_name, ban_input, kor_input, eng_input, math_input));
				menu();
			} catch(NumberFormatException e) {
				System.out.println("숫자가 아닙니다. 정보를 처음부터 다시 입력하세요.");
			}
		}
	}

	void display() {
		if(arr_student.size() == 0) {
			System.out.println("출력 목록이 없습니다. 메뉴화면으로 돌아갑니다.");
			menu();
		}
		System.out.println("학생 목록: "+arr_student);
		menu();
	}

	class rearrange implements Comparator<student>{
		public int compare(student one, student two) {
			return one.name.compareTo(two.name);
		}
	}
	void rearrange(){
		if(arr_student.size() == 0) {
			System.out.println("정렬 목록이 없습니다. 메뉴화면으로 돌아갑니다.");
			menu();
		}
		Collections.sort(arr_student, new rearrange());
		System.out.println("정렬: "+arr_student);
		menu();
	}


	void delete() {
		if(arr_student.size() == 0) {
			System.out.println("삭제 목록이 없습니다. 메뉴화면으로 돌아갑니다.");
			menu();
		}
		else {
			ListIterator<student> listit = arr_student.listIterator();
			String input = JOptionPane.showInputDialog("삭제할 이름 입력");
			student temp = null;
			while(listit.hasNext()) {
				temp = listit.next();
				if (temp.getname().equals(input)) {
					listit.remove();
					menu();
				}
			}
			if(input == null) {
				System.out.println("이름을 입력하지 않았습니다. 삭제할 이름을 다시 입력해주세요.");
				listit = arr_student.listIterator();
				delete();
			}
			if(!temp.getname().equals(input)) {
				System.out.println("삭제할 이름이 목록에 없습니다. 다시 입력해주세요.");
				listit = arr_student.listIterator();
				delete();
			}
		}
	}

	void search() {
		if(arr_student.size() == 0) {
			System.out.println("목록이 없습니다. 메뉴화면으로 돌아갑니다.");
			menu();
		}
		else {
			ListIterator<student> listit = arr_student.listIterator();
			String input = JOptionPane.showInputDialog("검색할 이름을 입력하세요.");
			student temp = null;
			while(listit.hasNext()) {
				temp = listit.next();
				if (temp.getname().equals(input)) {
					System.out.println("검색 결과: "+temp);
					menu();
				}
			}
			if(input == null) {
				System.out.println("이름을 입력하지 않았습니다. 검색할 이름을 다시 입력해주세요.");
				listit = arr_student.listIterator();
				search();
			}
			if(!temp.getname().equals(input)) {
				System.out.println("검색할 이름이 목록에 없습니다. 다시 입력해주세요.");
				listit = arr_student.listIterator();
				search();
			}
		}
	}

	void modify() {
		if(arr_student.size() == 0) {
			System.out.println("목록이 없습니다. 메뉴화면으로 돌아갑니다.");
			menu();
		}
		else {
			ListIterator<student> listit = arr_student.listIterator();
			String input = JOptionPane.showInputDialog("수정할 이름을 입력하세요.");
			student temp = null;
			while(listit.hasNext()) {
				temp = listit.next();
				if(temp.getname().equals(input)) {
					input_name = input;
					ban_input = Integer.parseInt(JOptionPane.showInputDialog("(수정)반 입력"));
					kor_input = Integer.parseInt(JOptionPane.showInputDialog("(수정)국어점수 입력"));
					eng_input = Integer.parseInt(JOptionPane.showInputDialog("(수정)영어점수 입력"));
					math_input = Integer.parseInt(JOptionPane.showInputDialog("(수정)수학점수 입력"));
					temp.setname(input_name);
					temp.setban(ban_input);
					temp.setkor(kor_input);
					temp.seteng(eng_input);
					temp.setmath(math_input);
					listit.set(temp);
					System.out.println("수정 완료");
					menu();
				}
			}
			if(input == null) {
				System.out.println("이름을 입력하지 않았습니다. 수정할 이름을 다시 입력해주세요.");
				listit = arr_student.listIterator();
				 modify();
			}
			if(!temp.getname().equals(input)) {
				System.out.println("수정할 이름이 목록에 없습니다. 다시 입력해주세요.");
				listit = arr_student.listIterator();
				modify();
			}
		}
	}
}
