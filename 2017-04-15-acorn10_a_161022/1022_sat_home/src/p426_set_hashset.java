import java.util.HashSet;
import java.util.Iterator;
//import java.util.Collection;
class a23{
	
}

class b23{
	
}

public class p426_set_hashset {
	public static void main(String[] args) {
		HashSet hs = new HashSet();		// hs는 HashSet의 객체 
		a23 ap = new a23();
		b23 bp = new b23();
		String cp = "abc";
		hs.add(ap);
		hs.add(bp);
		hs.add(cp);

		Iterator it = hs.iterator();	//	객체를 뽑아 오기 위해 사용하는 인터페이스: Iterator
		while(it.hasNext()) {	
			System.out.println(it.next());	//	순서 정렬 없이 들어 있는 객체를 하나씩 뽑아서 출
		}
	}
}
