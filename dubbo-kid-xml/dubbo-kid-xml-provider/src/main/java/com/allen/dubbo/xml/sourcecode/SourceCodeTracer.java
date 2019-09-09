package com.allen.dubbo.xml.sourcecode;

import org.apache.dubbo.common.config.CompositeConfiguration;
import org.apache.dubbo.common.config.SystemConfiguration;
import org.apache.dubbo.common.extension.ExtensionFactory;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.config.ConfigCenterConfig;
import org.apache.dubbo.config.context.ConfigManager;
import org.apache.dubbo.rpc.Protocol;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class SourceCodeTracer {

    public static void main(String... args) {
        ExtensionLoader.getExtensionLoader(ExtensionFactory.class).getAdaptiveExtension();

        ExtensionLoader loader = ExtensionLoader.getExtensionLoader(Protocol.class);
        loader.getAdaptiveExtension();
        loader.getExtension("registry");

        //Protocol REF_PROTOCOL = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();

        //Cluster CLUSTER = ExtensionLoader.getExtensionLoader(Cluster.class).getAdaptiveExtension();

        //ProxyFactory PROXY_FACTORY = ExtensionLoader.getExtensionLoader(ProxyFactory.class).getAdaptiveExtension();



        Map<String, String> map = new HashMap<String, String>();
        String v1 = map.computeIfAbsent("prefix", k -> new String("123"));
        String v2 = map.computeIfAbsent("prefix", k -> new String("456"));
        System.out.println(v1 + "," + v2);
    }
}
