package com.blissofgiving.repository;


import com.blissofgiving.model.Fundraise;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundraiseRespository extends MongoRepository<Fundraise, String> {

}
