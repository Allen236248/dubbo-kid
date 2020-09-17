package com.allen.dubbo.xml.listener;

import org.apache.dubbo.rpc.Exporter;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.listener.ExporterListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExportListener extends ExporterListenerAdapter {

    private static Logger LOGGER = LoggerFactory.getLogger(ExportListener.class);

    @Override
    public void exported(Exporter<?> exporter) throws RpcException {
        LOGGER.info("暴露服务：" + exporter.getInvoker().getInterface().getName());
    }

}
