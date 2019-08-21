package com.allen.dubbo.annotation.consumer;

import com.allen.dubbo.iface.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component("demoService")
public class DemoServiceConsumer implements DemoService {

    @Reference
    private DemoService demoService;

    public String sayHello(String name) {
        return demoService.sayHello(name);
    }
}
