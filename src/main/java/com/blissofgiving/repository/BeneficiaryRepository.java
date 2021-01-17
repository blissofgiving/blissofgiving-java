package com.blissofgiving.repository;

import com.blissofgiving.model.Beneficiary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryRepository extends MongoRepository<Beneficiary, String> {
}
