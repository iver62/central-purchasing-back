package com.apps.centralpurchasing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CentralPurchasingApplication {

    @Bean
    public BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("stream-sse").allowedOrigins("http://localhost:4200");
                registry.addMapping("stream-sse").allowedOrigins("http://localhost:8080");
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(CentralPurchasingApplication.class, args);
    }

}
