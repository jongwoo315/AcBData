import java.util.*;
class a1_arraylist1{
	public static void main(String args[]){
		//creating arraylist
		ArrayList<String> arrlist = new ArrayList<String>();
		
		//adding object in arraylist
		arrlist.add("Ravi");
		arrlist.add("Vijay");
		arrlist.add("Ravi2");
		arrlist.add("Ajay");

		//traversing list through iterator
		Iterator itr = arrlist.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
}
