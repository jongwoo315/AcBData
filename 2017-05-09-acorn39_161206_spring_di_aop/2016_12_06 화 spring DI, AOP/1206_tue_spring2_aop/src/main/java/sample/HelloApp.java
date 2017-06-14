package sample;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.*;

public class HelloApp {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("beans.xml"));
		MessageBean bean = (MessageBean)factory.getBean("Proxy");
		
		bean.sayHello();
		bean.sayHello2(100);
		bean.insert();
		bean.insertName(100, 500, 5);
		bean.nameInsert("합계결과:");
		
		
	}
}
