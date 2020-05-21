package com.allen.dubbo.xml.consumer;

import com.allen.dubbo.iface.ConsumerAction;
import com.allen.dubbo.iface.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerActionImpl implements ConsumerAction {

    @Autowired
    private DemoService demoService;

    @Override
    public void consume() {
        String hello = demoService.sayHello("Allen");
        System.out.println(hello);
    }

}
