package com.allen.dubbo.annotation;

import com.allen.dubbo.iface.DemoService;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "com.allen.dubbo.annotation.consumer")
@PropertySource("classpath:/META-INF/spring/dubbo-annotation-consumer.properties")
@ComponentScan(basePackages = "com.allen.dubbo.annotation.consumer")
public class AnnotationConsumerLauncher {

    public static void main(String...args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConsumerLauncher.class);
        context.start();
        DemoService demoService = context.getBean("demoService", DemoService.class);
        String hello = demoService.sayHello("Allen");
        System.out.println(hello);
    }

}
