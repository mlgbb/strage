//package com.example.strage.controller;
//
//import com.example.strage.io.IOUtilsDemo;
//import io.swagger.annotations.Api;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.Mapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletResponse;
//
//@RestController
//@Api(tags = {"测试接口"})
//@RequestMapping("/test")
//public class TestController {
//
//    @Autowired
//    IOUtilsDemo ioUtilsDemo;
//
//    @GetMapping("/download")
//    public void downloadFile(HttpServletResponse response){
//        ioUtilsDemo.downloadFile(response);
//
//    }
//}
