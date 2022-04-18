package com.psc.j215.service;

import com.psc.j215.domain.Dept;
import com.psc.j215.domain.DeptRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class DeptServiceImpl implements DeptService{

    final DeptRepository deptRepository;

    @Override
    public List<Dept> deptList() {
        List<Dept> list = new ArrayList<Dept>();
        deptRepository.findAll().forEach(dept -> {
            log.debug("deptList");
            list.add(dept);
        });
        return list;
    }
}
