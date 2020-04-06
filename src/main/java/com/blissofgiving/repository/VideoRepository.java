package com.blissofgiving.repository;

import com.blissofgiving.model.Photos;
import com.blissofgiving.model.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository  extends MongoRepository<Video, String> {
}
