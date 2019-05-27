package com.drclb.settings;

import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test2")
@Configuration
@EnableZuulServer
public class ZuulServerEnable {
}
