import java.util.Collections;
import java.util.LinkedList;
import java.util.Comparator;

class mountain /*implements Comparable<mountain>*/{	//Comparator를 여기서 구현하지 않고, compare를 하는 클래스에서 한다.
	String name;
	int height;
	
	mountain(String a, int b){
		name = a;
		height = b;
	}
	
	//public String getname() { return name; }
	//public int getheight() { return height; }
	
	//public int compareTo(mountain m) { return name.compareTo(m.getname()); }
	
	//public String toString() { return name; }	//이게 없으면 출력값이 주소로만 나온다.
	//toString 메서드는 문자열만 리턴할 수 있다. 중간에 +""+을 붙이면 int형도 포함 가능.
	public String toString() { return name+" "+height; }
}

public class p588_ {
	LinkedList<mountain> mtn = new LinkedList<mountain>();
	
	class namecompare implements Comparator<mountain>{
		public int compare(mountain one, mountain two) {	//매개변수로 객체를 받아 오는데 mountain 클래스에서 함수로 불러올 필요가 없다. 
			//return one.getname().compareTo(two.getname());
			return one.name.compareTo(two.name);
		}
	}
	
	class heightcompare implements Comparator<mountain>{
		public int compare(mountain one, mountain two) {
			//return one.getheight().compareTo(two.getheight());
			//return two.height.compareTo(one.height);	//compareTo를 int형에 대입할 수는 없다.	
			//return one.getheight() - two.getheight();
			return two.height - one.height;	//내림차순
		}
	}
	
	public static void main(String[] args) {
		p588_ abcd = new p588_(); 
		abcd.go();
	}
	
	public void go() {
		mtn.add(new mountain("longss", 10100));
		mtn.add(new mountain("elbert", 40040));
		mtn.add(new mountain("maroon", 33000));
		mtn.add(new mountain("castle", 20002));
		
		System.out.println("as entered:\n"+mtn);
		
		namecompare nc = new namecompare();
		//nc.compare(mtn, mtn);
		Collections.sort(mtn, nc);
		System.out.println("by name:\n"+mtn);
		
		heightcompare hc = new heightcompare();
		Collections.sort(mtn, hc);	//객체 vs 객체로 비교를 해야 한다.
		System.out.println("by height\n"+mtn);
		
		
	}
}
