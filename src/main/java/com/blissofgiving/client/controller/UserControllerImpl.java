package com.blissofgiving.client.controller;

import com.blissofgiving.client.dto.UserDTO;
import com.blissofgiving.client.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserControllerImpl implements UserController {

    @Autowired
    UserClientService userClientService;

    @GetMapping("/api/user")
    public UserDTO getUser(@RequestParam(value = "userID") String userID){ // TODO add Exception
        UserDTO userDTO  = userClientService.getUser(userID);
        return userDTO;
    }

}
