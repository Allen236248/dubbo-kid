package com.allen.dubbo.api.config.center;

import com.allen.dubbo.api.config.center.provider.DemoServiceImpl;
import com.allen.dubbo.iface.DemoService;
import org.apache.dubbo.config.*;

public class ApiConfigCenterProviderLauncher {

    public static void main(String...args) {
        ConfigCenterConfig configCenterConfig = new ConfigCenterConfig();
        configCenterConfig.setProtocol("zookeeper");
        configCenterConfig.setAddress("10.10.50.120:2181");

        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-kid-api-config-center-provider");

        ServiceConfig<DemoService> serviceConfig = new ServiceConfig<DemoService>();
        serviceConfig.setConfigCenter(configCenterConfig);
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setInterface(DemoService.class);
        serviceConfig.setRef(new DemoServiceImpl());

        serviceConfig.export();

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
