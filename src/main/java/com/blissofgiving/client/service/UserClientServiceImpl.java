package com.blissofgiving.client.service;

import com.blissofgiving.client.dto.UserDTO;
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
    public UserDTO getUser(String userID) {

        User user  = userService.getUser(userID);

        UserDTO userDTO = new UserDTO();

        BeanUtils.copyProperties(user,userDTO );

        return userDTO;

    }
}
