package com.drclb.config.feign.client;

import com.drclb.dto.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Configuration
@FeignClient(name = "${others.url.feign.student-service}")
public interface StudentFeignClient {

    @GetMapping("student/pendingFee/list")
    public ResponseEntity<List<Student>> getStudentNamesForFeProcessing();


}
