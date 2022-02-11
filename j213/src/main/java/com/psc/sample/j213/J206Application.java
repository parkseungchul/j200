package com.psc.sample.j213;

import com.psc.sample.j213.domain.DeptEntity;
import com.psc.sample.j213.domain.DeptRepository;
import com.psc.sample.j213.dto.Dept;
import com.psc.sample.j213.dto.DeptMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
@AllArgsConstructor
public class J206Application {

    DeptRepository deptRepository;
    DeptMapper deptMapper;

    public static void main(String[] args) {
        SpringApplication.run(J206Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void startApp() {

        log.debug(" ####################### HELLO ####################### ");

        List<DeptEntity> deptEntityList = new ArrayList<DeptEntity>();
        for(int i= 1; i<10; i++){
            Dept dept = new Dept(i ,String.valueOf(i),String.valueOf(i),String.valueOf(i));
            deptEntityList.add(deptMapper.dtoToEntity(dept));
        }
        deptRepository.saveAll(deptEntityList);
    }
}
