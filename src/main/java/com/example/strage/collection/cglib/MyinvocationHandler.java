package com.example.strage.collection.cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:定义动态代理类，都要实现InvocationHandler接口
 * */
public class MyinvocationHandler implements InvocationHandler {
    //实现了接口的被代理类对象的声明
    Object object;

    //1、给被代理类的对象实例化；2、返回一个代理类的对象
    public Object getProxy(Object object){
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    //当通过代理类的对象发起对被重写的方法时，转换为对以下invoke方法的调用
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnVal = method.invoke(object,args);
        return returnVal;
    }
}
