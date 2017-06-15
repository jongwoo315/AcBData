package abc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class a02_curd_arraylist {
	public static void main(String[] args) {
		ArrayList <String>al = new ArrayList<String>();
		//ArrayList al = new ArrayList();	//[1]-1 이렇게 하고 al.add(1)하면 가능
		//ArrayList al = new ArrayList<String>(); //[1]-1-1
		// <String> 사용할기본형을 정하는 템플릿
		// <Class명>이면 al.add(클래스)
		System.out.println("추가: ");
		al.add("c");
		al.add("1");	//al.add(1);	
		al.add("e");
		al.add("b");
		al.add("d");
		al.add("f");
//////////////////////////////////////////////////////////////////		
		
		System.out.println("초기값: ");
		Iterator<String> itr = al.iterator();
		//Iterator => 객체
		while(itr.hasNext()) {	//hasNext()는 있냐 없냐를 확인 -> 
			Object element = itr.next();	//next()는 다음 값을 가져오라는 명령어
			//Object => 어떤 기본형이든 사용 가능, class도 받는다
			System.out.println(element+" ");
		}
		System.out.println();
//////////////////////////////////////////////////////////////////
		
		ListIterator<String> litr = al.listIterator();	//앞뒤로 왔다갔다할 수 있게 하는 게 ListIterator
		String element = null;
//////////////////////////////////////////////////////////////////

		while(litr.hasNext()) {
			element = litr.next();
			litr.set(element+"+");		//set은 값을 그 자리에 넣는 것 / +를 넣겠다
		}
		System.out.println("수정: ");
		itr = al.iterator();		
		while(itr.hasNext()) {
			element = itr.next();
			System.out.println(element+" ");
		}
		System.out.println();
//////////////////////////////////////////////////////////////////		
		
		litr = al.listIterator();	//위에서 쓴 hasNext()에서 al의 끝까지 갔기 때문에 다시 선언을 해줘야 사용 가능
		while(litr.hasNext()) {
			element = litr.next();
			if(element.equals("e+")) litr.remove(); 		//삭제 명령어
		}
		System.out.println("삭제: ");
		itr = al.iterator();		
		while(itr.hasNext()) {
			element = itr.next();
			System.out.println(element+" ");
		}
		System.out.println();
//////////////////////////////////////////////////////////////////		

		litr = al.listIterator();
		//int i = 0;	//없어도 되는 코드
		while(litr.hasNext()) {
			element = litr.next();
			if(element.equals("b+")) litr.add("TF");		//삽입 명령어
		}
		//i++;		
		System.out.println("삽입: ");
		itr = al.iterator();
		while(itr.hasNext()) {
			element = itr.next();
			System.out.println(element+" ");
		}
		System.out.println();
//////////////////////////////////////////////////////////////////		

		//litr = al.listIterator(); 	//출력만 하기 때문에 필요없는 코드
		System.out.println("역으로: ");		
		while(litr.hasPrevious()){
			element = litr.previous();
			System.out.println(element+" ");
		}
		System.out.println();
//////////////////////////////////////////////////////////////////		
	}//main
}//class

/*
 * 이름, 나이를 가지는 클래스를 add해서 같은 프로그램을 만들 것
 */ 
