package com.example.strage.service.impl;

import com.example.strage.pojo.Result;
import com.example.strage.service.Strategy;
import org.springframework.stereotype.Component;

/**
 * @description:第一种情形
 * */
@Component("A")
public class RA implements Strategy {
    @Override
    public String get(Result result) {
        return result.getName();
    }
}
