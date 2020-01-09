package com.example.strage.collection.cglib.demo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @description:基于cglib实现的动态代理
 * */

public class CglibProxy implements MethodInterceptor {

    //获取用户信息的方法名
    private static final String METHOD_GET_USERINFO = "getUserInfo";

    private CglibProxy(){

    }
    //单例模式获取代理类对象
    private static CglibProxy proxy = new CglibProxy();
    public static CglibProxy getInstance(){
        return proxy;
    }

    //获取被代理后的目标类
    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> clazz){
        return (T) Enhancer.create(clazz,this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        long start = System.currentTimeMillis();
        if (METHOD_GET_USERINFO.equals(method.getName())){//获取用户信息的方法
            if (checkIsLogined()){//检验是否登录
                result = methodProxy.invokeSuper(o,objects);
            }
        } else {
            //非获取用户信息的方法，不需要校验
            result = methodProxy.invokeSuper(o,objects);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start)+"毫秒");
        return result;
    }
    private boolean checkIsLogined() {
        Random r = new Random();
        int i = r.nextInt(10);
        if (i % 2 == 0) {
            System.out.println("已登录");
            return true;
        }
        System.out.println("未登录");
        return false;
    }
}
