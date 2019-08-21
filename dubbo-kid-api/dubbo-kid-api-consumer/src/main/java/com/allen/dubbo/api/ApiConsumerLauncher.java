package com.allen.dubbo.api;

import com.allen.dubbo.iface.DemoService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

public class ApiConsumerLauncher {

    public static void main(String...args) {
        boolean isDirect = true;

        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-kid-api-consumer");
        applicationConfig.setOwner("Allen.W");

        RegistryConfig registryConfig = null;
        if(!isDirect) {
            registryConfig = new RegistryConfig();
            registryConfig.setProtocol("zookeeper");
            registryConfig.setAddress("10.10.50.120:2181");
        }

        ReferenceConfig<DemoService> referenceConfig = new ReferenceConfig<DemoService>();
        referenceConfig.setApplication(applicationConfig);
        if(!isDirect) {
            referenceConfig.setRegistry(registryConfig);
        } else {
            System.out.println("直连");
            referenceConfig.setUrl("dubbo://192.168.9.49:20880/com.allen.dubbo.iface.DemoService");
        }
        referenceConfig.setInterface(DemoService.class);
        DemoService demoService = referenceConfig.get();
        String hello = demoService.sayHello("Allen");
        System.out.println(hello);
    }
}
