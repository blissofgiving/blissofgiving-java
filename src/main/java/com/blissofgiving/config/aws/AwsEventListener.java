package com.blissofgiving.config.aws;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component("AwsEventListener")
public class AwsEventListener implements ApplicationListener<ApplicationPreparedEvent> {
	private static final Logger LOGGER = LoggerFactory.getLogger(AwsEventListener.class);
	private final ObjectMapper mapper = new ObjectMapper();
	@Value("${aws.accessKey}")
	private String accessKeyId;
	@Value("${aws.accessKey}")
	private String accessKey;

	private void setProperty() {

	}

	@Override
	public void onApplicationEvent(ApplicationPreparedEvent event) {
		// Get username and password from AWS Secret Manager using secret name
//		String secretJson = getSecret();
//		String systemUserAccessKey = getString(secretJson, "aws.system.user.accesskey");
//		String systemUserSecretKey = getString(secretJson, "aws.system.user.secretkey");
//		String dynamoAccesskey = getString(secretJson, "aws.dynamo.accesskey");
//		String dynamoSecretkey = getString(secretJson, "aws.dynamo.secretkey");
//		String s3BucketName = getString(secretJson, "aws.s3.bucketName");
//		//String stripeApiKey = getString(secretJson, "stripe.apikey");
//		//String stripeSecretKey = getString(secretJson, "stripe.secretkey");
//		ConfigurableEnvironment environment = event.getApplicationContext().getEnvironment();
//		Properties props = new Properties();
//		System.setProperty("aws.system.user.accesskey", systemUserAccessKey);
//		System.setProperty("aws.system.user.secretkey", systemUserSecretKey);
//		System.setProperty("aws.dynamo.accesskey", dynamoAccesskey);
//		System.setProperty("aws.dynamo.secretkey", dynamoSecretkey);
//		System.setProperty("aws.s3.bucketName", s3BucketName);
		//System.setProperty("stripe.apikey", stripeApiKey);
		//System.setProperty("stripe.secretkey", stripeSecretKey);
	}

	private String getSecret() {
		String secretName = "BlissSecrets";
		String region = "us-east-1";
		// Create a Secrets Manager client
		setProperty();
		AWSCredentials credentials = new BasicAWSCredentials(System.getProperty("aws.accessKey"), System.getProperty("aws.secretKey"));
		AWSCredentialsProvider awsCredentialsProvider = new AWSStaticCredentialsProvider(credentials);
		AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard().withRegion(region).withCredentials(awsCredentialsProvider).build();
		String secret = null;
		GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest().withSecretId(secretName);
		GetSecretValueResult getSecretValueResult = null;
		try {
			getSecretValueResult = client.getSecretValue(getSecretValueRequest);
			// Decrypts secret using the associated KMS CMK.
			// Depending on whether the secret is a string or binary, one of these fields
			// will be populated.
			if (getSecretValueResult != null && getSecretValueResult.getSecretString() != null) {
				secret = getSecretValueResult.getSecretString();
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
		return secret;
	}

	private String getString(String json, String path) {
		try {
			JsonNode root = mapper.readTree(json);
			return root.path(path).asText();
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}
}
