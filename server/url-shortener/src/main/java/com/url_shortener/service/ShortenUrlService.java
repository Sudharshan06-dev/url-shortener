package com.url_shortener.service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.url_shortener.interfaces.ShortenUrlRepository;
import com.url_shortener.model.ShortenUrl;

public class ShortenUrlService {

    @Autowired
    private ShortenUrlRepository shortenUrlRepository;

    @Autowired
    private ZookeeperService zookeeperService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private String shortenUrlExists = null;

    public String createShortenUrl(ShortenUrl shortenUrl) throws Exception {

        //Check whether the longurl is not used
        try {

            if(this.getShortentUrl(shortenUrl.getOriginalUrl())) {
                shortenUrlRepository.incrementVisits(shortenUrl.getOriginalUrl());
                return this.shortenUrlExists;
            } else {

                //Get the length of the original string
                int stringLength = shortenUrl.getOriginalUrl().length();

                //Get the new Hash
                String newHashedUrl = zookeeperService.hashGenerator(stringLength);

                //Set the shorten url
                String newUrl = "shorturl.com/" + newHashedUrl;

                ShortenUrl newShortenUrl = new ShortenUrl();
                newShortenUrl.setOriginalUrl(shortenUrl.getOriginalUrl());
                newShortenUrl.setUrlHash(newHashedUrl);
                newShortenUrl.setShortenUrl(newUrl);
                newShortenUrl.setVisits(1);
                newShortenUrl.setCreatedAt(new Date());
                newShortenUrl.setExpiredAt(new Date(new Date().getTime() + (1000 * 60 * 60 * 24)));

                shortenUrlRepository.save(newShortenUrl);
            
                System.out.println("New short URL created." + newUrl);

                this.getShortentUrl(shortenUrl.getOriginalUrl());

                return this.shortenUrlExists;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Failure in shortening the url";
        }

    }

    private boolean getShortentUrl(String longUrl) {
        //Check Redis Cache first
        String cachedLongUrl = redisTemplate.opsForValue().get(longUrl);

        if(cachedLongUrl != null) {
            this.shortenUrlExists = cachedLongUrl;
            return true;
        }


        this.shortenUrlExists = shortenUrlRepository.findByOriginalUrl(longUrl);

        System.out.println(this.shortenUrlExists);

        if(this.shortenUrlExists != null) {
            redisTemplate.opsForValue().set(longUrl, this.shortenUrlExists, 24, TimeUnit.HOURS);
            return true;
        }
    
        return  this.shortenUrlExists != null;
    }

}
