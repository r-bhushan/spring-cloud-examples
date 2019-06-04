package com.drclb.controller;


import com.drclb.dto.Student;
import com.drclb.settings.StudentData;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
public class StudentDetailsController {

    @Autowired
    private StudentData studentData;

    @Autowired
    HttpServletRequest request;

    @GetMapping(path = "/pendingFee/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Student>> getStudents() {
        log.debug("Correlation id is " + request.getHeader("X-C-ID"));
        return new ResponseEntity<>(studentData.getList(), HttpStatus.OK);
    }

    @GetMapping(path = "/scholarship/list")
    @HystrixCommand(fallbackMethod = "fallBackMech")
    public ResponseEntity<List<Student>> getStudentsWithScholarship() {
        return new ResponseEntity<>(callScholarshipService(),HttpStatus.OK);
    }


    public List<Student> callScholarshipService(){
        throw new RuntimeException("Service is down!");
    }

    public ResponseEntity<List<Student>> fallBackMech(){
        System.out.println("calling fall back process!!");
        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.FAILED_DEPENDENCY);
    }


}
