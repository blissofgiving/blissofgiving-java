package com.blissofgiving.service.media.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.service.media.api.MediaService;
import com.blissofgiving.service.s3.api.S3Service;

@Service
public class MediaServiceImpl implements MediaService {

	@Autowired
	private S3Service storageService;

	@Override
	public String addMedia(String title, String type, MultipartFile file) throws BlissofgivingServiceException {
		String mediaObjectId = null;
		try {
			mediaObjectId = uploadMediaStorage(title, file);
		} catch (Exception e) {
			throw new BlissofgivingServiceException(e);
		}
		return mediaObjectId;
	}

	@Override
	public String uploadMediaStorage(String title, MultipartFile file) throws Exception {
		String fileID = storageService.uploadFile(file);
		return fileID;
	}

	@Override
	public String getMediaLink(String fileName) throws IOException {
		return storageService.getFileFromS3Bucket(fileName);
	}

	@Override
	public List<String> getMediaLinks(String fun) {
		return null;
	}
}
