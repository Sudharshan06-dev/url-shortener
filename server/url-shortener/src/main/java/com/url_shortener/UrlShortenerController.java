package com.url_shortener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.url_shortener.model.ShortenUrl;
import com.url_shortener.service.ShortenUrlService;

@RestController

@RequestMapping("/api")
@Configuration
public class UrlShortenerController {

    private ShortenUrlService shortenUrlService = null;

    @PostMapping("/short-url")
    public String shortenUrl(@RequestBody ShortenUrl shortenUrl) throws Exception {
        try {
            return this.getShortenUrlService().createShortenUrl(shortenUrl);
        } catch (Exception e) {
            e.printStackTrace();
            return "Failure in shortening the url";
        }
    }


    @Bean
    public ShortenUrlService getShortenUrlService() {
        
        if(this.shortenUrlService == null) {
            this.shortenUrlService = new ShortenUrlService();
        }

        return this.shortenUrlService;
    }

}