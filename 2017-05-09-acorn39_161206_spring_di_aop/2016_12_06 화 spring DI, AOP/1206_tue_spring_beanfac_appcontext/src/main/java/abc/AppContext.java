package abc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import Message.Messagebean;

public class AppContext {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:beans.xml");
		
		Messagebean bean = ctx.getBean("messageBean", Messagebean.class);
		Messagebean bean2 = ctx.getBean("messageBean2", Messagebean.class);
		
		bean.sayHello("Spring");
		bean.sayHello("Spring222");
	}
}
