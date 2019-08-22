package com.allen.dubbo.xml.config.center;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigCenterProviderLauncher {

    public static void main(String...args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/applicationContext.xml");
        context.start();
        Thread.currentThread().join();
    }
}
