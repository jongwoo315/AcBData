package abc;
//import java.util.*;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Collection;	//필요없나??


class Dog implements Comparable<Dog>, Comparator<Dog>{
	private String name;
	private int age;
	int aa;
	Dog(){}
	Dog(String n, int a){
		name = n;
		age = a;
	}
	
	public String getDogName() { return name; }	
	public int getDogAge() { return age; }
	public String toString() { return name; } //이게 없으면 list로 받은 것들을 출력할 때 주소값이 출력된다.
	
	public int compareTo(Dog d) { return (this.name).compareTo(d.name); }
	//compareTo가 정의되었다고 해도 인터페이스 Comparable를 구현한 것이기 때문에 반드시! 인터페이스에 있는 것을 여기서 구현해야함
	// 안그러면 오류발생. 위의 메서드를 주석처리하면 Dog클래스에 오류메세지가 출력됨

	public int compare(Dog d, Dog d1) { return  aa = d.age - d1.age; }
	//인터페이스 Comparator를 구현한 것 / 오버라이딩한 것이다. 없으면 오류 발생
	//오버라이딩하는 거니까 메서드명도 동일하게 적어야 한다.
}

public class a01_compare_class {
	public static void main(String[] args) {
		List<Dog> list = new ArrayList<Dog>();

		list.add(new Dog("shaggy", 3));	//클래스로 입력한 것
		list.add(new Dog("lacy", 2));
		list.add(new Dog("roger", 10));
		list.add(new Dog("tommy", 4));
		list.add(new Dog("tammy", 1));
		
		System.out.println("최초입력순\t"+list);
		Collections.sort(list);	//sort는 매개변수가 1개, 2개를 쓸 수 있다. //알파벳순서로 정렬
		for(Dog a : list) { System.out.println(a.getDogName()+", ");}
		// list에 있는 것을 Dog a가 다 돌 때까지 출력하겠다.
		// sort함수를 쓸 때 매개변수(list)를 가져와라. 그리고 compareTo를 사용해라 (규칙이다. 그냥 외울 것)
		// 인터페이스 Comarable -> 메서드 compareTo 
		
		Collections.sort(list, new Dog());
		System.out.println(" ");
		for(Dog a : list) {System.out.println(a.getDogName()+" : "+a.getDogAge()+", ");}
		// Sorts the specified list according to the order induced by the specified comparator.
		// Collections.sort( a , b) 에 매개변수가 두 개일 때에는 뒤에 b가 comparator 객체로 받아야한다.
		// 또한, b를 기준으로 정렬이 된다.
		// 인터페이스 Comparator -> 메서드 compare
		
		Dog b =new Dog();
		//b.compareTo(b.name); compareTo함수는 이미 자바내에 정의가 된 것이다.
		
		
	}
}