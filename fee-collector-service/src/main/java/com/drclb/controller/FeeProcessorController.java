package com.drclb.controller;

import com.drclb.config.feign.client.StudentFeignClient;
import com.drclb.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class FeeProcessorController {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StudentFeignClient studentFeignClient;

    @Value("${others.url.student-service-default-url}")
    private String STUDENT_SERVICE_DEFAULT_URL;


    @Value("${others.url.student-service-loadBalanced-url}")
    private String STUDENT_SERVICE_LOAD_BALANCED_URL;

        @PostMapping(value = "/collect")
    public List<Student> collect() {

        List<Student> students = restTemplateBuilder.build().exchange(STUDENT_SERVICE_DEFAULT_URL, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Student>>() {
                })
                .getBody();
        System.out.println(students);
        return students;
    }

    @PostMapping(value = "/collect-with-loadBalanced")
    public List<Student> collectWithLoadBalancedRestTemplate() {
        List<Student> students = restTemplate.exchange(STUDENT_SERVICE_LOAD_BALANCED_URL, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Student>>() {
                })
                .getBody();
        System.out.println(students);
        return students;
    }

    @PostMapping(value = "/collect-with-feign-client")
    public List<Student> collectWithFeignClient(){
        return studentFeignClient.getStudentNamesForFeProcessing().getBody();
    }
}
