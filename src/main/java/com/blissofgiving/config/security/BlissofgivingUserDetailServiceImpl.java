package com.blissofgiving.config.security;

import com.blissofgiving.exception.BlissofgivingRecordNotFoundException;
import com.blissofgiving.exception.BlissofgivingRuntimeException;
import com.blissofgiving.dynamodbmodel.User;
import com.blissofgiving.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BlissofgivingUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userService.getUser(username);
            if(user != null){
                Set<GrantedAuthority> authorities = new HashSet<>();

                return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getPassword(), authorities);
            }
            else throw new BlissofgivingRuntimeException("User doesn't exists with userName: "+username);
        } catch (BlissofgivingRecordNotFoundException e) {
           throw new BlissofgivingRuntimeException(e.getMessage());
        }
    }
}
