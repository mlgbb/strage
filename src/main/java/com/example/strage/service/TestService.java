package com.example.strage.service;

import com.example.strage.dao.TestMapper;
import com.example.strage.pojo.WSCLDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public WSCLDto query() {
//        List<Map<String,String>> list = testMapper.query();
//        list.forEach(map -> {
//            map.forEach((k,v)->{
//                System.out.println("k:"+k+"  v:"+v);
//            });
//        });
        WSCLDto wsclDto = testMapper.query("2101000026");
        return new WSCLDto(){{
            setClnl("123");
            setXmmc("sywsc");
        }};
    }
}
