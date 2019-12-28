package com.example.strage.dao;

import com.example.strage.pojo.WSCLDto;
import org.apache.ibatis.annotations.Param;

public interface TestMapper {

    WSCLDto query(@Param("xmdm") String xmdm);
}
