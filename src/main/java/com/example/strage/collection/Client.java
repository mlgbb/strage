package com.example.strage.collection;

public class Client {
    public static void main(String[] args){
        Context context;

        context = new Context(new StrategyAddition());
        //加法运算
        context.algorithm(1,2);

        context = new Context(new StrategyDevision());
        //减法运算
        context.algorithm(1,3);
    }
}
