package com.blissofgiving.service.media.api;

import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.model.Photos;
import com.blissofgiving.model.Video;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MediaService {
    String addMedia(String title, String type, MultipartFile file)throws BlissofgivingServiceException;

    String uploadMediaStorage(String title, MultipartFile file) throws Exception;

    String getMediaLink(String fileName) throws Exception;
}
