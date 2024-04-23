package com.vistal.tech.security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final long MAX_AGE_SECS = 3600;

    @Value("${app.cors.allowedOrigins: localhost:3000}")
    private String[] allowedOrigins;
    
    @PostConstruct
    public void init() {
    	allowedOrigins= new String[]{"http://localhost:3000"};
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	System.out.println(allowedOrigins[0]);
        registry.addMapping("/**")
                .allowedOrigins(allowedOrigins)
                .allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE")
                .maxAge(MAX_AGE_SECS);
    }
}