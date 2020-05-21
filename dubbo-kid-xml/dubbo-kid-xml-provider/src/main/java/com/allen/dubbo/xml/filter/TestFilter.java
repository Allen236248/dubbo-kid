package com.allen.dubbo.xml.filter;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.apache.log4j.Logger;

@Activate(group = "provider")
public class TestFilter implements Filter {

    private static Logger LOGGER = Logger.getLogger(TestFilter.class);

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        LOGGER.info("isProviderSide " + RpcContext.getContext().isProviderSide());
        LOGGER.info("isConsumerSide " + RpcContext.getContext().isConsumerSide());

        LOGGER.info(RpcContext.getContext().get("aaa"));
        LOGGER.info(RpcContext.getContext().getAttachment("xxx"));
        LOGGER.info(invocation.getAttachment("yyy"));

        RpcContext.getContext().set("111", "xxx");
        return invoker.invoke(invocation);
    }

}
