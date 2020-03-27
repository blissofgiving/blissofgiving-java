package com.blissofgiving.client.controller;

import com.blissofgiving.client.dto.UserDTO;
import com.blissofgiving.exception.BlissofgivingClientException;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserController {

    UserDTO getUser(String username) throws BlissofgivingClientException;

   // public void addUser(UserDTO userDTO) throws BlissofgivingClientException;
}
