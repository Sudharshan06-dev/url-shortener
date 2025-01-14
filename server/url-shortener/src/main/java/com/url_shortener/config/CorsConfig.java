package com.url_shortener.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Applies to all endpoints
                        .allowedOrigins("http://localhost", "http://localhost:80", "http://localhost:3000", "http://localhost:4000", "http://localhost:4000/")                         
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Specify HTTP methods
                        .allowedHeaders("*") // Allow all headers
                        .allowCredentials(true); // Support cookies if needed
            }
        };
    }
}
