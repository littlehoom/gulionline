package com.guli.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.guli.oss.service.FileService;
import com.guli.oss.util.ConstantPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
@Service
public class FileServiceImpl implements FileService {
    @Override
    public String upload(MultipartFile file, String fileHost) throws IOException {
        // 获取阿里云存储相关常量
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        String accessKeyId = "LTAI8MchuLNHhvPP";
        String accessKeySecret = "VZkx5v5TuakyrPvJ3CsZH3bgsJgfdy";
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;
        String upLoadUrl = null;

        // 判断oss实例是否存在：如果不存在则创建，如果存在则获取
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        if (!ossClient.doesBucketExist(bucketName)){
            //创建oss实例
            ossClient.createBucket(bucketName);
            //设置oss实例的访问权限：公共读
            ossClient.setBucketAcl(bucketName,CannedAccessControlList.PublicRead);
        }


        // 上传文件流。
        InputStream inputStream = file.getInputStream();
        //构建日期路径：avatar/2019/02/25/文件名
        String filePath = new DateTime().toString("yyyy/MM/dd");
        
        //文件名:uuid.拓展名
        String original = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString();
        String fileType = original.substring(original.lastIndexOf("."));
        String newName = fileName + fileType;
        String fileUrl = fileHost + "/" + "/" + filePath + "/" + newName;
        ossClient.putObject(bucketName,fileUrl,inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();

        //获取url地址
        String uploadUrl = "http://" + bucketName + "." + endpoint + "/" + fileUrl;
        return uploadUrl;
    }
}
