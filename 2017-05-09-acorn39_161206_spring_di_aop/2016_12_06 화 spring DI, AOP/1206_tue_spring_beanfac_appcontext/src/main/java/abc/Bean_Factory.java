package abc;

import org.springframework.beans.factory.*;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.core.io.FileSystemResource;

import Message.Messagebean;

public class Bean_Factory {
	public static void main(String[] args) {
		try{
			FileSystemResource fsr = new FileSystemResource("beans.xml");
			BeanFactory factory = new XmlBeanFactory(fsr);
			
			Messagebean bean = factory.getBean("messageBean", Messagebean.class);
			bean.sayHello("Spring");
			
			Messagebean bean2 = factory.getBean("messageBean2", Messagebean.class);
			bean2.sayHello("Spring");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println("hello world!");
	}
}
