import java.util.*;
class a1_arraylist6{
	public static void main(String[] args){
		ArrayList<String> al = new ArrayList<String>();
		al.add("ravi");
		al.add("vijay");
		al.add("ajay");

		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("ravi");
		al2.add("hanumat");

		al.retainAll(al2);
		System.out.println("iterating the elements after retaining the elements of al2");
		Iterator iter = al.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}

// result ->  ravi
