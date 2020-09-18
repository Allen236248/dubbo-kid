package com.allen.dubbo.xml.demotion;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionFactory;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.registry.Registry;
import org.apache.dubbo.registry.RegistryFactory;
import org.apache.dubbo.rpc.Protocol;

/**
 * ExtensionLoader实现机制揭秘
 */
public class ExtensionLoaderUncover {

    public static void main(String...args) {
        loadProtocol();
//        loadExtensionFactory();
    }

    public static void loadProtocol() {
        ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();
    }

    public static void loadExtensionFactory() {
        ExtensionLoader.getExtensionLoader(ExtensionFactory.class).getAdaptiveExtension();
    }

    /**
     * 通过服务降级临时屏蔽某个出错的非关键服务，并定义降级后的返回策略。
     * <ul>
     * <li>mock=force:return+null 表示消费方对该服务的方法调用都直接返回 null 值，不发起远程调用。用来屏蔽不重要服务不可用时对调用方的影响。</li>
     * <li>mock=fail:return+null 表示消费方对该服务的方法调用失败后返回 null 值，不抛异常。用来容忍不重要服务不稳定时对调用方的影响。</li>
     * </ul>
     */
    public static void demotion() {
        RegistryFactory registryFactory = ExtensionLoader.getExtensionLoader(RegistryFactory.class).getAdaptiveExtension();
        Registry registry = registryFactory.getRegistry(URL.valueOf("zookeeper://10.10.50.120:2181"));
        registry.register(URL.valueOf("override://0.0.0.0/com.foo.BarService?category=configurators&dynamic=false&application=foo&mock=force:return+null"));
    }
}
