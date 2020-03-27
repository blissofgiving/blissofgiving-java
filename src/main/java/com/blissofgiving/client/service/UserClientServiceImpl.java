package com.blissofgiving.client.service;

import com.blissofgiving.client.dto.UserDTO;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.blissofgiving.exception.BlissofgivingRecordNotFoundException;
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

        User user  = null;
        try {
            user = userService.getUser(username);
        } catch (BlissofgivingRecordNotFoundException e) {
            throw new BlissofgivingClientException("User not found: " + e.getMessage());
        }

        UserDTO userDTO = new UserDTO();

        BeanUtils.copyProperties(user,userDTO );

        return userDTO;

    }
}
