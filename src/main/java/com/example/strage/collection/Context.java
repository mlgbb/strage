package com.example.strage.collection;

public class Context {

    Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public Double algorithm(int x ,int y) {
        return strategy.algorithm(x,y);
    }


}
