package com.blissofgiving.service.media.api;

import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.model.Photos;
import com.blissofgiving.model.Video;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MediaService {
    String addMedia(String title, String type, MultipartFile file)throws BlissofgivingServiceException;

    String addVideo(String title, MultipartFile file) throws IOException;

    String addPhoto(String title, MultipartFile file) throws IOException;

    Video getVideo(String id) throws IllegalStateException, IOException;

    Photos getPhoto(String id);
}
