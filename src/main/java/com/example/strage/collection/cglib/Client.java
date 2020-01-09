package com.example.strage.collection.cglib;

public class Client {

    public static void main(String[] args){
        //创建一个被代理类的对象
        IGamePlayer gamePlayer = new GamePlayer();
        //创建一个实现了InvocationHandler实现类的对象
        MyinvocationHandler handler = new MyinvocationHandler();

        //获取代理对象
        IGamePlayer proxy = (IGamePlayer) handler.getProxy(gamePlayer);
        //代理对象去玩
        proxy.play();
    }
}
