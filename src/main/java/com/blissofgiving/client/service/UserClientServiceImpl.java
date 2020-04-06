package com.blissofgiving.client.service;

import com.blissofgiving.client.dto.UserDTO;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.blissofgiving.exception.BlissofgivingRecordNotFoundException;
import com.blissofgiving.exception.BlissofgivingValidationException;
import com.blissofgiving.model.User;
import com.blissofgiving.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserClientServiceImpl implements  UserClientService {

    @Autowired
    UserService userService;

    @Override
    public UserDTO getUser(String username) throws BlissofgivingClientException {

        // Get the User from DB
        User user  = null;
        try {
            user = userService.getUser(username);
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
    public void deleteUser(String username) throws BlissofgivingClientException {
        userService.deleteUser(username);
    }
}
