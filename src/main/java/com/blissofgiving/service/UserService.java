package com.blissofgiving.service;

import com.blissofgiving.model.User;
import org.springframework.stereotype.Service;

public interface UserService {

    User getUser(String userID);
}
