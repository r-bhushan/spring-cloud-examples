package com.drclb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerEntry {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServerEntry.class, args);
    }
}
