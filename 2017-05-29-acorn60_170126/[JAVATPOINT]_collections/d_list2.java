import java.util.*;
public class d_list2{
	public static void main(String[] args){
		List<String> al = new ArrayList<String>();
		al.add("ojay");
		al.add("thomas");
		al.add("timber");
		al.add(1, "flymouth");

		System.out.println("2nd position "+al.get(2));

		ListIterator<String> itr = al.listIterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		System.out.println();
		System.out.println("print backwards");
		while(itr.hasPrevious()){
			System.out.println(itr.previous());
		}
	}
}
