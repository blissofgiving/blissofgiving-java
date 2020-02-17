package com.blissofgiving.client.service;

import com.blissofgiving.client.dto.UserDTO;
import org.springframework.stereotype.Component;

public interface UserClientService {

    public UserDTO getUser(String userID);

}
