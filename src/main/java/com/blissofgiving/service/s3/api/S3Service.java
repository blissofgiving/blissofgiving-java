package com.blissofgiving.service.s3.api;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service {

	String uploadFile(MultipartFile multipartFile) throws Exception;

	String deleteFileFromS3Bucket(String fileName);

	String getFileFromS3Bucket(String fileName);
}
