package com.example.strage.controller;

import com.example.strage.io.IOUtilsDemo;
import com.example.strage.pojo.WSCLDto;
import com.example.strage.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@Api(tags = {"测试接口"})
@RequestMapping("/test")
public class TestController {

    @Autowired
    IOUtilsDemo ioUtilsDemo;

    @Autowired
    TestService testService;

    @GetMapping("/download")
    public void downloadFile(HttpServletResponse response){
        ioUtilsDemo.downloadFile(response);
    }

    /**
     * @api {get} /index/:userName
     * @apiDescription  这只是一个测试的接口描述
     * @apiName index
     * @apiParam {String} userName 用户的姓名
     * @apiParam {Number} userAge 用户的年龄
     * @apiParamExample {json} Request-Example:
     * {
     *     "userName":"caojing",
     *     "userAge":12
     * }
     * @apiGroup index
     * @apiError userNotFound  The <code>id</code>
     * @apiSampleRequest /index
     */
    @ResponseBody
    @CrossOrigin
    @GetMapping("/query")
    public WSCLDto query(){
        return testService.query();
    }
}
