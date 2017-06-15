import java.util.*;
class c_linkedVSarray{
	public static void main(String[] args){
		List<String> list = new ArrayList<String>();
		list.add("ravi");
		list.add("vijay");
		list.add("ravi");
		list.add("ajay");

		List<String> list2 = new LinkedList<String>();
		list2.add("james");
		list2.add("serena");
		list2.add("swati");
		list2.add("junaid");

		System.out.println("arraylist"+list);
		System.out.println("linkedlist"+list2);
	}
}
