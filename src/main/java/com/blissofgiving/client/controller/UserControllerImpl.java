package com.blissofgiving.client.controller;

import com.blissofgiving.client.dto.UserDTO;
import com.blissofgiving.client.service.UserClientService;
import com.blissofgiving.exception.BlissofgivingClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserControllerImpl implements UserController {

    @Autowired
    UserClientService userClientService;

    @Override
    @RequestMapping(path = "/api/rest/v1/user", method = RequestMethod.GET)
    public UserDTO getUser(@RequestParam(value = "username") String username) throws BlissofgivingClientException {
        UserDTO userDTO  = userClientService.getUser(username);
        return userDTO;
    }

//    @Override
//    @RequestMapping(path = "/api/rest/v1/user", method = RequestMethod.POST)
//    public void addUser(@RequestBody(UserDTO userDTO)) throws BlissofgivingClientException {
//
//    }
}
