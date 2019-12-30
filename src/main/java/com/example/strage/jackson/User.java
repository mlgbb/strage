package com.example.strage.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data//lombok工具使用，免set,get等方法手动生成
@NoArgsConstructor//无参构造函数
@AllArgsConstructor//有参构造函数
@JsonRootName("user")//根目录名称
public class User {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("NickName")
    private String nickName;
    @JsonProperty("Age")
    private int age;
    @JsonProperty("IdentityCode")
    private String identityCode;
    @JsonProperty()
    @JsonFormat(pattern = "yyyy-MM-DD")
    private LocalDate birthday;
}
