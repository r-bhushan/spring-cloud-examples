package com.drclb.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {

        RestTemplate restTemplate = new RestTemplate();
        ClientHttpRequestInterceptor interceptor =
                (request, body, exe) ->{
                    request.getHeaders().add("X-C-ID",CorrelationThreadLocal.getCorrelationId());
                    System.out.println("-------->"+request.getHeaders().get("X-C-ID"));
                    return exe.execute(request, body);};

        restTemplate.setInterceptors((List<ClientHttpRequestInterceptor>)
                Collections.singletonList(interceptor));
        return restTemplate;
    }
}
