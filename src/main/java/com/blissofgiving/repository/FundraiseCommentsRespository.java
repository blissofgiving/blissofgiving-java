package com.blissofgiving.repository;


import com.blissofgiving.model.Fundraise;
import com.blissofgiving.model.FundraiseComments;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundraiseCommentsRespository extends MongoRepository<FundraiseComments, String> {

}
