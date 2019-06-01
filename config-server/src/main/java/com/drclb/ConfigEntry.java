package com.drclb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigEntry {

    public static void main(String[] args) {
        SpringApplication.run(ConfigEntry.class, args);
    }
}
