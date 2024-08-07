package com.microservices.anime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



@SpringBootApplication
@EnableFeignClients(basePackages = "com.microservices.anime")

public class AnimeApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnimeApplication.class,args);
    }
}
