package com.allen.dubbo.xml.listener;

import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.listener.InvokerListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReferListener extends InvokerListenerAdapter {

    private static Logger LOGGER = LoggerFactory.getLogger(ReferListener.class);

    @Override
    public void referred(Invoker<?> invoker) throws RpcException {
        LOGGER.info("引用服务：" + invoker.getInterface().getName());
    }
}
