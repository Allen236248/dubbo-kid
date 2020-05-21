package com.allen.dubbo.xml;

import com.allen.dubbo.domain.User;
import com.allen.dubbo.iface.*;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class XmlConsumerLauncher {

    public static void main(String...args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/applicationContext.xml");
        context.start();

        //ConsumerAction action = context.getBean(ConsumerAction.class);
        //action.consume();
        RpcContext.getContext().set("xxx", "yyy");
        RpcContext.getContext().setAttachment("aaa", "bbb");

        //testDemoService(context);

        RpcContext.getContext().setAttachment("aaa", "bbb");
        //testGroupService(context);
        //testCallbackService(context);
        testGenericService(context);
    }

    public static void testDemoService(ApplicationContext context) {
        DemoService demoService = context.getBean(DemoService.class);
        String hello = demoService.sayHello("Allen");
        System.out.println(hello);
    }

    public static void testGroupService(ApplicationContext context) {
        for(int i = 0; i < 5; i++) {
            GroupService groupService = context.getBean("groupService", GroupService.class);
            String name = groupService.groupName();
            System.out.println(name);
        }


//        GroupService groupService = context.getBean("moonGroupService", GroupService.class);
//        String name = groupService.groupName();
//        System.out.println(name);
//
//        groupService = context.getBean("starGroupService", GroupService.class);
//        name = groupService.groupName();
//        System.out.println(name);
    }

    public static void testCallbackService(ClassPathXmlApplicationContext context) {
        CallbackService callbackService = context.getBean("callbackService", CallbackService.class);
        callbackService.addListener("foo.bar", new CallbackListener() {
            public void changed(String msg) {
                System.out.println(msg);
            }
        });
        context.start();
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 泛化调用主要用于消费者没有 API 接口及模型类元的情况。
     * 此例中只知道接口：com.allen.dubbo.xml.provider.GenericTestService暴露了服务，但是本地没有接口
     * @param context
     */
    public static void testGenericService(ApplicationContext context) {
        GenericService genericService = (GenericService) context.getBean("genericTestService");
        String result = (String) genericService.$invoke("invoke1", new String[]{"java.lang.String"}, new Object[]{"allen"});
        System.out.println(result);

        //参数及返回值中的所有 POJO 均用 Map 表示
        Map<String, Object> user = new HashMap<>();
        user.put("name", "Allen");
        Object _user = genericService.$invoke("findUser", new String[]{"com.allen.dubbo.domain.User"}, new Object[]{user});
        if(_user instanceof Map) {
            user = (Map<String, Object>)_user;
            System.out.println(user.get("name") + "," + user.get("email"));
        }

    }
}
