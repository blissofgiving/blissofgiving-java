package com.blissofgiving.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.blissofgiving.dynamodbmodel.User;
import com.blissofgiving.dynamodbrepository.BlissDynamoDBConfig;

@Service
public class UserDAOImpl implements UserDAO {

	@Autowired
	private BlissDynamoDBConfig blissDynamoDBConfig;

	private DynamoDBMapper getDynamoDBMapper() {
		DynamoDBMapper dynamoDBMapper = blissDynamoDBConfig.dynamoDBMapper(blissDynamoDBConfig.amazonDynamoDB(), blissDynamoDBConfig.dynamoDBMapperConfig());
		return dynamoDBMapper;
	}

	public User getUser(String userId){
		DynamoDBMapper dynamoDBMapper = getDynamoDBMapper();
		User user =  dynamoDBMapper.load(User.class, userId);
		return user;
	}

	@Override
	public User save(User user) {
		getDynamoDBMapper().save(user);
		return user;
	}

	@Override
	public void deleteByUserId(String userId) {
		User user = new User();
		user.setUserId(userId);
		getDynamoDBMapper().delete(user);
	}
}
