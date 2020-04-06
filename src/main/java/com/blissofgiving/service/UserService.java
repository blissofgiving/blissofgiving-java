package com.blissofgiving.service;

import com.blissofgiving.exception.BlissofgivingCheckedException;
import com.blissofgiving.exception.BlissofgivingRecordNotFoundException;
import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.exception.BlissofgivingValidationException;
import com.blissofgiving.model.User;
import org.springframework.stereotype.Service;

public interface UserService {

    User getUser(String username) throws BlissofgivingRecordNotFoundException;

    void addUser(User user) throws BlissofgivingServiceException, BlissofgivingValidationException;

    void updateUser(User user)throws BlissofgivingServiceException, BlissofgivingValidationException;

    void deleteUser(String username) throws BlissofgivingServiceException;
}
