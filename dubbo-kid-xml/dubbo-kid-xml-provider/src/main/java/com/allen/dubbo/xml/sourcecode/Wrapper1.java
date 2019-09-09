package com.allen.dubbo.xml.sourcecode;

public class Wrapper1 extends org.apache.dubbo.common.bytecode.Wrapper {

    public static String[] pns; //属性名
    public static java.util.Map pts; //属性类型
    public static String[] mns = new String[]{"sayHello"}; //方法名
    public static String[] dmns = new String[]{"sayHello"}; //声明的方法名
    public static Class[] mts0 = new Class[]{String.class}; //参数类型

    public Wrapper1() {

    }

    public String[] getPropertyNames() {
        return pns;
    }

    public boolean hasProperty(String n) {
        return pts.containsKey(n);
    }

    public Class getPropertyType(String n) {
        return (Class) pts.get(n);
    }

    public String[] getMethodNames() {
        return mns;
    }

    public String[] getDeclaredMethodNames() {
        return dmns;
    }

    public void setPropertyValue(Object o, String n, Object v) {
        com.allen.dubbo.iface.DemoService w;
        try {
            w = ((com.allen.dubbo.iface.DemoService) o);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
        throw new org.apache.dubbo.common.bytecode.NoSuchPropertyException("Not found property " + n + " field or setter method in class com.allen.dubbo.iface.DemoService.");
    }


    public Object getPropertyValue(Object o, String n) {
        com.allen.dubbo.iface.DemoService w;
        try {
            w = ((com.allen.dubbo.iface.DemoService) o);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
        throw new org.apache.dubbo.common.bytecode.NoSuchPropertyException("Not found property " + n + " field or setter method in class com.allen.dubbo.iface.DemoService.");
    }


    public Object invokeMethod(Object o, String n, Class[] p, Object[] v) throws java.lang.reflect.InvocationTargetException {
        com.allen.dubbo.iface.DemoService w;
        try {
            w = ((com.allen.dubbo.iface.DemoService) o);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
        try {
            if ("sayHello".equals(n) && p.length == 1) {
                return w.sayHello((java.lang.String) v[0]);
            }
        } catch (Throwable e) {
            throw new java.lang.reflect.InvocationTargetException(e);
        }
        throw new org.apache.dubbo.common.bytecode.NoSuchMethodException("Not found method " + n + " in class com.allen.dubbo.iface.DemoService.");
    }
}
