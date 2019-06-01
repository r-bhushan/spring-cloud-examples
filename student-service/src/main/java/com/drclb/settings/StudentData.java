package com.drclb.settings;

import com.drclb.dto.Student;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@ConfigurationProperties(prefix = "others.data.students")
@Configuration
@RefreshScope
@Profile("data")
public class StudentData {
    List<Student> list;

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }
}
