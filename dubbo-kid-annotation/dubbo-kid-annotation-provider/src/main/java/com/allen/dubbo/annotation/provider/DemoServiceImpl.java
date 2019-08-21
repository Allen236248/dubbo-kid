package com.allen.dubbo.annotation.provider;

import com.allen.dubbo.iface.DemoService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class DemoServiceImpl implements DemoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);

    public String sayHello(String name) {
        LOGGER.info("Annotation:Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Annotation:Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress();
    }
}
