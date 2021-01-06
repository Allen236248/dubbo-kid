package com.allen.dubbo.xml;

import com.alibaba.dubbo.rpc.service.GenericService;
import com.allen.dubbo.domain.User;
import com.allen.dubbo.iface.*;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

public class XmlConsumerLauncher {

    public static void main(String... args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/applicationContext.xml");
        context.start();

        while(true) {
            try {
                testDemoService(context);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //testAction(context);
        //testDemoService(context);
        //testDemoService2(context);
        //testGroupService(context);
        //testCallbackService(context);
        //testGenericServiceInvoke(context);
        //testGenericServiceImplement(context);

        //testAsyncService1(context);
        //testAsyncService2(context);
    }

    public static void testAction(ApplicationContext context) {
        ConsumerAction action = context.getBean(ConsumerAction.class);
        action.consume();
    }

    public static void testDemoService(ApplicationContext context) {
        DemoService demoService = context.getBean(DemoService.class);
        String hello = demoService.sayHello("Allen");
        System.out.println(hello);
    }

    public static void testDemoService2(ApplicationContext context) {
        DemoService demoService = context.getBean(DemoService.class);
        String hello = demoService.sayHelloSlowly("Allen");
        System.out.println(hello);
    }

    public static void testGroupService(ApplicationContext context) {
        for (int i = 0; i < 5; i++) {
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

    public static void testCallbackService(ApplicationContext context) {
        CallbackService callbackService = context.getBean(CallbackService.class);
        callbackService.addListener("foo.bar", new CallbackListener() {
            public void changed(String msg) {
                System.out.println(msg);
            }
        });
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 泛化调用：主要用于客户端没有 API 接口及模型类元的情况。
     * 此例中只知道接口：com.allen.dubbo.xml.provider.GenericTestService暴露了服务，但是本地没有接口
     *
     * @param context
     */
    public static void testGenericServiceInvoke(ApplicationContext context) {
        GenericService genericService = (GenericService) context.getBean("genericTestService");
        String result = (String) genericService.$invoke("invoke1", new String[]{"java.lang.String"}, new Object[]{"allen"});
        System.out.println(result);

        //参数及返回值中的所有 POJO 均用 Map 表示
        Map<String, Object> user = new HashMap<>();
        user.put("name", "Allen");
        Object _user = genericService.$invoke("findUser", new String[]{"com.allen.dubbo.domain.User"}, new Object[]{user});
        if (_user instanceof Map) {
            user = (Map<String, Object>) _user;
            System.out.println(user.get("name") + "," + user.get("email"));
        }
    }

    public static void testGenericServiceImplement(ApplicationContext context) {
        BarService barService = context.getBean(BarService.class);
        String result = barService.invoke1("Sophy");
        System.out.println(result);

        User user = new User();
        user.setName("Sophy");
        user = barService.findUser(user);
        System.out.println(user.getName() + "," + user.getEmail());
    }

    public static void testAsyncService1(ApplicationContext context) {
        AsyncService asyncService = context.getBean(AsyncService.class);

//        CompletableFuture<String> future = RpcContext.getContext().asyncCall(() -> asyncService.asyncInvoke1("async call request1"));
//        try {
//            future.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        asyncService.asyncInvoke1("async call request1");
        CompletableFuture<String> future = RpcContext.getContext().getCompletableFuture();
        future.whenComplete(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable t) {
                if (t != null) {
                    t.printStackTrace();
                } else {
                    System.out.println("Response: " + s);
                }
            }
        });
        // 早于结果输出
        System.out.println("Executed before response return." + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    public static void testAsyncService2(ApplicationContext context) {
        AsyncService asyncService = context.getBean(AsyncService.class);

        RpcContext.getContext().setAttachment("key1", "value1");
        // 调用直接返回CompletableFuture
        CompletableFuture<String> future = asyncService.asyncInvoke2("async call request");
        future.whenComplete(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable t) {
                if (t != null) {
                    t.printStackTrace();
                } else {
                    System.out.println("Response: " + s);
                }
            }
        });
        // 早于结果输出
        System.out.println("Executed before response return." + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
