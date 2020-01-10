package com.example.strage.controller;

import com.example.strage.cache.service.CacheService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/user")
    public String upUserInfo(int id,String str){return  cacheService.updateC(str, id);}
    @DeleteMapping("/user")
    public Boolean deUserInfo(int id){return  cacheService.deleteC(id);}
}
