package singleton2;


public class SingletonPatternDemo {
	public static void main(String[] args) {
		// illegal construct
		// compile time error: the constructor singleobject() is not visible
		// singleobject = new singleObject();
		
		// get the only object available
		SingleObject object = SingleObject.getInstance();
		//show the message
		object.showMessage();
		
		//The constructor SingleObject() is not visible / SingleObject가 private으로 선언되었기 때문에
		SingleObject aaa = new SingleObject();
		aaa.showMessage();
	}
	
}
