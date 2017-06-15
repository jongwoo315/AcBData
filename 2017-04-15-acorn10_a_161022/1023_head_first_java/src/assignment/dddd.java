package assignment;


/*	Attached File:iles/juso.zip

	// *********************************************
	//
	// 주소록 클래스
	//
	// *********************************************
*/	
class AddrBook {
		// 외부 클래스에서 직접 접근하지 못함...메소드를 통해 접근 가능
	private int no;
	private String name;
	private String addr;
	private String tel;

	// --------------------- 생성자
	AddrBook(int no, String name, String addr, String tel) {
		this.no = no;
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}

	// --------------------- 재정의(Object Class의 toString())
	public String toString() {
		String a = no + " : ";
		a += name + ",";
		a += addr + ",";
		a += tel;

		return a;
	}

	// 주소록의 이름을 돌려주는 메소드
	public String getName() {
		return this.name;
	}
}

// ***********************************************
// ArrayList 인터페이스가 구현해야 하는 메소드 정의
//
// 인터페이스
// ***********************************************
interface ArrayInterface {
	public void add(Object o); // 맨 뒤에 넣는 case

	public void add(int index, Object o);

	public void removeAll();

	public boolean remove(String name);

	public boolean remove(int idx);

	public int size();
}

	// *******************************************
	//
	// 주소록 조작을 위한 클래스
	//
	// *******************************************
class MyArray implements ArrayInterface {
	Object[] myArray;

	MyArray() {
		myArray = new Object[0];
	}

	MyArray(int i) {
		if (i < 0)
			throw new IllegalArgumentException();
		myArray = new Object[i];
	}

	public int size() {
		for (int i = 0; i < myArray.length; i++) {
			if (myArray[i] == null)
				return i;
		}
		return myArray.length;
	}

	public void ensureCapacity(int minCapacity) {
		// minCapacity가 현재 size보다 클경우에만 처리할수도 있슴
		Object[] newArray = new Object[minCapacity];
		System.arraycopy(myArray, 0, newArray, 0, size());
		myArray = newArray;
	}

	public void add(Object s) {
		ensureCapacity(size() + 1);
		myArray[size()] = s;
	}

	public void add(int index, Object s) {
		int size = size();
		if (index > size) {
			System.out.println("Invalid Index...");
		} else {
			if (size == myArray.length)
				ensureCapacity(size + 1);
			// arraycopy로 대체가 가능하다.
			// if (index != size)
			// System.arraycopy(myArray, index, myArray, index + 1, size -
			// index);
			// myArray[index] = s;
			if (index < size) {
				for (int i = size; i > index; i--) {
					myArray[i] = myArray[i - 1];
				}
				myArray[index] = s;
			}
		}
	}

	public boolean remove(int idx) {
		int size = size();

		if (idx < size) {
			myArray[idx] = null;
			for (int i = idx; i < size - 1; i++) {
				myArray[i] = myArray[i + 1];
				myArray[i + 1] = null;
			}
			// 삭제의 경우라면 under flow를 생각안할수도 있슴.
			ensureCapacity(size - 1);
			return true;
		}

		return false;
	}

	public boolean remove(String name) {
		int i = 0, idx = 0, size = 0;
		size = size();

		for (i = 0; i < size; i++) {
			AddrBook book = (AddrBook) myArray[i];
			if (book.getName().equals(name)) {
				idx = i;
				break;
			}
		}

		if (i == size) {
			System.out.println("Data Not Found....");
			return false;
		}

		if (idx < size) {
			myArray[idx] = null;
			for (i = idx; i < size - 1; i++) {
				myArray[i] = myArray[i + 1];
				myArray[i + 1] = null;
			}
			ensureCapacity(size - 1);
			return true;
		}
		return false;
	}

	public void removeAll() {
		Object[] myArray = new Object[0];
	}

	// ------------------ 주소록 전부 출력하는 메소드
	public void printAll() {
		for (int i = 0; i < size(); i++) {
			System.out.println(myArray[i]);
		}
	}

	// ----------------- 이름으로 주소록 검색 후 출력
	public void search(String name) {
		int size = size();
		for (int i = 0; i < size; i++) {
			AddrBook book = (AddrBook) myArray[i];
			if (book.getName().equals(name)) {
				System.out.println(book);
				;
			}
		}
	}
}

public class dddd {
	public static void main(String[] args) {
	  MyArray array = new MyArray();
	  array.add(new AddrBook(1,"이종철","수원", "111-1111"));
	  array.add(new AddrBook(2,"jclee","수원", "222-2222"));
	  array.add(new AddrBook(3,"tatata","수원", "333-3333"));
	  array.printAll();
	  System.out.println("----------------------");
	  array.search("이종철");
	  System.out.println("----------------------");
	  array.remove("이종철");
	  array.printAll();   
	}
}