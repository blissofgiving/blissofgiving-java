package com.blissofgiving.client.controller;

import com.blissofgiving.client.dto.UserDTO;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserController {

    UserDTO getUser( String userID);
}
