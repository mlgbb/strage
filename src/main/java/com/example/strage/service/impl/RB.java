package com.example.strage.service.impl;

import com.example.strage.pojo.Result;
import com.example.strage.service.Strategy;
import org.springframework.stereotype.Component;

@Component("B")
public class RB implements Strategy {
    @Override
    public String get(Result result) {
        return result.getName();
    }
}
