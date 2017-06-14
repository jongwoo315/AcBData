package spring;
import org.springframework.context.support.GenericXmlApplicationContext;
public class HelloSpringMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:spring/context.xml");
		
		//HelloSpring helloSpring1 = ctx.getBean("helloBean1", HelloSpring.class);
		//HelloSpring helloSpring2 = ctx.getBean("helloBean2", HelloSpring.class);				
		//객체 주소 출력:
		//scope = "prototype"; //-> helloBean1
		//scope = "singleton"; //-> helloBean2
		//System.out.println(helloSpring1);
		//System.out.println(helloSpring2);
		ctx.close();
	}
}
