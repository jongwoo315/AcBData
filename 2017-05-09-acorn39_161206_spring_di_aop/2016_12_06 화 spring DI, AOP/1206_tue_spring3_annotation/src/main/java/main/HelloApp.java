package main;

import Message.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloApp {
    public static void main(String[] args) {
        ApplicationContext factory = new FileSystemXmlApplicationContext("beans.xml");
        MessageBean aaa = factory.getBean("messageBean12", MessageBean.class);
        aaa.sayHello();
    }
}
