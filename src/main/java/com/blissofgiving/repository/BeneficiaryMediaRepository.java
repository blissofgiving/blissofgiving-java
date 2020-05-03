package com.blissofgiving.repository;

import com.blissofgiving.model.BeneficiaryMedia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryMediaRepository extends MongoRepository<BeneficiaryMedia, String> {

}
