package com.allen.dubbo.xml;

import com.allen.dubbo.iface.DemoService;
import com.allen.dubbo.iface.GroupService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConsumerLauncher {

    public static void main(String...args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/applicationContext.xml");
        context.start();

        //testDemoService(context);
        testGroupService(context);

    }

    public static void testDemoService(ApplicationContext context) {
        DemoService demoService = context.getBean(DemoService.class);
        String hello = demoService.sayHello("Allen");
        System.out.println(hello);
    }

    public static void testGroupService(ApplicationContext context) {
        GroupService groupService = context.getBean("moonGroupService", GroupService.class);
        String name = groupService.groupName();
        System.out.println(name);

        groupService = context.getBean("starGroupService", GroupService.class);
        name = groupService.groupName();
        System.out.println(name);
    }
}
