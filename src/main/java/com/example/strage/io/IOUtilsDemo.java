package com.example.strage.io;


import java.io.*;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * @description:common-io中的IOUtils类（静态类）
 * */
@Component
public class IOUtilsDemo {

    public static void main(String[] args){

    }

    public void downloadFile(HttpServletResponse response){
        File file = new File("G:\\data\\资源目录结构\\cityLayer.json");
        try {
            InputStream is = new FileInputStream(file);
            OutputStream os = response.getOutputStream();
            IOUtils.copy(is,os);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
