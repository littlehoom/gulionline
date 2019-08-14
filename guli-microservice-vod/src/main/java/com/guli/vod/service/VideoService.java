package com.guli.vod.service;

import org.springframework.web.multipart.MultipartFile;

public interface VideoService {
    String uploadVideo(MultipartFile file);

    void removeVideo(String videoId);

    String getVideoPlayAuth(String videoId);

}