package Message;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;

import File.Output;

public class MessageBeanImpl implements MessageBean{
	private String name1 = "새로운스프링";
	private String greeting1 = "반갑습니다";
	
	@Autowired
	Output output;
	public void setOutput(Output output){
		this.output = output;
	}
	
	public MessageBeanImpl(){
		name1 = "초기화";
		greeting1 = "시작하지요";	// 이 부분 주석처리 + xml 주석처리하면 (반갑습니다, 새로운스프링!) 출력
	}	
	public MessageBeanImpl(String a){
		this.name1 = a;
	}	
	public MessageBeanImpl(String b, String c){
		this.name1 = b;
		this.greeting1 = c;
	}
	
	public void setgreeting1(String d){
		this.greeting1 = d;
	}	
	public void setname1(String e){
		this.name1 = e;
	}
	
	public void sayHello(){
		try{
			String message = greeting1 +", "+name1+"!";
			System.out.println(message);
			output.output123(message);
		}catch(IOException ex){
			System.out.println(ex.getMessage());
		}
		
	}
}
