package com.allen.dubbo.xml;

import com.allen.dubbo.iface.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConsumerLauncher {

    public static void main(String...args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/applicationContext.xml");
        context.start();

        DemoService demoService = context.getBean(DemoService.class);
        String hello = demoService.sayHello("Allen");
        System.out.println(hello);
    }
}
