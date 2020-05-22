package com.allen.dubbo.iface;

public class DemoServiceStub implements DemoService {

    private final DemoService demoService;

    public DemoServiceStub(DemoService demoService) {
        this.demoService = demoService;
    }

    @Override
    public String sayHello(String name) {
        try {
            return demoService.sayHello(name);
        } catch (Exception e) {
            // 你可以容错，可以做任何AOP拦截事项
            return "容错数据";
        }
    }

    @Override
    public String sayHelloSlowly(String name) {
        try {
            return demoService.sayHelloSlowly(name);
        } catch (Exception e) {
            // 你可以容错，可以做任何AOP拦截事项
            return "容错数据";
        }
    }

}
