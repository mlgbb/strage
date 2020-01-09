package com.example.strage.collection;

public class StrategyDevision extends Strategy{
    @Override
    public Double algorithm(int x, int y) {
        Double r = Double.valueOf(x>y?x-y:y-x);
        System.out.println("减法运算："+r);
        //减法
        return r;
    }
}
