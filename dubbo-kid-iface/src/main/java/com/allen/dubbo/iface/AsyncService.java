package com.allen.dubbo.iface;

import java.util.concurrent.CompletableFuture;

public interface AsyncService {

    String asyncInvoke1(String name);

    //异步调用，需要声明范围类型为CompletableFuture<?>的签名类型
    CompletableFuture<String> asyncInvoke2(String name);

}
