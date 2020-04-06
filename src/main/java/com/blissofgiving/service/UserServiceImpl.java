package com.blissofgiving.service;

import com.blissofgiving.exception.BlissofgivingRecordNotFoundException;
import com.blissofgiving.model.User;
import com.blissofgiving.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public User getUser(String username) throws BlissofgivingRecordNotFoundException {
        List<User> users = repository.findByUsername(username);
        if(users == null || users.size() <= 0)
            throw new BlissofgivingRecordNotFoundException("No record found for user: "+ username);
        return users.get(0);
    }

    @Override
    public void saveUser(User user) {
        repository.save(user);
    }
}
