package com.blissofgiving.client.controller;

import com.blissofgiving.client.dto.UserDTO;
import com.blissofgiving.client.service.UserClientService;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.blissofgiving.exception.BlissofgivingValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = {"http://blissofgiving-react-app.s3-website.us-east-2.amazonaws.com"})
public class UserControllerImpl implements UserController {

    @Autowired
    UserClientService userClientService;

    @Override
    @RequestMapping(path = "/api/rest/v1/user", method = RequestMethod.GET)
    public UserDTO getUser(@RequestParam(value = "username") String username) throws BlissofgivingClientException {
        UserDTO userDTO  = userClientService.getUser(username);
        return userDTO;
    }

    @Override
    @RequestMapping(path = "/api/rest/v1/user", method = RequestMethod.POST)
    public void addUser(@RequestBody UserDTO userDTO) throws BlissofgivingClientException {
        try {
            userClientService.addUser(userDTO);
        } catch (BlissofgivingValidationException e) {
            e.printStackTrace();//TODO Shashi
        }
    }

    @Override
    @RequestMapping(path = "/api/rest/v1/user", method = RequestMethod.PUT)
    public void updateUser(@RequestBody UserDTO userDTO) throws BlissofgivingClientException {
        try {
            userClientService.updateUser(userDTO);
        } catch (BlissofgivingValidationException e) {
            e.printStackTrace();//TODO Shashi
        }
    }

    @Override
    @RequestMapping(path = "/api/rest/v1/user", method = RequestMethod.DELETE)
    public void deleteUser(@RequestParam(value = "username") String username) throws BlissofgivingClientException {
            userClientService.deleteUser(username);
    }
}
