package com.blissofgiving.service;

import com.blissofgiving.dao.UserDAO;
import com.blissofgiving.dynamodbmodel.User;
import com.blissofgiving.exception.BlissofgivingRecordNotFoundException;
import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.exception.BlissofgivingValidationException;
import com.blissofgiving.service.validator.UserServiceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserServiceValidator userServiceValidator;

    @Autowired
    UserDAO userDAO;

    @Override
    public User getUser(String userId) throws BlissofgivingRecordNotFoundException {
//        List<User> users = repository.findByUsername(username);
//        if(users == null || users.size() <= 0)
//            throw new BlissofgivingRecordNotFoundException("No record found for user: "+ username);
//        return users.get(0);
        User user = userDAO.getUser(userId);
        return user;
    }


    @Override
    public void addUser(User user) throws BlissofgivingServiceException, BlissofgivingValidationException {
        // Validate
        userServiceValidator.validateUser(user);

        //Save in to DB
        User savedUser = userDAO.save(user);
    }

    @Override
    public void updateUser(User user) throws BlissofgivingServiceException, BlissofgivingValidationException {
        // Validate
        //userServiceValidator.validateUser(user);
        //TODO update only if the user value is null
        if(user.getUserSysGUID() == null) {
            try {
                User userFromDB = getUser(user.getUserId());

                user.setUserSysGUID(userFromDB.getUserSysGUID());
            } catch (BlissofgivingRecordNotFoundException e) {
                throw new BlissofgivingServiceException("User is not availbale." + user.getUserId());
            }
        }
        //Save to DB
        User savedUser = userDAO.save(user);
    }

    @Override
    public void deleteUser(String userId) throws BlissofgivingServiceException {
        userDAO.deleteByUserId(userId);
    }
}
