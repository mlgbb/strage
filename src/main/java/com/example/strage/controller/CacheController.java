package com.example.strage.controller;

import com.example.strage.cache.service.CacheService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"测试缓存接口"})
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    CacheService cacheService;

    @GetMapping("/user")
    public String getUserInfo(int id){
        return cacheService.getUserInfo(id);
    }
}
