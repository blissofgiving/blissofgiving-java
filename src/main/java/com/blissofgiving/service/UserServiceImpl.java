package com.blissofgiving.service;

import com.blissofgiving.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(String userID) {

        User user = new User(); //TODO temp
        user.setFirstName("Bliss");
        user.setLastName("Giving");
        user.setUserID(userID);
        return user;
    }
}
