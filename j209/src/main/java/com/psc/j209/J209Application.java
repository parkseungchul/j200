package com.psc.j209;

import com.psc.j209.domain.Dept;
import com.psc.j209.domain.DeptRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

@AllArgsConstructor
@SpringBootApplication
public class J209Application implements ApplicationListener<ApplicationStartedEvent> {

    private final DeptRepository deptRepository;

    public static void main(String[] args) {
        SpringApplication.run(J209Application.class, args);
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        deptRepository.save(new Dept(1,"1","1"));
    }
}
