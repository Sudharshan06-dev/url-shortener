package com.url_shortener.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection =  "shorten_url")

public class ShortenUrl {

    @Id
    private String id;

    private String originalUrl;

    @Indexed(unique = true)
    private String urlHash;

    private String shortenUrl;

    private int visits;

    private Date createdAt;

    private Date expiresAt;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return this.originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getUrlHash() {
        return this.urlHash;
    }

    public void setUrlHash(String urlHash) {
        this.urlHash = urlHash;
    }

    public String getShortentUrl() {
        return this.shortenUrl;
    }

    public void setShortenUrl(String shortenUrl) {
        this.shortenUrl = shortenUrl;
    }

    public Integer getVisits() {
        return this.visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getExpiredAt() {
        return this.expiresAt;
    }

    public void setExpiredAt(Date expiredAt) {
        this.expiresAt = expiredAt;
    }

    public String toObjectString() {
        return "ShortenUrl{" +
               "originalUrl='" + originalUrl + '\'' +
               ", urlHash='" + urlHash + '\'' +
               ", shortenUrl='" + shortenUrl + '\'' +
               ", visits=" + visits +
               ", createdAt=" + createdAt +
               ", expiredAt=" + expiresAt +
               '}';
    }


}