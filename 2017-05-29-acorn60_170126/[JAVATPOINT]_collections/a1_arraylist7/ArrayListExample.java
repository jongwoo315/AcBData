package a1_arraylist7;
import java.util.*;

public class ArrayListExample{
	public static void main(String[] args){
		//creating list of books
		List<Book> list = new ArrayList<Book>();
		//creating books
		Book b1 = new Book(101, "let us C", "yashwant kanetkar", "BPB", 8);
		Book b2 = new Book(102, "data communications & networking", "forouzan", "mc graw hill", 4);
		Book b3 = new Book(103, "operating system", "galvin", "wiley", 6);

		//adding books to list
		list.add(b1);
		list.add(b2);
		list.add(b3);

		//traversing list
		for(Book b : list){
			System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
		}
	}
}
