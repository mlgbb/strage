package com.example.strage.collection;

public class StrategyAddition extends Strategy{

    @Override
    public Double algorithm(int x, int y) {
        int r = x+y;
        System.out.println("加法运算："+r);
        //加法运算
        return Double.valueOf(x+y);
    }
}
