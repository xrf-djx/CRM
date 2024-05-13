package com.bjpowernode.util;

public class ServiceFactory {
    //传实现类对象获取代理对象
    public static Object getService(Object service){
        //返回这个service对象的代理对象
        return new TransactionInvocationHandier(service).getProxy();
    }
}
