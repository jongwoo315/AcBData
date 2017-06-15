import java.util.*;
public class d_list1{
	public static void main(String[] args){
		ArrayList<String> al = new ArrayList<String>();
		al.add("amit");
		al.add("vijay");
		al.add("kumar");
		al.add(1, "sachin");
		System.out.println("elemnet at 0nd position: "+al.get(0));
		System.out.println("elemnet at 1nd position: "+al.get(1));
		System.out.println("elemnet at 2nd position: "+al.get(2));
		System.out.println("elemnet at 3nd position: "+al.get(3));

		/*for(int a = 0; a < 4; a++){
			System.out.println(al.get(a));
		}*/

		/*for(String s : al){
			System.out.println(s);
		}*/
	}
}
