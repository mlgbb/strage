package com.example.strage.springbootdemo.controller;

import com.example.strage.springbootdemo.comm.pojo.FastDFSFile;
import com.example.strage.springbootdemo.comm.utils.FastDFSClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@Slf4j
public class UploadController {

    public static String UPLOADED_FOLDER = "G:\\springbootDemo\\";

    @GetMapping("/")
    public String index(){
        return "upload";
    }

    /**
     * @description:单文件上传
     * */
    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file")MultipartFile file){
        if (file.isEmpty()){
            return "Please select a file to upload";
        }
        try {
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(UPLOADED_FOLDER+file.getOriginalFilename());
//            Files.write(path,bytes);
            String path = saveFile(file);
            return path;
        }catch (IOException e){
            e.printStackTrace();
        }
        return "fail";
    }

    @PostMapping("/uploadMore")
    public String moreFileUpload(@RequestParam("file")MultipartFile[] files){
        if (files.length == 0){
            return "please select a file to upload";
        }
        for (MultipartFile file:files){
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER+file.getOriginalFilename());
                Files.write(path,bytes);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return "you successfully upload all files";
    }

    private String saveFile(MultipartFile multipartFile) throws IOException {
        String[] fileAbsolutePath = {};
        String fileName = multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".")+1);
        byte[] file_buff = null;
        InputStream inputStream = multipartFile.getInputStream();
        if (inputStream != null){
            int len1 = inputStream.available();
            file_buff = new byte[len1];
            inputStream.read(file_buff);
        }
        inputStream.close();
        FastDFSFile file = new FastDFSFile(fileName,file_buff,ext);
        try {
            fileAbsolutePath = FastDFSClient.upload(file);
        }catch (Exception e){
            log.error("upload file Exception!",e);
        }
        if (fileAbsolutePath == null){
            log.error("upload file failed,please upload again");
        }
        String path = FastDFSClient.getTrackerUrl()+fileAbsolutePath[0]+ File.separator+fileAbsolutePath[1];
        return path;
    }
}
