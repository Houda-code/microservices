package com.microservices.anime;

import feign.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
//    @Bean
//    public FeignClientFactory feignClientFactory() {
//        return new FeignClientFactory();
//    }
@Bean
Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL; // You can use NONE, BASIC, HEADERS, or FULL
}
}