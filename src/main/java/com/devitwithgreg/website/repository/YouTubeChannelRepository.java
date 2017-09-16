package com.devitwithgreg.website.repository;

import com.devitwithgreg.website.domain.YouTubeChannel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YouTubeChannelRepository extends MongoRepository<YouTubeChannel, String> {
}
