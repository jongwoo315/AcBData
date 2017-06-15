import java.util.Enumeration;
import java.util.Vector;

class a24{
	
}

class b24{
	
}

public class p428_list_vector {
	public static void main(String[] args) {
		Vector vc = new Vector();
		a24 ap = new a24();
		b24 bp = new b24();
		String cp = "test";
		
		vc.addElement(ap);
		vc.add("aa");
		vc.add(bp);
		vc.add(cp);
		
		for(int i = 0; i < vc.size(); i++) {
			Object obj = vc.elementAt(i);
			System.out.println(i+" : "+obj);
		}
		System.out.println();
		
		Enumeration enu = vc.elements();
		while(enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
	}
}
