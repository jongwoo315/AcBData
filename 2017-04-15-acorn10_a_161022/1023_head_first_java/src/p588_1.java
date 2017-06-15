import java.util.Collections;
import java.util.LinkedList;
import java.util.Comparator;

class mountain1 {
	String name;
	int height;
	
	mountain1(String a, int b){
		name = a;
		height = b;
	}
	public String toString() { return name+" "+height; }
}

public class p588_1 {
	LinkedList<mountain1> mtn = new LinkedList<mountain1>();
	
	public static void main(String[] args) {
		p588_ abcd = new p588_(); 
		abcd.go();
	}
	
	public void go() {
		mtn.add(new mountain1("longss", 10100));
		mtn.add(new mountain1("elbert", 40040));
		mtn.add(new mountain1("maroon", 33000));
		mtn.add(new mountain1("castle", 20002));
		
		System.out.println("as entered:\n"+mtn);
		
		namecompare nc = new namecompare();
		Collections.sort(mtn, nc);
		System.out.println("by name:\n"+mtn);
		
		heightcompare hc = new heightcompare();
		Collections.sort(mtn, hc);
		System.out.println("by height\n"+mtn);
		
	}

	class namecompare implements Comparator<mountain1>{
		public int compare(mountain1 one, mountain1 two) { 
			return one.name.compareTo(two.name);
		}
	}
	
	class heightcompare implements Comparator<mountain1>{
		public int compare(mountain1 one, mountain1 two) {
			return two.height - one.height;
		}
	}
}
