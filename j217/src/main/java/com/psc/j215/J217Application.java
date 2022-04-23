package com.psc.j215;

import com.psc.j215.domain.Dept;
import com.psc.j215.domain.DeptRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@AllArgsConstructor
@SpringBootApplication
public class J217Application {

    final DeptRepository deptRepository;

    public static void main(String[] args) {
        SpringApplication.run(J217Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void startApp(){
        for(int i=0; i< 10; i++){
            deptRepository.save(new Dept(i,String.valueOf(i), String.valueOf(i)));
        }



    }

}
