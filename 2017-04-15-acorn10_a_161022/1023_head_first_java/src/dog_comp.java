
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

class dog{
	String name;
	int age;
	dog(String a, int b){
		name = a;
		age = b;
	}
	
	public String toString() {
		return name+" "+age;
	}
}

class compare1 implements Comparator<dog>{	//생각해볼 것. sort의 매개변수 
	public int compare(dog one, dog two) {
		return one.name.compareTo(two.name);
	}
}

class compare2 implements Comparator<dog>{
	public int compare(dog one, dog two) {
		return two.age - one.age;
	}	
}

//////////////////////////////////////////////////////////
public class dog_comp {
	ArrayList<dog> dg = new ArrayList<dog>();
	compare1 compare_by_name = new compare1();
	compare2 compare_by_age = new compare2();
	
	public static void main(String[] args) {
		dog_comp dogcp = new dog_comp();
		dogcp.action();
	}
	
	public void action(){
		dg.add(new dog("george", 32));
		dg.add(new dog("don", 24));
		dg.add(new dog("alias", 18));
		dg.add(new dog("bob", 47));
		dg.add(new dog("chris", 19));
		System.out.println(dg);
		
		Collections.sort(dg, compare_by_name);	//sort의 매개변수는 객체가 와야 하는데, 비교용으로 만든 클래스가 이름순, 나이
		System.out.println(dg);					//이 있다면 각각을 어떻게 구분할 것인
		
		Collections.sort(dg, compare_by_age);
		System.out.println(dg);
	}
}
