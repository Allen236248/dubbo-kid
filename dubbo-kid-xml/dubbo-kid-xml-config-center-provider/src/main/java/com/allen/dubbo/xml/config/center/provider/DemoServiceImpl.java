package com.allen.dubbo.xml.config.center.provider;

import com.allen.dubbo.iface.DemoService;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);

    public String sayHello(String name) {
        LOGGER.info("XML:Config-Center:Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "XML:Config-Center:Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress();
    }
}
