package com.blissofgiving.repository;

import com.blissofgiving.model.BeneficiaryTestimonials;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryTestimonialsRepository extends MongoRepository<BeneficiaryTestimonials, String> {
}
