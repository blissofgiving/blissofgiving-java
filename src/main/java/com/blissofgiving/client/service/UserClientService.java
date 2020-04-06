package com.blissofgiving.client.service;

import com.blissofgiving.client.dto.UserDTO;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.blissofgiving.exception.BlissofgivingValidationException;

public interface UserClientService {

    public UserDTO getUser(String username) throws BlissofgivingClientException;

    void addUser(UserDTO userDTO) throws BlissofgivingClientException, BlissofgivingValidationException;

    void updateUser(UserDTO userDTO) throws BlissofgivingClientException, BlissofgivingValidationException;

    void deleteUser(String username) throws BlissofgivingClientException;
}
