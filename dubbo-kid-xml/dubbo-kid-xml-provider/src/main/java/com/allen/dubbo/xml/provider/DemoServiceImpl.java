package com.allen.dubbo.xml.provider;

import com.allen.dubbo.iface.DemoService;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public String sayHello(String name) {
        LOGGER.info("XML:Hello " + name);
        return "XML:Hello " + name;
    }

    @Override
    public String sayHelloSlowly(String name) {
        LOGGER.info("XML:Hello " + name);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "XML:Hello " + name;
    }

}
