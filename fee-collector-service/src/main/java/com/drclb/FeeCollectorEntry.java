package com.drclb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class FeeCollectorEntry {

    public static void main(String[] args) {
        SpringApplication.run(FeeCollectorEntry.class,args);
    }


}
