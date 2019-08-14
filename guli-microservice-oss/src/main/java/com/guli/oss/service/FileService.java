package com.guli.oss.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
public interface FileService {
    /**
     * 文件上传到阿里云
     * @param file
     * @param fileHost
     * @return
     */
    String upload(MultipartFile file,String fileHost)throws IOException;
}
