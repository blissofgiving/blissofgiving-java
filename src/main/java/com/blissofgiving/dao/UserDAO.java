package com.blissofgiving.dao;

import com.blissofgiving.dynamodbmodel.User;

public interface UserDAO {
	public User getUser(String userId);

	User save(User user);

	void deleteByUserId(String userId);
}
