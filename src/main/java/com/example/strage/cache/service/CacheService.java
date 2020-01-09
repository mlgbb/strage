package com.example.strage.cache.service;

import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

@Service
public class CacheService {

    /**
     * @description:id为1 才会走缓存，不等于1，不走缓存
     * */
    @Cacheable(cacheNames = "getUserInfo",key = "#id",condition = "#id==1")
    public String getUserInfo(int id){
        if (id==1){
            for (int i = 1 ; i<10;i++){
                System.out.println("没走缓存");
            }
            return "xmcx";
        }else{
            for (int i = 1 ; i<10;i++){
                System.out.println("没走缓存");
            }
            return "dgqb";
        }
    }

    /**
     * TODO:缓存策略？
     * */
}
