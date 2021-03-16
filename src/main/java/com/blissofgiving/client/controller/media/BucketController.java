package com.blissofgiving.client.controller.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blissofgiving.service.s3.api.S3Service;

@RestController
@RequestMapping("/storage/")
@CrossOrigin(origins = {"http://blissofgiving-react-app.s3-website.us-east-2.amazonaws.com"})
public class BucketController {

	@Autowired
	private S3Service s3Service;

	@PostMapping("/uploadFile")
	public String uploadFile(@RequestPart(value = "file") MultipartFile file) throws Exception {
		String result = this.s3Service.uploadFile(file);
		return result;
	}

	@DeleteMapping("/deleteFile")
	public String deleteFile(@RequestPart(value = "fileName") String fileName) {
		return this.s3Service.deleteFileFromS3Bucket(fileName);
	}

	@GetMapping("/getFile")
	public String getFileUrl(@RequestPart(value = "fileName") String fileName) {
		return this.s3Service.getFileFromS3Bucket(fileName);
	}
}
