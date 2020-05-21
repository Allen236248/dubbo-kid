package com.allen.dubbo.xml.provider;

import com.allen.dubbo.iface.DemoService;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);

    public String sayHello(String name) {
        LOGGER.info("" + RpcContext.getContext().get("xxx"));
        LOGGER.info("" + RpcContext.getContext().getAttachment("aaa"));
        LOGGER.info("" + RpcContext.getContext().isProviderSide());
        LOGGER.info("" + RpcContext.getContext().isConsumerSide());
        LOGGER.info("XML:Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "XML:Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress();
    }
}
