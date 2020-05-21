package com.allen.dubbo.xml.filter;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.apache.log4j.Logger;

@Activate(group = "consumer")
public class TestFilter implements Filter {

    private static Logger LOGGER = Logger.getLogger(TestFilter.class);

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        LOGGER.info("isProviderSide " + RpcContext.getContext().isProviderSide());
        LOGGER.info("isConsumerSide " + RpcContext.getContext().isConsumerSide());
        RpcContext.getContext().set("aaa", "000");
        RpcContext.getContext().setAttachment("xxx", "111");
        invocation.setAttachment("yyy", "222");
        return invoker.invoke(invocation);
    }

}
