package com.example.strage.cache.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

@Service
@CacheConfig(cacheNames = {"myCache"})
public class CacheService {

    /**
     * @description:id为1 才会走缓存，不等于1，不走缓存
     * */
    @Cacheable(key = "#id")
    public String getUserInfo(int id){
        System.out.println("没有进缓存");
        return "我是"+id+"号缓存";
    }

    /**
     * TODO:缓存策略？
     * */
    // 更新缓存
    @CachePut(key = "#id")
    public String updateC(String str ,int id){
        System.out.println("更新成功");
        return  str;
    }
    //删除缓存
    @CacheEvict(key = "#id")
    public Boolean deleteC(int id){
        System.out.println("删除成功");
        return true;
    }
}
