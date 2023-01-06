package com.blissofgiving.service.media.api;

import java.util.List;

import com.blissofgiving.exception.BlissofgivingServiceException;
import org.springframework.web.multipart.MultipartFile;

public interface MediaService {
    String addMedia(String title, String type, MultipartFile file)throws BlissofgivingServiceException;

    String uploadMediaStorage(String title, MultipartFile file) throws Exception;

    String getMediaLink(String fileName) throws Exception;

	List<String> getMediaLinks(String fileName);
}
