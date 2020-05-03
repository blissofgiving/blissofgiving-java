package com.blissofgiving.repository;

import com.blissofgiving.model.Fundraise;
import com.blissofgiving.model.FundraiseMedia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundraiserMediaRepository extends MongoRepository<FundraiseMedia, String> {
}
