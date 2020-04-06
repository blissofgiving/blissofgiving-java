package com.blissofgiving.service;

import com.blissofgiving.exception.BlissofgivingRecordNotFoundException;
import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.exception.BlissofgivingValidationException;
import com.blissofgiving.model.User;
import com.blissofgiving.repository.UserRepository;
import com.blissofgiving.service.validator.UserServiceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    UserServiceValidator userServiceValidator;

    @Override
    public User getUser(String username) throws BlissofgivingRecordNotFoundException {
        List<User> users = repository.findByUsername(username);
        if(users == null || users.size() <= 0)
            throw new BlissofgivingRecordNotFoundException("No record found for user: "+ username);
        return users.get(0);
//        User user =  new User();
//        user.setUsername("bliss");
//        user.setPassword("bliss");
//        return user;
    }


    @Override
    public void addUser(User user) throws BlissofgivingServiceException, BlissofgivingValidationException {
        // Validate
        userServiceValidator.validateUser(user);

        //Save in to DB
        User savedUser = repository.save(user);
    }

    @Override
    public void updateUser(User user) throws BlissofgivingServiceException, BlissofgivingValidationException {
        // Validate
        userServiceValidator.validateUser(user);
        // TODO shashi get the user and update only new values
        //Save in to DB
        User savedUser = repository.save(user);
    }

    @Override
    public void deleteUser(String username) throws BlissofgivingServiceException {
        repository.deleteByUsername(username);
    }
}
