package com.blissofgiving.repository;


import com.blissofgiving.model.User;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query("{username: '?0'}")
    List<User> findByUsername(String username);


    @DeleteQuery("{username: '?0'}")
    void deleteByUsername(String username);
}
