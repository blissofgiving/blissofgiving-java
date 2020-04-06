package com.blissofgiving.repository;

import com.blissofgiving.model.Photos;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photos, String> {

}