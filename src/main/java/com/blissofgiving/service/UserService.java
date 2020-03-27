package com.blissofgiving.service;

import com.blissofgiving.exception.BlissofgivingRecordNotFoundException;
import com.blissofgiving.model.User;
import org.springframework.stereotype.Service;

public interface UserService {

    User getUser(String username) throws BlissofgivingRecordNotFoundException;

    void saveUser(User user);
}
