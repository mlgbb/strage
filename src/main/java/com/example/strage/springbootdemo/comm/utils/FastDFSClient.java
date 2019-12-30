package com.example.strage.springbootdemo.comm.utils;

import com.example.strage.springbootdemo.comm.pojo.FastDFSFile;
import lombok.extern.slf4j.Slf4j;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description：文件工具类
 * */
@Slf4j
public class FastDFSClient {
    static {
        try {
            String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath() ;
            //读取配置文件，并初始化对应的属性
            ClientGlobal.init(filePath);
        } catch (Exception e){
            log.error("FastDFS Client Init Fail!",e);
        }
    }

    /**
     * @description:上传文件
     * */
    public static String[] upload(FastDFSFile file){
        log.info("File Name:"+file.getName()+"File Length:"+file.getContent().length);

        //文件属性信息
        NameValuePair[] metaList = new NameValuePair[1];
        metaList[0] = new NameValuePair("author",file.getAuthor());

        long startTime = System.currentTimeMillis();
        String[] uploadResults = null;
        StorageClient storageClient = null;
        try {
            //获取客户端
//            storageClient = getStorageClient();
            TrackerClient trackerClient = new TrackerClient();
//4.创建一个TrakerServer对象
            TrackerServer trackerServer = trackerClient.getConnection();
//5.声明一个StorageServer
            StorageServer storageServer = null;
            storageClient = new StorageClient(trackerServer,storageServer);
            //上传
            uploadResults = storageClient.upload_file(file.getContent(),file.getExt(),metaList);
        } catch (IOException e){
            log.error("IO Exception when upload the file:"+file.getName(),e);
        } catch (Exception e) {
            log.error("Non IO exception when uploading the file:"+file.getName(),e);
        }
        log.info("upload_file time used :"+(System.currentTimeMillis()-startTime));

        //验证上传结果
        if (uploadResults == null && storageClient != null){
            log.error("upload file fail ,error code:"+storageClient.getErrorCode());
        }
        //文件上传成功会返回groupName
        log.info("upload file successfully!!!"+"group_name:"+uploadResults[0]+",remoteFileName: "+uploadResults[1]);
        return  uploadResults;
    }

    private static StorageClient getStorageClient() throws IOException {
        TrackerServer trackerServer = getTrackerServer();
        StorageClient storageClient = new StorageClient(trackerServer,null);
        return storageClient;
    }

    private static TrackerServer getTrackerServer() throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerServer;
    }

    /**
     * @description:获取文件
     * */
    public static FileInfo getFile(String groupName,String remoteFileName){
        try {
//            StorageClient storageClient = getStorageClient();
            TrackerClient trackerClient = new TrackerClient();
//4.创建一个TrakerServer对象
            TrackerServer trackerServer = trackerClient.getConnection();
//5.声明一个StorageServer
            StorageServer storageServer = null;
            StorageClient storageClient = new StorageClient(trackerServer,storageServer);
            return storageClient.get_file_info(groupName,remoteFileName);
        } catch (IOException e){
            log.error("IO Exception : Get File from Fast DFS failed",e);
        } catch (Exception e){
            log.error("Non IO Exception: Get File from Fast DFS failed",e);
        }
        return null;
    }

    /**
     * @description:下载文件
     * */
    public static InputStream downFile(String groupName,String remoteFileName){
        try {
            StorageClient storageClient = getStorageClient();
            byte[] fileByte = storageClient.download_file(groupName,remoteFileName);
            InputStream inputStream = new ByteArrayInputStream(fileByte);
            return inputStream;
        } catch(IOException e){
            log.error("IO Exception : Get File from Fast DFS failed",e);
        } catch(Exception e){
            log.error("Non IO Exception : Get File from Fast DFS failed",e);
        }
        return null;
    }

    /**
     * @description:删除文件
     * */
    public static void deleteFile(String groupName,String remoteFileName) throws Exception {
        StorageClient storageClient = getStorageClient();
        int i = storageClient.delete_file(groupName,remoteFileName);
        log.info("delete file successfully!!!"+i);
    }

    /**
     * @description：获得一个网络url
     * */
    public static String getTrackerUrl() throws IOException {
        return "http://"+getTrackerServer().getInetSocketAddress().getHostString()+":"+ClientGlobal.getG_tracker_http_port()+"/";
    }
    /**
     * @description:将文件上传至fastDFS并返回文件的地址信息
     * */
    public String saveFile(MultipartFile multipartFile) throws IOException {
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

    public static ServerInfo[] getFetchStorage(String groupName,String remoteFileName) throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerClient.getFetchStorages(trackerServer,groupName,remoteFileName);
    }

}
