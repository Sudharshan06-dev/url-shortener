package com.url_shortener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.url_shortener.service.ZookeeperService;
@SpringBootApplication
public class UrlShortenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlShortenerApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ZookeeperService zookeeperService) {
		return args -> {
			zookeeperService.connectZk();
		};
	}
}
