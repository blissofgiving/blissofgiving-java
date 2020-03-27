package com.blissofgiving.client.service;

import com.blissofgiving.client.dto.UserDTO;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.blissofgiving.exception.BlissofgivingRecordNotFoundException;
import org.springframework.stereotype.Component;

public interface UserClientService {

    public UserDTO getUser(String username) throws BlissofgivingClientException;

}
