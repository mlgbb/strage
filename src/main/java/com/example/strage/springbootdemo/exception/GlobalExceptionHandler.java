package com.example.strage.springbootdemo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @description:全局异常捕获
 * */

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @description:监控文件大小是否首先
     * */
    @ExceptionHandler(MultipartException.class)
    public String handleError1(MultipartException e){
        return "1";
    }
}
