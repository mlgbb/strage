package com.example.strage.service.impl;

import com.example.strage.pojo.Result;
import com.example.strage.service.Strategy;
import org.springframework.stereotype.Component;

@Component("C")
public class RC implements Strategy {
    @Override
    public String get(Result result) {
        return result.getName();
    }
}
