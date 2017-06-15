import java.util.*;
class a1_arraylist4{
	public static void main(String args[]){
		ArrayList<String> al = new ArrayList<String>();
		al.add("ravi");
		al.add("vijay");
		al.add("ajay");

		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("sonoo");
		al2.add("hanumat");

		al.addAll(al2);	//adding second list in first list	// al2 into al

		Iterator itr = al.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
}
