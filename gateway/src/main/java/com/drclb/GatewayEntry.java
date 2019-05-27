package com.drclb;

import com.drclb.filter.CorrelationIdFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableZuulProxy
@EnableEurekaClient
public class GatewayEntry {
    public static void main(String[] args) {
        SpringApplication.run(GatewayEntry.class,args);
    }

//    @Bean
//    public CorrelationIdFilter CorrelationIdFilter(){
//        return new CorrelationIdFilter();
//    }
}
