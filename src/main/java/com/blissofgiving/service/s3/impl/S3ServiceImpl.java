package com.blissofgiving.service.s3.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.blissofgiving.service.s3.api.S3Service;

@Service
public class S3ServiceImpl implements S3Service {
	@Autowired
	private AmazonS3 amazonS3Client;

	@Value("${aws.s3.bucketName}")
	private String bucketName;

	public AmazonS3 getAmazonS3Client() {
		return amazonS3Client;
	}

	public void setAmazonS3Client(AmazonS3 amazonS3Client) {
		this.amazonS3Client = amazonS3Client;
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	@Override
	public String uploadFile(final MultipartFile multipartFile) throws Exception {
		try {
			final File file = convertMultiPartFileToFile(multipartFile);
			PutObjectResult result = uploadFileToS3Bucket(getBucketName(), file);
			file.delete();  // To remove the file locally created in the project folder.
			return result.getMetadata().getUserMetadata().get("fileName");
		} catch (final AmazonServiceException ex) {
			throw ex;
		}
	}

	@Override
	public String deleteFileFromS3Bucket(String fileName) {
		getAmazonS3Client().deleteObject(new DeleteObjectRequest(bucketName, fileName));
		return "Successfully deleted";
	}

	@Override
	public String getFileFromS3Bucket(String fileName) {
		boolean isFilePresent = getAmazonS3Client().doesObjectExist(bucketName, fileName);
		String fileURL = isFilePresent ? getAmazonS3Client().getUrl(bucketName, fileName).toString() : "File not present in S3";
		return fileURL;
	}

	private File convertMultiPartFileToFile(final MultipartFile multipartFile) throws Exception {
		final File file = new File(multipartFile.getOriginalFilename());
		try (final FileOutputStream outputStream = new FileOutputStream(file)) {
			outputStream.write(multipartFile.getBytes());
		} catch (final IOException ex) {
			throw ex;
		}
		return file;
	}

	private PutObjectResult uploadFileToS3Bucket(final String bucketName, final File file) {
		final String uniqueFileName = LocalDateTime.now() + "_" + file.getName();
		final PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, uniqueFileName, file);
		PutObjectResult result = getAmazonS3Client().putObject(putObjectRequest);
		result.getMetadata().addUserMetadata("fileName", uniqueFileName);
		return result;
	}
}
