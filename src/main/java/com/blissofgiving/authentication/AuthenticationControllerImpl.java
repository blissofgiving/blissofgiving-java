package com.blissofgiving.authentication;

import com.blissofgiving.config.security.BlissofgivingUserDetailServiceImpl;
import com.blissofgiving.exception.BlissofgivingRuntimeException;
import com.blissofgiving.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class AuthenticationControllerImpl implements AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    BlissofgivingUserDetailServiceImpl blissofgivingUserDetailService;

    @Autowired
    JWTUtil jwtUtil;

    @Override
    @RequestMapping(path = "/api/rest/v1/token", method = RequestMethod.POST)
    public ResponseEntity<?> getJWTToken(@RequestBody AuthenticationRequest authenticationRequest) throws BlissofgivingRuntimeException {
        //Authenticate
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        }catch (BadCredentialsException e){
            throw new BlissofgivingRuntimeException("Invalid credentials!");
        }

        //Generate JWT token
        UserDetails userDetails = blissofgivingUserDetailService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwtToken = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
    }
}
