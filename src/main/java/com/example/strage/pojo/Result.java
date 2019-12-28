package com.example.strage.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:统一返回的实体类
 * */
@Data
public class Result {
    private int id;
    private String name;
    private String nickName;

    public void smoke(){
        System.out.println("can smoking");
    }
}