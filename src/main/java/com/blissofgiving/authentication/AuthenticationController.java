package com.blissofgiving.authentication;

import com.blissofgiving.exception.BlissofgivingRuntimeException;
import org.springframework.http.ResponseEntity;

public interface AuthenticationController {

    public ResponseEntity<?> getJWTToken(AuthenticationRequest authenticationRequest) throws BlissofgivingRuntimeException;
}
