package com.example.strage.service;

import com.example.strage.pojo.Result;

/**
 * @description:策略模式的接口
 * */
public interface Strategy {

    String get(Result result);
}
