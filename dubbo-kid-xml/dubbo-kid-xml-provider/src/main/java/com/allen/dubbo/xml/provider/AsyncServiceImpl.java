package com.allen.dubbo.xml.provider;

import com.allen.dubbo.iface.AsyncService;
import com.allen.dubbo.iface.DemoService;
import org.apache.dubbo.rpc.AsyncContext;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@Service
public class AsyncServiceImpl implements AsyncService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncServiceImpl.class);

    @Override
    public String asyncInvoke1(String name) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "异步调用 " + name + ", " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        //异步实现
        //return async(name);
    }

    private String async(final String name) {
        AsyncContext asyncContext = RpcContext.startAsync();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 如果要使用上下文，则必须要放在第一句执行
                asyncContext.signalContextSwitch();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 写回响应
                asyncContext.write("异步调用 " + name + ", " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            }
        }).start();
        return null;
    }

    @Override
    public CompletableFuture<String> asyncInvoke2(String name) {
        System.out.println(RpcContext.getContext().getAttachment("key1"));

        // 建议为supplyAsync提供自定义线程池，避免使用JDK公用线程池
        return CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                //进入异步处理逻辑，RpcContext已经发生变化
                String attachment = RpcContext.getContext().getAttachment("key1");
                System.out.println(attachment + ", " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "异步调用 " + name + ", " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            }
        });
    }
}
