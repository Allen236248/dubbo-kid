package com.allen.dubbo.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlProviderLauncher {

    public static void main(String...args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/applicationContext.xml");
        context.start();
        Thread.currentThread().join();
    }
}
