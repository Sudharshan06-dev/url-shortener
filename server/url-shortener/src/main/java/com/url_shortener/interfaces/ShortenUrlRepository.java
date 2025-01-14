package com.url_shortener.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import com.url_shortener.model.ShortenUrl;

@Repository
public interface ShortenUrlRepository extends MongoRepository<ShortenUrl, String> {
    ShortenUrl findByShortenUrl(String hash);
    String findByOriginalUrl(String originalUrl);

    @Query("{'originalUrl' : ?0}")
    @Update("{ '$inc': { 'visits': 1 } }")
    void incrementVisits(String originalUrl);
}
