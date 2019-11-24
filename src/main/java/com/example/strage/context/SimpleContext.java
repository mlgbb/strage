package com.example.strage.context;

import com.example.strage.pojo.Result;
import com.example.strage.service.Strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/***、
 *@description:通过Spring将实现Strategy的实现类都自动注入到strategyMap类中，
 * 当用户传入选择的资源池时，自动根据资源池id去对应的资源池实现中查找资源。
 *
 */
@Service
public class SimpleContext {
    @Autowired
    private Map<String, Strategy> strategyMap = new ConcurrentHashMap<>();

    public SimpleContext(Map<String,Strategy> strategyMap){
        this.strategyMap.clear();
        strategyMap.forEach((k,v)->this.strategyMap.put(k,v));
    }

    public String getResource(Result result){
        return strategyMap.get(result.getId()).get(result);
    }
}
