package b_linkedlist2;
import java.util.*;

public class LinkedListExample{
	public static void main(String args[]){
		//creating list of books
		List<Book> list = new LinkedList<Book>();

		//creating books
		Book b1 = new Book(101, "let us C", "yashwant", "bpb", 8);
		Book b2 = new Book(102, "data communications & networking", "forouzan", "mc graw hill", 4);
		Book b3 = new Book(103, "operating system", "galvin", "wiley", 6);

		//adding books to list
		list.add(b1);
		list.add(b2);
		list.add(b3);

		//traversion list
		for(Book b : list){
			System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
		}
	}
}
