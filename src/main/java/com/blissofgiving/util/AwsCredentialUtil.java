package com.blissofgiving.util;

import org.springframework.boot.SpringApplication;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;


public class AwsCredentialUtil {

	public static AWSCredentials getAWSCredentials() {
		AWSCredentials credentials = new BasicAWSCredentials(System.getProperty("aws.accessKey"), System.getProperty("aws.secretKey"));
		return credentials;
	}
}
