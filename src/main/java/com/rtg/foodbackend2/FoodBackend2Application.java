package com.rtg.foodbackend2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FoodBackend2Application {

    public static void main(String[] args) {
        SpringApplication.run(FoodBackend2Application.class, args);
    }

}
