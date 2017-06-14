package sample;

public class MessageBeanImpl implements MessageBean{
	private String name;
	public void setName(String name){
		this.name = name;
	}
	public void sayHello(){
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){}
		System.out.println("Hello,"+name+"!");
	}
	
	public void sayHello2(int limit){
		try{
			int sum = 0;
			for(int i = 1; i <= limit; i++){
				sum += i;
				Thread.sleep(100);
			}
			System.out.println("합계: "+sum);
		}catch(InterruptedException e){}
	}
	
	public void insert(){
		try{
			int sum = 0;
			for(int i = 1; i <= 100; i++){
				sum += i;
				Thread.sleep(30);
			}
			System.out.println("합계: "+sum);
		}catch(InterruptedException e){}
	}
	
	public void insertName(int start, int limit, int gap){
		try{
			int sum = 0;
			for(int i = start; i <= limit; i += gap){
				sum += i;
				Thread.sleep(50);
			}
			System.out.println("합계: "+sum);
		}catch(InterruptedException e){}
	}
	
	public void nameInsert(String name){
		try{
			int sum = 0;
			for(int i =1; i <= 1000; i++){
				sum += i;
				Thread.sleep(20);
			}
			System.out.println(name+sum);
		}catch(InterruptedException e){}
	}
}
