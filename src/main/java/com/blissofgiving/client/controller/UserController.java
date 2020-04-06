package com.blissofgiving.client.controller;

import com.blissofgiving.client.dto.UserDTO;
import com.blissofgiving.exception.BlissofgivingClientException;

public interface UserController {

    UserDTO getUser(String username) throws BlissofgivingClientException;

    void addUser(UserDTO userDTO) throws BlissofgivingClientException;

    void updateUser(UserDTO userDTO)throws BlissofgivingClientException;

    void deleteUser(String username)throws BlissofgivingClientException;
}
