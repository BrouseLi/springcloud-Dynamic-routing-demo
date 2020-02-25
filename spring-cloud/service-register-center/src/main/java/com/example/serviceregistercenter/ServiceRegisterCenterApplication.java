package com.example.serviceregistercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer

public class ServiceRegisterCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegisterCenterApplication.class, args);
    }

}
