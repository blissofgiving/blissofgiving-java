package com.blissofgiving.client.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blissofgiving.client.dto.UserDTO;
import com.blissofgiving.dynamodbmodel.User;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.blissofgiving.exception.BlissofgivingRecordNotFoundException;
import com.blissofgiving.exception.BlissofgivingValidationException;
import com.blissofgiving.service.UserService;

@Component
public class UserClientServiceImpl implements  UserClientService {

    @Autowired
    UserService userService;

    @Override
    public UserDTO getUser(String userId) throws BlissofgivingClientException {

        // Get the User from DB
        com.blissofgiving.dynamodbmodel.User user  = null;
        try {
            user = userService.getUser(userId);
        } catch (BlissofgivingRecordNotFoundException e) {
            throw new BlissofgivingClientException("User not found: " + e.getMessage());
        }

        //Create user DTO by copying properties.
        UserDTO userDTO = new UserDTO();

        BeanUtils.copyProperties(user,userDTO );

        return userDTO;

    }

    @Override
    public void addUser(UserDTO userDTO) throws BlissofgivingClientException, BlissofgivingValidationException {
        // Create User object from DTO data
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);

        //Save the User
        userService.addUser(user);

    }

    @Override
    public void updateUser(UserDTO userDTO) throws BlissofgivingClientException, BlissofgivingValidationException {
        // Create User object from DTO data
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);

        //Save the User
        userService.updateUser(user);
    }

    @Override
    public void deleteUser(String userId) throws BlissofgivingClientException {
        userService.deleteUser(userId);
    }
}
