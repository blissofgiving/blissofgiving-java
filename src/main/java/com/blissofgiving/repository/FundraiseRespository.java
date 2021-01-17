package com.blissofgiving.repository;


import com.blissofgiving.model.Fundraise;
import com.blissofgiving.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FundraiseRespository extends MongoRepository<Fundraise, String> {

    @Query("{createdUser: '?0'}")
    List<Fundraise> findByUsername(String username);

    @Query("{createdUser: '?0',endDate: '{ $gt: ?1 }'}")
    List<Fundraise> findActivefundraiseByUsername(String username, Date endDate);
}
