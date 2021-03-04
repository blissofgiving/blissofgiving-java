package com.blissofgiving.dynamodbrepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;


@Configuration
public class BlissDynamoDBConfig {

	//@Value("amazon.aws.region")
	private String awsRegion = "us-east-2";

	//@Value("amazon.aws.accessKey")
	private String awsAccessKey = "AKIAXD3VKNFRU37SR2XS";

	//@Value("amazon.aws.secretKey")
	private String awsSecretKey = "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";

	public AWSCredentialsProvider amazonAWSCredentialsProvider() {
		return new AWSStaticCredentialsProvider(getAWSCredentials());
	}

	@Bean
	public AWSCredentials getAWSCredentials() {
		return new BasicAWSCredentials(awsAccessKey, awsSecretKey);
	}

	@Bean
	public DynamoDBMapperConfig dynamoDBMapperConfig() {
		return DynamoDBMapperConfig.DEFAULT;
	}

	@Bean
	public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig config) {
		return new DynamoDBMapper(amazonDynamoDB, config);
	}

	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		return AmazonDynamoDBClientBuilder.standard().withCredentials(amazonAWSCredentialsProvider()).withRegion(awsRegion).build();
	}

}
