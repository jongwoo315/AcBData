import java.util.Hashtable;
import java.util.Enumeration;

class aaa{
	
}

class bbb{
	
}

public class p429_map_hashtable {
	public static void main(String[] args) {
		Hashtable ht = new Hashtable();
		
		aaa ap = new aaa();
		bbb bp = new bbb();
		String cp = "java";
		
		ht.put("kim",ap);
		ht.put("lee",bp);	//key value 순으로 저장
		ht.put("park",cp);	//동일한 key값이 헤쉬테이블에 저장하려고 하면 하나면 저장되고 나머지는 사라진다.
		ht.put("wang",cp);	//문자열 cp에 "java"가 중복 저장된다. 

		Enumeration keys = ht.keys();
		while(keys.hasMoreElements()) {
			System.out.println(keys.nextElement());
		}
		System.out.println();
		System.out.println("value 출력");
		
		Enumeration elements = ht.elements();
		while(elements.hasMoreElements()){
			System.out.println(elements.nextElement());
		}
		
	}
}
