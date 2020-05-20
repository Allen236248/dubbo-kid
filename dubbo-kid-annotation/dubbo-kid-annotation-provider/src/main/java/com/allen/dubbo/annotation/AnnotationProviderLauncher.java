package com.allen.dubbo.annotation;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

@EnableDubbo(scanBasePackages = "com.allen.dubbo.annotation.provider")
@PropertySource("classpath:/META-INF/spring/dubbo-annotation-provider.properties")
public class AnnotationProviderLauncher {

    public static void main(String...args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationProviderLauncher.class);
        context.start();
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
